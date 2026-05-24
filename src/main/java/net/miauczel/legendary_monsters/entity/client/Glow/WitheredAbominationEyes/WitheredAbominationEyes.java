package net.miauczel.legendary_monsters.entity.client.Glow.WitheredAbominationEyes;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.client.Model.Withered_AbominationModel;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Withered_AbominationEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class WitheredAbominationEyes<T extends Withered_AbominationEntity> extends EyesLayer<T, Withered_AbominationModel<T>> {
    private static final RenderType EYES1 = RenderType.eyes(new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/withered_abomination/glow/withered_abomination_eyes1.png"));
    private static final RenderType EYES2 = RenderType.eyes(new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/withered_abomination/glow/withered_abomination_eyes2.png"));
    private final Withered_AbominationEntity entity;

    public WitheredAbominationEyes(RenderLayerParent<T, Withered_AbominationModel<T>> p_116964_, Withered_AbominationEntity entity) {
        super(p_116964_);
        this.entity = entity;
    }

    @Override
    public RenderType renderType() {
        Withered_AbominationEntity.Crackiness crackiness = this.entity.getCrackiness();
        if (crackiness == Withered_AbominationEntity.Crackiness.HIGH) {
            return EYES2;
        }
        return EYES1;
    }
}
