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

  public boolean equals(Employer employer)
  {
    return employer.equals(this.id) && employer.equals(this.name);
  }

  public boolean equals(EmployerID employerID)
  {
    return this.id.equals(employerID);
  }

  public boolean equals(EmployerName employerName)
  {
    return this.name.equals(employerName);
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
    if (o instanceof EmployerName)
    {
      return (this.equals((EmployerName) o));
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
