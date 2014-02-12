package jobseeker;

import java.io.StringWriter;

public class HumanName
{

  private String givenName;
  private String familyName;


  public HumanName(String givenName)
  {
    this.givenName = givenName;
  }


  public HumanName(String givenName,
                   String familyName)
  {
    this.givenName = givenName;
    this.familyName = familyName;
  }


  @Override
  public String toString()
  {
    return (this.givenName + " " + this.familyName);
  }


  public void putRepresentation(StringWriter sw)
  {
    sw.write(this.givenName + " " + this.familyName);
  }

}
