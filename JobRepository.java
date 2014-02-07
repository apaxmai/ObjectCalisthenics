public interface JobRepository
{

  public void addJob(Employer employer,
                     Job job);

  public Employer getEmployerForJob(Job job);

}
