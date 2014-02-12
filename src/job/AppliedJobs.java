package job;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppliedJobs implements java.lang.Iterable<AppliedJob>

{
  private List<AppliedJob> jobs;


  private AppliedJobs()
  {
    this.jobs = new ArrayList<>();
  }
  
  public static AppliedJobs empty()
  {
    return new AppliedJobs();
  }

  public void add(AppliedJob job)
  {
    jobs.add(job);
  }


  @Override
  public Iterator<AppliedJob> iterator()
  {
    return jobs.iterator();
  }
};
