import java.util.List;

class Jobs
{

  private List<Job> jobs;

  public Jobs(List<Job> jobs)
  {
    this.jobs = jobs;
  }

  public void addJob(Job job)
  {
    jobs.add(job);
  }

};
