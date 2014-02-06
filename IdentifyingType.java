
public class IdentifyingType
{

  private Integer data;

  public IdentifyingType()
  {
  }

  public IdentifyingType(Integer data)
  {
    this.data = data;
  }

  public IdentifyingType(IdentifyingType other)
  {
    this.data = other.data;
  }

};
