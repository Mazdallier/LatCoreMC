package mods.lm_core;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;

public interface ISimpleInvOwner extends ITileInterface
{
	public void onInventoryChanged();
	public boolean isUseableByPlayer(EntityPlayer ep);
	public boolean isItemValidForSlot(int i, ItemStack is);
}