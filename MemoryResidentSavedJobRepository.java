import java.util.List;
import java.util.ArrayList;

public class MemoryResidentSavedJobRepository implements SavedJobRepository
{

  private List<Triplet<Employer, Job, Jobseeker>> jobs;

  public MemoryResidentSavedJobRepository()
  {
    jobs = new ArrayList<>();
  }

  public void addSavedJob(Employer employer,
                          Job job,
                          Jobseeker jobseeker)
  {
    jobs.add(new Triplet<Employer, Job, Jobseeker>(employer, job, jobseeker));
  }

  public List<Pair<Employer, Job>> getSavedJobsForJobseeker(Jobseeker jobseeker)
  {
    // this is not main, if I had a SQL database ...

    /*
     * for (Pair<Employer, Job> p : jobs) { if (job.equals(p.getSecond())) { return p.getFirst(); }
     * }
     */

    return null; // oh Employer.invalid where are you
  }

}
