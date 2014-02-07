import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JobApplication
{
  /*
   * could be: private JobApplicant (jobseekerID + resume ) private JobApplicationData ( jobID +
   * applicationDate )
   */

  private Jobseeker jobseeker;
  private Resume    resume;
  private Job       job;
  private String    date;     // todo: Wrap it DateType style

  private JobApplication(Jobseeker jobseeker,
                         Resume resume,
                         Job job)
  {
    this.date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()); // dateformatter.now()
    this.jobseeker = jobseeker;
    this.resume = resume;
    this.job = job;
  }

  public static JobApplication from(Jobseeker jobseeker,
                                    Job job)
  {
    return new JobApplication(jobseeker, Resume.invalid, job);
  }

  public static JobApplication from(Jobseeker jobseeker,
                                    Resume resume,
                                    Job job)
  {
    return new JobApplication(jobseeker, resume, job);
  }

  public boolean appliedOnDate(String date)
  {
    return this.date.equals(date);
  }

  @Override
  public String toString()
  {
    return jobseeker.toString() + ':' + resume.toString() + ':' + job.toString() + ':' + date;
  }

};
