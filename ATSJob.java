public class ATSJob extends Job
{
  public static ATSJob jobFrom(Employer creator, JobID id) throws AlreadyExistsException
  {
    if( ! Globals.createdJobRepository.containsJobWithID(id) )
    {
      ATSJob job = new ATSJob(creator, id);
      Globals.createdJobRepository.add(job);
      return job;
    }
	    
    throw new AlreadyExistsException();
  }
	  
  private ATSJob(Employer creator,
		        JobID id)
  {
    this.id = id;
    this.creator = creator;
  }
};
