
public class ATSJob extends Job
{

	public ATSJob()
	{
	}

	public ATSJob(String name)
	{
		_name = new JobName(name);
	}
	public ATSJob(JobID id, JobName name)
	{
		_id = id;
		_name = name;
	}

};
