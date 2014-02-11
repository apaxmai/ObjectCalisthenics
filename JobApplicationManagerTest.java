
import static org.junit.Assert.*;

import org.junit.Test;

public class JobApplicationManagerTest
{
	// 4 Jobseekers can apply to jobs posted by employers.
	
	// 4.2 "JReq jobs require a resume to apply to them."
	@Test(expected = ResumeRequiredException.class)
	public void testApplicationToJREQWithoutResumeThrowsException() throws AlreadyExistsException, ResumeRequiredException
	{
	      Employer employer = EmployerFactory.employerFrom(new EmployerName("Perfect Cuboid Masonry"));
		  Job job = JobFactory.jobFrom(employer, JobType.JREQ, new JobName("test testApplicationToJREQWithoutResumeThrowsException"));
		  employer.postJob(job);
		  
		  Jobseeker sophie = JobseekerFactory.jobseekerFrom(new HumanName("Sophie", "Germain"));
		  sophie.applyToJob(job);
	}
	
	// 4.3 "ATS jobs do not."
	@Test
	public void testApplicationToATSWithoutResume() throws AlreadyExistsException, ResumeRequiredException
	{
      Employer employer = EmployerFactory.employerFrom(new EmployerName("Perfect Cuboid Masonry"));
      Job job = JobFactory.jobFrom(employer, JobType.ATS, new JobName("test testApplicationToATSWithoutResume"));
      employer.postJob(job);
		  
      Jobseeker sophie = JobseekerFactory.jobseekerFrom(new HumanName("Sophie", "Germain"));
      sophie.applyToJob(job);
	}
	
	// 4.3 extended
	@Test
	public void testApplicationToATSWithResume() throws AlreadyExistsException, ResumeRequiredException, NoSuchResumeException
	{
      Employer employer = EmployerFactory.employerFrom(new EmployerName("Perfect Cuboid Masonry"));
      Job job = JobFactory.jobFrom(employer, JobType.ATS, new JobName("test testApplicationToATSWithoutResume"));
      employer.postJob(job);
		  
      Jobseeker sophie = JobseekerFactory.jobseekerFrom(new HumanName("Sophie", "Germain"));
      sophie.createResume("Example Resume");
      sophie.applyToJobWithResume(job, new ResumeName("Example Resume"));
	}
}
