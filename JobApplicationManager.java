import java.util.ArrayList;
import java.util.List;

public class JobApplicationManager
{

  public static void acceptApplicationToJob(Jobseeker jobseeker,
                                            Job job,
                                            Resume resume) throws ResumeRequiredException
  {
    if ((Resume.invalid == resume) && (job instanceof JReqJob))
    {
      Globals.jobApplicationRepository.addFailedJobApplication(JobApplication.from(jobseeker, resume, job));
      throw new ResumeRequiredException();
    }

    Globals.jobApplicationRepository.addJobApplication(JobApplication.from(jobseeker, resume, job));
  }

  public static void acceptApplicationToJob(Jobseeker jobseeker,
                                            Job job) throws ResumeRequiredException
  {
    if (job instanceof JReqJob)
    {
      throw new ResumeRequiredException();
    }

    Globals.jobApplicationRepository.addJobApplication(JobApplication.from(jobseeker, job));
  }

  public static Jobs appliedJobs(Jobseeker jobseeker)
  {

    Jobs appliedToJobs = new Jobs();
    List<JobApplication> applications = Globals.jobApplicationRepository.jobApplicationsByJobseeker(jobseeker);
    for (JobApplication application : applications)
    {
      if (jobseeker.equals(application.getJobseeker()))
      {
        appliedToJobs.add(application.getJob());
      }
    }

    return appliedToJobs;
  }

}
