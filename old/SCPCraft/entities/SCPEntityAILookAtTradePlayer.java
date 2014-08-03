package SCPCraft.entities;

import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;

public class SCPEntityAILookAtTradePlayer extends EntityAIWatchClosest
{
    private final SCPEntity217Testificate theMerchant;

    public SCPEntityAILookAtTradePlayer(SCPEntity217Testificate par1SCPEntity217Testificate)
    {
        super(par1SCPEntity217Testificate, EntityPlayer.class, 8.0F);
        this.theMerchant = par1SCPEntity217Testificate;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.theMerchant.isTrading())
        {
            this.closestEntity = this.theMerchant.getCustomer();
            return true;
        }
        else
        {
            return false;
        }
    }
}
