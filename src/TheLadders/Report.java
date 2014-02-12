package TheLadders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Report
{
  private List<Object[]> rows;


  public Report()
  {
    rows = new ArrayList<Object[]>();
  }


  public void addRow(Object... fields)
  {
    rows.add(fields);
  }


  public List<Object> row(Integer rowNum)
  {
    return new ArrayList<Object>(Arrays.asList(rows.get(rowNum)));
  }


  public Integer length()
  {
    return rows.size();
  }

}
