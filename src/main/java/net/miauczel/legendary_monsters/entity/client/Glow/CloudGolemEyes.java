package net.miauczel.legendary_monsters.entity.client.Glow;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.client.Model.Cloud_GolemModel;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.CloudGolem.Cloud_GolemEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class CloudGolemEyes<T extends Cloud_GolemEntity> extends EyesLayer<T, Cloud_GolemModel<T>> {
    private static final RenderType EYES1 = RenderType.eyes(new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/cloud_golem/glow/cloud_golem_glow.png"));
    private static final RenderType EYES2 = RenderType.eyes(new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/cloud_golem/glow/cloud_golem_angry_glow.png"));
    private final Cloud_GolemEntity entity;

    public CloudGolemEyes(RenderLayerParent<T, Cloud_GolemModel<T>> p_116964_, Cloud_GolemEntity entity) {
        super(p_116964_);
        this.entity = entity;
    }

    @Override
    public RenderType renderType() {
      // if (entity.getTextureVariant() == 1){
           //return EYES2;
       //}else {
           return EYES1;
       }
   // }
}
