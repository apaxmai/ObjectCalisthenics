package employer;
import java.util.List;


public interface EmployerRepository
{
  public void add(Employer employer);
  public boolean containsEmployerWithID(EmployerID employerID);
}
