import java.util.HashMap;

public class Jobseeker
{
  // private JobseekerID id; // this will need to contain HumanName //todo
  private HumanName                   name;
  private HashMap<ResumeName, Resume> resumes;

  // saving jobs cannot be done yet due to restriction on number of members //todo
  // move saved jobs data to another class that remembers the map: JobseekerID -> List<JobID>

  public Jobseeker(String givenName)
  {
    name = new HumanName(givenName);
    resumes = new HashMap<ResumeName, Resume>();
  }

  public Jobseeker(String givenName,
                   String familyName)
  {
    name = new HumanName(givenName, familyName);
    resumes = new HashMap<ResumeName, Resume>();
  }

  public void saveJob(Job theJob)
  {
	  //is this OK to be exposed to Jobseeker, maybe we want a "saver" to do this for us
    Globals.savedJobRepository.addSavedJob(
    		Globals.postedJobRepository.getEmployerForJob(theJob),
    		theJob,
    		this);
  }

  public void createResume(String rName)
  {
    createResume(new ResumeName(rName));
  }

  public void createResume(ResumeName rName)
  {
    resumes.put(rName, new Resume(rName));
  }

  public void applyToJob(Job job) throws ResumeRequiredException
  {
    JobApplicationManager.acceptApplicationToJob(this, job);
  }

  public void applyToJobWithResume(Job job,
                                   ResumeName rName) throws ResumeRequiredException
  {
    Resume theResumeToSubmit = Resume.invalid;
    if (ResumeName.invalid != rName)
    {
      theResumeToSubmit = resumes.get(rName);
    }

    try
    {
      JobApplicationManager.acceptApplicationToJob(this, job, theResumeToSubmit);
    }
    catch (ResumeRequiredException ex)
    {
      throw ex;
    }

  }

  // (5) Jobseekers should be able to see a listing of jobs they have saved for later viewing.
  // //todo
  public void getListingOfSavedJobs()
  {
    for( Pair<Employer, Job> tuple : Globals.savedJobRepository.getSavedJobsForJobseeker(this) )
    {
      System.out.println(tuple.getFirst().toString() +", "+ tuple.getSecond().toString() );
    }
  }

  // (6) Jobseekers should be able to see a listing of the jobs for which they have applied. //todo
  public void getListingOfAppliedJobs()
  {
    Jobs appliedJobs = JobApplicationManager.appliedJobs(this);
    // display //todo
  }

  @Override
  public String toString()
  {
    return name.toString();
  }

}
