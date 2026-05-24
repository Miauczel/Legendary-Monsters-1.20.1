package net.miauczel.legendary_monsters.block;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.block.blockentity.SomberTrapdoorBlockEntity;
import net.miauczel.legendary_monsters.block.blockentity.SwingingAxeBlockEntity;
import net.miauczel.legendary_monsters.block.blockentity.TeleportMachineBlockEntity;
import net.miauczel.legendary_monsters.block.blockentity.EnderAnchorBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntity {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY=
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, LegendaryMonsters.MOD_ID);

    public static final RegistryObject<BlockEntityType<EnderAnchorBlockEntity>> ENDER_ANCHOR = BLOCK_ENTITY.register("ender_anchor",
            () -> BlockEntityType.Builder.of(EnderAnchorBlockEntity::new, ModBlocks.ENDER_ANCHOR.get()).build(null));


    public static final RegistryObject<BlockEntityType<TeleportMachineBlockEntity>> TELEPORT_MACHINE = BLOCK_ENTITY.register("teleport_machine",
            () -> BlockEntityType.Builder.of(TeleportMachineBlockEntity::new, ModBlocks.TELEPORT_MACHINE.get()).build(null));

    public static final RegistryObject<BlockEntityType<SwingingAxeBlockEntity>> SWINGING_AXE = BLOCK_ENTITY.register("swinging_axe",
            () -> BlockEntityType.Builder.of(SwingingAxeBlockEntity::new, ModBlocks.SWINGING_AXE.get()).build(null));

    public static final RegistryObject<BlockEntityType<SomberTrapdoorBlockEntity>> SOMBER_TRAPDOOR = BLOCK_ENTITY.register("somber_trapdoor",
            () -> BlockEntityType.Builder.of(SomberTrapdoorBlockEntity::new, ModBlocks.SOMBER_TRAPDOOR.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY.register(eventBus);
    }
}
