package net.miauczel.legendary_monsters.entity.client.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.client.Render.LMRenderTypes;
import net.miauczel.legendary_monsters.entity.client.Model.TheObliteratorModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TheObliteratorFlameyBladesLayer
        extends RenderLayer<TheObliteratorEntity, TheObliteratorModel<TheObliteratorEntity>> {

    private static final ResourceLocation[] PHASE_3_TEXTURES = new ResourceLocation[]{
            new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/the_warped_one/layer/flames_1.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/the_warped_one/layer/flames_2.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/the_warped_one/layer/flames_3.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/the_warped_one/layer/flames_4.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/the_warped_one/layer/flames_5.png"),
    };

    public TheObliteratorFlameyBladesLayer(RenderLayerParent<TheObliteratorEntity, TheObliteratorModel<TheObliteratorEntity>> renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer,
                       int packedLight, TheObliteratorEntity entity,
                       float limbSwing, float limbSwingAmount,
                       float partialTicks, float ageInTicks,
                       float netHeadYaw, float headPitch) {

        int totalFrames = PHASE_3_TEXTURES.length;
        float speed = 10.0F;
        int frame = (int)((entity.tickCount + partialTicks) * speed / 20.0F) % totalFrames;

        RenderType rt = LMRenderTypes.getGlowEyes(PHASE_3_TEXTURES[frame]);
        VertexConsumer vc = buffer.getBuffer(rt);

        int overlay = LivingEntityRenderer.getOverlayCoords(entity, 0.0F);

        if (entity.getIsThirdPhase() && !entity.isDuringTeleportation(entity.level().isClientSide)) {

            this.getParentModel().renderToBuffer(poseStack, vc, packedLight, overlay, 1f, 1f, 1f, 1f);
        } else {

            this.getParentModel().renderToBuffer(poseStack, vc, packedLight, overlay, 0f,0f,0f,0f);
        }
    }
}
