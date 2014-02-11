import java.util.List;

public interface SavedJobRepository
{
  public void addSavedJob(Job job,
                          Jobseeker jobseeker);

  public Jobs getSavedJobsForJobseeker(Jobseeker jobseeker);
}
