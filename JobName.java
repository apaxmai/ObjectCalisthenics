public class JobName
{
  public static final JobName invalid = new JobName();
  private String              name;

  public JobName()
  {}

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
