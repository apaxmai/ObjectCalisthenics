package job;
import datastructures.IdentifyingType;
import hashcodeprovider.HashCodeProvider;

public class JobID
{
  public static JobID           invalid;
  
  private final IdentifyingType id;
  protected JobName             name;

  public JobID(IdentifyingType id, JobName name)
  {
    this.id = new IdentifyingType(id);
    this.name = name;
  }

  @Override
  public String toString()
  {
    return this.name.toString();
  }
  
  @Override
  public boolean equals(Object o)
  {
    return (o instanceof JobID) && ( ((JobID) o).id.equals(this.id) );
  }

  @Override
  public int hashCode()
  {
    return HashCodeProvider.hashCodeFor(this, id.hashCode());
  }

};
