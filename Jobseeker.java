import java.util.HashMap;

public class Jobseeker
{
  //private JobseekerID                 id;     // this will need to contain HumanName //todo
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
    // unimp //todo
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
      JobApplicationManager.acceptApplicationToJobWithResume(this, job, theResumeToSubmit);
    }
    catch (ResumeRequiredException ex)
    {
      throw ex;
    }

  }

  @Override
  public String toString()
  {
    return name.toString();
  }

}
