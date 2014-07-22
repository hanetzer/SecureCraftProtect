package securecraftprotect.common.entity.passive;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedAnimalSCP implements IExtendedEntityProperties{
    private final static String EXT_PROP_NAME = "ExtendedAnimalSCP";
    private final EntityAnimal animal;
    private boolean aggro;

    public ExtendedAnimalSCP(EntityAnimal animal) {
        this.animal = animal;
        this.aggro  = false;
    }

    public static void register(EntityAnimal animal) {
        animal.registerExtendedProperties(EXT_PROP_NAME,
                new ExtendedAnimalSCP(animal));
    }

    public static ExtendedAnimalSCP get(EntityAnimal animal) {
        return (ExtendedAnimalSCP) animal.getExtendedProperties(EXT_PROP_NAME);
    }
    @Override
    public void saveNBTData(NBTTagCompound compound) {
        NBTTagCompound props = new NBTTagCompound();
        props.setBoolean("Aggro", this.aggro);
        compound.setTag(EXT_PROP_NAME, props);
    }

    @Override
    public void loadNBTData(NBTTagCompound compound) {
        NBTTagCompound props = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
        this.aggro = props.getBoolean("Aggro");

    }

    @Override
    public void init(Entity entity, World world) {}

    public boolean isAggro() {
        return this.aggro;
    }

    public void setAggro(boolean bool) {
        this.aggro = bool;
    }
}
