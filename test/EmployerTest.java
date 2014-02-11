

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import job.Job;
import job.JobFactory;
import job.JobName;
import job.JobType;
import jobapplication.JobApplication;
import jobseeker.HumanName;
import jobseeker.Jobseeker;
import jobseeker.JobseekerFactory;
import jobseeker.ResumeRequiredException;

import org.junit.Test;

import datastructures.IdentifyingType;
import employer.AlreadyExistsException;
import employer.Employer;
import employer.EmployerFactory;
import employer.EmployerID;
import employer.EmployerName;
import globals.Globals;


public class EmployerTest
{

	@Test(expected = AlreadyExistsException.class)
	public void testDuplicateEmployerThrowsException() throws AlreadyExistsException
	{
	  EmployerID testID = new EmployerID( new IdentifyingType(31337) );
	  Employer theMasonry = Employer.employerFrom(testID, new EmployerName("Perfect Cuboid Masonry")); 
	  Employer pizzaStop = Employer.employerFrom(testID, new EmployerName("Big Sals Pizza Stop"));
	}

	//(14) Employers, when displayed, should be displayed by their name.
	@Test
	public void testEmployerIsRenderedByName() throws AlreadyExistsException
	{
      Employer employer = EmployerFactory.employerFrom(new EmployerName("Perfect Cuboid Masonry"));
      assertEquals(employer.toString(), "Perfect Cuboid Masonry");
	}
	
	//(1) Employers can post jobs.
	@Test
	public void testEmployerCanPostJob() throws AlreadyExistsException
	{
	  Employer employer = EmployerFactory.employerFrom(new EmployerName("Perfect Cuboid Masonry"));
	  Job job = JobFactory.jobFrom(employer, JobType.ATS, new JobName("CEO"));
	  employer.postJob(job);
	  
	  assertTrue( Globals.postedJobRepository.containsJobWithID(job.id) );
	}

	//(2) Employers should be able to see a listing of the jobs they have posted.
	@Test
	public void testEmployerCanSeePostedJobs() throws AlreadyExistsException, IOException
	{
	  Employer employer = EmployerFactory.employerFrom(new EmployerName("Perfect Cuboid Masonry"));
      Job job = JobFactory.jobFrom(employer, JobType.ATS, new JobName("test testEmployerCanSeePostedJobs"));
      employer.postJob(job);
 
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      System.setOut(new PrintStream(baos));
      
      employer.listPostedJobs();
      
      baos.flush();
      String whatWasPrinted = new String(baos.toByteArray());
      String[] linesOfOutput = whatWasPrinted.split(//
    		  System.getProperty("line.separator"));
      
      assertEquals(1, linesOfOutput.length);
      assertEquals("test testEmployerCanSeePostedJobs", linesOfOutput[0]);
	}
	

	//(7) Employers should be able to see jobseekers who have applied to their jobs by both job and day.
	//If possible, we would like to be able to combine the 2 and see jobseekers who have applied to a
	//given job on a given day.
	
	// 7.1
	@Test
	public void testEmployerCanSeeApplicantsByJob() throws AlreadyExistsException, ResumeRequiredException
	{
      Employer employer = EmployerFactory.employerFrom(new EmployerName("Perfect Cuboid Masonry"));
	  Job job = JobFactory.jobFrom(employer, JobType.ATS, new JobName("test testEmployerCanSeePostedJobs"));
	  employer.postJob(job);
	  
	  Jobseeker sophie = JobseekerFactory.jobseekerFrom(new HumanName("Sophie", "Germain"));
	  sophie.applyToJob(job);
	  
	  //employer.viewApplicantsByJob(job);
	  List<JobApplication> applications = Globals.jobApplicationRepository.succeededJobApplicationsByJob(job);
	  
	  boolean found = false;
	  for( JobApplication application : applications )
	  {
		if( sophie.equals( application.getJobseeker() ) )
		{
  		  found = true;
		}
	  }
	  
	  if( found == false )
	  {
        fail("cannot find application by job");
	  }

	}
	
	// 7.2
	@Test
	public void testEmployerCanSeeApplicantsByDay() throws AlreadyExistsException, ResumeRequiredException
	{
      Employer employer = EmployerFactory.employerFrom(new EmployerName("Perfect Cuboid Masonry"));
      Job job = JobFactory.jobFrom(employer, JobType.ATS, new JobName("test testEmployerCanSeePostedJobs"));
      employer.postJob(job);
		  
      Jobseeker sophie = JobseekerFactory.jobseekerFrom(new HumanName("Sophie", "Germain"));
      sophie.applyToJob(job);
		  
      String today = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
      List<JobApplication> applications = Globals.jobApplicationRepository.succeededJobApplicationsByDay(today);
      
	  boolean found = false;
	  for( JobApplication application : applications )
	  {
		if( sophie.equals( application.getJobseeker() ) )
		{
  		  found = true;
		}
	  }
	  
	  if( found == false )
	  {
        fail("cannot find application by day");
	  }
	}
	
	// 7.3 (boolean AND)
	@Test
	public void testEmployerCanSeeApplicantsByJobAndDay() throws AlreadyExistsException, ResumeRequiredException
	{
      Employer employer = EmployerFactory.employerFrom(new EmployerName("Perfect Cuboid Masonry"));
      Job job = JobFactory.jobFrom(employer, JobType.ATS, new JobName("test testEmployerCanSeePostedJobs"));
      employer.postJob(job);
			  
      Jobseeker sophie = JobseekerFactory.jobseekerFrom(new HumanName("Sophie", "Germain"));
      sophie.applyToJob(job);
			  
      String today = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
      List<JobApplication> applications = Globals.jobApplicationRepository.succeededJobApplicationsByJobAndDay(job, today);
	      
	  boolean found = false;
	  for( JobApplication application : applications )
	  {
	    if( sophie.equals( application.getJobseeker() ) )
		{
	      found = true;
		}
	  }
		  
	  if( found == false )
	  {
        fail("cannot find application by job AND day");
	  }
	}
	
	// 18. TheLadders wants the system to be able to handle more than one employer with the same name.
	@Test
	public void testMultipleEmployersSameName() throws AlreadyExistsException
	{
      Employer realMasonry = EmployerFactory.employerFrom(new EmployerName("Perfect Cuboid Masonry"));
      Employer fakeMasonry = EmployerFactory.employerFrom(new EmployerName("Perfect Cuboid Masonry"));
      
      assertNotEquals(realMasonry, fakeMasonry);
	}
	
}
