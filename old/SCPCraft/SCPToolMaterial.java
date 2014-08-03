package SCPCraft;
 
public enum SCPToolMaterial
{
    SCP143("SCP-143", 0, 500,10, 17F, 4, 12);
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiencyOnProperMaterial;
    private final int damageVsEntity;
    private final int enchantability;
    private static final SCPToolMaterial allToolMaterials[];
 
    private SCPToolMaterial(String s, int i, int j, int k, float f, int l, int i1)
    {
        harvestLevel = j;
        maxUses = k;
        efficiencyOnProperMaterial = f;
        damageVsEntity = l;
        enchantability = i1;
    }
 
    public int getMaxUses()
    {
        return maxUses;
    }
 
    public float getEfficiencyOnProperMaterial()
    {
        return efficiencyOnProperMaterial;
    }
 
    public int getDamageVsEntity()
    {
        return damageVsEntity;
    }
 
    public int getHarvestLevel()
    {
        return harvestLevel;
    }
 
    public int getEnchantability()
    {
        return enchantability;
    }
 
    static
    {
        allToolMaterials = (new SCPToolMaterial[] {
            SCP143
        });   
    }
}