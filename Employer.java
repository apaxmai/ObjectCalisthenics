
public class Employer
{
  private EmployerID   id;
  private EmployerName name;

  public Employer(EmployerID id,
                  EmployerName name)
  {
    this.id = id;
    this.name = name;
  }

  public void postJob(Job theJob)
  {
    Globals.postedJobRepository.addJob(this, theJob);
  }

  public void postJob(JobType type,
                      JobName name)
  {
    Globals.postedJobRepository.addJob(this, JobFactory.jobFrom(type, name));
  }

  public boolean equalsID(EmployerID eID)
  {
    return this.id.equals(eID);
  }

  public boolean equalsName(EmployerName eName)
  {
    return this.name.toString().equals(eName.toString());
  }

  @Override
  public String toString()
  {
    return name.toString();
  }

}
