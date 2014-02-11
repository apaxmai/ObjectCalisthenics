package jobseeker;
import datastructures.IdentifyingType;
import hashcodeprovider.HashCodeProvider;


public class JobseekerID
{
  public static JobseekerID     invalid;
  
  private HumanName             name;
  private final IdentifyingType id;

  public JobseekerID(IdentifyingType id, HumanName name)
  {
    this.id = new IdentifyingType(id);
    this.name = name;
  }
  
  @Override
  public boolean equals(Object o)
  {
    return (o instanceof JobseekerID) && (this.id.equals(((JobseekerID)o).id));
  }

  @Override
  public int hashCode()
  {
    return HashCodeProvider.hashCodeFor(this, id.hashCode());
  }
  
  @Override
  public String toString()
  {
    return name.toString();
  }
};
