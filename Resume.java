
public class Resume {

	static final public Resume invalid = new Resume();

	public Resume() {
	}
	public Resume(String name) {
		_name = new ResumeName(name);
	}
	public Resume(ResumeName name) {
		_name = name;
	}

        private ResumeName _name;

};

