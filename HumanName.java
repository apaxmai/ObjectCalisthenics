
public class HumanName {

	public HumanName() {
	}
	public HumanName(String givenName) {
		_givenName = givenName;
	}
	public HumanName(String givenName, String familyName) {
		_givenName = givenName;
		_familyName = familyName;
	}

	private String _givenName;
	private String _familyName;
};
