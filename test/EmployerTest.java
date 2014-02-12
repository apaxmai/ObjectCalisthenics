
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
import job.Jobs;
import jobapplication.JobApplication;
import jobapplication.JobApplications;
import jobseeker.HumanName;
import jobseeker.Jobseeker;
import jobseeker.Jobseekers;
import jobseeker.ResumeRequiredException;

import org.junit.Before;
import org.junit.Test;

import employer.AlreadyExistsException;
import employer.Employer;
import employer.EmployerName;

public class EmployerTest
{

  private Employer employer;
  private Job job;
  private Jobseeker sophie;
  private JobApplications jobApplications;
  
  @Before
  public void testSetup() throws AlreadyExistsException, ResumeRequiredException
  {
    employer = Employer.with(new EmployerName("Perfect Cuboid Masonry"));
    job = JobFactory.jobFrom(employer, JobType.ATS, new JobName("CEO"));
    employer.postJob(job);
    
    sophie = Jobseeker.with(new HumanName("Sophie", "Germain"));
    
    jobApplications = JobApplications.empty();
    jobApplications.add(sophie.applyToJob(job));
  }
  
  @Test
  public void testDuplicateEmployerThrowsException()
  {
    // dont even test this because one cannot create duplicate employers.
    // EmployerID testID = new EmployerID();
    // Employer theMasonry = Employer.with(testID, new EmployerName("Perfect Cuboid Masonry"));
    // Employer pizzaStop = Employer.employerFrom(testID, new EmployerName("Big Sals Pizza Stop"));
  }


  // (14) Employers, when displayed, should be displayed by their name.
  @Test
  public void testEmployerIsRenderedByName() throws AlreadyExistsException
  {
    assertEquals(employer.toString(), "Perfect Cuboid Masonry");
  }


  // (1) Employers can post jobs.
  // (2) Employers should be able to see a listing of the jobs they have posted.
  @Test
  public void testEmployerCanPostJobAndSeeListing() throws AlreadyExistsException
  {
    Jobs postedJobs = employer.listPostedJobs();
    
    boolean found = false;
    for( Job postedJob : postedJobs )
    {
      if( postedJob.equals(job) )
      {
        found = true;
      }
    }
    
    assertTrue(found);
  }


  // (7) Employers should be able to see jobseekers who have applied to their jobs by both job and
  // day.
  // If possible, we would like to be able to combine the two and see jobseekers who have applied to
  // a given job on a given day.

  // 7.1
  @Test
  public void testEmployerCanSeeApplicantsByJob() throws AlreadyExistsException, ResumeRequiredException
  {
    assertTrue( employer.jobseekersAppliedToJob(jobApplications, job).contains(sophie) );
  }


  // 7.2
  @Test
  public void testEmployerCanSeeApplicantsByDay() throws AlreadyExistsException, ResumeRequiredException
  {
    String today = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) ;
    boolean found = false;
    Jobseekers jobseekers = employer.jobseekersAppliedByDay(jobApplications, today);
    for( Jobseeker jobseeker : jobseekers )
    {
      if( sophie.equals(jobseeker) )
      {
        found = true;
      }
    }
    assertTrue(found);
  }


  // 7.3 (boolean AND)
  @Test
  public void testEmployerCanSeeApplicantsByJobAndDay() throws AlreadyExistsException, ResumeRequiredException
  {
    String today = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) ;
    boolean found = false;
    Jobseekers jobseekers = employer.jobseekersAppliedToJobByDay(jobApplications, job, today);
    for( Jobseeker jobseeker : jobseekers )
    {
      if( sophie.equals(jobseeker) )
      {
        found = true;
      }
    }
    assertTrue(found);
  }


  // 18. TheLadders wants the system to be able to handle more than one employer with the same name.
  @Test
  public void testMultipleEmployersSameName() throws AlreadyExistsException
  {
    Employer realMasonry = Employer.with(new EmployerName("Perfect Cuboid Masonry"));
    Employer fakeMasonry = Employer.with(new EmployerName("Perfect Cuboid Masonry"));

    assertNotEquals(realMasonry, fakeMasonry);
  }

}
