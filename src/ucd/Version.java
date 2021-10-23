package ucd;

public class Version {
	public final int Major;
	public final int Minor;
	public final int Update;
	public final String Date;
	
	public Version(int major, int minor, int update, String date) {
		Major = major;
		Minor = minor;
		Update = update;
		Date = date;
	}
}
