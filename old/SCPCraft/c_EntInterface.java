package SCPCraft;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemInWorldManager;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import SCPCraft.CoroAI.entity.c_EntityPlayerMPExt;

public class c_EntInterface extends EntityMob
{
    public InventoryPlayer inventory;
    public c_EntityPlayerMPExt fakePlayer;

    public c_EntInterface(World world)
    {
        super(world);

        try
        {
            if (!world.isRemote)
            {
                fakePlayer = newFakePlayer(world);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return;
        }
    }

    public c_EntityPlayerMPExt newFakePlayer(World world)
    {
        MinecraftServer mc = MinecraftServer.getServer();

        //this.setDead();
        
        if (mc == null)
        {
            return null;
        }

        //int dim = world.worldInfo.getDimension();
        c_EntityPlayerMPExt player = null;//

        //System.out.println("DEBUG FIX 2: ");
        //player = new c_EntityPlayerMPExt(mc, world, "fakePlayer_", new ItemInWorldManager(world));
        if (worldObj.chunkExists((int)(posX / 16), (int)(posZ / 16))) {
        	player = new c_EntityPlayerMPExt(mc, world, "fakePlayer_" + this.entityId, new ItemInWorldManager(world));
        	inventory = player.inventory;
        } else {
        	//System.out.println("Chunk doesnt exist, cant create fake player, posX: " + posX + " | posZ: " + posZ);
        }
        
        
        
        
        
        //System.out.println("c_CoroAIUtil.playerToAILookup.put(player.username, this); OFF");

        //mc.configManager.netManager
        //player.movementInput = new MovementInputFromOptions(mod_ZombieCraft.mc.gameSettings);
        return player;
    }

    public int getMaxHealth()
    {
        return 20;
    }

    public int getHealth()
    {
        return this.health;
    }

    public int getPlHealth()
    {
        return this.fakePlayer.getHealth();
    }

    public void setPlHealth(int h)
    {
    	try {
    		if (fakePlayer != null) fakePlayer.setEntityHealth(h);
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    }

    public boolean getSleeping()
    {
        return this.fakePlayer.isPlayerSleeping();
    }

    public void setSleeping(boolean h)
    {
        h = fakePlayer.isPlayerSleeping(); 
    }

    public void updateItemUse(ItemStack is, int val)
    {
        fakePlayer.updateItemUse(is, val);
    }

    public void onItemUseFinish()
    {
        if (fakePlayer instanceof EntityPlayerMP && ((EntityPlayerMP)fakePlayer).playerNetServerHandler != null)
        {
            fakePlayer.onItemUseFinish();
        }
    }

    public void setThrower(EntityThrowable prj, EntityLiving ent)
    {
    	//c_CoroAIUtil.setPrivateValueBoth(EntityThrowable.class, prj, c_CoroAIUtil.refl_thrower_obf, c_CoroAIUtil.refl_thrower_mcp, ent);
        //prj.thrower = ent;
    }
}
