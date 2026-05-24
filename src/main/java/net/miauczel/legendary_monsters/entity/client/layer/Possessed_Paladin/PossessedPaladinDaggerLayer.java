package net.miauczel.legendary_monsters.entity.client.layer.Possessed_Paladin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.PossessedPaladin.PossessedPaladinEntity;
import net.miauczel.legendary_monsters.entity.client.Model.NewPossessedPaladinModel;
import net.miauczel.legendary_monsters.entity.client.Render.LMRenderTypes;
import net.miauczel.legendary_monsters.entity.client.Render.PossessedPaladinRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PossessedPaladinDaggerLayer extends RenderLayer<PossessedPaladinEntity, NewPossessedPaladinModel<PossessedPaladinEntity>> {
    private static final ResourceLocation POSSESSED_PALADIN_DAGGER = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/posessed_paladin/layer/possessed_paladin_dagger_layer.png");

    private static final ResourceLocation POSSESSED_PALADIN_DAGGER_RED = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/posessed_paladin/layer/possessed_paladin_dagger_red_layer.png");

    public PossessedPaladinDaggerLayer(PossessedPaladinRenderer renderIn) {
        super(renderIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, PossessedPaladinEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderType eyes = LMRenderTypes.entityTranslucentEmissive(entity.getPhase() >= 2 ? POSSESSED_PALADIN_DAGGER_RED : POSSESSED_PALADIN_DAGGER);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
        if (entity.hasDagger()) {
            this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        }
    }
}