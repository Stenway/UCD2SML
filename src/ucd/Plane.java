package ucd;

public class Plane {
	public final int Number;
	public final String Name;
	public final String Abbreviation;
	
	public Plane(int number, String name, String abbreviation) {
		Number = number;
		Name = name;
		Abbreviation = abbreviation;
		
		if (number < 0 || number >= Unicode.NUM_PLANES) {
			throw new UcdException("Invalid plane");
		}
	}
	
	public int getStart() {
		return Number * Unicode.PLANE_SIZE;
	}
	
	public int getEnd() {
		return (Number+1) * Unicode.PLANE_SIZE - 1;
	}
	
	public boolean contains(int codePoint) {
		return codePoint >= getStart() && codePoint <= getEnd();
	}
	
	@Override
	public String toString() {
		return "" + Number + " - " + Name + " - " + Abbreviation + " (" + StringUtils.getRangeString(getStart(), getEnd()) + ")";
	}
}
