public class EmployerName
{

  public static final EmployerName invalid = new EmployerName();
  private String                   name;

  public EmployerName()
  {}

  public EmployerName(String name)
  {
    this.name = name;
  }

  public boolean equals(EmployerName eName)
  {
    return this.name.equals(eName);
  }
  
  @Override
  public boolean equals(Object o)
  {
    return (o instanceof EmployerName) && (this.equals((EmployerName) o));
  }
  
  @Override
  public int hashCode()
  {
    return (1031 * name.hashCode());
  }

  @Override
  public String toString()
  {
    return name;
  }

};
