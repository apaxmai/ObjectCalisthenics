import java.util.List;
import java.util.ArrayList;

public class MemoryResidentJobApplicationRepository implements JobApplicationRepository
{
  private List<JobApplication> jobApplications;

  public MemoryResidentJobApplicationRepository()
  {
    jobApplications = new ArrayList<>();
  }

  public void addJobApplication(JobApplication jobApplication)
  {
    jobApplications.add(jobApplication);
  }

  // todo: public JobApplications ...
  public List<JobApplication> jobApplicationsByDay(String date)
  {

    List<JobApplication> applications = new ArrayList<>();
    for (JobApplication application : jobApplications)
    {
      addIfAppliedOnDate(date, applications, application); // 2% chance of need to return this
    }

    return applications;
  }

  private void addIfAppliedOnDate(String date,
                                  List<JobApplication> applications,
                                  JobApplication application)
  {
    if (application.appliedOnDate(date))
    {
      applications.add(application);
    }
  }

}
