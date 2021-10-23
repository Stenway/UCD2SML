package ucd;

import java.io.IOException;
import java.util.ArrayList;

public class Blocks {
	public Block[] Blocks;
	private final Block[] lookup = new Block[Unicode.MAX_CODEPOINT+1];
	
	public Blocks(String filePath) throws IOException {
		String[][] lines = CsvFile.readCsvFile(filePath);
		ArrayList<Block> blocks = new ArrayList<>();
		int nextBlockStart = 0;
		int count = 0;
		for (String[] line : lines) {
			String fromToStr = line[0];
			int[] fromTo = StringUtils.getRange(fromToStr);
			String name = line[1];
			Block block = new Block(fromTo[0], fromTo[1], name);
			
			if (block.From != nextBlockStart) {
				Block noBlock = new Block(nextBlockStart, block.From-1, null);
				blocks.add(noBlock);
				count += noBlock.getSize();
			}
			
			blocks.add(block);
			count += block.getSize();
			
			for (int i=block.From; i<=block.To; i++) {
				lookup[i] = block;
			}
			
			nextBlockStart = block.To+1;
		}
		Blocks = blocks.toArray(new Block[0]);
		
		if (count != Unicode.NUM_CODEPOINTS) {
			throw new UcdException("Block error");
		}
	}
	
	public Block getBlock(int codePoint) {
		return lookup[codePoint];
	}
	
	public String[][] toTable() {
		String[][] result = new String[Blocks.length+1][];
		result[0] = new String[] {"From", "To", "Name", "Size"};
		for (int i=0; i<Blocks.length; i++) {
			Block block = Blocks[i];
			result[i+1] = new String[] {StringUtils.toHexString(block.From), StringUtils.toHexString(block.To), block.Name, ""+block.getSize()};
		}
		return result;
	}
}