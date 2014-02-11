package jobseeker;

import java.util.HashMap;

import employer.AlreadyExistsException;
import globals.Globals;
import job.Job;
import job.Jobs;
import jobapplication.JobApplicationManager;


public class Jobseeker
{
  //private JobseekerIdentity identity; //contains JobseekerID and HumanName
  private JobseekerID                 id;
  private Resumes                     resumes;
  //private HashMap<ResumeName, Resume> resumes; //this is a type Resumes

  public static Jobseeker jobseekerFrom(JobseekerID id) throws AlreadyExistsException
  {
    if( ! Globals.createdJobseekerRepository.containsJobseekerWithID(id) )
    {
      Jobseeker ret = new Jobseeker(id);
      Globals.createdJobseekerRepository.add(ret);
      return ret;
    }
    throw new AlreadyExistsException();
  }
  private Jobseeker(JobseekerID id)
  {
    this.id = id;
    resumes = new Resumes(); //HashMap<ResumeName, Resume>();
  }

  public void saveJob(Job job)
  {
    Globals.savedJobRepository.addSavedJob(job, this);
  }

  public void createResume(String rName)
  {
    createResume(new ResumeName(rName));
  }

  public void createResume(ResumeName rName)
  {
    resumes.add(new Resume(rName));
  }

  public void applyToJob(Job job) throws ResumeRequiredException
  {
    JobApplicationManager.acceptApplicationToJob(this, job);
  }

  public void applyToJobWithResume(Job job,
                                   ResumeName rName) throws ResumeRequiredException, NoSuchResumeException
  {
    Resume theResumeToSubmit = Resume.invalid;
    if (ResumeName.invalid != rName)
    {
      theResumeToSubmit = resumes.resumeWithName(rName);
      if( theResumeToSubmit == Resume.invalid )
      {
        throw new NoSuchResumeException();
      }
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
      //jobseeker doSomethingElse() with the listing. (outside the scope of project)
    }
  }

  @Override
  public String toString()
  {
    return id.toString();
  }
  
  public boolean hasID(JobseekerID id)
  {
	return this.id.equals(id);
  }

}
