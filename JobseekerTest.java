import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


public class JobseekerTest
{
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
	public void testSeeListingOfSavedJobs() throws AlreadyExistsException
	{
      Employer employer = EmployerFactory.employerFrom(new EmployerName("Perfect Cuboid Masonry"));
      Job job = JobFactory.jobFrom(employer, JobType.ATS, new JobName("test testSeeListingOfSavedJobs"));
      employer.postJob(job);
				  
      Jobseeker sophie = JobseekerFactory.jobseekerFrom(new HumanName("Sophie", "Germain"));
      sophie.saveJob(job);
      
      Integer jobCount = 0;
      Integer one = 1;
      Jobs jobs = Globals.savedJobRepository.getSavedJobsForJobseeker(sophie);
      for( Job savedjob : jobs )
      {
        jobCount++;
      }
      assertEquals(jobCount, one);
      
      Job temp = jobs.iterator().next();
      assertEquals(temp.toString(), "test testSeeListingOfSavedJobs");
	}
	
	// 6. Jobseekers should be able to see a listing of the jobs for which they have applied.
	@Test
	public void testSeeListingOfAppliedJobs() throws AlreadyExistsException, ResumeRequiredException
	{
	  Employer employer = EmployerFactory.employerFrom(new EmployerName("Perfect Cuboid Masonry"));
	  Job job = JobFactory.jobFrom(employer, JobType.ATS, new JobName("test testSeeListingOfAppliedJobs"));
      employer.postJob(job);
					  
	  Jobseeker sophie = JobseekerFactory.jobseekerFrom(new HumanName("Sophie", "Germain"));
	  sophie.applyToJob(job);
	  
	  Integer jobCount = 0;
	  Integer one = 1;
	  List<JobApplication> applications = Globals.jobApplicationRepository.succeededJobApplicationsByJobseeker(sophie);
	  for( JobApplication application : applications )
	  {
		if( ! sophie.equals( application.getJobseeker() ) )
		{
		  fail("jobseeker filter failure");
		}
	    jobCount++;
      }
	  assertEquals(jobCount, one);
	  
	  Job temp = applications.iterator().next().getJob();
      assertEquals(temp.toString(), "test testSeeListingOfAppliedJobs");
	}
	
	// 13. Jobseekers, when displayed, should be displayed by their name.
	@Test
	public void testJobseekerIsRenderedByName() throws AlreadyExistsException
	{
      Jobseeker sophie = JobseekerFactory.jobseekerFrom(new HumanName("Sophie", "Germain"));
      assertEquals(sophie.toString(), "Sophie Germain");
	}
	
	// 17. TheLadders wants the system to be able to handle more than one jobseeker with the same name.
	@Test
	public void testMultipleJobseekersSameName() throws AlreadyExistsException
	{
		Jobseeker sophie = JobseekerFactory.jobseekerFrom(new HumanName("Sophie", "Germain"));
		Jobseeker leblanc = JobseekerFactory.jobseekerFrom(new HumanName("Sophie", "Germain"));
		
		assertNotEquals(sophie, leblanc);
	}
	
}
