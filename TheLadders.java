import java.util.List;

public class TheLadders
{
  /*
   * TheLadders should be able to get a report of what jobseekers have applied to jobs on any given
   * day. TheLadders should be able to get the job application report in either csv or html format.
   * TheLadders should be able to ascertain jobseeker, job, employer and job application date from
   * the job application report. reportForJobsApplicationsByDay( Day d, ReportType t ) TheLadders
   * should be able to see aggregate job application numbers by job and employer.
   * reportForAggregateJobApplications( TheLadders should be able to see how many job applications
   * failed and how many succeeded aggregated by job and employer.
   * reportForAggregateJobApplicationsSuccessRate()
   */

  public static void reportForJobApplicationsByDay(String date,
                                                   ReportFormatType theReportFormatType)
  {
    Report report = new Report(4);
    List<JobApplication> applications = Globals.jobApplicationRepository.jobApplicationsByDay(date);
    
    for( JobApplication application : applications )
    {
      Job job = application.getJob(); //until i figure out how to do this, just do it.
      Jobseeker jobseeker = application.getJobseeker();
      Employer employer = Globals.postedJobRepository.getEmployerForJob(job);
      report.addRow( employer.toString(), job.toString(), jobseeker.toString(), date.toString() );
    }
    
    if( ReportFormatType.CSV == theReportFormatType )
    {
      String decoratedReport = Globals.gCSVReportDecorator.decorate(report);
      System.out.println(decoratedReport);
      return;
    }
    
    if( ReportFormatType.HTML == theReportFormatType )
    {
      String decoratedReport = Globals.gHTMLReportDecorator.decorate(report);
      System.out.println(decoratedReport);
      return;
    }
  }

  public static void reportForAggregateJobApplications()
  {
    // for (Employer e : Employers.getEmployersAsList())
    // {
    // reportForAggregateJobApplications(e);
    // }
  }

  public static void reportForAggregateJobApplications(Employer theEmployer)
  {
    // todo
  }

  public static void reportForAggregateJobApplicationsSuccessRate()
  {
    // for (Employer e : Employers.getEmployersAsList())
    // {
    // reportForAggregateJobApplicationsSuccessRate(e);
    // }
  }

  public static void reportForAggregateJobApplicationsSuccessRate(Employer theEmployer)
  {
    // daniel: failures for technical reasons
    // ask
  }

}
