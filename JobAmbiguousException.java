
import java.util.List;

class JobAmbiguousException extends Exception
{

  public List<JobID> matchingJobs;

  public JobAmbiguousException()
  {
    super();
  }

  public JobAmbiguousException(List<JobID> matchingJobsList)
  {
    super();
    matchingJobs = matchingJobsList;
  }
}
