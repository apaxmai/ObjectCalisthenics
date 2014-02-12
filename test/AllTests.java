import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EmployerTest.class,
               JobTest.class,
               JobseekerTest.class,
               JobApplicationManagerTest.class,
               TheLaddersTest.class })
public class AllTests
{

}
