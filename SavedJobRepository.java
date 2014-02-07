import java.util.List;

public interface SavedJobRepository
{
  public void addSavedJob(Employer employer,
                          Job job,
                          Jobseeker jobseeker);

  public List<Pair<Employer, Job>> getSavedJobsForJobseeker(Jobseeker jobseeker);
}
