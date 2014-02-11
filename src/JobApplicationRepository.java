import java.util.List;

public interface JobApplicationRepository
{
  public void addJobApplication(JobApplication jobApplication);
  public void addFailedJobApplication(JobApplication jobApplication);
  
  public List<JobApplication> succeededJobApplicationsByDay(String date);
  public List<JobApplication> succeededJobApplicationsByJob(Job job);
  public List<JobApplication> succeededJobApplicationsByJobAndDay(Job job, String date);
  public List<JobApplication> succeededJobApplicationsByJobseeker(Jobseeker jobseeker);
  
  public List<JobApplication> succeededJobApplications();
  public List<JobApplication> failedJobApplications();
}
