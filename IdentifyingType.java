
public class IdentifyingType
{

  private Integer data;

  public IdentifyingType()
  {
  }

  public IdentifyingType(Integer data)
  {
    data = data;
  }

  public IdentifyingType(IdentifyingType other)
  {
    this.data = other.data;
  }

};
