package job;

import employer.Employer;

public interface JobRepository
{

  public void add(Job job);


  public boolean containsJobWithID(JobID id);


  public Jobs jobsByEmployer(Employer employer);

}
