import java.util.List;
import java.util.ArrayList;

public class MemoryResidentSavedJobRepository implements SavedJobRepository
{

  private List<Triplet<Employer, Job, Jobseeker>> jobs;

  public MemoryResidentSavedJobRepository()
  {
    jobs = new ArrayList<>();
  }

  public void addSavedJob(Employer employer,
                          Job job,
                          Jobseeker jobseeker)
  {
    jobs.add(new Triplet<Employer, Job, Jobseeker>(employer, job, jobseeker));
  }

  public List<Pair<Employer, Job>> getSavedJobsForJobseeker(Jobseeker jobseeker)
  {
	List<Pair<Employer,Job>> mySavedJobs = new ArrayList<>();
    for( Triplet<Employer, Job, Jobseeker> tuple : jobs )
    {
      if( jobseeker.equals(tuple.getThird()) )
      {
        mySavedJobs.add( new Pair<Employer, Job>(tuple.getFirst(), tuple.getSecond()) );
      }
    }
    return mySavedJobs;
  }

}
