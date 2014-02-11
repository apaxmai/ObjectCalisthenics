
public class Employer
{
  private EmployerID   id;
  private EmployerName name;

  public static Employer employerFrom(EmployerID id, EmployerName name) throws AlreadyExistsException
  {
    if( ! Globals.createdEmployerRepository.containsEmployerWithID(id) )
    {
      Employer ret = new Employer(id, name);
      Globals.createdEmployerRepository.add(ret);
      return ret;
    }
    
    throw new AlreadyExistsException();
  }
  
  private Employer(EmployerID id,
                  EmployerName name)
  {
    this.id = id;
    this.name = name;
  }

  public void createAndPostJob(JobType jobType, JobName jobName) throws AlreadyExistsException
  {
	Job job = JobFactory.jobFrom(this, jobType, jobName );
    this.postJob(job);
  }
  public void postJob(Job job)
  {
    Globals.postedJobRepository.add(job);
  }

  @Override
  public boolean equals(Object o)
  {
    return (o instanceof Employer) && (this.id.equals(((Employer)o).id));
  }

  @Override
  public int hashCode()
  {
	//useful methods in java 7 HashCodeBuilder ?
    return HashCodeProvider.hashCodeFor(this, id.hashCode());
  }

  @Override
  public String toString()
  {
    return name.toString();
  }



}
