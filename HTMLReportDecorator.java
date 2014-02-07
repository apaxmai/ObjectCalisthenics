
public class HTMLReportDecorator implements ReportDecorator
{
  public String decorate(Report report)
  {
    return "Hi";
    /*
     * 
     *       
      prefix = "<html><head><title>Job Application Report For Date "+ date +"</title></head><body><table>";
      suffix = "</table></body></html>";
      interleave[0] = "<tr><td>";
      interleave[1] = "</td><td>";
      interleave[2] = "</td><td>";
      interleave[3] = "</td><td>";
      interleave[4] = "</td></tr>";
      
     * */
  }
}
