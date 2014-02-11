package job;
import java.util.List;
import java.util.ArrayList;

import datastructures.Pair;
import jobseeker.Jobseeker;

public class MemoryResidentSavedJobRepository implements SavedJobRepository
{

  private List<Pair<Job, Jobseeker>> savedJobs;

  public MemoryResidentSavedJobRepository()
  {
    savedJobs = new ArrayList<>();
  }

  public void addSavedJob(Job job,
                          Jobseeker jobseeker)
  {
    savedJobs.add(new Pair<Job, Jobseeker>(job, jobseeker));
  }

  public Jobs getSavedJobsForJobseeker(Jobseeker jobseeker)
  {
	Jobs jobs = new Jobs();
    for( Pair<Job, Jobseeker> tuple : savedJobs )
    {
      if( jobseeker.equals(tuple.getSecond()) )
      {
        jobs.add( tuple.getFirst() );
      }
    }
    return jobs;
  }

}
