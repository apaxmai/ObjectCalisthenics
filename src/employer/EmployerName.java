package employer;
import hashcodeprovider.HashCodeProvider;

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
    return (o instanceof EmployerName) && (((EmployerName)o).name.equals(this.name));
  }

  @Override
  public int hashCode()
  {
    return HashCodeProvider.hashCodeFor(this, name.hashCode());
  }

  @Override
  public String toString()
  {
    return name;
  }

}