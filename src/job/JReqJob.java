package job;

import employer.Employer;

public class JReqJob extends Job
{
  public static JReqJob from(Employer creator,
                             JobID id)
  {
    return new JReqJob(creator, id);
  }


  private JReqJob(Employer creator,
                  JobID id)
  {
    this.id = id;
    this.creator = creator;
  }
};
