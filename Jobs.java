
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Jobs
{
	private static final Jobs INSTANCE = new Jobs();

	//replace this with a list of "rows" (PostDate, EmployerID, EmployerName, Job)
	private static HashMap<EmployerID, HashMap<JobName, List<Job> > > _postedJobs;

	public static Jobs getInstance()
	{
		return INSTANCE;
	}

	public static void addJob(EmployerID theEmployerID, Job theJob)
	{
		JobName theJobName = theJob.getName(); //illegal get() //todo

		if( ! _postedJobs.containsKey(theEmployerID) )
		{
			List<Job> tempList = new ArrayList<Job>();
			tempList.add(theJob);

			HashMap<JobName, List<Job> > tempMap = new HashMap<JobName, ArrayList<Job> >();
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
//			if( theJob.matches(tempJob) ) { return; }
			if( theJob == tempJob ) { return; }
		}

		_postedJobs.get(theEmployerID).get(theJobName).add(theJob);
		return;
	}

	public static void acceptApplicationToJobWithResumeByEmployerAndJobName(JobseekerID theJobseekerID, Resume theResume, EmployerName eName, JobName jName)
	{

		//todo
		//get employerID from.
		//if job is not ambiguous, record application.
		return;

		List<JobID> matchingJobsList = new ArrayList<JobID>();
		// set ... matchingJobsList //todo
		throw new JobAmbiguousException(matchingJobsList);
		return;
	}

	public static void acceptApplicationToJobWithResumeByJobID(JobseekerID theJobseekerID, Resume theResume, JobID theJobID )
	{

		//Look up Job by theJobID
		Job theJob; //todo

		if( (Resume.invalid == theResume) && (theJob instanceof JReqJob) )
		{
			throw new ResumeRequiredException();
			return;
		}

		JobApplication theApp = new JobApplication(theJobseekerID, theResume, theJobID);
		JobApplications.add(theApp);
	}

	protected Jobs()
	{
	}

};
