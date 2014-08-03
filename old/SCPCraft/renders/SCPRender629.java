package SCPCraft.renders;
 
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import SCPCraft.entities.SCPEntity629;

public class SCPRender629 extends RenderLiving
{
	public SCPRender629(ModelBase modelbase, float f)
	{
		super(modelbase, f);
	}

	public void func_177_a(SCPEntity629 entity, double d, double d1, double d2, float f, float f1)
	{
		super.doRenderLiving(entity, d, d1, d2, f, f1);
		if(entity.Name.length() > 0 && entity.Name != "")      
		{                
			renderLivingLabel(entity, entity.Name, d, d1, d2, 64);      
		}
	}

	public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
	{
		func_177_a((SCPEntity629)entityliving, d, d1, d2, f, f1);
	}

	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
	{
		func_177_a((SCPEntity629)entity, d, d1, d2, f, f1);
	}
}