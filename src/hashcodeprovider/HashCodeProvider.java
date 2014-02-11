package hashcodeprovider;

public class HashCodeProvider
{
  //this would be another "premature optimization", just ignore this it can be `return 0;`
  public static int hashCodeFor(Object object, Object ... fields)
  {
    int ret = 0;
    int temp = 0;
    
    int []array = new int[] {38, 113, 41, 68, 35, 74, 111};
    
    for( Object field : fields )
    {
      temp = field.hashCode();
      for( int i = 0; i < 7; i++ )
      {
    	int k = array[i];
        if( k <= 32 )
        {
          temp += ret << k;
        }
        if( k > 32 && k <= 64 )
        {
          temp -= temp << (k-32);
        }
        if( k > 64 && k <= 96 )
        {
          ret ^= temp << (k-64);
        }
        if( k > 96 )
        {
          ret ^= temp >> (k-96);
        }
      }
      ret = ret ^ temp;
    }
    
    return ret;
  }
  
  
  //
}

/*
38 113  42  69  35  73 112
38 114   9 100  35 107  46
38 114  11  66   8  68 112
38 114  42  69  35  73 112
38 114  78  37  71  35 111
39 113  41  68   2  74 112
39 114   9 101   2 107  17
39 114   9 101   2 107  49
39 114  37  99  39 109  50
39 115  36  67  38  44 112
39 115  37  70  35 110  11
39 115  41  74  36  67 111
39 116   4 104   6 107  16
39 116  10 101   8  75 113
40 113  12  99  39  69 112
40 113  13  99   6  69 113
40 113  38 101   2 106  16
40 113  38 101   2 106  48
40 114   3 102   8 109  15
40 114  37  99   7  77 113
41 113  11 100   7  69 111
42 114  44  99  38  72 113
43 115   7 101   3 109  48
44 114  36 105  38 108  16
44 114  37 102  35 107  16
44 114  41 101   2 109  16
45 113  37 102   3 108  47
45 113  37 105  35 104  17
45 113  37 105  35 104  47
45 113  39  99  37  76 111
45 113  42 101   2 109  46
45 113  42 101   2 109  50
46 113  42 101  35 110  47
46 113  42 101  35 110  50
 */