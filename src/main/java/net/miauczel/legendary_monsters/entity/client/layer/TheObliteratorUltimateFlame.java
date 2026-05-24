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
public class TheObliteratorUltimateFlame
        extends RenderLayer<TheObliteratorEntity, TheObliteratorModel<TheObliteratorEntity>> {

    private static final ResourceLocation[] ULTIMATE_FLAME_TEXTURES = new ResourceLocation[]{
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/ultimate_flame/ultimate_flame_0.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/ultimate_flame/ultimate_flame_1.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/ultimate_flame/ultimate_flame_2.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/ultimate_flame/ultimate_flame_3.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/ultimate_flame/ultimate_flame_4.png"),
    };

    public TheObliteratorUltimateFlame(RenderLayerParent<TheObliteratorEntity, TheObliteratorModel<TheObliteratorEntity>> renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer,
                       int packedLight, TheObliteratorEntity entity,
                       float limbSwing, float limbSwingAmount,
                       float partialTicks, float ageInTicks,
                       float netHeadYaw, float headPitch) {

        int totalFrames = ULTIMATE_FLAME_TEXTURES.length;
        float speed = 10.0F;
        int frame = (int) ((entity.tickCount + partialTicks) * speed / 20.0F) % totalFrames;

        RenderType rt = LMRenderTypes.getGlowEyes(ULTIMATE_FLAME_TEXTURES[frame]);
        VertexConsumer vc = buffer.getBuffer(rt);

        int overlay = LivingEntityRenderer.getOverlayCoords(entity, 0.0F);

        if (entity.getIsThirdPhase() && (entity.getAttackState() == 53 || entity.getAttackState() == 56 || entity.getAttackState() == 59 || entity.getAttackState() == 58 || entity.getAttackState() == 57) && !entity.isDuringTeleportation(entity.level().isClientSide)) {
            this.getParentModel().renderToBuffer(poseStack, vc, packedLight, overlay, 1f, 1f, 1f, 1f);
        } else {
            this.getParentModel().renderToBuffer(poseStack, vc, packedLight, overlay, 0f, 0f, 0f, 0f);
        }
    }
}
