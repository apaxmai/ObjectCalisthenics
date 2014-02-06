
public class Employer
{

  private EmployerID id;
  private EmployerName name;

  public Employer()
  { 
  }
  public Employer(String name)
  {
    this.name = new EmployerName(name);
  }
  public Employer(EmployerID id, EmployerName name)
  {
    this.id = id;
    this.name = name;
  }

  public void postJob(Job theJob)
  {
    Jobs.addJob(id, theJob);
  }
  public void postJob(JobType type, String name)
  {
    postJob(type, new JobName(name));
  }
  public void postJob(JobType type, JobName name)
  {
    Jobs.addJob(id, JobFactory.jobFrom(type, name) );
  }
  
  public boolean equalsID(EmployerID eID)
  {
    return this.id.equals(eID);
  }
  public boolean equalsName(EmployerName eName)
  {
	return this.name.getName().equals( eName.getName() );
	//return this.name.equalsName(eName);
  }

}
