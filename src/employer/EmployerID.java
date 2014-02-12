package employer;

import hashcodeprovider.HashCodeProvider;
import datastructures.IdentifyingType;

public class EmployerID
{
  public static EmployerID invalid;
  private IdentifyingType  id;


  public EmployerID()
  {
    this.id = new IdentifyingType();
  }


  @Override
  public boolean equals(Object o)
  {
    return (o instanceof EmployerID) && (((EmployerID) o).id.equals(this.id));
  }


  @Override
  public int hashCode()
  {
    return HashCodeProvider.hashCodeFor(this, id.hashCode());
  }
}
