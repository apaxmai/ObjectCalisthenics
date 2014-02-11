import java.util.List;
import java.util.ArrayList;

public class MemoryResidentJobRepository implements JobRepository
{
  private Jobs jobs;
	
  public MemoryResidentJobRepository()
  {
    jobs = new Jobs();
  }

  @Override
  public void add(Job job)
  {
    jobs.add(job);
  }

  @Override
  public boolean containsJobWithID(JobID id)
  {
	return jobs.containsJobWithID(id);
  }

}
