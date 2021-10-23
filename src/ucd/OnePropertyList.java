package ucd;

import java.io.IOException;

public class OnePropertyList extends Properties {
	public String[] Values;
	
	public OnePropertyList(String filePath) throws IOException {
		super(filePath);
		Values = getSet(1);
	}
}
