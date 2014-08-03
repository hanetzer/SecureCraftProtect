package SCPCraft.blocks;

//TODO
public class SCPRedstoneUpdateInfo
{
    int x;
    int y;
    int z;
    long updateTime;

    public SCPRedstoneUpdateInfo(int par1, int par2, int par3, long par4)
    {
        this.x = par1;
        this.y = par2;
        this.z = par3;
        this.updateTime = par4;
    }
    
    //TODO
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public long getUpdateTime() {
		return updateTime;
	}

	public long setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
		return updateTime;
	}
}
