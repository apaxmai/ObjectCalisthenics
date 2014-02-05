
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

	public void saveJob(Job theJob) {
		//unimp //todo
	}
	public void saveJob(EmployerName eName, JobName jName) {
		//look up job //unimp //todo
	}

	public void createResume(String rName) {
		createResume(new ResumeName(rName));
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
			Jobs.acceptApplicationToJobWithResumeByEmployerAndJobName( _id, theResumeToSubmit, eName, jName);
		} catch (JobAmbiguousException ex) {
			List<JobID> matchingJobs = ex.matchingJobs;
			Jobs.acceptApplicationToJobWithResumeByJobID( _id, theResumeToSubmit, matchingJobs.get(0) ); //user would pick
		}
	}

	private JobseekerID _id;	//this will need to contain HumanName //todo
	private HumanName _name;
	private HashMap<ResumeName, Resume> _resumes;
	//saving jobs cannot be done yet due to restriction on number of members //todo
	//move saved jobs data to another class that remembers the map: JobseekerID -> List<JobID>
}
