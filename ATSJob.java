public class ATSJob extends Job
{
  public ATSJob(String name)
  {
    this.name = new JobName(name);
  }

  public ATSJob(JobName name)
  {
    this.name = name;
  }

  public ATSJob(JobID id,
                JobName name)
  {
    this.id = id;
    this.name = name;
  }
};
