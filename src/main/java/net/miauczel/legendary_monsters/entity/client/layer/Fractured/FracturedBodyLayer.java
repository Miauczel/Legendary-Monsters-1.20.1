package net.miauczel.legendary_monsters.entity.client.layer.Fractured;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.Fractured.FracturedEntity;
import net.miauczel.legendary_monsters.entity.client.Model.FracturedModel;
import net.miauczel.legendary_monsters.entity.client.Render.FracturedRenderer;
import net.miauczel.legendary_monsters.entity.client.Render.LMRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FracturedBodyLayer extends RenderLayer<FracturedEntity, FracturedModel<FracturedEntity>> {
    private static final ResourceLocation BODY = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/fractured/fractured.png");


    public FracturedBodyLayer(FracturedRenderer renderIn) {
        super(renderIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, FracturedEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderType eyes = LMRenderTypes.entityTranslucentEmissive(BODY);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);

        float animationProgress1 = Math.min(entity.bodyFadeAway.getAnimationFraction(), 1F);
        float f_0_245976 = 1f - animationProgress1;
        this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, Math.max(f_0_245976 - 0.5f, 0));

    }

}