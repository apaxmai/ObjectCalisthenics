package job;

import employer.Employer;

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


  @Override
  public Jobs jobsByEmployer(Employer employer)
  {
    Jobs retJobs = new Jobs();

    for (Job job : jobs)
    {
      if (employer.equals(job.creator()))
      {
        retJobs.add(job);
      }
    }

    return retJobs;
  }

}
