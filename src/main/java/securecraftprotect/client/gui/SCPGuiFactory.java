package securecraftprotect.client.gui;

import cpw.mods.fml.client.IModGuiFactory;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;
import securecraftprotect.SCP;

import java.util.Set;

@SuppressWarnings("unused")
public class SCPGuiFactory implements IModGuiFactory
{
	@Override
	public void initialize(Minecraft mc) {}

	@Override
	public Class<? extends GuiScreen> mainConfigGuiClass()
	{
		return SCPConfigGui.class;
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories()
	{
		return null;
	}

	@Override
	public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement
															 element)
	{
		return null;
	}

	@SuppressWarnings("unchecked")
	public static class SCPConfigGui extends GuiConfig
	{
		public SCPConfigGui(GuiScreen parent)
		{
			super(parent,
					(new ConfigElement(SCP.config.getCategory("scp.blink")).getChildElements()),
					"scp", false, false, I18n.format("scp.configgui.name"));
		}
	}
}
