package ucd;

public class StringUtils {
	public static String padLeft(String str, int count, char c) {
		String paddingStr = repeat(count-str.length(), c);
		return paddingStr + str;
	}
	
	public static String padRight(String str, int count, char c) {
		String paddingStr = repeat(count-str.length(), c);
		return str + paddingStr;
	}
	
	public static String repeat(int count, char c) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<count; i++) {
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static int[] getRange(String rangeStr) {
		String[] parts = rangeStr.split("\\.\\.");
		int from = Integer.parseInt(parts[0], 16);
		int to = Integer.parseInt(parts[1], 16);
		return new int[] { from, to };
	}
	
	public static String getRangeString(int from, int to) {
		return toHexString(from) + ".." + toHexString(to);
	}
	
	public static int getCodePoint(String codePointStr) {
		return Integer.parseInt(codePointStr, 16);
	}
	
	public static String toHexString(int number) {
		String str = Integer.toHexString(number).toUpperCase();
		if (str.length() == 4 || str.length() == 6) {
			return str;
		} else if (str.length() < 4) {
			return padLeft(str, 4, '0');
		} else if (str.length() < 6) {
			return padLeft(str, 6, '0');
		}
		return str;
	}
	
	public static String getCode(String str) {
		return str.replace(" ", "").replace("-", "").replace("_", "");
	}
}
