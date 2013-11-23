/**
 * Copyright (c) SpaceToad, 2011 http://www.mod-buildcraft.com
 *
 * BuildCraft is distributed under the terms of the Minecraft Mod Public License
 * 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */
package buildcraft.core.gui.widgets;

import buildcraft.core.gui.BuildCraftContainer;
import buildcraft.core.gui.GuiBuildCraft;
import buildcraft.core.gui.tooltips.IToolTipProvider;
import buildcraft.core.gui.tooltips.ToolTip;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.inventory.ICrafting;

/**
 *
 * @author CovertJaguar <http://www.railcraft.info/>
 */
public class Widget implements IToolTipProvider {

	public final int x;
	public final int y;
	public final int u;
	public final int v;
	public final int w;
	public final int h;
	public boolean hidden;
	protected BuildCraftContainer container;

	public Widget(int x, int y, int u, int v, int w, int h) {
		this.x = x;
		this.y = y;
		this.u = u;
		this.v = v;
		this.w = w;
		this.h = h;
	}

	public void addToContainer(BuildCraftContainer container) {
		this.container = container;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public final boolean isMouseOver(int mouseX, int mouseY) {
		return mouseX >= x - 1 && mouseX < x + w + 1 && mouseY >= y - 1 && mouseY < y + h + 1;
	}

	@SideOnly(Side.CLIENT)
	public boolean mouseClicked(int mouseX, int mouseY, int button) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public void draw(GuiBuildCraft gui, int guiX, int guiY, int mouseX, int mouseY) {
		gui.drawTexturedModalRect(guiX + x, guiY + y, u, v, w, h);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ToolTip getToolTip() {
		return null;
	}

	@Override
	public boolean isToolTipVisible() {
		return true;
	}

	public void initWidget(ICrafting player) {
	}

	public void updateWidget(ICrafting player) {
	}
}