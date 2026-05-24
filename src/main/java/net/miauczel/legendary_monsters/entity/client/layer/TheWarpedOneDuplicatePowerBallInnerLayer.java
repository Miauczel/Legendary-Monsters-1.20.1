package net.miauczel.legendary_monsters.entity.client.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity.TheObliteratorCloneEntity;
import net.miauczel.legendary_monsters.entity.client.Render.LMRenderTypes;
import net.miauczel.legendary_monsters.entity.client.Model.TheObliteratorCloneModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class TheWarpedOneDuplicatePowerBallInnerLayer
        extends RenderLayer<TheObliteratorCloneEntity, TheObliteratorCloneModel<TheObliteratorCloneEntity>>
{
    private static final ResourceLocation LOCATION =
            new ResourceLocation(LegendaryMonsters.MOD_ID,
                    "textures/entity/the_warped_one/ball/inner_ball_layer.png");

    public TheWarpedOneDuplicatePowerBallInnerLayer(
            RenderLayerParent<TheObliteratorCloneEntity,
                    TheObliteratorCloneModel<TheObliteratorCloneEntity>> rendererIn
    ) {
        super(rendererIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, TheObliteratorCloneEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {


            RenderType eyes = LMRenderTypes.getGlowEyes(LOCATION);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);


    this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, 15728640, OverlayTexture.NO_OVERLAY, 0.95f, 0.95f, 0.95f, 1f);
    this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, 15728640, OverlayTexture.NO_OVERLAY, 0, 0, 0, 0);
}

}