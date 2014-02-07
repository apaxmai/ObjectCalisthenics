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

  public boolean equals(IdentifyingType id)
  {
    return id.equals(this.data);
  }

  public boolean equals(Integer data)
  {
    return (this.data == data);
  }

  @Override
  public int hashCode()
  {
    return (101 * data);
  }
};
