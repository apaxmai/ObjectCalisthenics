public class IdentifyingType
{

  private Integer data;

  public IdentifyingType()
  {}

  public IdentifyingType(Integer data)
  {
    this.data = data;
  }

  public IdentifyingType(IdentifyingType other)
  {
    this.data = other.data;
  }

  public boolean equalsIdentifyingType(IdentifyingType id)
  {
    return id.equalsInteger(this.data);
  }

  public boolean equalsInteger(Integer data)
  {
    return (this.data == data);
  }

};
