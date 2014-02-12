package job;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class AppliedJob
{

  private String time;
  private Job    job;


  protected AppliedJob(Job job)
  {
    this.job = job;
    this.time = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
  }

  public void putJob(Job[] job)
  {
    job[0] = this.job;
  }

  public void putEmployerRepresentation(StringWriter sw)
  {
    job.putEmployerRepresentation(sw);
  }

  public void putJobRepresentation(StringWriter sw)
  {
    job.putRepresentation(sw);
  }
  
}
