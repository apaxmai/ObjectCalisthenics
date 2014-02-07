public class EmployerID
{
  public static EmployerID invalid;
  private IdentifyingType  id;

  public EmployerID(IdentifyingType id)
  {
    this.id = new IdentifyingType(id);
  }
};
