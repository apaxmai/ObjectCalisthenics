
public class IdentifyingType
{

  private Integer _data;

  public IdentifyingType()
  {
  }

  public IdentifyingType(Integer data)
  {
    _data = data;
  }

  public IdentifyingType(IdentifyingType other)
  {
    this._data = other._data;
  }

};
