package net.miauczel.legendary_monsters.entity.client.Glow;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.client.Model.EndersentModel;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Chorusling.EndersentEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EndermanRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class EndersentGlow<T extends EndersentEntity> extends EyesLayer<T, EndersentModel<T>> {
    private static final RenderType GLOW = RenderType.eyes(new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/endersent/glow/endersent_glow.png"));

    private final EndersentEntity entity;

    public EndersentGlow(RenderLayerParent<T, EndersentModel<T>> p_116964_, EndersentEntity entity) {
        super(p_116964_);
        this.entity = entity;
    }

    @Override
    public RenderType renderType() {



           return GLOW;
       }
    }
