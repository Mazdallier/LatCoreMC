package mods.lm_core.client;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;

@SideOnly(Side.CLIENT)
public class LMRenderer
{
	public static final void colorize(int c, int a)
	{
		float r = ((c >> 16) & 255) / 255F;
		float g = ((c >> 8) & 255) / 255F;
		float b = ((c >> 0) & 255) / 255F;
		GL11.glColor4f(r, g, b, a / 255F);
	}
	
	public static final void colorize(int c)
	{ colorize(c, (c >> 24) & 255); }
	
	public static final void recolor()
	{ GL11.glColor4f(1F, 1F, 1F, 1F); }
	
	public static final void renderStandardBlockIcons(RenderBlocks r, Icon[] icons)
	{
		Tessellator tessellator = Tessellator.instance;
		GL11.glRotatef(90F, 0F, 1F, 0F);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		Block.glass.setBlockBoundsForItemRender();
		r.setRenderBoundsFromBlock(Block.glass);
		
		if(icons[0] != null)
		{
			tessellator.startDrawingQuads();
			tessellator.setNormal(0F, -1F, 0F);
			r.renderFaceYNeg(null, 0D, 0D, 0D, icons[0]);
			tessellator.draw();
		}
		
		if(icons[1] != null)
		{
			tessellator.startDrawingQuads();
			tessellator.setNormal(0F, 1F, 0F);
			r.renderFaceYPos(null, 0D, 0D, 0D, icons[1]);
			tessellator.draw();
		}
		
		if(icons[2] != null)
		{
			tessellator.startDrawingQuads();
			tessellator.setNormal(0F, 0F, -1F);
			r.renderFaceZNeg(null, 0D, 0D, 0D, icons[2]);
			tessellator.draw();
		}
		
		if(icons[3] != null)
		{
			tessellator.startDrawingQuads();
			tessellator.setNormal(0F, 0F, 1F);
			r.renderFaceZPos(null, 0D, 0D, 0D, icons[3]);
			tessellator.draw();
		}
		
		if(icons[4] != null)
		{
			tessellator.startDrawingQuads();
			tessellator.setNormal(-1F, 0F, 0F);
			r.renderFaceXNeg(null, 0D, 0D, 0D, icons[4]);
			tessellator.draw();
		}
		
		if(icons[5] != null)
		{
			tessellator.startDrawingQuads();
			tessellator.setNormal(1F, 0F, 0F);
			r.renderFaceXPos(null, 0D, 0D, 0D, icons[5]);
			tessellator.draw();
		}
		
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}
}