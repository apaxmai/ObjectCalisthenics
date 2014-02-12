package TheLadders;

import java.util.List;

public class HTMLReportDecorator implements ReportDecorator
{
  public String decorate(Report report)
  {
    String decorationTemplate[] = new String[5];
    decorationTemplate[0] = new String("<tr><td>");
    decorationTemplate[1] = new String("</td><td>");
    decorationTemplate[2] = new String("</td><td>");
    decorationTemplate[3] = new String("</td><td>");
    decorationTemplate[4] = new String("</td></tr>");

    String decoratedReport = new String();

    decoratedReport += "<html>\n<head><title>Job Applications Report by Day</title></head>\n<body>\n";
    for (Integer rownum = 0; rownum < report.length(); rownum++)
    {
      List<Object> row = report.row(rownum);

      // extract method //todo
      Integer fieldNum = 0;
      for (Object field : row)
      {
        decoratedReport += decorationTemplate[fieldNum] + field.toString();
        fieldNum++;
      }
      decoratedReport += decorationTemplate[4] + "\n";

    }
    decoratedReport += "</body>\n</html>";

    return decoratedReport;
  }
}
