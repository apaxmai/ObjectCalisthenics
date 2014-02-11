import static org.junit.Assert.*;

import org.junit.Test;


public class JobseekerTest {

	// 3. Jobseekers can save jobs onsite for later viewing.
	// 4. Jobseekers can apply to jobs posted by employers.
	// 4.4 Jobseekers can not apply to a job with someone else's resume.
	// 4.5 Jobseekers should be able to apply to different jobs with different resumes.
	// 5. Jobseekers should be able to see a listing of jobs they have saved for later viewing.
	// 6. Jobseekers should be able to see a listing of the jobs for which they have applied.
	// 13. Jobseekers, when displayed, should be displayed by their name.
	
	// 3. Jobseekers can save jobs onsite for later viewing.
	@Test
	public void testSaveJob() throws AlreadyExistsException
	{
      Employer employer = EmployerFactory.employerFrom(new EmployerName("Perfect Cuboid Masonry"));
      Job job = JobFactory.jobFrom(employer, JobType.ATS, new JobName("test testEmployerCanSeePostedJobs"));
      employer.postJob(job);
			  
      Jobseeker sophie = JobseekerFactory.jobseekerFrom(new HumanName("Sophie", "Germain"));
      sophie.saveJob(job);
	}

	// 4. Jobseekers can apply to jobs posted by employers.
	@Test
	public void testApplyToPostedJob() throws AlreadyExistsException, ResumeRequiredException
	{
      Employer employer = EmployerFactory.employerFrom(new EmployerName("Perfect Cuboid Masonry"));
      Job job = JobFactory.jobFrom(employer, JobType.ATS, new JobName("test testEmployerCanSeePostedJobs"));
      employer.postJob(job);
				  
      Jobseeker sophie = JobseekerFactory.jobseekerFrom(new HumanName("Sophie", "Germain"));
      sophie.applyToJob(job);
	}
	
	// 4.4 Jobseekers can not apply to a job with someone else's resume.
	@Test(expected = NoSuchResumeException.class)
	public void testApplyToJobWithStolenResume() throws AlreadyExistsException, ResumeRequiredException, NoSuchResumeException
	{
	  //this cannot occur in the current design, but lets attempt to test it anyhow.
      Employer employer = EmployerFactory.employerFrom(new EmployerName("Perfect Cuboid Masonry"));
      Job job = JobFactory.jobFrom(employer, JobType.JREQ, new JobName("first Job"));
      employer.postJob(job);
		  
      Jobseeker sophie = JobseekerFactory.jobseekerFrom(new HumanName("Sophie", "Germain"));
      sophie.createResume("Sophie's Best Resume");
      
      Jobseeker fakeSophie = JobseekerFactory.jobseekerFrom(new HumanName("M.", "LeBlanc"));
      fakeSophie.applyToJobWithResume(job, new ResumeName("Sophie's Best Resume") );
	}
	
	// 4.5 Jobseekers should be able to apply to different jobs with different resumes.
	@Test
	public void testApplyToJobsUsingDifferentResumes() throws AlreadyExistsException, ResumeRequiredException, NoSuchResumeException
	{
      Employer employer = EmployerFactory.employerFrom(new EmployerName("Perfect Cuboid Masonry"));
      Job job = JobFactory.jobFrom(employer, JobType.JREQ, new JobName("first Job"));
      Job alternateJob = JobFactory.jobFrom(employer, JobType.JREQ, new JobName("alternate Job"));
      employer.postJob(job);
      employer.postJob(alternateJob);
	  
      Jobseeker sophie = JobseekerFactory.jobseekerFrom(new HumanName("Sophie", "Germain"));
      sophie.createResume("My Best Resume");
      sophie.createResume("My Average Quality Resume");
      
      sophie.applyToJobWithResume(job, new ResumeName("My Best Resume") );
      sophie.applyToJobWithResume(alternateJob, new ResumeName("My Average Quality Resume") );
	}
	
	// 5. Jobseekers should be able to see a listing of jobs they have saved for later viewing.
	@Test
	public void testSeeListingOfSavedJobs()
	{
	  fail("unimp");
	}
	
	// 6. Jobseekers should be able to see a listing of the jobs for which they have applied.
	@Test
	public void testSeeListingOfAppliedJobs()
	{
	  fail("unimp");
	}
	
	// 13. Jobseekers, when displayed, should be displayed by their name.
	@Test
	public void testJobseekerIsRenderedByName() throws AlreadyExistsException
	{
      Jobseeker sophie = JobseekerFactory.jobseekerFrom(new HumanName("Sophie", "Germain"));
      assertEquals(sophie.toString(), "Sophie Germain");
	}
}
