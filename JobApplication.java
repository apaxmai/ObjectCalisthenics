
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class JobApplication
{
  /*
   * could be:
   * private JobApplicant (jobseekerID + resume )
   * private JobApplicationData ( jobID + applicationDate )
   */
	
  private JobseekerID jobseekerID;
  private Resume resume;
  private JobID jobID;
  private String timestamp; //datetime type?
  
  public JobApplication()
  {
  }

  public JobApplication(JobseekerID jobseekerID, Resume resume, JobID jobID)
  {
    this.timestamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
    this.jobseekerID = jobseekerID;
    this.resume = resume;
    this.jobID = jobID;
  }
  
};
