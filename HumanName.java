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

};
