public class JobseekerID
{
  public static JobseekerID invalid;
  private IdentifyingType   id;

  public JobseekerID(IdentifyingType id)
  {
    this.id = new IdentifyingType(id);
  }
};
