
public class JobID
{
  public static JobID     invalid;
  private IdentifyingType id;

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
    return (1013 * id.hashCode());
  }
  

  //because of .equals() and .hashCode(), it does not make sense to perform .equals() on mutable objects

};
