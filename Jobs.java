
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Jobs
{

  public Jobs()
  {
  }

  //replace this with a list of "rows" (PostDate, EmployerID, EmployerName, Job)
  private static HashMap<EmployerID, HashMap<JobName, List<Job> > > _postedJobs = new HashMap<>();

  public static void addJob(EmployerID theEmployerID, Job theJob)
  {
    JobName theJobName = theJob.getName(); //illegal get() //todo

    if( ! _postedJobs.containsKey(theEmployerID) )	//null pointer?
    {
      List<Job> tempList = new ArrayList<Job>();
      tempList.add(theJob);

      HashMap<JobName, List<Job> > tempMap = new HashMap<>();
      tempMap.put(theJobName, tempList);

      _postedJobs.put(theEmployerID, tempMap);
      return;
    }

    if( ! _postedJobs.get(theEmployerID).containsKey(theJobName) )
    {
      List<Job> tempList = new ArrayList<Job>();
      tempList.add(theJob);

      _postedJobs.get(theEmployerID).put(theJobName, tempList);
      return;
    }

    for( Job tempJob : _postedJobs.get(theEmployerID).get(theJobName) )
    {
      if( theJob == tempJob ) { return; }
    }

    _postedJobs.get(theEmployerID).get(theJobName).add(theJob);
    return;
  }

  public static void acceptApplicationToJobWithResumeByEmployerAndJobName(JobseekerID theJobseekerID, Resume theResume, EmployerName eName, JobName jName) throws ResumeRequiredException, JobAmbiguousException, EmployerAmbiguousException
  {

    Job theJob = null; //todo
    if( (Resume.invalid == theResume) && (theJob instanceof JReqJob) )
    {
      throw new ResumeRequiredException();
    }

    //get EmployerID from EmployerName.
    //if job is not ambiguous, record application.
    try
    {
    	EmployerID theEmployer = Employers.findEmployerByName(eName);
    }
    catch(EmployerAmbiguousException ex)
    {
    	throw ex;
    }
    
    //if( )
    //{
    //
    //}
    
    List<JobID> matchingJobsList = new ArrayList<JobID>();
    // set ... matchingJobsList //todo
    throw new JobAmbiguousException(matchingJobsList);
  }

  public static void acceptApplicationToJobWithResumeByJobID(JobseekerID theJobseekerID, Resume theResume, JobID theJobID ) throws ResumeRequiredException
  {

    //Look up Job by theJobID
    Job theJob = null; //TODO

    if( (Resume.invalid == theResume) && (theJob instanceof JReqJob) )
    {
      throw new ResumeRequiredException();
    }

    JobApplication theApp = new JobApplication(theJobseekerID, theResume, theJobID);
    JobApplications.add(theApp);
  }


};
