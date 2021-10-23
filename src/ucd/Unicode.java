package ucd;

public class Unicode {
	public static final int NUM_PLANES = 17;
	public static final int PLANE_SIZE = 0x10000;
	
	public static final int NUM_CODEPOINTS = NUM_PLANES * PLANE_SIZE;
	
	public static final int MAX_CODEPOINT = NUM_CODEPOINTS - 1;
	
	public static final String NO_BLOCK = "No_Block";
}
