package ucd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Properties {
	public Property[] Properties;
	
	public Properties(String filePath) throws IOException {
		String[][] lines = CsvFile.readCsvFile(filePath);
		ArrayList<Property> properties = new ArrayList<>();
		for (String[] line : lines) {
			Property property = new Property(line);
			properties.add(property);
		}
		Properties = properties.toArray(new Property[0]);
	}
	
	public String[] getSet(int index) {
		LinkedHashSet<String> lookup = new LinkedHashSet<>();
		for (Property property : Properties) {
			if (property.Values.length <= index) {
				continue;
			}
			lookup.add(property.Values[index]);
		}
		return lookup.toArray(new String[0]);
	}
	
	public Property[] getPropertiesWhere(int index, String value) {
		ArrayList<Property> result = new ArrayList<>();
		for (Property property : Properties) {
			if (property.Values.length <= index) {
				continue;
			}
			if (property.Values[index].equals(value)) {
				result.add(property);
			}
		}
		return result.toArray(new Property[0]);
	}
	
	public String[] getWhere(int index, String value) {
		ArrayList<String> result = new ArrayList<>();
		for (Property property : Properties) {
			if (property.Values.length <= index) {
				continue;
			}
			if (property.Values[index].equals(value)) {
				result.add(property.Values[0]);
			}
		}
		return result.toArray(new String[0]);
	}
}
