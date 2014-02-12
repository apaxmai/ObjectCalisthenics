import static org.junit.Assert.assertTrue;
import job.Job;
import job.JobFactory;
import job.JobName;
import job.JobType;
import jobapplication.FailedJobApplication;
import jobapplication.JobApplication;
import jobseeker.HumanName;
import jobseeker.Jobseeker;
import jobseeker.NoSuchResumeException;
import jobseeker.ResumeName;
import jobseeker.ResumeRequiredException;

import org.junit.Test;

import employer.AlreadyExistsException;
import employer.Employer;
import employer.EmployerName;

public class JobApplicationManagerTest
{
  // 4 Jobseekers can apply to jobs posted by employers.

  // 4.2 "JReq jobs require a resume to apply to them."
  @Test
  public void testApplicationToJREQWithoutResumeFails() throws AlreadyExistsException, ResumeRequiredException
  {
    Employer employer = Employer.with(new EmployerName("Perfect Cuboid Masonry"));
    Job job = JobFactory.jobFrom(employer,
                                 JobType.JREQ,
                                 new JobName("test testApplicationToJREQWithoutResumeThrowsException"));
    employer.postJob(job);

    Jobseeker sophie = Jobseeker.with(new HumanName("Sophie", "Germain"));
    JobApplication jobApplication = sophie.applyToJob(job);

    assertTrue(jobApplication instanceof FailedJobApplication);
  }


  // 4.3 "ATS jobs do not."
  @Test
  public void testApplicationToATSWithoutResume() throws AlreadyExistsException, ResumeRequiredException
  {
    Employer employer = Employer.with(new EmployerName("Perfect Cuboid Masonry"));
    Job job = JobFactory.jobFrom(employer, JobType.ATS, new JobName("test testApplicationToATSWithoutResume"));
    employer.postJob(job);

    Jobseeker sophie = Jobseeker.with(new HumanName("Sophie", "Germain"));
    sophie.applyToJob(job);
  }


  // 4.3 extended
  @Test
  public void testApplicationToATSWithResume() throws AlreadyExistsException, ResumeRequiredException,
      NoSuchResumeException
  {
    Employer employer = Employer.with(new EmployerName("Perfect Cuboid Masonry"));
    Job job = JobFactory.jobFrom(employer, JobType.ATS, new JobName("test testApplicationToATSWithoutResume"));
    employer.postJob(job);

    Jobseeker sophie = Jobseeker.with(new HumanName("Sophie", "Germain"));
    sophie.createResume("Example Resume");
    sophie.applyToJobWithResume(job, new ResumeName("Example Resume"));
  }
}
