package jobseeker;

public class MemoryResidentJobseekerRepository implements JobseekerRepository
{

  private Jobseekers jobseekers;


  public MemoryResidentJobseekerRepository()
  {
    jobseekers = new Jobseekers();
  }


  @Override
  public void add(Jobseeker jobseeker)
  {
    jobseekers.add(jobseeker);
  }


  @Override
  public boolean containsJobseekerWithID(JobseekerID id)
  {
    return jobseekers.containsJobseekerWithID(id);
  }

}
