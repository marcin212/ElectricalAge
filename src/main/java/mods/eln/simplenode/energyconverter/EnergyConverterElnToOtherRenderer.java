package mods.eln.simplenode.energyconverter;

import org.lwjgl.opengl.GL11;

import mods.eln.misc.Obj3D;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;


public class EnergyConverterElnToOtherRenderer extends TileEntitySpecialRenderer implements IItemRenderer{
	Obj3D obj = new Obj3D();
	
	public EnergyConverterElnToOtherRenderer() {
		obj.loadFile("EnergyConverterElnToOther/EnergyConverterElnToOther.obj");
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float d) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x+.5F, (float)y+.5F, (float)z+.5F);

		if(te instanceof EnergyConverterElnToOtherEntity && ((EnergyConverterElnToOtherEntity)te).front != null){
			EnergyConverterElnToOtherEntity converter = ((EnergyConverterElnToOtherEntity)te);
			converter.front.glRotateXnRef();
			converter.lrdu.glRotateOnX();
			obj.draw("V2_Cylinder.003");
			
			
			
			GL11.glRotatef(180, 1f, 0f, 1f);
			GL11.glRotatef(-20, 1f, 0f, 0f);
			GL11.glTranslatef(-0.5f + (4.5f/16f) ,0.2f ,-0.37f);
			GL11.glScalef(0.02f, .02f, .02f);
			func_147498_b().drawString(Integer.toString(converter.inStdVoltage) + "V", 0, 0, 0);
			
		}
		

		
		
		GL11.glPopMatrix();
		
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float).5F, (float).5F, (float).5F);
		obj.draw("V2_Cylinder.003");
		GL11.glPopMatrix();
		
	}

	
	
}
