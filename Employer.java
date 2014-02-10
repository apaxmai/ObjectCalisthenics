public class Employer
{
  private EmployerID   id;
  private EmployerName name;

  public static Employer employerFrom(EmployerID id, EmployerName name)
  {
    //if( ! Globals.employerRepository.containsEmployerWithID(id) )
    //{
    return new Employer(id, name);
    //}
  }
  
  private Employer(EmployerID id,
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

  public boolean equals(Employer employer)
  {
    return employer.equals(this.id);
  }

  public boolean equals(EmployerID employerID)
  {
    return this.id.equals(employerID);
  }

  @Override
  public boolean equals(Object o)
  {
    if (o instanceof Employer)
    {
      return (this.equals((Employer) o));
    }
    if (o instanceof EmployerID)
    {
      return (this.equals((EmployerID) o));
    }
    return false;
  }

  @Override
  public int hashCode()
  {
    return id.hashCode() ^ name.hashCode();
  }

  @Override
  public String toString()
  {
    return name.toString();
  }

}
