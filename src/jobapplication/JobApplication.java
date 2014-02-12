package jobapplication;

import java.io.StringWriter;

import job.AppliedJob;
import job.Job;
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


  public void putAppliedJob(AppliedJob[] appliedJob)
  {
   appliedJob[0] = this.appliedJob;
  }

  public void putJobseeker(Jobseeker[] jobseeker)
  {
    jobseeker[0] = this.jobseeker;
  }


  public void putEmployerRepresentation(StringWriter sw)
  {
    appliedJob.putEmployerRepresentation(sw); 
  }


  public void putJobseekerRepresentation(StringWriter sw)
  {
    jobseeker.putRepresentation(sw);
  }


  public void putJobRepresentation(StringWriter sw)
  {
    appliedJob.putJobRepresentation(sw);
  }


  public boolean appliedOnDate(String date)
  {
    return appliedJob.appliedOnDate(date);
  }


  public boolean isForJob(Job job)
  {
    return appliedJob.isForJob(job);
  }
}
