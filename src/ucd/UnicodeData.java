package ucd;

import java.io.IOException;
import java.util.ArrayList;

public class UnicodeData {
	public String[][] CodePoints = new String[Unicode.NUM_CODEPOINTS][];
	
	public UnicodeData(String filePath) throws IOException {
		String[][] lines = CsvFile.readCsvFile(filePath);
		
		for (String[] line : lines) {
			int codePoint = StringUtils.getCodePoint(line[0]);
			line[0] = StringUtils.toHexString(codePoint);
			CodePoints[codePoint] = line;
		}
	}
	
	public String[][] getRange(int from, int to) {
		ArrayList<String[]> codePoints = new ArrayList<>();
		
		for (int i=from; i<=to; i++) {
			String[] codePointData = CodePoints[i];
			if (codePointData == null) {
				continue;
			}
			codePoints.add(codePointData);
		}
		return codePoints.toArray(new String[0][]);
	}
	
	public String[][] getRange(Block block) {
		return getRange(block.From, block.To);
	}
	
	public static String[] getColumnNames() {
		return new String[] {"Name", "General_Category", "Canonical_Combining_Class", "Bidi_Class", "Decomposition_Type/Decomposition_Mapping", "Numeric_Type/Numeric_Value", "Numeric_Type/Numeric_Value", "Numeric_Type/Numeric_Value", "Bidi_Mirrored", "Unicode_1_Name", "ISO_Comment", "Simple_Uppercase_Mapping", "Simple_Lowercase_Mapping", "Simple_Titlecase_Mapping"};
	}
}
