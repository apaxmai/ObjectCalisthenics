package globals;
import TheLadders.CSVReportDecorator;
import TheLadders.HTMLReportDecorator;
import TheLadders.ReportDecorator;
import job.JobRepository;
import job.MemoryResidentJobRepository;
import job.MemoryResidentSavedJobRepository;
import job.SavedJobRepository;
import jobapplication.JobApplicationRepository;
import jobapplication.MemoryResidentJobApplicationRepository;
import jobseeker.JobseekerRepository;
import jobseeker.MemoryResidentJobseekerRepository;
import employer.EmployerRepository;
import employer.MemoryResidentEmployerRepository;

public class Globals
{
  public static JobRepository            postedJobRepository        = new MemoryResidentJobRepository();
  public static JobRepository            createdJobRepository       = new MemoryResidentJobRepository();
  public static SavedJobRepository       savedJobRepository         = new MemoryResidentSavedJobRepository();
  public static JobApplicationRepository jobApplicationRepository   = new MemoryResidentJobApplicationRepository();
  public static ReportDecorator          gCSVReportDecorator        = new CSVReportDecorator();
  public static ReportDecorator          gHTMLReportDecorator       = new HTMLReportDecorator();
  public static EmployerRepository       createdEmployerRepository  = new MemoryResidentEmployerRepository();
  public static JobseekerRepository      createdJobseekerRepository = new MemoryResidentJobseekerRepository();
}
