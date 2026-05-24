package net.miauczel.legendary_monsters.entity.client.Glow;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.client.Model.Lava_eaterModel;
import net.miauczel.legendary_monsters.entity.client.Render.Lava_eaterRenderer;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Lava_eaterEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class lvgl extends RenderLayer<Lava_eaterEntity, Lava_eaterModel<Lava_eaterEntity>> {
    private static final ResourceLocation g = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/lvglow.png");

    public lvgl(Lava_eaterRenderer renderIn) {
        super(renderIn);

    }


    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, Lava_eaterEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
if (pLivingEntity.hh() <20){
        float f = 1.0F - (float) pLivingEntity.hh() / 40;
        f = (float) (f - Mth.clamp((float) pLivingEntity.deathTime / 100, 0, 1.0));
        RenderType eyes = RenderType.eyes(g);
        VertexConsumer VertexConsumer = pBuffer.getBuffer(eyes);
        this.getParentModel().renderToBuffer(pPoseStack, VertexConsumer, pPackedLight, OverlayTexture.NO_OVERLAY, f, f, f, f);
    }
}}
