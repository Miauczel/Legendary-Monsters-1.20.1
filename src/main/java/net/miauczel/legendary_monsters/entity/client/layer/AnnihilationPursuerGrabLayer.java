package net.miauczel.legendary_monsters.entity.client.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.Flameborn.AnnihilationPursuer.AnnihilationPursuerEntity;
import net.miauczel.legendary_monsters.entity.client.Model.AnnihilationPursuerModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.Entity;

public class AnnihilationPursuerGrabLayer extends RenderLayer<AnnihilationPursuerEntity, AnnihilationPursuerModel<AnnihilationPursuerEntity>> {
    private final EntityRenderDispatcher mobRenderer;
    public AnnihilationPursuerGrabLayer(RenderLayerParent<AnnihilationPursuerEntity, AnnihilationPursuerModel<AnnihilationPursuerEntity>> renderer, EntityRenderDispatcher dispatcher) {
        super(renderer);
        mobRenderer = dispatcher;
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, AnnihilationPursuerEntity pLivingEntity, float pLimbSwing,
                       float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        for (Entity passenger : pLivingEntity.getPassengers()){
            if (passenger == Minecraft.getInstance().player && Minecraft.getInstance().options.getCameraType().isFirstPerson()) {
                continue;
            }
            renderHeldMobs(this.mobRenderer,passenger,pPoseStack,pPartialTick,pBuffer,pPackedLight);
        }
    }
    public void renderHeldMobs(EntityRenderDispatcher renderDispatcher, Entity livingEntity,PoseStack pMatrixStack,float partialTicks,MultiBufferSource pBuffer,int packedLight){
LegendaryMonsters.PROXY.releaseRenderingEntity(livingEntity.getUUID());
pMatrixStack.pushPose();
this.getParentModel().translateModel(pMatrixStack);

       // pMatrixStack.scale(0.7f, 0.7f, 0.7f);

        pMatrixStack.mulPose(Axis.YP.rotation(180));
        pMatrixStack.mulPose(Axis.ZP.rotation(75));
        pMatrixStack.mulPose(Axis.XP.rotation(45));

        //pMatrixStack.mulPose(Axis.XN.rotation(90));
renderDispatcher.render(livingEntity,0,0,0,0,partialTicks,pMatrixStack,pBuffer,packedLight);
pMatrixStack.popPose();
LegendaryMonsters.PROXY.blockRenderingEntity(livingEntity.getUUID());
    }

}
