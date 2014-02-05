

class Jobs {

	static public Jobs getInstance() { return INSTANCE; }

	public void acceptApplicationToJobWithResumeByEmployerAndJobName(ResumeName rName, EmployerName eName, JobName jName) {

		//List<JobID> matchingJobsList;
		//throw new JobAmbiguousException(matchingJobsList);
	}

	protected Jobs() { }

	static final private Jobs INSTANCE = new Jobs();

};
