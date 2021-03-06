package latmod.core.cmd;

public enum CommandLevel
{
	NONE, ALL, OP;
	
	public static final CommandLevel[] VALUES = { NONE, ALL, OP };
	public static final String[] LEVEL_STRINGS = { "NONE", "ALL", "OP" };
	
	public static CommandLevel get(String s)
	{
		if(s.toUpperCase().equals("ALL")) return ALL;
		if(s.toUpperCase().equals("OP")) return OP;
		return NONE;
	}
	
	public boolean isEnabled()
	{ return this != NONE; }
	
	public boolean isOP()
	{ return this == OP; }
}
