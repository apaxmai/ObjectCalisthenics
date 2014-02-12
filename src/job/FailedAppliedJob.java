package job;

public class FailedAppliedJob extends AppliedJob
{
  private FailedAppliedJob(Job job)
  {
    super(job);
  }

  public static AppliedJob from(Job job)
  {
    return new FailedAppliedJob(job);
  }
}
