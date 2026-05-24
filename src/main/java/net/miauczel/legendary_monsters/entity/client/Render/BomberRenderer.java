package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.RuinedPyramid.BomberEntity;
import net.miauczel.legendary_monsters.entity.client.Model.BomberModel;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class BomberRenderer extends MobRenderer<BomberEntity, BomberModel<BomberEntity>> {
    public BomberRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BomberModel<>(pContext.bakeLayer(ModModelLayers.BOMBER_LAYER)), 1f);
    }
    protected void scale(BomberEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        float f = pLivingEntity.getSwelling(pPartialTickTime);
        float f1 = 1.0F + Mth.sin(f * 100.0F) * f * 0.01F;
        f = Mth.clamp(f, 0.0F, 1.0F);
        f *= f;
        f *= f;
        float f2 = (1.0F + f * 0.4F) * f1;
        float f3 = (1.0F + f * 0.1F) / f1;
        pMatrixStack.scale(f2, f3, f2);
    }
    protected float getWhiteOverlayProgress(BomberEntity pLivingEntity, float pPartialTicks) {
        float f = pLivingEntity.getSwelling(pPartialTicks);
        return (int)(f * 5.0F) % 2 == 0 ? 0.0F : Mth.clamp(f, 0.5F, 1.0F);
    }
    @Override
    public ResourceLocation getTextureLocation(BomberEntity pEntity) {

        return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/bomber_dune.png")  ;
    }

    @Override
    public void render(BomberEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
