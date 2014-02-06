
public class JReqJob extends Job
{
  public JReqJob(String name)
  {
    this.name = new JobName(name);
  }
  public JReqJob(JobName name)
  {
    this.name = name;
  }
  public JReqJob(JobID id, JobName name)
  {
    this.id = id;
    this.name = name;
  }
};
