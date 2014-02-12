package jobseeker;

import job.AppliedJob;
import job.AppliedJobs;
import job.Job;
import job.Jobs;

public class JobseekerJobContainer
{
  private AppliedJobs appliedJobs;
  private Jobs        savedJobs;


  public static JobseekerJobContainer empty()
  {
    return new JobseekerJobContainer();
  }


  private JobseekerJobContainer()
  {
    appliedJobs = AppliedJobs.empty();
    savedJobs = new Jobs();
  }


  public void addSavedJob(Job job)
  {
    savedJobs.add(job);
  }


  public void addAppliedJob(AppliedJob appliedJob)
  {
    appliedJobs.add(appliedJob);
  }


  public AppliedJobs appliedJobs()
  {
    return appliedJobs;
  }


  public Jobs savedJobs()
  {
    return savedJobs;
  }

}
