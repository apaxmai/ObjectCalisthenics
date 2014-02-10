import java.util.List;

public interface JobApplicationRepository
{
  public void addJobApplication(JobApplication jobApplication);
  public void addFailedJobApplication(JobApplication jobApplication);
  public List<JobApplication> jobApplicationsByDay(String date);
  public List<JobApplication> jobApplicationsByJobseeker(Jobseeker jobseeker);
  public List<JobApplication> succeededJobApplications();
  public List<JobApplication> failedJobApplications();
}
