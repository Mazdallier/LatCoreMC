package latmod.core.event;

import latmod.core.LMPlayer;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.relauncher.Side;

public abstract class LMPlayerEvent extends EventLM
{
	public final LMPlayer player;
	
	public LMPlayerEvent(LMPlayer p)
	{ player = p; }
	
	public static class DataChanged extends LMPlayerEvent
	{
		public final Side side;
		public final String channel;
		
		public DataChanged(LMPlayer p, Side s, String c)
		{ super(p); side = s; channel = c; }
		
		public boolean isChannel(String s)
		{ return channel != null && channel.equals(s); }
	}
	
	public static class DataLoaded extends LMPlayerEvent
	{
		public DataLoaded(LMPlayer p)
		{ super(p); }
	}
	
	public static class DataSaved extends LMPlayerEvent
	{
		public DataSaved(LMPlayer p)
		{ super(p); }
	}
	
	public static class LoggedIn extends LMPlayerEvent
	{
		public final EntityPlayer entityPlayer;
		public final boolean firstTime;
		
		public LoggedIn(LMPlayer p, EntityPlayer ep, boolean b)
		{ super(p); entityPlayer = ep; firstTime = b; }
	}
	
	public static class LoggedOut extends LMPlayerEvent
	{
		public final EntityPlayer entityPlayer;
		
		public LoggedOut(LMPlayer p, EntityPlayer ep)
		{ super(p); entityPlayer = ep; }
	}
}