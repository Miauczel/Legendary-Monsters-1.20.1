package net.miauczel.legendary_monsters.entity.client.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.client.Model.TheObliteratorModel;
import net.miauczel.legendary_monsters.entity.client.Render.LMRenderTypes;
import net.miauczel.legendary_monsters.entity.client.Render.TheObliteratorRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TheObliteratorPowerBallInnerLayer extends RenderLayer<TheObliteratorEntity, TheObliteratorModel<TheObliteratorEntity>> {
    private static final ResourceLocation LOCATION = new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/the_warped_one/ball/inner_ball_layer.png");

    public TheObliteratorPowerBallInnerLayer(TheObliteratorRenderer renderIn) {
        super( renderIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, TheObliteratorEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {


            RenderType eyes = LMRenderTypes.getGlowEyes(LOCATION);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);

        if (entity.isShootingClusterBomb()) {
    this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, 15728640, OverlayTexture.NO_OVERLAY, 0.95f, 0.95f, 0.95f, 1f);
}else {

    this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, 15728640, OverlayTexture.NO_OVERLAY, 0, 0, 0, 0);
}
}

}