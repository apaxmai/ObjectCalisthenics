
public class JobName
{
  public static final JobName invalid = new JobName();

  public JobName()
  {
  }
  public JobName(String name)
  {
    _name = name;
  }

  private String _name;
};
