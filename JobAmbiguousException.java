
class JobAmbiguousException extends Exception {

	public JobAmbiguousException() {
		super();
	}

	public JobAmbiguousException(List<JobID> matchingJobsList) {
		super();
		matchingJobs = matchingJobsList;
	}

	public List<JobID> matchingJobs;
}
