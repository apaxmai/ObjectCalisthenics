import java.text.SimpleDateFormat;
import java.util.Calendar;

import job.Job;
import job.JobFactory;
import job.JobName;
import job.JobType;
import jobapplication.JobApplications;
import jobseeker.HumanName;
import jobseeker.Jobseeker;
import jobseeker.NoSuchResumeException;
import jobseeker.ResumeName;
import jobseeker.ResumeRequiredException;
import TheLadders.ReportFormatType;
import TheLadders.TheLadders;
import employer.AlreadyExistsException;
import employer.Employer;
import employer.EmployerName;

public class ObjectCalisthenics
{
  public final static void main(String[] args) throws AlreadyExistsException, NoSuchResumeException, ResumeRequiredException
  {

    Employer theMasonry = Employer.with(new EmployerName("Perfect Cuboid Masonry"));
    Employer numbersRUs = Employer.with(new EmployerName("Numbers-R-Us"));

    Job masonryCEOJob = JobFactory.jobFrom(theMasonry, JobType.ATS, new JobName("CEO"));
    Job masonryGroundskeeperJob1 = JobFactory.jobFrom(theMasonry, JobType.ATS, new JobName("Groundskeeper"));
    Job masonryGroundskeeperJob2 = JobFactory.jobFrom(theMasonry, JobType.ATS, new JobName("Groundskeeper"));
    Job masonryGroundskeeperJob3 = JobFactory.jobFrom(theMasonry, JobType.ATS, new JobName("Groundskeeper"));
    Job masonrySeniorGeometerJob = JobFactory.jobFrom(theMasonry, JobType.JREQ, new JobName("Senior Geometer"));

    Job numberStoreJob = JobFactory.jobFrom(numbersRUs,
                                            JobType.ATS,
                                            new JobName("Head of 64-bit Unsigned Integer Sales"));

    theMasonry.postJob(masonryCEOJob);
    theMasonry.postJob(masonryGroundskeeperJob1);
    theMasonry.postJob(masonryGroundskeeperJob2);
    theMasonry.postJob(masonryGroundskeeperJob3);
    theMasonry.postJob(masonrySeniorGeometerJob);
    numbersRUs.postJob(numberStoreJob);
    
    JobApplications jobApplications = JobApplications.empty();

    Jobseeker sophie = Jobseeker.with(new HumanName("Sophie", "Germain"));
    Jobseeker euler = Jobseeker.with(new HumanName("Leonhard", "Euler"));
    Jobseeker me = Jobseeker.with(new HumanName("Charles", "Morris"));

    jobApplications.add( sophie.applyToJob(numberStoreJob) );
    jobApplications.add( euler.applyToJob(numberStoreJob) );

    System.out.println("Jobseeker applying to ATS CEO without Resume");
    jobApplications.add( euler.applyToJob(masonryCEOJob) );


    System.out.println("Jobseeker applying to ATS Groundskeeper without Resume");
    jobApplications.add( euler.applyToJob(masonryGroundskeeperJob1) );

    System.out.println("Jobseeker saving job Senior Geometer");
    euler.saveJob(masonrySeniorGeometerJob);

    System.out.print("The saved job was: ");
    euler.getListingOfSavedJobs();


    System.out.println("Jobseeker applying to JREQ Senior Geometer without Resume");
    jobApplications.add( me.applyToJob(masonrySeniorGeometerJob) );
    me.createResume("All About Me");
    me.createResume("Relevant Facts");
    jobApplications.add( me.applyToJobWithResume(masonrySeniorGeometerJob, new ResumeName("Relevant Facts")));


    String today = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());

    System.out.println("Testing TheLadders.reportForJobApplicationsByDay for Today and CSV:");
    TheLadders.reportForJobApplicationsByDay(jobApplications, today, ReportFormatType.CSV);

    System.out.println("Testing TheLadders.reportForJobApplicationsByDay for Today and HTML:");
    TheLadders.reportForJobApplicationsByDay(jobApplications, today, ReportFormatType.HTML);

    System.out.println("Testing TheLadders.reportForAggregateJobApplications for CSV:");
    TheLadders.reportForAggregateJobApplications(jobApplications, ReportFormatType.CSV);
    
    System.out.println("Testing TheLadders.reportForAggregateJobApplications for HTML:");
    TheLadders.reportForAggregateJobApplications(jobApplications, ReportFormatType.HTML);
    
    System.out.println("Testing TheLadders.reportForAggregateJobApplicationsSuccessRate for CSV:");
    TheLadders.reportForAggregateJobApplicationsSuccessRate(jobApplications, ReportFormatType.CSV);
  }
}
