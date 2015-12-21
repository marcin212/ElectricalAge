package mods.eln.simplenode.energyconverter;

import cofh.api.energy.IEnergyReceiver;

import mods.eln.Other;

import net.minecraft.tileentity.TileEntity;

public class EnergyConverterElnToOtherFireWallRf {
	public static void updateEntity(EnergyConverterElnToOtherEntity e) {
		if (e.getWorldObj().isRemote) return;
		if (e.getNode() == null) return;

		EnergyConverterElnToOtherNode node = (EnergyConverterElnToOtherNode) e.getNode();
		TileEntity tileEntity = node.getFront().getInverse().applyToTileEntity(e);

        if(tileEntity == null || !(tileEntity instanceof IEnergyReceiver)) return;
        IEnergyReceiver energyHandler = (IEnergyReceiver)tileEntity;
		
		double pMax = node.getOtherModEnergyBuffer(Other.getElnToTeConversionRatio());
		node.drawEnergy(energyHandler.receiveEnergy(node.getFront().toForge(), (int) pMax, false), Other.getElnToTeConversionRatio());
	}
}
