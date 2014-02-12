package TheLadders;

import java.io.OutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import job.AppliedJob;
import job.Job;
import jobapplication.FailedJobApplication;
import jobapplication.JobApplication;
import jobapplication.JobApplications;
import jobapplication.SuccessfulJobApplication;
import jobseeker.Jobseeker;
import datastructures.Triplet;
import employer.Employer;

public class TheLadders
{
  private static ReportDecorator myCSVReportDecorator  = new CSVReportDecorator();
  private static ReportDecorator myHTMLReportDecorator = new HTMLReportDecorator();

  public static void reportForJobApplicationsByDay(JobApplications jobApplications,
                                                   String date,
                                                   ReportFormatType theReportFormatType)
  {
    Report report = new Report();

    
    for (JobApplication application : jobApplications )
    {
      StringWriter sw = new StringWriter();
      application.putEmployerRepresentation(sw);
      String employerRepresentation = sw.toString();
      
      sw = new StringWriter();
      application.putJobRepresentation(sw);
      String jobRepresentation = sw.toString();
      
      sw = new StringWriter();
      application.putJobseekerRepresentation(sw);
      String jobseekerRepresentation = sw.toString();
      
      report.addRow(employerRepresentation,
                    jobRepresentation,
                    jobseekerRepresentation,
                    date.toString());
    }

    //todo, combine these using some polymorphism instead of typecheck
    if (ReportFormatType.CSV == theReportFormatType)
    {
      String decoratedReport = myCSVReportDecorator.decorate(report);
      System.out.println(decoratedReport);
      return;
    }

    if (ReportFormatType.HTML == theReportFormatType)
    {
      String decoratedReport = myHTMLReportDecorator.decorate(report);
      System.out.println(decoratedReport);
      return;
    }
  }

  // (11) TheLadders should be able to see aggregate job application numbers by job and employer.
  public static void reportForAggregateJobApplications(JobApplications jobApplications,
                                                       ReportFormatType theReportFormatType)
  {
    Report report = new Report();

    //these loops need extracting
    StringWriter sw;
    Map<String, Map<String, Integer>> uniqueEmployers = new HashMap<String, Map<String, Integer>>();
    for( JobApplication jobApplication : jobApplications )
    {
      sw = new StringWriter();
      jobApplication.putEmployerRepresentation(sw);
      String employerRepresentation = sw.toString();
      
      sw = new StringWriter();
      jobApplication.putJobRepresentation(sw);
      String jobRepresentation = sw.toString();
      
      Map<String, Integer> jobApplicationCountMap;
      if( uniqueEmployers.containsKey(employerRepresentation) )
      {
        jobApplicationCountMap = uniqueEmployers.get(employerRepresentation);
        if( jobApplicationCountMap.containsKey(jobRepresentation) )
        {
          Integer currentCount = jobApplicationCountMap.get(jobRepresentation);
          currentCount++;
          
          jobApplicationCountMap.put(jobRepresentation, currentCount);
          uniqueEmployers.put(employerRepresentation, jobApplicationCountMap);
        }
        
        if( ! jobApplicationCountMap.containsKey(jobRepresentation) )
        {
          jobApplicationCountMap = new HashMap<String, Integer>();
          jobApplicationCountMap.put(jobRepresentation, 1);
          uniqueEmployers.put(employerRepresentation, jobApplicationCountMap);
        }
      }
      if( ! uniqueEmployers.containsKey(employerRepresentation) )
      {
        jobApplicationCountMap = new HashMap<String, Integer>();
        jobApplicationCountMap.put(jobRepresentation, 1);
        uniqueEmployers.put(employerRepresentation, jobApplicationCountMap);
      }
    }

    for (Map.Entry entry : uniqueEmployers.entrySet())
    {
      String employerRepresentation = (String) entry.getKey();
      Object innerHashMap = entry.getValue();
      
      for (Map.Entry innerEntry : ((Map<String, Map<String, Integer>>) innerHashMap).entrySet())
      {
        String jobRepresentation = (String) innerEntry.getKey();
        Integer applicationCount = (Integer) innerEntry.getValue();
        report.addRow(employerRepresentation, jobRepresentation, applicationCount);
      }
    }

    if (ReportFormatType.CSV == theReportFormatType)
    {
      String decoratedReport = myCSVReportDecorator.decorate(report);
      System.out.println(decoratedReport);
      return;
    }

    if (ReportFormatType.HTML == theReportFormatType)
    {
      String decoratedReport = myHTMLReportDecorator.decorate(report);
      System.out.println(decoratedReport);
      return;
    }
  }

  // (12) TheLadders should be able to see how many job applications failed and how many succeeded
  // aggregated by job and employer.
  public static void reportForAggregateJobApplicationsSuccessRate(JobApplications jobApplications,
                                                                  ReportFormatType theReportFormatType)
  {
    Report report = new Report();

    // employer, job, successfulcount, failedcount
    StringWriter sw;
    Map<String, Map<String, Integer[]>> uniqueEmployers = new HashMap<String, Map<String, Integer[]>>();
    for( JobApplication jobApplication : jobApplications )
    {
      sw = new StringWriter();
      jobApplication.putEmployerRepresentation(sw);
      String employerRepresentation = sw.toString();
      
      sw = new StringWriter();
      jobApplication.putJobRepresentation(sw);
      String jobRepresentation = sw.toString();
      
      Map<String, Integer[]> jobApplicationCountMap;
      if( uniqueEmployers.containsKey(employerRepresentation) )
      {
        jobApplicationCountMap = uniqueEmployers.get(employerRepresentation);
        if( jobApplicationCountMap.containsKey(jobRepresentation) )
        {
          Integer[] currentCounts = jobApplicationCountMap.get(jobRepresentation);
          
          if( jobApplication instanceof SuccessfulJobApplication )
          {
            currentCounts[0]++;
          }
          if( jobApplication instanceof FailedJobApplication )
          {
            currentCounts[1]++;
          }
          
          jobApplicationCountMap.put(jobRepresentation, currentCounts);
          uniqueEmployers.put(employerRepresentation, jobApplicationCountMap);
        }
        
        if( ! jobApplicationCountMap.containsKey(jobRepresentation) )
        {
          jobApplicationCountMap = new HashMap<String, Integer[]>();
          if( jobApplication instanceof SuccessfulJobApplication )
          {
            jobApplicationCountMap.put(jobRepresentation, new Integer[]{1,0});
          }
          if( jobApplication instanceof FailedJobApplication )
          {
            jobApplicationCountMap.put(jobRepresentation, new Integer[]{0,1});
          }

          uniqueEmployers.put(employerRepresentation, jobApplicationCountMap);
        }
      }
      if( ! uniqueEmployers.containsKey(employerRepresentation) )
      {
        jobApplicationCountMap = new HashMap<String, Integer[]>();
        if( jobApplication instanceof SuccessfulJobApplication )
        {
          jobApplicationCountMap.put(jobRepresentation, new Integer[]{1,0});
        }
        if( jobApplication instanceof FailedJobApplication )
        {
          jobApplicationCountMap.put(jobRepresentation, new Integer[]{0,1});
        }
        uniqueEmployers.put(employerRepresentation, jobApplicationCountMap);
      }
    }

    for (Map.Entry entry : uniqueEmployers.entrySet())
    {
      String employerRepresentation = (String) entry.getKey();
      Object innerHashMap = entry.getValue();
      
      for (Map.Entry innerEntry : ((Map<String, Map<String, Integer[]>>) innerHashMap).entrySet())
      {
        String jobRepresentation = (String) innerEntry.getKey();
        
        Integer[] applicationCounts = (Integer[]) innerEntry.getValue();
        report.addRow(employerRepresentation, jobRepresentation, applicationCounts[0], applicationCounts[1]);
      }
    }

    if (ReportFormatType.CSV == theReportFormatType)
    {
      String decoratedReport = myCSVReportDecorator.decorate(report);
      System.out.println(decoratedReport);
      return;
    }

    if (ReportFormatType.HTML == theReportFormatType)
    {
      String decoratedReport = myHTMLReportDecorator.decorate(report);
      System.out.println(decoratedReport);
      return;
    }
  }

}
