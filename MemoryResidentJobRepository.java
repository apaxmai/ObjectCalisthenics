import java.util.List;
import java.util.ArrayList;

public class MemoryResidentJobRepository implements JobRepository
{

  private List<Pair<Employer, Job>> jobs;

  public MemoryResidentJobRepository()
  {
    jobs = new ArrayList<>();
  }

  public void addJob(Employer employer,
                     Job job)
  {
    jobs.add(new Pair<Employer, Job>(employer, job));
  }

  public Employer getEmployerForJob(Job job)
  {
    // this is not main, if I had a SQL database ...
    for (Pair<Employer, Job> p : jobs)
    {
      if (job.equalsJob(p.getSecond()))
      {
        return p.getFirst();
      }
    }

    return null; // oh Employer.invalid where are you
  }

}
