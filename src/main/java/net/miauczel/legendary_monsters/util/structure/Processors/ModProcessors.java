package net.miauczel.legendary_monsters.util.structure.Processors;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModProcessors {

    public static void register(IEventBus eventBus) {
        STRUCTURE_PROCESSOR.register(eventBus);
    }
    public static final DeferredRegister<StructureProcessorType<?>> STRUCTURE_PROCESSOR = DeferredRegister.create(Registries.STRUCTURE_PROCESSOR, LegendaryMonsters.MOD_ID);

    public static final RegistryObject<StructureProcessorType<NoWaterInStructureProcessor>> NO_WATER_PROCESSOR = STRUCTURE_PROCESSOR.register("no_water_processor", () -> () -> NoWaterInStructureProcessor.CODEC);
}
