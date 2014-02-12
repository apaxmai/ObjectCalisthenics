package job;

public class SuccessfulAppliedJob extends AppliedJob
{
  private SuccessfulAppliedJob(Job job)
  {
    super(job);
  }

  public static AppliedJob from(Job job)
  {
    return new SuccessfulAppliedJob(job);
  }

}
