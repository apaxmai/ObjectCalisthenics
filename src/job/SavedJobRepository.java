package job;
import java.util.List;

import jobseeker.Jobseeker;

public interface SavedJobRepository
{
  public void addSavedJob(Job job,
                          Jobseeker jobseeker);

  public Jobs getSavedJobsForJobseeker(Jobseeker jobseeker);
}
