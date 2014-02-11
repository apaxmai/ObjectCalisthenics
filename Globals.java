public class Globals
{
  public static JobRepository            postedJobRepository       = new MemoryResidentJobRepository();
  public static JobRepository            createdJobRepository      = new MemoryResidentJobRepository();
  public static SavedJobRepository       savedJobRepository        = new MemoryResidentSavedJobRepository();
  public static JobApplicationRepository jobApplicationRepository  = new MemoryResidentJobApplicationRepository();
  public static ReportDecorator          gCSVReportDecorator       = new CSVReportDecorator();
  public static ReportDecorator          gHTMLReportDecorator      = new HTMLReportDecorator();
  public static EmployerRepository       createdEmployerRepository = new MemoryResidentEmployerRepository();
}
