package jobseeker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jobseekers implements java.lang.Iterable<Jobseeker>
{
  private List<Jobseeker> jobseekers;


  public Jobseekers()
  {
    this.jobseekers = new ArrayList<>();
  }


  public Jobseekers(List<Jobseeker> jobseekers)
  {
    this.jobseekers = jobseekers;
  }


  public void add(Jobseeker jobseeker)
  {
    jobseekers.add(jobseeker);
  }


  @Override
  public Iterator<Jobseeker> iterator()
  {
    return jobseekers.iterator();
  }


  public boolean containsJobseekerWithID(JobseekerID id)
  {
    for (Jobseeker jobseeker : jobseekers)
    {
      if (jobseeker.hasID(id))
      {
        return true;
      }
    }
    return false;
  }


  public boolean contains(Jobseeker jobseeker)
  {
    for (Jobseeker otherJobseeker : jobseekers)
    {
      if (otherJobseeker.equals(jobseeker))
      {
        return true;
      }
    }
    return false;
  }

};
