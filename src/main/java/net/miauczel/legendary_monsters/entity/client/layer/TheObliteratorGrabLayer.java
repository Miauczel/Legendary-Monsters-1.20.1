package net.miauczel.legendary_monsters.entity.client.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.client.Model.TheObliteratorModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

public class TheObliteratorGrabLayer extends RenderLayer<TheObliteratorEntity, TheObliteratorModel<TheObliteratorEntity>> {
    private final EntityRenderDispatcher mobRenderer;
    private static final ResourceLocation[] PHASE_3_TEXTURES = new ResourceLocation[]{
            new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/the_warped_one/layer/flames_1.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/the_warped_one/layer/flames_2.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/the_warped_one/layer/flames_3.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/the_warped_one/layer/flames_4.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/the_warped_one/layer/flames_5.png"),
    };

    public TheObliteratorGrabLayer(RenderLayerParent<TheObliteratorEntity, TheObliteratorModel<TheObliteratorEntity>> renderer, EntityRenderDispatcher dispatcher) {
        super(renderer);
        mobRenderer = dispatcher;
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, TheObliteratorEntity pLivingEntity, float pLimbSwing,
                       float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        for (Entity passenger : pLivingEntity.getPassengers()){
            if (passenger == Minecraft.getInstance().player && Minecraft.getInstance().options.getCameraType().isFirstPerson()) {
                continue;
            }
            renderHeldMobs(this.mobRenderer,passenger,pPoseStack,pPartialTick,pBuffer,pPackedLight,pLivingEntity);
        }


    }
    public void renderHeldMobs(EntityRenderDispatcher renderDispatcher, Entity livingEntity,PoseStack pMatrixStack,float partialTicks,MultiBufferSource pBuffer,int packedLight,TheObliteratorEntity entity) {
        if (entity.getAttackState() == 50 || entity.getAttackState() == 40) {
            LegendaryMonsters.PROXY.releaseRenderingEntity(livingEntity.getUUID());
            pMatrixStack.pushPose();

            if (entity.getAttackState() == 50) {
                getParentModel().translateModelToLeftArm(pMatrixStack);

            } else if (entity.getAttackState() == 40) {
                getParentModel().translateModelToRightArm(pMatrixStack);
            }
            pMatrixStack.scale(1.2f, 1.2f, 1.2f);

            pMatrixStack.translate(1F, 0.25f, 0.5f);
            pMatrixStack.mulPose(Axis.XP.rotation(90));
            pMatrixStack.mulPose(Axis.ZP.rotation(90));

            renderDispatcher.render(livingEntity, 0, 0, 0, 0, partialTicks, pMatrixStack, pBuffer, packedLight);

            pMatrixStack.popPose();
            LegendaryMonsters.PROXY.blockRenderingEntity(livingEntity.getUUID());
        }
    }
}
