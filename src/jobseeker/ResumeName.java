package jobseeker;
import hashcodeprovider.HashCodeProvider;

public class ResumeName
{
  public static final ResumeName invalid = new ResumeName();
  private String                 name;

  public ResumeName()
  {}

  public ResumeName(String name)
  {
    this.name = name;
  }

  @Override
  public boolean equals(Object o)
  {
    return (o instanceof ResumeName) && (this.name.equals(((ResumeName)o).name));
  }

  @Override
  public int hashCode()
  {
    return HashCodeProvider.hashCodeFor(this, name.hashCode());
  }
  
};
