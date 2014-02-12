package job;

import employer.AlreadyExistsException;
import employer.Employer;

public class JobFactory
{

  private static Integer jobIDCounter = 0;


  public static Job jobFrom(Employer creator,
                            JobType jobType,
                            JobName jobName) throws AlreadyExistsException
  {
    JobID id = new JobID(jobName);

    Job job = null;
    if (JobType.ATS == jobType)
    {
      job = ATSJob.from(creator, id);
    }
    if (JobType.JREQ == jobType)
    {
      job = JReqJob.from(creator, id);
    }

    jobIDCounter++;
    return job;
  }

}
