public class EmployerFactory
{

  private static final EmployerFactory INSTANCE     = new EmployerFactory();
  private static Integer               jobIDCounter = 0;

  public static EmployerFactory getInstance()
  {
    return INSTANCE;
  }

  public static Employer employerFrom(EmployerName theEmployerName)
  {
    EmployerID id = new EmployerID(new IdentifyingType(jobIDCounter));
    Employer retJob = Employer.employerFrom(id, theEmployerName);

    jobIDCounter++;
    return retJob;
  }

  protected EmployerFactory()
  {}
}
