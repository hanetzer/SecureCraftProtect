package securecraftprotect.util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

/**
 * @author Two
 */
public enum BlockSide {

    bottom, top, north, south, west, east;
     // Blockside.ordinal() is the Minecraft side of a Block facing north

    /**
     * Returns the direction the entity is facing.
     * This is intended to be used for a block's metadata on placement.
     *
     * @param entity the entity in question
     * @return the direction the entity is facing as CW 0 (west) to 3 (south)
     */
    public static int getLookDirection(final EntityLivingBase entity) {
        return MathHelper.floor_double(((double) (entity.rotationYaw + 360.0F - 45.0F + 180.0F)) / 90.0) & 3; // Minecraft is -180° (north) to 180° CW, +360 to replace modulo with &
    }

    /**
     * Returns the direction that is facing the entity
     * This is intended to be used for a block's metadata on placement.
     *
     * @param entity the entity in question
     * @return the direction that is facing the entity as CW 0 (west) to 3 (south)
     */
    public static int getDirectionFacing(final EntityLivingBase entity) {
        return MathHelper.floor_double(((double) (entity.rotationYaw + 360.0F - 45.0F + 180.0F)) / 90.0) & 3; // Minecraft is -180° (north) to 180° CW, +360 to replace modulo with &
    }

    /**
     * Calculates which side is <i>side</i> given the block's orientation
     *
     * @param side the side that is searched for
     * @param blockDir the facing of the block as CW 0 (south) to 3 (east)
     * @return the side that corresponds to <i>side</i> according to the block's rotation.
     */
    public static BlockSide getRotatedSide(final int side, final int blockDir) {
        switch (side) {
            case 0:
                return bottom;
            case 1:
                return top;
            case 2: // north side
                switch (blockDir & 3) {
                    case 0: // facing west
                        return east;
                    case 1: // facing north
                        return north;
                    case 2: // facing east
                        return west;
                    case 3: // facing south
                        return south;
                }
            case 3: // south side
                switch (blockDir & 3) {
                    case 0: // facing west
                        return west;
                    case 1: // facing north
                        return south;
                    case 2: // facing east
                        return east;
                    case 3: // facing south
                        return north;
                }
            case 4: // west side
                switch (blockDir & 3) {
                    case 0: // facing west
                        return north;
                    case 1: // facing north
                        return west;
                    case 2: // facing east
                        return south;
                    case 3: // facing south
                        return east;
                }
            case 5: // east side
                switch (blockDir & 3) {
                    case 0: // facing west
                        return south;
                    case 1: // facing north
                        return east;
                    case 2: // facing east
                        return north;
                    case 3: // facing south
                        return west;
                }
        }
        throw new IllegalArgumentException("Illegal side " + side);
    }

    /**
     * Returns the "native" block orientation based on side.
     * This is a convenient function for blocks that do not rotate (with a metadata of 0).
     *
     * @param side the side that is searched for.
     * @return the "native" block orientation based on side.
     */
    public static BlockSide getSide(final int side) {
        return getRotatedSide(side, 0);
    }

    /**
     * Returns the side that corresponds to direction.
     *
     * @param direction the direction to look up.
     * @return the side that corresponds to direction.
     */
    public static BlockSide fromDirection(final int direction) {
        switch (direction & 3) {
            case 0:
                return west;
            case 1:
                return north;
            case 2:
                return east;
            case 3:
                return south;
        }
        throw new IllegalArgumentException("Illegal direction " + direction); // impossible to reach
    }

    /**
     * Returns the direction that corresponds to side.
     * The result is intended for a block's metadata.
     *
     * @param side the side to look up.
     * @return the direction that corresponds to side.
     */
    public static int toDirection(final BlockSide side) {
        switch (side) {
            case west:
                return 0;
            case north:
                return 1;
            case east:
                return 2;
            case south:
                return 3;
        }
        throw new IllegalArgumentException("Side " + side + " cannot be converted into a direction."); // for top/bottom
    }

    /**
     * Returns the direction that corresponds to this.
     * The result is intended for a block's metadata.
     *
     * @return the direction that corresponds to this.
     */
    public int toDirection() {
        return toDirection(this);
    }
}