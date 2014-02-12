package jobapplication;

import job.ATSJob;
import job.AppliedJob;
import job.FailedAppliedJob;
import job.JReqJob;
import job.Job;
import job.SuccessfulAppliedJob;
import jobseeker.Jobseeker;
import jobseeker.Resume;

public class JobApplicationManager
{

  public static JobApplication acceptApplicationToJob(Jobseeker jobseeker,
                                            Job job,
                                            Resume resume)
  {
    if ((Resume.invalid == resume) && (job instanceof JReqJob))
    {
      AppliedJob appliedjob = FailedAppliedJob.from(job);
      jobseeker.addAppliedJob(appliedjob);
      return FailedJobApplication.from(appliedjob, jobseeker);
    }


    AppliedJob appliedjob = SuccessfulAppliedJob.from(job);
    jobseeker.addAppliedJob(appliedjob);
    return SuccessfulJobApplication.from(appliedjob, jobseeker);
  }


  public static JobApplication acceptApplicationToJob(Jobseeker jobseeker,
                                            Job job)
  {
    if (job instanceof ATSJob)
    {
      AppliedJob appliedjob = SuccessfulAppliedJob.from(job);
      jobseeker.addAppliedJob(appliedjob);
      return SuccessfulJobApplication.from(appliedjob, jobseeker);
    }

    AppliedJob appliedjob = FailedAppliedJob.from(job);
    jobseeker.addAppliedJob(appliedjob);
    return FailedJobApplication.from(appliedjob, jobseeker);
  }
 

}
