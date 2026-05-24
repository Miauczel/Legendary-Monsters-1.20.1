package net.miauczel.legendary_monsters.item.custom.Capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.energy.IEnergyStorage;

public class ModCapability {
    public static final Capability<IParry> PARRY_CAPABILITY = CapabilityManager.get(new CapabilityToken<IParry>() {
    });

}
