package net.miauczel.legendary_monsters.entity.client.Render.BlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.block.blockentity.SwingingAxeBlockEntity;
import net.miauczel.legendary_monsters.block.custom.SwingingAxeBlock;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.BlockEntity.SwingingAxeModel;
import net.miauczel.legendary_monsters.entity.client.Render.LMRenderTypes;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;

public class SwingingAxeRenderer implements BlockEntityRenderer<SwingingAxeBlockEntity> {
    private final SwingingAxeModel model;
    public static final ResourceLocation LOCATION_BASE_0 = new ResourceLocation(LegendaryMonsters.MOD_ID,
            "textures/block/swinging_axe.png");

    public SwingingAxeRenderer(BlockEntityRendererProvider.Context pContext) {
        this.model = new SwingingAxeModel(pContext.bakeLayer(ModModelLayers.SWINGING_AXE_LAYER));
    }

    @Override
    public boolean shouldRenderOffScreen(SwingingAxeBlockEntity pBlockEntity) {
        return true;
    }

    @Override
    public int getViewDistance() {
        return 256;
    }

    @Override
    public void render(SwingingAxeBlockEntity swingingAxeBlockEntity, float pPartialTick, PoseStack matrixStack,
                       MultiBufferSource buffer, int pPackedLight, int pPackedOverlay) {
//System.out.println("KK");
        matrixStack.pushPose();
        model.animateBlock(swingingAxeBlockEntity, pPartialTick);
        Direction yRot = swingingAxeBlockEntity.getBlockState().getValue(SwingingAxeBlock.DIRECTION);
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
        matrixStack.mulPose(Axis.XP.rotationDegrees(180));
        matrixStack.scale(scale, scale, scale);

        RenderType t2 = LMRenderTypes.entityCutoutNoCull(LOCATION_BASE_0);
        VertexConsumer vertexconsumer = buffer.getBuffer(t2);

        this.model.renderToBuffer(matrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY,
                1.0F, 1.0F, 1.0F, 1.0F);

        Vec3 start = swingingAxeBlockEntity.IK_START();
        Vec3 endPoint = swingingAxeBlockEntity.IK_Point();


        matrixStack.popPose();

    }
}