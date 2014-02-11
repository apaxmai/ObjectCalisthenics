public class JobFactory
{

  private static Integer jobIDCounter = 0;

  public static Job jobFrom(Employer creator,
		                    JobType jobType,
                            JobName jobName) throws AlreadyExistsException
  {
    JobID id = new JobID(new IdentifyingType(jobIDCounter), jobName);

    Job job = null;
    if( JobType.ATS == jobType )
    {
      job = ATSJob.jobFrom(creator, id);
    }
    if (JobType.JREQ == jobType)
    {
      job = JReqJob.jobFrom(creator, id);
    }

    jobIDCounter++;
    return job;
  }

}
