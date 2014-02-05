
public class Employer
{

	private EmployerID _id;
	private EmployerName _name;

	public Employer()
	{ 
	}

	public Employer(String name)
	{
		_name = name;
	}

	public void postJob(Job theJob)
	{
		Jobs.addJob(_id, theJob);
	}

	public void postJob(JobType type, JobName name)
	{
		Jobs.addJob(_id, JobFactory.jobFrom(type, name) );
	}

}
