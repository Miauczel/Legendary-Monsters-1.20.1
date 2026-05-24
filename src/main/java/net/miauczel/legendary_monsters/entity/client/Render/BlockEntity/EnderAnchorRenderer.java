package net.miauczel.legendary_monsters.entity.client.Render.BlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.block.custom.EnderAnchorBlock;
import net.miauczel.legendary_monsters.block.blockentity.EnderAnchorBlockEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.BlockEntity.EnderAnchorModel;
import net.miauczel.legendary_monsters.entity.client.Render.LMRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;

public class EnderAnchorRenderer implements BlockEntityRenderer<EnderAnchorBlockEntity> {
private final EnderAnchorModel model;
    public static final ResourceLocation LOCATION = new ResourceLocation(LegendaryMonsters.MOD_ID,
            "textures/block/ender_anchor.png");
 public EnderAnchorRenderer(BlockEntityRendererProvider.Context pContext){
     this.model = new EnderAnchorModel(pContext.bakeLayer(ModModelLayers.ENDER_ANCHOR_LAYER));
 }

    @Override
    public void render(EnderAnchorBlockEntity pBlockEntity, float pPartialTick, PoseStack matrixStack,
                       MultiBufferSource buffer, int pPackedLight, int pPackedOverlay) {

        matrixStack.pushPose();

        float scale = 1f;
        matrixStack.scale(scale, scale, scale);
        matrixStack.translate(0.625D, -0.249D, 0.625D);
        BlockState state = pBlockEntity.getBlockState();


        int charges = 0;
        if (state.getBlock() instanceof EnderAnchorBlock) {
            charges = state.getValue(EnderAnchorBlock.CHARGES);
        }

        if (charges >= 1) {
            RenderType eyes = LMRenderTypes.endPortal();
            VertexConsumer vertexconsumer = buffer.getBuffer(eyes);

            this.model.renderToBuffer(matrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY,
                    1.0F, 1.0F, 1.0F, 1.0F);
        }

        matrixStack.popPose();
    }
}