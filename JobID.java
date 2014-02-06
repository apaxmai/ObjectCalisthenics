
public class JobID
{
  public static JobID invalid;
  private IdentifyingType id;

  public JobID(IdentifyingType id)
  {
    this.id = new IdentifyingType(id);
  }

};
