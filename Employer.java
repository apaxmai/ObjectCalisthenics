
public class Employer
{

  private EmployerID _id;
  private EmployerName _name;

  public Employer()
  { 
  }
  public Employer(String name)
  {
    _name = new EmployerName(name);
  }
  public Employer(EmployerID id, EmployerName name)
  {
    _id = id;
    _name = name;
  }

  public void postJob(Job theJob)
  {
    Jobs.addJob(_id, theJob);
  }
  public void postJob(JobType type, String name)
  {
    postJob(type, new JobName(name));
  }
  public void postJob(JobType type, JobName name)
  {
    Jobs.addJob(_id, JobFactory.jobFrom(type, name) );
  }

}
