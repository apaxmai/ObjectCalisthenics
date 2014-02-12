package datastructures;

import hashcodeprovider.HashCodeProvider;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class IdentifyingType
{
  private final String data;


  public IdentifyingType()
  {
    this.data = new SimpleDateFormat("yyyyMMdd HH:mm:ss ").format(Calendar.getInstance().getTime()) + new Random().nextInt(65536);
  }


  @Override
  public boolean equals(Object o)
  {
    return (o instanceof IdentifyingType) && (((IdentifyingType) o).data.equals(this.data));
  }


  @Override
  public int hashCode()
  {
    return HashCodeProvider.hashCodeFor(this, data);
  }
}
