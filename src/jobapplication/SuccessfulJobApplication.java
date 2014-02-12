package jobapplication;

import job.AppliedJob;
import job.Job;
import jobseeker.Jobseeker;

public class SuccessfulJobApplication extends JobApplication
{
  private SuccessfulJobApplication(AppliedJob appliedJob, Jobseeker jobseeker)
  {
    super(appliedJob, jobseeker);
  }


  public static SuccessfulJobApplication from(AppliedJob appliedJob, Jobseeker jobseeker)
  {
    return new SuccessfulJobApplication(appliedJob, jobseeker);
  }

}
