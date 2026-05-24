package net.miauczel.legendary_monsters.entity.client.layer.BeheadedKnight;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.BeheadedKnight.BeheadedKnightEntity;
import net.miauczel.legendary_monsters.entity.client.Model.BeheadedKnightModel;
import net.miauczel.legendary_monsters.entity.client.Render.BeheadedKnightRenderer;
import net.miauczel.legendary_monsters.entity.client.Render.LMRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BeheadedKnightGhostArmLayer extends RenderLayer<BeheadedKnightEntity, BeheadedKnightModel<BeheadedKnightEntity>> {
    private static final ResourceLocation POSSESSED_PALADIN_DAGGER = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/beheaded_knight/ghost_arm.png");


    public BeheadedKnightGhostArmLayer(BeheadedKnightRenderer renderIn) {
        super(renderIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, BeheadedKnightEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderType eyes = LMRenderTypes.entityTranslucentEmissive(POSSESSED_PALADIN_DAGGER);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);

        float animationProgress1 = Math.min(entity.armFade.getAnimationFraction(), 1F);
        float f_0_245976 = 1f - animationProgress1;
       // System.out.println("f: " + f_0_245976);
        if (entity.hasGhostArm()) {
            this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, Math.max(f_0_245976 - 0.5f, 0));
        }
    }
}