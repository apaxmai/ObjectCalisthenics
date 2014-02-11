package datastructures;
import hashcodeprovider.HashCodeProvider;

public class IdentifyingType
{
  private final Integer data;

  public IdentifyingType(Integer data)
  {
    this.data = data;
  }

  public IdentifyingType(IdentifyingType other)
  {
    this.data = other.data;
  }

  @Override
  public boolean equals(Object o)
  {
    return (o instanceof IdentifyingType) && ( ((IdentifyingType) o).data.equals(this.data) );
  }
  @Override
  public int hashCode()
  {
    return HashCodeProvider.hashCodeFor(this, data);
  }
}
