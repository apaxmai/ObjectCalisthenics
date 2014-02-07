public class JobseekerID
{
  public static JobseekerID     invalid;
  private final IdentifyingType id;

  public JobseekerID(IdentifyingType id)
  {
    this.id = new IdentifyingType(id);
  }
};
