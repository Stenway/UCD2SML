package ucd2sml;

import java.io.IOException;
import ucd.Block;
import ucd.Blocks;
import ucd.DerivedAge;
import ucd.OnePropertyList;
import ucd.Planes;
import ucd.Properties;
import ucd.UnicodeData;
import ucd.Versions;

public class Converter {
	PrettySmlOutput smlOutput;
	
	public void convert(String ucdDirPath, String outputSmlFile) throws IOException {
		DerivedAge derivedAge = new DerivedAge(ucdDirPath+"DerivedAge.txt");
				
		Versions versions = new Versions();
		Planes planes = new Planes();		
		Blocks blocks = new Blocks(ucdDirPath+"Blocks.txt");
		UnicodeData unicodeData = new UnicodeData(ucdDirPath+"UnicodeData.txt");
		
		OnePropertyList derivedCoreProperties = new OnePropertyList(ucdDirPath+"DerivedCoreProperties.txt");
		OnePropertyList propList = new OnePropertyList(ucdDirPath+"PropList.txt");
			
		smlOutput = new PrettySmlOutput("UnicodeCharacterDatabase");
		smlOutput.writeAttribute("FormatVersion", "0.1");
		smlOutput.writeAttribute("UcdDocumentation", "https://unicode.org/reports/tr44/");
		smlOutput.writeAttribute("GeneralSource", "https://www.unicode.org/Public/UCD/latest/ucd/");
				
		smlOutput.beginElement("Versions");
		smlOutput.writeTable(versions.toTable());
		smlOutput.closeElement();
		
		smlOutput.writeAttribute("SourceVersion", derivedAge.getLatestVersion());
		
		smlOutput.beginElement("Planes");
		smlOutput.writeTable(planes.toTable());
		smlOutput.closeElement();
		
		smlOutput.beginElement("Blocks");
		smlOutput.writeTable(blocks.toTable());
		smlOutput.closeElement();
		
		smlOutput.beginElement("UnicodeData");
		smlOutput.writeAttribute("Fields", UnicodeData.getColumnNames());
		for (Block block : blocks.Blocks) {
			smlOutput.beginElement(block.getCode());
			smlOutput.writeTable(unicodeData.getRange(block));
			smlOutput.closeElement();
		}
		smlOutput.closeElement();
		
		writeOnePropertyList(propList, "PropertiesList");
		writeOnePropertyList(derivedCoreProperties, "DerivedCoreProperties");
		writeOnePropertyList(derivedAge, "DerivedAge");
		
		smlOutput.finish();
		smlOutput.save(outputSmlFile);
	}
	
	private void writeOnePropertyList(Properties properties, String name) {
		smlOutput.beginElement(name);
		String[] values = properties.getSet(1);
		for (String value : values) {
			String[] result = properties.getWhere(1, value);
			smlOutput.writeAttribute(value, result);
		}
		smlOutput.closeElement();
	}
}
