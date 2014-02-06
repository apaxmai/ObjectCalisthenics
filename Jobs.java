
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Jobs
{

  public Jobs()
  {
  }

  //replace this with a list of "rows" (PostDate, EmployerID, EmployerName, Job)
  private static HashMap<EmployerID, HashMap<JobName, List<Job> > > myPostedJobs = new HashMap<>();

  public static void addJob(EmployerID theEmployerID, Job theJob)
  {
    JobName theJobName = theJob.getName(); //illegal get() //todo

    if( ! myPostedJobs.containsKey(theEmployerID) )	//null pointer?
    {
      List<Job> tempList = new ArrayList<Job>();
      tempList.add(theJob);

      HashMap<JobName, List<Job> > tempMap = new HashMap<>();
      tempMap.put(theJobName, tempList);

      myPostedJobs.put(theEmployerID, tempMap);
      return;
    }

    if( ! myPostedJobs.get(theEmployerID).containsKey(theJobName) )
    {
      List<Job> tempList = new ArrayList<Job>();
      tempList.add(theJob);

      myPostedJobs.get(theEmployerID).put(theJobName, tempList);
      return;
    }

    for( Job tempJob : myPostedJobs.get(theEmployerID).get(theJobName) )
    {
      if( theJob == tempJob ) { return; }
    }

    myPostedJobs.get(theEmployerID).get(theJobName).add(theJob);
    return;
  }

  public static void acceptApplicationToJobWithResumeByEmployerAndJobName(JobseekerID theJobseekerID, Resume theResume, EmployerName eName, JobName jName) throws ResumeRequiredException, JobAmbiguousException, EmployerAmbiguousException, NoSuchEmployerException
  {

    Job theJob = null; //todo
    if( (Resume.invalid == theResume) && (theJob instanceof JReqJob) )
    {
      throw new ResumeRequiredException();
    }

    //get EmployerID from EmployerName.
    //if job is not ambiguous, record application.
    EmployerID theEmployerID = EmployerID.invalid;
    try
    {
      theEmployerID = Employers.findEmployerByName(eName);
    }
    catch(EmployerAmbiguousException ex)
    {
      throw ex;
    }
    
    if( theEmployerID == EmployerID.invalid )
    {
      throw new NoSuchEmployerException();
    }
    
    JobID matchingJobID = JobID.invalid;
    try
    {
      matchingJobID = Jobs.findJobIDsByEmployerIDAndJobName(theEmployerID, jName);
    }
    catch(JobAmbiguousException ex)
    {
      throw ex;
    }
    
    //accept the application.
    JobApplications.add( new JobApplication(theJobseekerID, theResume, matchingJobID) );
  }

  private static JobID findJobIDsByEmployerIDAndJobName(EmployerID theEmployerID, JobName jName) throws JobAmbiguousException
  {
    throw new JobAmbiguousException();
    //throw new JobAmbiguousException(matchingJobsList);
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
