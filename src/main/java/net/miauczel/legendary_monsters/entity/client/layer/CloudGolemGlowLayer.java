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
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CloudGolemGlowLayer extends RenderLayer<Cloud_GolemEntity, Cloud_GolemModel<Cloud_GolemEntity>> {
    private static final ResourceLocation CLOUD_GOLEM_GLOW_LAYER = new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/cloud_golem/glow/cloud_golem_angry_glow3.png");

    public CloudGolemGlowLayer(Cloud_GolemRenderer renderIn) {
        super((RenderLayerParent<Cloud_GolemEntity, Cloud_GolemModel<Cloud_GolemEntity>>) renderIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, Cloud_GolemEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {


            RenderType eyes = LMRenderTypes.getGlowEyes(CLOUD_GOLEM_GLOW_LAYER);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);

        float strength = 0.5F + Mth.clamp(((float) Math.cos((entity.LayerTicks + partialTicks) * 0.05F)) - 0.25F, -0.25F, 0.5F);


        strength += Mth.lerp(partialTicks, entity.oLayerBrightness, entity.LayerBrightness) * 1 * Mth.PI;
        strength = Mth.clamp(strength, 0.5f, 1.0F);

        this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, 15728640, OverlayTexture.NO_OVERLAY, strength, strength, strength, strength);

}

}