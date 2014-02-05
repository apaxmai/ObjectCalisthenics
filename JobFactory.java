
public class JobFactory
{

	private static final JobFactory INSTANCE = new JobFactory();
	private static Integer jobIDCounter = 0;

	public static JobFactory getInstance()
	{
		return INSTANCE;
	}

	public static Job jobFrom(JobType theJobType, JobName theJobName)
	{
		Job retJob;

		if( JobType.ATS == theJobType )
		{
			retJob = new ATSJob(theJobName); //pass integer
		}

		if( JobType.JREQ == theJobType )
		{
			retJob = new JReqJob(theJobName);
		}

		jobIDCounter++;
		return retJob;
	}

	protected JobFactory()
	{
	}
}
