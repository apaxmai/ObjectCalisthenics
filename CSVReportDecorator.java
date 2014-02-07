
import java.util.List;

public class CSVReportDecorator implements ReportDecorator
{
  public String decorate(Report report)
  {
    String decorationTemplate[] = new String[5];
    decorationTemplate[0] = new String();
    decorationTemplate[1] = new String(",");
    decorationTemplate[2] = new String(",");
    decorationTemplate[3] = new String(",");
    decorationTemplate[4] = new String();
    
    String decoratedReport = new String();
    
    for( Integer rownum = 0; rownum < report.length(); rownum++ )
    {
      List<Object> row = report.row(rownum);
      
      //extract method //todo
      Integer fieldNum = 0;
      for( Object field : row )
      {
        decoratedReport += decorationTemplate[fieldNum] + field.toString();
        fieldNum++;
      }
      decoratedReport += decorationTemplate[4] + "\n";
      
    }
    
    return decoratedReport;
  }
}
