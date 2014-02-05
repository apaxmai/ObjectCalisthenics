
public class Employer {

	public Employer() { 
	}

	public Employer(String name) { 
		_name = name;
	}

	public void postJob(Job theJob) {
		Jobs.addJob(_id, theJob);
	}

	public void postJob(JobType type, String name) {
		Jobs.addJob(_id, JobFactory.jobFrom(type, name) );
	}

	private EmployerID _id;
	private String _name;
}
