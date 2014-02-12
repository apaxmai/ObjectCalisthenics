package job;

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

}
