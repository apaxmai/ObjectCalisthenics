public class EmployerFactory
{

  //daniel suggests to place global employer into the factory?
  private static Integer               jobIDCounter = 0;

  public static Employer employerFrom(EmployerName theEmployerName) throws AlreadyExistsException
  {
    EmployerID id = new EmployerID(new IdentifyingType(jobIDCounter));
    Employer retJob = Employer.employerFrom(id, theEmployerName);

    jobIDCounter++;
    return retJob;
  }

  private EmployerFactory()
  {
  }
}
