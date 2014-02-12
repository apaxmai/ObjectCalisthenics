package job;

import employer.Employer;

public class ATSJob extends Job
{
  public static ATSJob from(Employer creator,
                            JobID id)
  {
    ATSJob job = new ATSJob(creator, id);
    return job;
  }


  private ATSJob(Employer creator,
                 JobID id)
  {
    this.id = id;
    this.creator = creator;
  }
};
