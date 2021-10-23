package ucd;

public class Planes {
	public static final Plane[] Planes = new Plane[Unicode.NUM_PLANES];
	
	public Planes() {
		Planes[0] = new Plane(0, "Basic Multilingual Plane", "BMP");
		Planes[1] = new Plane(1, "Supplementary Multilingual Plane", "SMP");
		Planes[2] = new Plane(2, "Supplementary Ideographic Plane", "SIP");
		Planes[3] = new Plane(3, "Tertiary Ideographic Plane", "TIP");
		Planes[4] = new Plane(4, null, null);
		Planes[5] = new Plane(5, null, null);
		Planes[6] = new Plane(6, null, null);
		Planes[7] = new Plane(7, null, null);
		Planes[8] = new Plane(8, null, null);
		Planes[9] = new Plane(9, null, null);
		Planes[10] = new Plane(10, null, null);
		Planes[11] = new Plane(11, null, null);
		Planes[12] = new Plane(12, null, null);
		Planes[13] = new Plane(13, null, null);
		Planes[14] = new Plane(14, "Supplementary Special-purpose Plane", "SSP");
		Planes[15] = new Plane(15, "Supplementary Private Use Area A", "SPUA-A");
		Planes[16] = new Plane(16, "Supplementary Private Use Area B", "SPUA-B");
	}
	
	public String[][] toTable() {
		String[][] result = new String[18][];
		result[0] = new String[] {"Plane", "Name", "Abbreviation", "From", "To"};
		for (int i=0; i<Unicode.NUM_PLANES; i++) {
			Plane plane = Planes[i];
			result[i+1] = new String[] {""+plane.Number, plane.Name, plane.Abbreviation,
				StringUtils.toHexString(plane.getStart()), StringUtils.toHexString(plane.getEnd())};
		}
		return result;
	}
}
