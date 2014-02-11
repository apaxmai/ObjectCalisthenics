package job;
import employer.AlreadyExistsException;
import employer.Employer;
import globals.Globals;

public class JReqJob extends Job
{
  public static JReqJob jobFrom(Employer creator, JobID id) throws AlreadyExistsException
  {
    if( ! Globals.createdJobRepository.containsJobWithID(id) )
    {
      JReqJob ret = new JReqJob(creator, id);
      Globals.createdJobRepository.add(ret);
      return ret;
    }
		    
    throw new AlreadyExistsException();
  }
		  
  private JReqJob(Employer creator,
			        JobID id)
  {
    this.id = id;
    this.creator = creator;
  }
};
