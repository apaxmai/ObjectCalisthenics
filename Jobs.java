import java.util.ArrayList;
import java.util.List;

class Jobs
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

  public void addJob(Job job)
  {
    jobs.add(job);
  }

};
