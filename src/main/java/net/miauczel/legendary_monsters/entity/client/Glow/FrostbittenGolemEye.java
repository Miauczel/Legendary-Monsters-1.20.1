package net.miauczel.legendary_monsters.entity.client.Glow;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.client.Model.Frostbitten_GolemModel;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Frostbitten_GolemEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FrostbittenGolemEye<T extends Frostbitten_GolemEntity> extends EyesLayer<T, Frostbitten_GolemModel<T>> {
    private static final RenderType EYE = RenderType.eyes(new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/frostbitten_golem/glow/frostbitten_golem_eye.png"));
    private final Frostbitten_GolemEntity entity;
    public FrostbittenGolemEye(RenderLayerParent<T, Frostbitten_GolemModel<T>> p_116964_, Frostbitten_GolemEntity entity) {
        super(p_116964_);
        this.entity = entity;
    }

    @Override
    public RenderType renderType() {
            return EYE;
        }
    }
