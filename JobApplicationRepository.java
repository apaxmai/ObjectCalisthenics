import java.util.List;

public interface JobApplicationRepository
{
  public void addJobApplication(JobApplication jobApplication);

  public List<JobApplication> jobApplicationsByDay(String date);
}
