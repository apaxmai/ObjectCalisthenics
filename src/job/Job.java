package job;

import java.io.StringWriter;

import hashcodeprovider.HashCodeProvider;
import employer.Employer;

public abstract class Job
{
  public JobID       id;
  protected Employer creator;


  @Override
  public boolean equals(Object o)
  {
    return (o instanceof Job) && ((Job) o).id.equals(this.id);
  }


  @Override
  public int hashCode()
  {
    return HashCodeProvider.hashCodeFor(this, this.id);
  }


  public String toString()
  {
    return this.id.toString();
  }


  public boolean hasID(JobID id)
  {
    return this.id.equals(id);
  }


  public Employer creator()
  {
    return this.creator;
  }


  public void putRepresentation(StringWriter sw)
  {
    this.id.putRepresentation(sw);  
  }
  
  public void putEmployerRepresentation(StringWriter sw)
  {
    this.creator.putRepresentation(sw);
  }
};
