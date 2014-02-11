import static org.junit.Assert.*;

import org.junit.Test;


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
