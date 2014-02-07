public class JobID
{
  public static JobID     invalid;
  private IdentifyingType id;

  public JobID(IdentifyingType id)
  {
    this.id = new IdentifyingType(id);
  }

  public boolean equalsJobID(JobID id)
  {
    return id.equalsIdentifyingType(this.id);
  }

  private boolean equalsIdentifyingType(IdentifyingType id)
  {
    return id.equalsIdentifyingType(this.id);
  }

};
