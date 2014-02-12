package jobapplication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JobApplications implements java.lang.Iterable<JobApplication>
{
  private List<JobApplication> appliedJobs;


  public static JobApplications empty()
  {
    return new JobApplications();
  }


  private JobApplications()
  {
    this.appliedJobs = new ArrayList<>();
  }


  private JobApplications(List<JobApplication> appliedJobs)
  {
    this.appliedJobs = appliedJobs;
  }


  public void add(JobApplication appliedJob)
  {
    appliedJobs.add(appliedJob);
  }


  @Override
  public Iterator<JobApplication> iterator()
  {
    return appliedJobs.iterator();
  }

};
