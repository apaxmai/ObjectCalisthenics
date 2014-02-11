package jobseeker;
import datastructures.IdentifyingType;
import employer.AlreadyExistsException;


public class JobseekerFactory
{

  //daniel suggests to place global employer into the factory?
  private static Integer  jobseekerIDCounter = 0;

  public static Jobseeker jobseekerFrom(HumanName name) throws AlreadyExistsException
  {
    JobseekerID id = new JobseekerID(new IdentifyingType(jobseekerIDCounter), name);
    Jobseeker jobseeker = Jobseeker.jobseekerFrom(id);

    jobseekerIDCounter++;
    return jobseeker;
  }

  private JobseekerFactory()
  {
  }
}
