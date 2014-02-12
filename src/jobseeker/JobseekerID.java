package jobseeker;

import hashcodeprovider.HashCodeProvider;
import datastructures.IdentifyingType;

public class JobseekerID
{
  public static JobseekerID     invalid;

  private HumanName             name;
  private final IdentifyingType id;


  public JobseekerID(HumanName name)
  {
    this.id = new IdentifyingType();
    this.name = name;
  }


  @Override
  public boolean equals(Object o)
  {
    return (o instanceof JobseekerID) && (this.id.equals(((JobseekerID) o).id));
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
