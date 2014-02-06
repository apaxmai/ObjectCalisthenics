
public class JReqJob extends Job
{
  public JReqJob(String name)
  {
    _name = new JobName(name);
  }
  public JReqJob(JobName name)
  {
    _name = name;
  }
  public JReqJob(JobID id, JobName name)
  {
    _id = id;
    _name = name;
  }
};
