package net.miauczel.legendary_monsters.entity.client.Render.BlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.block.blockentity.TeleportMachineBlockEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.BlockEntity.TeleportMachineModel;
import net.miauczel.legendary_monsters.entity.client.Render.LMRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class TeleportMachineRenderer implements BlockEntityRenderer<TeleportMachineBlockEntity> {
private final TeleportMachineModel model;
    public static final ResourceLocation LOCATION_BASE_1 = new ResourceLocation(LegendaryMonsters.MOD_ID,
            "textures/block/teleport_machine_1.png");

    public static final ResourceLocation LOCATION_BASE_0 = new ResourceLocation(LegendaryMonsters.MOD_ID,
            "textures/block/teleport_machine_0.png");
 public TeleportMachineRenderer(BlockEntityRendererProvider.Context pContext){
     this.model = new TeleportMachineModel(pContext.bakeLayer(ModModelLayers.TELEPORT_MACHINE_LAYER));
 }

    @Override
    public void render(TeleportMachineBlockEntity pBlockEntity, float pPartialTick, PoseStack matrixStack,
                       MultiBufferSource buffer, int pPackedLight, int pPackedOverlay) {
//System.out.println("KK");
matrixStack.pushPose();
        float scale = 1f;
       // matrixStack.scale(scale, scale, scale);

        matrixStack.mulPose(Axis.XP.rotationDegrees(180));
        matrixStack.translate(0.5D, -1.5D, -0.5D);
        matrixStack.scale(scale, scale, scale);

        RenderType t2 = LMRenderTypes.entityCutoutNoCull(pBlockEntity.active ? LOCATION_BASE_1 :LOCATION_BASE_0);
            VertexConsumer vertexconsumer = buffer.getBuffer(t2);

            this.model.renderToBuffer(matrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY,
                    1.0F, 1.0F, 1.0F, 1.0F);
matrixStack.popPose();

    }
}