package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.Flameborn.AnnihilationPursuer.AnnihilationPursuerEntity;
import net.miauczel.legendary_monsters.entity.client.Model.AnnihilationPursuerModel;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.layer.AnnihilationPursuerGrabLayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class AnnihilationPursuerRenderer extends MobRenderer<AnnihilationPursuerEntity, AnnihilationPursuerModel<AnnihilationPursuerEntity>> {
    public AnnihilationPursuerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new AnnihilationPursuerModel<>(pContext.bakeLayer(ModModelLayers.ANNIHILATION_PURSUER_LAYER)), 1.5f);
        this.addLayer(new AnnihilationPursuerGrabLayer(this,pContext.getEntityRenderDispatcher()));
        this.addLayer(new EyesLayer<>(this) {
            @Override
            public RenderType renderType() {
                return RenderType.eyes(new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/flameborn/annihilation_pursuer/annihilation_pursuer_glow.png"));
            }
        });
    }
    public static final ResourceLocation AWAKE = new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/flameborn/annihilation_pursuer/annihilation_pursuer.png");

    public static final ResourceLocation ASLEEP = new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/flameborn/annihilation_pursuer/annihilation_pursuer_sleep.png");
    @Override
    public ResourceLocation getTextureLocation(AnnihilationPursuerEntity pEntity) {

        return AWAKE;
    }

    @Override
    public void render(AnnihilationPursuerEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
