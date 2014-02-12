package employer;

import hashcodeprovider.HashCodeProvider;
import job.Job;
import job.JobFactory;
import job.JobName;
import job.JobType;
import job.Jobs;
import jobseeker.Jobseekers;

public class Employer
{
  private EmployerID   id;
  private EmployerName name;
  private Jobs         postedJobs;


  public static Employer with(EmployerName name)
  {
    return new Employer(new EmployerID(), name);
  }


  private Employer(EmployerID id,
                   EmployerName name)
  {
    this.id = id;
    this.name = name;
  }


  public void createAndPostJob(JobType jobType,
                               JobName jobName) throws AlreadyExistsException
  {
    Job job = JobFactory.jobFrom(this, jobType, jobName);
    this.postJob(job);
  }


  public void postJob(Job job)
  {
    postedJobs.add(job);
  }


  @Override
  public boolean equals(Object o)
  {
    return (o instanceof Employer) && (this.id.equals(((Employer) o).id));
  }


  @Override
  public int hashCode()
  {
    // useful methods in java 7 HashCodeBuilder ?
    return HashCodeProvider.hashCodeFor(this, id.hashCode());
  }


  @Override
  public String toString()
  {
    return name.toString();
  }


  public boolean hasID(EmployerID employerID)
  {
    return this.id.equals(employerID);
  }


  // (2) Employers should be able to see a listing of the jobs they have posted.
  public Jobs listPostedJobs()
  {
    return postedJobs;
  }


  public Jobseekers jobseekersAppliedToJob(Job job)
  {
    // no data :)
    return null; // todo
  }

}
