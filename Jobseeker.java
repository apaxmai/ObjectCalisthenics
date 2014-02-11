import java.util.HashMap;

public class Jobseeker
{
  //private JobseekerIdentity identity; //contains JobseekerID and HumanName
  private JobseekerID                 id; // this will need to contain HumanName //todo
  private HumanName                   name;
  private HashMap<ResumeName, Resume> resumes; //this is a type Resumes

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

  public void saveJob(Job job)
  {
	//is this OK to be exposed to Jobseeker, maybe we want a "saver" to do this for us
    Globals.savedJobRepository.addSavedJob(job, this);
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

    JobApplicationManager.acceptApplicationToJob(this, job, theResumeToSubmit);
  }

  // (5) Jobseekers should be able to see a listing of jobs they have saved for later viewing.
  public void getListingOfSavedJobs()
  {
    for( Job job : Globals.savedJobRepository.getSavedJobsForJobseeker(this) )
    {
      //jobseeker doSomething() with this information (outside the scope of project)
    }
  }

  // (6) Jobseekers should be able to see a listing of the jobs for which they have applied. //todo
  public void getListingOfAppliedJobs()
  {
    Jobs appliedJobs = JobApplicationManager.appliedJobs(this);
    for( Job job : appliedJobs )
    {
      //jobseeker doessomething() with the listing. (outside the scope of project)
    }
  }

  @Override
  public String toString()
  {
    return name.toString();
  }

}
