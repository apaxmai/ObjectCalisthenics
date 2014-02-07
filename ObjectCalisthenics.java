import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ObjectCalisthenics
{
  public final static void main(String[] args)
  {

    Employer theMasonry = EmployerFactory.employerFrom(new EmployerName("Perfect Cuboid Masonry"));
    Employer numbersRUs = EmployerFactory.employerFrom(new EmployerName("Numbers-R-Us"));

    Job masonryCEOJob = JobFactory.jobFrom(JobType.ATS, new JobName("CEO"));
    Job masonryGroundskeeperJob1 = JobFactory.jobFrom(JobType.ATS, new JobName("Groundskeeper"));
    Job masonryGroundskeeperJob2 = JobFactory.jobFrom(JobType.ATS, new JobName("Groundskeeper"));
    Job masonryGroundskeeperJob3 = JobFactory.jobFrom(JobType.ATS, new JobName("Groundskeeper"));
    Job masonrySeniorGeometerJob = JobFactory.jobFrom(JobType.JREQ, new JobName("Senior Geometer"));

    Job numberStoreJob = JobFactory.jobFrom(JobType.ATS, new JobName("Head of 64-bit Unsigned Integer Sales"));

    theMasonry.postJob(masonryCEOJob);
    theMasonry.postJob(masonryGroundskeeperJob1);
    theMasonry.postJob(masonryGroundskeeperJob2);
    theMasonry.postJob(masonryGroundskeeperJob3);
    theMasonry.postJob(masonrySeniorGeometerJob);

    numbersRUs.postJob(numberStoreJob);

    Jobseeker sophie = new Jobseeker("Sophie", "Germain");
    Jobseeker euler = new Jobseeker("Leonhard", "Euler");
    Jobseeker me = new Jobseeker("Charles", "Morris");

    try
    {
      sophie.applyToJob(numberStoreJob);
    }
    catch (ResumeRequiredException e)
    {}

    try
    {
      System.out.println("Jobseeker applying to ATS CEO without Resume");
      euler.applyToJob(masonryCEOJob);
    }
    catch (ResumeRequiredException innerEx)
    {}

    try
    {
      System.out.println("Jobseeker applying to ATS Groundskeeper without Resume");
      euler.applyToJob(masonryGroundskeeperJob1);
    }
    catch (ResumeRequiredException innerEx)
    {}

    System.out.println("Jobseeker saving job Senior Geometer");
    euler.saveJob(masonrySeniorGeometerJob);

    try
    {
      System.out.println("Jobseeker applying to JREQ Senior Geometer without Resume");
      me.applyToJob(masonrySeniorGeometerJob);
    }
    catch (ResumeRequiredException ex)
    {
      System.out.println("Jobseeker recieved a ResumeRequiredException... creating a resume");
      me.createResume("All About Me");
      me.createResume("Relevant Facts");
      try
      {
        System.out.println("Jobseeker applying to JREQ Senior Geometer with Resume");
        me.applyToJobWithResume(masonrySeniorGeometerJob, new ResumeName("Relevant Facts"));
      }
      catch (ResumeRequiredException ex2)
      {
        System.out.println("Exception: Jobseeker applying to JREQ Senior Geometer with Resume [FAILED]: " + ex2);
      }
    }

    String today = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
    TheLadders.reportForJobApplicationsByDay(today, ReportFormatType.CSV);
    
  }
}
