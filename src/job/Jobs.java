package job;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Jobs implements java.lang.Iterable<Job>
{
  private List<Job> jobs;

  public Jobs()
  {
    this.jobs = new ArrayList<>();
  }

  public Jobs(List<Job> jobs)
  {
    this.jobs = jobs;
  }

  public void add(Job job)
  {
    jobs.add(job);
  }

  @Override
  public Iterator<Job> iterator()
  {
    return jobs.iterator();
  }

  public boolean containsJobWithID(JobID id)
  {
	for( Job job : jobs )
	{
	  if(job.hasID(id))
	  {
	    return true;
	  }
	}
	return false;
  }

};
