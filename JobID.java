public class JobID
{
  public static JobID           invalid;
  private final IdentifyingType id;

  public JobID(IdentifyingType id)
  {
    this.id = new IdentifyingType(id);
  }

  public boolean equals(JobID id)
  {
    return id.equals(this.id);
  }

  private boolean equals(IdentifyingType id)
  {
    return id.equals(this.id);
  }

  @Override
  public boolean equals(Object o)
  {
    return (o instanceof JobID) && (this.equals((JobID) o));
  }

  @Override
  public int hashCode()
  {
    return HashCodeProvider.hashCodeFor(this, id);
  }

};
