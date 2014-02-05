
import java.util.Collection;
import java.util.List;
import java.util.HashMap;

public class Jobseeker {

	public Jobseeker() {
		_name = new HumanName();
		_resumes = new HashMap<ResumeName, Resume>();
	}
	public Jobseeker(String givenName) {
		_name = new HumanName(givenName);
		_resumes = new HashMap<ResumeName, Resume>();
	}
	public Jobseeker(String givenName, String familyName) {
		_name = new HumanName(givenName, familyName);
		_resumes = new HashMap<ResumeName, Resume>();
	}

	public void createResume(ResumeName rName) {
		_resumes.put( rName, new Resume(rName) );
	}

	public void applyToJob(EmployerName eName) {
		applyToJob(eName, JobName.invalid);
	}
	public void applyToJob(JobName jName) {
		applyToJob(EmployerName.invalid, jName);
	}
	public void applyToJob(EmployerName eName, JobName jName) {
		applyToJobWithResume(ResumeName.invalid, eName, jName);
	}
	public void applyToJobWithResume(ResumeName rName, EmployerName eName, JobName jName) {

		Resume theResumeToSubmit = Resume.invalid;
		if( ResumeName.invalid != rName ) {
			theResumeToSubmit = _resumes.get(rName);
		}

		try {
			Jobs.applyToJobWithResumeByEmployerAndJobName(rName, eName, jName);
		} catch (JobAmbiguousException ex) {
			List<JobID> matchingJobs = ex.matchingJobs();
			Jobs.applyToJobWithResumeByJobID( rName, matchingJobs.get(0) ); //user would pick
		}
	}


	private HumanName _name;
	private HashMap<ResumeName, Resume> _resumes;
}
