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
    Report report = new Report();
    List<JobApplication> applications = Globals.jobApplicationRepository.jobApplicationsByDay(date);

    for (JobApplication application : applications)
    {
      Job job = application.getJob(); // until i figure out how to do this, just do it. ( could be:
                                      // Job job; application.putJob(job); )
      Jobseeker jobseeker = application.getJobseeker();
      Employer employer = Globals.postedJobRepository.getEmployerForJob(job);
      report.addRow(employer.toString(), job.toString(), jobseeker.toString(), date.toString());
    }

    if (ReportFormatType.CSV == theReportFormatType)
    {
      String decoratedReport = Globals.gCSVReportDecorator.decorate(report);
      System.out.println(decoratedReport);
      return;
    }

    if (ReportFormatType.HTML == theReportFormatType)
    {
      String decoratedReport = Globals.gHTMLReportDecorator.decorate(report);
      System.out.println(decoratedReport);
      return;
    }
  }

  public static void reportForAggregateJobApplications(ReportFormatType theReportFormatType)
  {
    Report report = new Report();

    // //

    if (ReportFormatType.CSV == theReportFormatType)
    {
      String decoratedReport = Globals.gCSVReportDecorator.decorate(report);
      System.out.println(decoratedReport);
      return;
    }

    if (ReportFormatType.HTML == theReportFormatType)
    {
      String decoratedReport = Globals.gHTMLReportDecorator.decorate(report);
      System.out.println(decoratedReport);
      return;
    }
  }

  public static void reportForAggregateJobApplications(Employer theEmployer,
                                                       ReportFormatType theReportFormatType)
  {
    Report report = new Report();

    // //

    if (ReportFormatType.CSV == theReportFormatType)
    {
      String decoratedReport = Globals.gCSVReportDecorator.decorate(report);
      System.out.println(decoratedReport);
      return;
    }

    if (ReportFormatType.HTML == theReportFormatType)
    {
      String decoratedReport = Globals.gHTMLReportDecorator.decorate(report);
      System.out.println(decoratedReport);
      return;
    }
    return;
  }

  public static void reportForAggregateJobApplicationsSuccessRate(ReportFormatType theReportFormatType)
  {
    Report report = new Report();

    // //

    if (ReportFormatType.CSV == theReportFormatType)
    {
      String decoratedReport = Globals.gCSVReportDecorator.decorate(report);
      System.out.println(decoratedReport);
      return;
    }

    if (ReportFormatType.HTML == theReportFormatType)
    {
      String decoratedReport = Globals.gHTMLReportDecorator.decorate(report);
      System.out.println(decoratedReport);
      return;
    }
  }

  public static void reportForAggregateJobApplicationsSuccessRate(Employer theEmployer,
                                                                  ReportFormatType theReportFormatType)
  {
    // daniel: failures for technical reasons
  }

}
