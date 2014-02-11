import static org.junit.Assert.*;
import job.Job;
import job.JobFactory;
import job.JobName;
import job.JobType;

import org.junit.Test;

import employer.AlreadyExistsException;
import employer.Employer;
import employer.EmployerFactory;
import employer.EmployerName;


public class JobTest
{

	// 16. TheLadders wants the system to be able to handle more than one job with the same title.
	@Test
	public void testMultipleJobsSameName() throws AlreadyExistsException
	{
	  Employer employer = EmployerFactory.employerFrom(new EmployerName("Perfect Cuboid Masonry"));
      Job firstJob = JobFactory.jobFrom(employer, JobType.ATS, new JobName("Brick Dust Collector"));
      Job secondJob = JobFactory.jobFrom(employer, JobType.ATS, new JobName("Brick Dust Collector"));

      employer.postJob(firstJob);
      employer.postJob(secondJob);
      
	  assertNotEquals(firstJob, secondJob);
	}

}
