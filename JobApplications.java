
public class JobApplications {

	static public JobApplications getInstance() { return INSTANCE; }

	static public void add(JobApplication theJobApplication) {
		//todo
	}

	protected JobApplications() { }

	static final private JobApplications INSTANCE = new JobApplications();
	//some structure
};
