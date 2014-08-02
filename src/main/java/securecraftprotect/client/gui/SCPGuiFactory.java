package securecraftprotect.client.gui;

import cpw.mods.fml.client.IModGuiFactory;
import cpw.mods.fml.client.config.DummyConfigElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.GuiConfigEntries;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;
import securecraftprotect.SCP;
import securecraftprotect.common.config.SCPConfigBlink;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static cpw.mods.fml.client.config.DummyConfigElement.*;
import static cpw.mods.fml.client.config.GuiConfig.*;
import static cpw.mods.fml.client.config.GuiConfigEntries.*;
import static cpw.mods.fml.client.config.GuiConfigEntries.CategoryEntry;

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
			super(parent, getConfigElements(), "scp", false, false,
					I18n.format("scp.configgui.name"));
		}

		private static List<IConfigElement> getConfigElements()
		{
			List<IConfigElement> list = new ArrayList<IConfigElement>();
			list.add(new DummyCategoryElement("blink", "scp.config.blink.title", BlinkEntry.class));
			return list;
		}

		public static class BlinkEntry extends CategoryEntry
		{
			public BlinkEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop)
			{
				super(owningScreen, owningEntryList, prop);
			}

			@Override
			protected GuiScreen buildChildScreen()
			{
				return new GuiConfig(this.owningScreen,
						(new ConfigElement(
								SCPConfigBlink.getConfig().getCategory("blink"))).getChildElements(),
						"scp", "blink", true, false, "scp.blink.title",
						getAbridgedConfigPath(SCPConfigBlink.getConfig().toString()));
			}
		}
	}
}
