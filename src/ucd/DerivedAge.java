package ucd;

import java.io.IOException;

public class DerivedAge extends Properties {
	public String[] OccurringVersions;
	
	public DerivedAge(String filePath) throws IOException {
		super(filePath);
		OccurringVersions = getSet(1);
	}
	
	public String getLatestVersion() {
		return OccurringVersions[OccurringVersions.length-1];
	}
}
