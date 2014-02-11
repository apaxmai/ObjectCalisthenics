import java.util.List;
import java.util.ArrayList;

public class MemoryResidentJobApplicationRepository implements JobApplicationRepository
{
  //this might be a JobApplicationCollection instead of two lists
  private List<JobApplication> jobApplications;
  private List<JobApplication> failedJobApplications;

  public MemoryResidentJobApplicationRepository()
  {
    jobApplications = new ArrayList<>();
    failedJobApplications = new ArrayList<>();
  }

  @Override
  public void addJobApplication(JobApplication jobApplication)
  {
    jobApplications.add(jobApplication);
  }

  // todo: public JobApplications ...
  @Override
  public List<JobApplication> succeededJobApplicationsByDay(String date)
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

  @Override
  public List<JobApplication> succeededJobApplicationsByJobseeker(Jobseeker jobseeker)
  {
    List<JobApplication> applications = new ArrayList<>();
    for (JobApplication application : jobApplications)
    {
      addToListIfCreatedByJobseeker(applications, application, jobseeker);
    }

    return applications;
  }

  private void addToListIfCreatedByJobseeker(List<JobApplication> applications,
                                             JobApplication application,
                                             Jobseeker jobseeker)
  {
    if (jobseeker.equals(application.getJobseeker()))
    {
      applications.add(application);
    }
  }
  private void addToListIfApplicationIsForJob(List<JobApplication> applications,
			JobApplication application, Job job)
  {
    if( job.equals( application.getJob() ))
    {
      applications.add(application);
    }
  }

  @Override
  public void addFailedJobApplication(JobApplication jobApplication) {
	failedJobApplications.add(jobApplication);
  }
  
  public List<JobApplication> failedJobApplicationsByJobseeker(Jobseeker jobseeker)
  {
    List<JobApplication> applications = new ArrayList<>();
    for( JobApplication application : failedJobApplications )
    {
      addToListIfCreatedByJobseeker(applications, application, jobseeker);
    }
    return applications;
  }

  @Override
  public List<JobApplication> succeededJobApplications()
  {
	return jobApplications;
  }

  @Override
  public List<JobApplication> failedJobApplications()
  {
    return failedJobApplications;
  }

  @Override
  public List<JobApplication> succeededJobApplicationsByJob(Job job)
  {
    List<JobApplication> applications = new ArrayList<>();
    for (JobApplication application : jobApplications)
    {
      addToListIfApplicationIsForJob(applications, application, job);
    }

    return applications;
  }

  @Override
  public List<JobApplication> succeededJobApplicationsByJobAndDay(Job job, String date)
  {
	List<JobApplication> applications = new ArrayList<>();
    for (JobApplication application : jobApplications)
    {
      if (application.appliedOnDate(date))
      {
    	addToListIfApplicationIsForJob(applications, application, job);
      }
    }
	return applications;
  }



}
