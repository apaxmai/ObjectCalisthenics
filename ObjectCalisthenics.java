

public class ObjectCalisthenics
{
  public final static void main(String[] args)
  {
	
	Employers.add( EmployerFactory.employerFrom( new EmployerName("Perfect Cuboid Masonry") ) );
	//Employers.add( EmployerFactory.employerFrom( new EmployerName("Perfect Cuboid Masonry") ) ); //a second one, with no jobs.
	
	try
	{
	  Employers.firstEmployerByNamePostJob(
			new EmployerName("Fake Employer !!DEBUG"),
			JobType.ATS,
			new JobName("CEO")
		);
	}
	catch (NoSuchEmployerException ex)
	{
		System.out.println("Fake Employer not found. [OK]");
	}
	
	try
	{
	  Employers.firstEmployerByNamePostJob(
			new EmployerName("Perfect Cuboid Masonry"),
			JobType.ATS,
			new JobName("CEO")
		);
	}
	catch (NoSuchEmployerException ex){ System.out.println("Exception: Cannot find the masonry [FAILED]: "+ex); }
	
    //anEmployer.postJob(JobType.ATS, "CEO");
    System.out.println("Created ATS CEO");
    //anEmployer.postJob(JobType.ATS, "Groundskeeper");	//multiple jobs with same name and employer
    System.out.println("Created ATS Groundskeeper");
    //anEmployer.postJob(JobType.ATS, "Groundskeeper");
    System.out.println("Created ATS Groundskeeper");
    //anEmployer.postJob(JobType.ATS, "Groundskeeper");
    System.out.println("Created ATS Groundskeeper");
    //anEmployer.postJob(JobType.JREQ, "Senior Geometer");
    System.out.println("Created JREQ Senior Geometer");

    Jobseeker euler = new Jobseeker("Leonhard", "Euler");
    System.out.println("Created new Jobseeker");
    Jobseeker me = new Jobseeker("Charles", "Morris");
    System.out.println("Created new Jobseeker");
    
    try
    {
      System.out.println("Jobseeker applying to ATS CEO without Resume");
      euler.applyToJob( new EmployerName("Perfect Cuboid Masonry"), new JobName("CEO") );
    } catch  (ResumeRequiredException | EmployerAmbiguousException | NoSuchEmployerException innerEx) { }
    try
    {
      System.out.println("Jobseeker applying to ATS Grounskeeper without Resume");
      euler.applyToJob( new EmployerName("Perfect Cuboid Masonry"), new JobName("Groundskeeper") );
    } catch  (ResumeRequiredException | EmployerAmbiguousException | NoSuchEmployerException innerEx) { }
    
    System.out.println("Jobseeker saving job Senior Geometer");
    euler.saveJob( new EmployerName("Perfect Cuboid Masonry"), new JobName("Senior Geometer") );

    try
    {
      System.out.println("Jobseeker applying to JREQ Senior Geometer without Resume");
      me.applyToJob( new EmployerName("Perfect Cuboid Masonry"), new JobName("Senior Geometer") );
    }
    catch (ResumeRequiredException ex)
    {
      System.out.println("Jobseeker recieved a ResumeRequiredException");
      me.createResume("All About Me");
      me.createResume("Relevant Facts");
      try
      {
    	System.out.println("Jobseeker applying to JREQ Senior Geometer with Resume");
        me.applyToJobWithResume( new ResumeName("Relevant Facts"), new EmployerName("Perfect Cuboid Masonry"), new JobName("Senior Geometer") );
      }
      catch (ResumeRequiredException | EmployerAmbiguousException | NoSuchEmployerException innerEx)
      {
    	System.out.println("Exception: Jobseeker applying to JREQ Senior Geometer with Resume [FAILED]: "+innerEx);
      }
    }
    catch ( EmployerAmbiguousException | NoSuchEmployerException ex )
    {
      System.out.println("Exception: Jobseeker applying to JREQ Senior Geometer without Resume [FAILED]: "+ex);
    }

  }
}
