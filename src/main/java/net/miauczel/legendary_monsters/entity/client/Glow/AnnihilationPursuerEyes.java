package net.miauczel.legendary_monsters.entity.client.Glow;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.Flameborn.AnnihilationPursuer.AnnihilationPursuerEntity;
import net.miauczel.legendary_monsters.entity.client.Model.AnnihilationPursuerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class AnnihilationPursuerEyes<T extends AnnihilationPursuerEntity> extends EyesLayer<T, AnnihilationPursuerModel<T>> {

    public static final ResourceLocation GLOW_LAYER = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/flameborn/annihilation_pursuer/annihilation_pursuer_glow.png");
    private static final RenderType GLOW = RenderType.eyes(GLOW_LAYER);
    private static final RenderType NORMAL = RenderType.entityCutoutNoCull(GLOW_LAYER);

    @Override
    protected ResourceLocation getTextureLocation(T pEntity) {
        return super.getTextureLocation(pEntity);
    }
    public AnnihilationPursuerEyes(RenderLayerParent<T, AnnihilationPursuerModel<T>> p_116964_) {
        super(p_116964_);

    }
    @Override
    public void render(PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight, T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
if (pLivingEntity.getAttackState() == 6) {
    VertexConsumer vertexConsumer = pBuffer.getBuffer(GLOW);
    getParentModel().renderToBuffer(pMatrixStack, vertexConsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
}
        super.render(pMatrixStack, pBuffer, pPackedLight, pLivingEntity, pLimbSwing, pLimbSwingAmount, pPartialTicks, pAgeInTicks, pNetHeadYaw, pHeadPitch);
    }

    @Override
    public RenderType renderType() {

        return GLOW;
    }
}

