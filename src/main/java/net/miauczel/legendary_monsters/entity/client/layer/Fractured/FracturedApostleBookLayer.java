package net.miauczel.legendary_monsters.entity.client.layer.Fractured;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CollapsedKingdom.Fractured.FracturedApostleEntity;
import net.miauczel.legendary_monsters.entity.client.Model.FracturedApostleModel;
import net.miauczel.legendary_monsters.entity.client.Render.FracturedApostleRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FracturedApostleBookLayer extends RenderLayer<FracturedApostleEntity, FracturedApostleModel<FracturedApostleEntity>> {
    private static final ResourceLocation EYES_1 = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/fractured_apostle/fractured_apostle_book.png");


    public FracturedApostleBookLayer(FracturedApostleRenderer renderIn) {
        super(renderIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, FracturedApostleEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderType eyes = renderType(entity);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
            this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1f);
    }

    @Override
    protected ResourceLocation getTextureLocation(FracturedApostleEntity pEntity) {
        return EYES_1;
    }

    public RenderType renderType(FracturedApostleEntity possessedPaladinEntity) {
        return RenderType.eyes(getTextureLocation(possessedPaladinEntity));
    }
}