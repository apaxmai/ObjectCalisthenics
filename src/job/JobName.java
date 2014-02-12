package job;

public class JobName
{
  public static JobName invalid;
  private final String  name;


  public JobName(String name)
  {
    this.name = name;
  }


  @Override
  public String toString()
  {
    return this.name;
  }
};
