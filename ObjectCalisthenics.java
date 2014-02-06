

public class ObjectCalisthenics
{
  public final static void main(String[] args)
  {

    Employer anEmployer = new Employer("Perfect Cuboid Masonry");

    anEmployer.postJob(JobType.ATS, "CEO");
    anEmployer.postJob(JobType.ATS, "Groundskeeper");	//multiple jobs with same name and employer
    anEmployer.postJob(JobType.ATS, "Groundskeeper");
    anEmployer.postJob(JobType.ATS, "Groundskeeper");
    anEmployer.postJob(JobType.JREQ, "Senior Geometer");

    Jobseeker euler = new Jobseeker("Leonhard", "Euler");
    Jobseeker me = new Jobseeker("Charles", "Morris");

    try
    {
      euler.applyToJob( new EmployerName("Perfect Cuboid Masonry"), new JobName("CEO") );
    } catch  (ResumeRequiredException | EmployerAmbiguousException innerEx) { }
    try
    {
      euler.applyToJob( new EmployerName("Perfect Cuboid Masonry"), new JobName("Groundskeeper") );
    } catch  (ResumeRequiredException | EmployerAmbiguousException innerEx) { }
    euler.saveJob( new EmployerName("Perfect Cuboid Masonry"), new JobName("Senior Geometer") );

    try
    {
      me.applyToJob( new EmployerName("Perfect Cuboid Masonry"), new JobName("Senior Geometer") );
    }
    catch (ResumeRequiredException | EmployerAmbiguousException ex)
    {
      me.createResume("All About Me");
      me.createResume("Relevant Facts");
      try
      {
        me.applyToJobWithResume( new ResumeName("Relevant Facts"), new EmployerName("Perfect Cuboid Masonry"), new JobName("Senior Geometer") );
      }
      catch (ResumeRequiredException | EmployerAmbiguousException innerEx)
      {
        //should never happen
      }
    }

  }
}
