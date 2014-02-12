package employer;

public interface EmployerRepository
{
  public void add(Employer employer);


  public boolean containsEmployerWithID(EmployerID employerID);
}
