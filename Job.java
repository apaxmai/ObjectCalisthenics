public abstract class Job
{
  protected JobID   id;
  protected JobName name;

  public boolean equalsJob(Job job)
  {
    return job.equalsJobID(id);
  }

  public boolean equalsJobID(JobID id)
  {
    return this.id.equalsJobID(id);
  }

  public String toString()
  {
    return name.toString();
  }
};
