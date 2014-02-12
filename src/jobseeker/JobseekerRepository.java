package jobseeker;

public interface JobseekerRepository
{
  public void add(Jobseeker jobseeker);


  public boolean containsJobseekerWithID(JobseekerID id);
}
