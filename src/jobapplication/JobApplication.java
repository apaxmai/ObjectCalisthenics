package jobapplication;

import job.AppliedJob;
import jobseeker.Jobseeker;

public abstract class JobApplication
{
  private AppliedJob appliedJob;
  private Jobseeker  jobseeker;


  public JobApplication(AppliedJob appliedJob, Jobseeker jobseeker)
  {
    this.appliedJob = appliedJob;
    this.jobseeker = jobseeker;
  }
}
