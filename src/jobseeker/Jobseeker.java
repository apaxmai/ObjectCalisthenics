package jobseeker;

import job.AppliedJob;
import job.AppliedJobs;
import job.Job;
import job.Jobs;
import jobapplication.JobApplicationManager;

public class Jobseeker
{
  private JobseekerID           id;
  private Resumes               resumes;
  private JobseekerJobContainer jobContainer; // maybe rename to ...


  public static Jobseeker with(HumanName name)
  {
    return new Jobseeker(new JobseekerID(name));
  }


  private Jobseeker(JobseekerID id)
  {
    this.id = id;
    jobContainer = JobseekerJobContainer.empty();
    resumes = new Resumes();
  }


  public void saveJob(Job job)
  {
    jobContainer.addSavedJob(job);
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
      if (theResumeToSubmit == Resume.invalid)
      {
        throw new NoSuchResumeException();
      }
    }

    JobApplicationManager.acceptApplicationToJob(this, job, theResumeToSubmit);
  }


  public void addAppliedJob(AppliedJob appliedJob)
  {
    jobContainer.addAppliedJob(appliedJob);
  }


  // (5) Jobseekers should be able to see a listing of jobs they have saved for later viewing.
  public Jobs getListingOfSavedJobs()
  {
    return jobContainer.savedJobs();
  }


  // (6) Jobseekers should be able to see a listing of the jobs for which they have applied. //todo
  public AppliedJobs getListingOfAppliedJobs()
  {
    return jobContainer.appliedJobs();
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
