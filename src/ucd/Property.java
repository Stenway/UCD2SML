package ucd;

public class Property {
	public final int CodePoint;
	public final int From;
	public final int To;
	public final String[] Values;
	
	public Property(String[] values) {
		String codePointStr = values[0];
		if (codePointStr.contains("..")) {
			int[] range = StringUtils.getRange(codePointStr);
			CodePoint = -1;
			From = range[0];
			To = range[1];
			values[0] = StringUtils.getRangeString(From, To);
		} else {
			CodePoint = StringUtils.getCodePoint(values[0]);
			From = -1;
			To = -1;
			values[0] = StringUtils.toHexString(CodePoint);
		}
		Values = values;
	}
	
	public boolean isRange() {
		return CodePoint < 0;
	}
	
	@Override
	public String toString() {
		return String.join(" - ", Values);
	}
}
