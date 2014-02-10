public abstract class Job
{
  protected JobID   id;
  protected JobName name;

  public boolean equals(Job job)
  {
    return job.equals(id);
  }

  public boolean equals(JobID id)
  {
    return this.id.equals(id);
  }

  @Override
  public boolean equals(Object o)
  {
    if (o instanceof Job)
    {
      return this.equals((Job) o);
    }
    if (o instanceof JobID)
    {
      return this.equals((JobID) o);
    }
    return false;
  }

  @Override
  public int hashCode()
  {
    return HashCodeProvider.hashCodeFor(this, name);
  }

  public String toString()
  {
    return name.toString();
  }
};
