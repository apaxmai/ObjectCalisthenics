public class EmployerID
{
  public static EmployerID invalid;
  private IdentifyingType  id;

  public EmployerID(IdentifyingType id)
  {
    this.id = new IdentifyingType(id);
  }
  
  public boolean equals(EmployerID id)
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
    return (o instanceof EmployerID) && (this.equals((EmployerID) o));
  }
  
  @Override
  public int hashCode()
  {
    return (1019 * id.hashCode());
  }
};
