package net.miauczel.legendary_monsters.worldgen;


import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModDepositPlacement {
    public static List<PlacementModifier> depositPlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonDepositPlacement(int pCount, PlacementModifier pHeightRange) {
        return depositPlacement(CountPlacement.of(pCount), pHeightRange);
    }

    public static List<PlacementModifier> rareDepositPlacement(int pChance, PlacementModifier pHeightRange) {
        return depositPlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
    }
}
