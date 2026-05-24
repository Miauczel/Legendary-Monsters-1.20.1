package net.miauczel.legendary_monsters.entity.client.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.CloudGolem.Cloud_GolemEntity;
import net.miauczel.legendary_monsters.entity.client.Model.Cloud_GolemModel;
import net.miauczel.legendary_monsters.entity.client.Render.Cloud_GolemRenderer;
import net.miauczel.legendary_monsters.entity.client.Render.LMRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CloudGolemLaserBallOuterLayer extends RenderLayer<Cloud_GolemEntity, Cloud_GolemModel<Cloud_GolemEntity>> {
    private static final ResourceLocation LOCATION = new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/cloud_golem/laser_ball/laser_ball_outer.png");

    public CloudGolemLaserBallOuterLayer(Cloud_GolemRenderer renderIn) {
        super((RenderLayerParent<Cloud_GolemEntity, Cloud_GolemModel<Cloud_GolemEntity>>) renderIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Cloud_GolemEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {


            RenderType eyes = LMRenderTypes.getGlowEyes(LOCATION);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);

if (entity.getAttackState() == 14 ) {
    this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, 15728640, OverlayTexture.NO_OVERLAY, 0.5f, 0.5f, 0.5f, 0.4f);
}else {

    this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, 15728640, OverlayTexture.NO_OVERLAY, 0, 0, 0, 0);
}
}

}