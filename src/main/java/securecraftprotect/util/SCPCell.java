package securecraftprotect.util;

import java.util.List;

public class SCPCell {
	public List blocks;
	public int[][][] content;
	public int[] start = new int[3];
	public void setStart(int xCoord, int yCoord, int zCoord) {
		this.start[0] = xCoord;
		this.start[1] = yCoord;
		this.start[2] = zCoord;
	}

	public void setStart(int[] xyz) {
		if (xyz.length == 3) {
			this.start = xyz;
		}
	}

	public int[][][] getContent() {
		return this.content;
	}

	public void setContent(int[][][] content) {
		this.content = content;
	}

	public List getBlocks() {
		return this.blocks;
	}

	public void setBlocks(List blocks) {
		this.blocks = blocks;
	}
}
