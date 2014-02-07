
public class Report
{

  //a report has `n` columns and lots of rows.
  //define columns in constructor and addRow
  
  public Report(Integer n)
  {
    // todo
  }

  public void addRow(Object... fields)
  {
    Integer i = 0;
    for( Object field : fields )
    {
      //col[i] = field.toString();
      i++;
    }
  }
  
}
