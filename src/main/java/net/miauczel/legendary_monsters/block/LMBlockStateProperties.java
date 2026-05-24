package net.miauczel.legendary_monsters.block;

import net.miauczel.legendary_monsters.entity.client.Render.BlockEntity.SomberTrapdoor.SomberTrapdoorPart;
import net.minecraft.world.level.block.state.properties.*;

public class LMBlockStateProperties {

public LMBlockStateProperties(){}

    public static final BooleanProperty AXE_CIRCLING;

    public static final BooleanProperty POWER_ON_STEP;

    public static final IntegerProperty LOCKS_UNLOCKED;

    public static final EnumProperty<SomberTrapdoorPart> SOMBER_TRAPDOOR_PART;
    static {
        AXE_CIRCLING = BooleanProperty.create("axe_circling");
        POWER_ON_STEP = BooleanProperty.create("power_on_step");

        LOCKS_UNLOCKED = IntegerProperty.create("locks_unlocked",0,2);
        SOMBER_TRAPDOOR_PART = EnumProperty.create("part", SomberTrapdoorPart.class);

    }
}


