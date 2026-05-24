package net.miauczel.legendary_monsters.entity.client.Render.BlockEntity.SomberTrapdoor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.block.blockentity.SomberTrapdoorBlockEntity;
import net.miauczel.legendary_monsters.block.custom.SomberTrapdoorBlock;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.BlockEntity.SomberTrapdoorModel;
import net.miauczel.legendary_monsters.entity.client.Render.LMRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;

public class SomberTrapdoorRenderer implements BlockEntityRenderer<SomberTrapdoorBlockEntity> {
    private final SomberTrapdoorModel model;
    public static final ResourceLocation LOCATION_BASE_0 = new ResourceLocation(LegendaryMonsters.MOD_ID,
            "textures/block/somber_trapdoor.png");

    public SomberTrapdoorRenderer(BlockEntityRendererProvider.Context pContext) {
        this.model = new SomberTrapdoorModel(pContext.bakeLayer(ModModelLayers.SOMBER_TRAPDOOR_LAYER));
    }

    @Override
    public boolean shouldRenderOffScreen(SomberTrapdoorBlockEntity pBlockEntity) {
        return true;
    }

    @Override
    public int getViewDistance() {
        return 256;
    }

    @Override
    public void render(SomberTrapdoorBlockEntity pBlockEntity, float pPartialTick, PoseStack matrixStack,
                       MultiBufferSource buffer, int pPackedLight, int pPackedOverlay) {
//System.out.println("KK");
        matrixStack.pushPose();
        model.animateBlock(pBlockEntity, pPartialTick);
        Direction yRot = pBlockEntity.getBlockState().getValue(SomberTrapdoorBlock.DIRECTION);
        SomberTrapdoorPart part = pBlockEntity.getBlockState().getValue(SomberTrapdoorBlock.PART);
        float scale = 1f;
        float rot = (float) Math.toDegrees(-yRot.getOpposite().getRotation().y * Math.PI);
        Axis axis = Axis.YP;
        switch (yRot) {
            case WEST, EAST -> {
                matrixStack.translate(0.5, 1.5, 0.5);
                matrixStack.mulPose(axis.rotationDegrees(-90));
            }
            case SOUTH, NORTH, DOWN, UP -> matrixStack.translate(0.5, 1.5, 0.5);
        }
        //  model.animateBlock(pBlockEntity,pPartialTick);
        matrixStack.mulPose(Axis.XP.rotationDegrees(180));
        matrixStack.scale(scale, scale, scale);

        RenderType t2 = LMRenderTypes.entityCutoutNoCull(LOCATION_BASE_0);
        VertexConsumer vertexconsumer = buffer.getBuffer(t2);
        if (part == SomberTrapdoorPart.MIDDLE) {
            this.model.renderToBuffer(matrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY,
                    1.0F, 1.0F, 1.0F, 1.0F);
        }
        matrixStack.popPose();

    }
}