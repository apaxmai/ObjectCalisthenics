import java.util.ArrayList;
import java.util.List;


public class MemoryResidentEmployerRepository implements EmployerRepository
{
  private List<Employer> employers;
	
  @Override
  public void add(Employer employer)
  {
    employers.add(employer);
  }

  @Override
  public boolean containsEmployerWithID(EmployerID employerID)
  {
	for( Employer employer : employers )
	{
	  if( employer.equals(employerID) )
	  {
        return true;
	  }
	}
    return false;
  }
  
  public MemoryResidentEmployerRepository()
  {
    employers = new ArrayList<>();
  }

}
