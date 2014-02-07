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

  public boolean equalsName(EmployerName eName)
  {
    return this.name.equals(eName);
  }

  @Override
  public String toString()
  {
    return name;
  }

};
