package job;

import java.io.StringWriter;

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


  public void putRepresentation(StringWriter sw)
  {
    sw.write(this.name); 
  }
};
