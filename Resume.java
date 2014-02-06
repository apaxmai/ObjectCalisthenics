
public class Resume
{

  public static final Resume invalid = new Resume();
  private ResumeName _name;
  
  public Resume()
  {
  }
  public Resume(String name)
  {
    _name = new ResumeName(name);
  }
  public Resume(ResumeName name)
  {
    _name = name;
  }
};

