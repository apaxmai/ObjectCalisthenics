
public class JobFactory
{

  private static Integer jobIDCounter;

  public static Job jobFrom(JobType theJobType, JobName theJobName)
  {
	JobID id = new JobID(new IdentifyingType(jobIDCounter));
    Job retJob = new ATSJob(id, theJobName);

    if( JobType.JREQ == theJobType )
    {
      retJob = new JReqJob(id, theJobName);
    }

    jobIDCounter++;
    return retJob;
  }

  public JobFactory()
  {
    jobIDCounter = 0;
  }
}
