package ucd2sml;

public class Program {

	public static void main(String[] args) {
		try {
			String ucdDirPath = "D:\\UCDTest\\UCD\\";
			String outputSmlFile = "D:\\UCDTest\\UCD.sml";
			
			Converter converter = new Converter();
			converter.convert(ucdDirPath, outputSmlFile);
			
			System.out.println("[SUCCESS]");
		} catch (Exception e) {
			System.out.println("[ERROR] "+e.getMessage());
		}
	}

}