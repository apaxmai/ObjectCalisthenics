public class JobApplicationManager
{

  public static void acceptApplicationToJobWithResume(Jobseeker jobseeker,
                                                      Job job,
                                                      Resume resume) throws ResumeRequiredException
  {
    if ((Resume.invalid == resume) && (job instanceof JReqJob))
    {
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

}
