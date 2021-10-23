package ucd;

import java.util.ArrayList;

public class Versions {
	public final Version[] Versions;
	
	public Versions() {
		ArrayList<Version> versions = new ArrayList<>();
		versions.add(new Version(1,1,0,"June, 1993"));
		versions.add(new Version(2,0,0,"July, 1996"));
		versions.add(new Version(2,1,2,"May, 1998"));
		versions.add(new Version(3,0,0,"September, 1999"));
		versions.add(new Version(3,1,0,"March, 2001"));
		versions.add(new Version(3,2,0,"March, 2002"));
		versions.add(new Version(4,0,0,"April, 2003"));
		versions.add(new Version(4,1,0,"March, 2005"));
		versions.add(new Version(5,0,0,"July, 2006"));
		versions.add(new Version(5,1,0,"March, 2008"));
		versions.add(new Version(5,2,0,"October, 2009"));
		versions.add(new Version(6,0,0,"October, 2010"));
		versions.add(new Version(6,1,0,"January, 2012"));
		versions.add(new Version(6,2,0,"September, 2012"));
		versions.add(new Version(6,3,0,"September, 2013"));
		versions.add(new Version(7,0,0,"June, 2014"));
		versions.add(new Version(8,0,0,"June, 2015"));
		versions.add(new Version(9,0,0,"June, 2016"));
		versions.add(new Version(10,0,0,"June, 2017"));
		versions.add(new Version(11,0,0,"June, 2018"));
		versions.add(new Version(12,0,0,"March, 2019"));
		versions.add(new Version(12,1,0,"May, 2019"));
		versions.add(new Version(13,0,0,"March, 2020"));
		versions.add(new Version(14,0,0,"September, 2021"));
		
		Versions = versions.toArray(new Version[0]);
	}
	
	public String[][] toTable() {
		String[][] result = new String[Versions.length+1][];
		result[0] = new String[] {"Version", "Date"};
		for (int i=0; i<Versions.length; i++) {
			Version version = Versions[i];
			result[i+1] = new String[] {""+version.Major+"."+version.Minor+"."+version.Update, version.Date};
		}
		return result;
	}
}
