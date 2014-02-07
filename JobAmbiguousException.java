import java.util.List;

class JobAmbiguousException extends Exception
{
  private static final long serialVersionUID = 4870430872076782014L;
  public List<JobID>        matchingJobs;

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
