package jobapplication;

import job.AppliedJob;
import jobseeker.Jobseeker;

public class FailedJobApplication extends JobApplication
{
  private FailedJobApplication(AppliedJob job, Jobseeker jobseeker)
  {
    super(job, jobseeker);
  }


  public static JobApplication from(AppliedJob job, Jobseeker jobseeker)
  {
    return new FailedJobApplication(job, jobseeker);
  }
}
