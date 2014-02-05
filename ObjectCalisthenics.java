

public class ObjectCalisthenics {
	public final static void main(String[] args) {

		Employer anEmployer = new Employer("Perfect Cuboid Masonry");

		Job dummyJob = new ATSJob("CEO");
		anEmployer.postJob(dummyJob);

		anEmployer.postJob(JobType.ATS, "Groundskeeper");	//multiple jobs with same name and employer
		anEmployer.postJob(JobType.ATS, "Groundskeeper");
		anEmployer.postJob(JobType.ATS, "Groundskeeper");
		anEmployer.postJob(JobType.JREQ, "Senior Geometer");

		Jobseeker euler = new Jobseeker("Leonhard", "Euler");
		Jobseeker me = new Jobseeker("Charles", "Morris");

		euler.applyToJob( new EmployerName("Perfect Cuboid Masonry"), new JobName("CEO") );
		euler.applyToJob( new EmployerName("Perfect Cuboid Masonry"), new JobName("Groundskeeper") );
		euler.saveJob( new EmployerName("Perfect Cuboid Masonry"), new JobName("Senior Geometer") );

		try {
			me.applyToJob( new EmployerName("Perfect Cuboid Masonry"), new JobName("Senior Geometer") );
		} catch (ResumeRequiredException ex) {
			me.createResume("All About Me");
			me.createResume("Relevant Facts");
			me.applyToJobWithResume( new ResumeName("Relevant Facts"), new EmployerName("Perfect Cuboid Masonry"), new JobName("Senior Geometer") );
		}



	}
}
