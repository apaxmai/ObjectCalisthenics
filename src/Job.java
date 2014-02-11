public abstract class Job
{
  protected JobID   id;
  protected Employer creator;

  @Override
  public boolean equals(Object o)
  {
    return (o instanceof Job) && ((Job) o).id.equals( this.id );
  }

  @Override
  public int hashCode()
  {
    return HashCodeProvider.hashCodeFor(this, this.id);
  }

  public String toString()
  {
    return this.id.toString();
  }

  public boolean hasID(JobID id)
  {
    return this.id.equals(id);
  }

  public Employer creator()
  {
	return this.creator;
  }
};
