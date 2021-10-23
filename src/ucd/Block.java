package ucd;

public class Block {
	public final int From;
	public final int To;
	public final String Name;
	
	public Block(int from, int to, String name) {
		From = from;
		To = to;
		Name = name;
		
		if (From % 16 != 0 || To % 16 != 15) {
			throw new UcdException("Invalid block");
		}
	}
	
	public boolean contains(int codePoint) {
		return codePoint >= From && codePoint <= To;
	}
	
	public int getSize() {
		return To-From+1;
	}
	
	public String getCode() {
		if (Name == null) {
			return StringUtils.getCode(Unicode.NO_BLOCK);
		}
		return StringUtils.getCode(Name);
	}

	@Override
	public String toString() {
		return Name + " (" + StringUtils.getRangeString(From, To) + ") #" + getSize();
	}
}