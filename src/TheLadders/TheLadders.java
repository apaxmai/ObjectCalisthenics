package TheLadders;
import java.util.ArrayList;
import java.util.List;

import datastructures.Triplet;
import job.Job;
import jobapplication.JobApplication;
import jobseeker.Jobseeker;
import employer.Employer;
import globals.Globals;

public class TheLadders
{

  public static void reportForJobApplicationsByDay(String date,
                                                   ReportFormatType theReportFormatType)
  {
    Report report = new Report();
    List<JobApplication> applications = Globals.jobApplicationRepository.succeededJobApplicationsByDay(date);

    for (JobApplication application : applications)
    {
      Job job = application.getJob(); // until i figure out how to do this, just do it. ( could be:
                                      // Job job; application.putJob(job); )
      Jobseeker jobseeker = application.getJobseeker();
      Employer employer = job.creator();
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

  //(11) TheLadders should be able to see aggregate job application numbers by job and employer.
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
  
  //(12) TheLadders should be able to see how many job applications failed and how many succeeded
  //aggregated by job and employer.
  public static void reportForAggregateJobApplicationsSuccessRate(ReportFormatType theReportFormatType)
  {
    Report report = new Report();
    
    //employer, job, applicationcount, ok%
    
    //this code is duplicated, need to combine into function //todo

    //this type needs to be created instead of list of triplet //todo
    List< Triplet<Employer, Job, Integer> > applicationAggregator = new ArrayList<>();
    
    List<JobApplication> applications = Globals.jobApplicationRepository.succeededJobApplications();
    for (JobApplication application : applications)
    {
      Job job = application.getJob(); // until i figure out how to do this, just do it. ( could be:
                                      // Job job; application.putJob(&job); )
      Employer employer = job.creator(); //Globals.postedJobRepository.getEmployerForJob(job);
      
      //if it does not contain [Employer, Job], add it
      boolean found = false;
      for( Triplet<Employer, Job, Integer> tuple : applicationAggregator )
      {
        if( employer.equals(tuple.getFirst()) && job.equals(tuple.getSecond()) )
        {
          //todo
          //update count in triplet in applicationAggregator
          //this def. needs its own object with update method.
          found = true;
        }
      }
      if( ! found )
      {
        applicationAggregator.add( new Triplet<Employer, Job, Integer>(employer, job, 0) );
      }
      
      //report.addRow(employer.toString(), job.toString(), applicationCount, successPct.toString());
    }
    //for all entries for the aggregate report:
    //foreach job and employer
    //Globals.jobApplicationRepository.failedJobApplicationsByJob(job);
    
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
	// this method will be extracted from the above. (byEmployer, then collect and decorate)
  }

}
