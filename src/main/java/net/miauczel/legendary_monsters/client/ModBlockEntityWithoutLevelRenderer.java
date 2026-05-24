package net.miauczel.legendary_monsters.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.block.ModBlocks;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.BlockEntity.SomberTrapdoorModel;
import net.miauczel.legendary_monsters.entity.client.Model.BlockEntity.SwingingAxeModel;
import net.miauczel.legendary_monsters.entity.client.Model.BlockEntity.TeleportMachineModel;
import net.miauczel.legendary_monsters.entity.client.Model.Item.ResurrectedJavelinItemModel;
import net.miauczel.legendary_monsters.entity.client.Model.Item.ShatteredGreatswordItemModel;
import net.miauczel.legendary_monsters.entity.client.Model.Item.TheTesseractItemModel;
import net.miauczel.legendary_monsters.entity.client.Render.LMRenderTypes;
import net.miauczel.legendary_monsters.item.ModItems;
import net.miauczel.legendary_monsters.item.custom.ResurrectedJavelinItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModBlockEntityWithoutLevelRenderer extends BlockEntityWithoutLevelRenderer {
    public ModBlockEntityWithoutLevelRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }

    public static int ticks = 0;

    public static void incrementTick() {
        ticks++;
    }

    public static final ModBlockEntityWithoutLevelRenderer INSTANCE =
            new ModBlockEntityWithoutLevelRenderer();

    private static final TheTesseractItemModel TESSERACT_ITEM_MODEL = new TheTesseractItemModel(Minecraft.getInstance().getEntityModels().bakeLayer(ModModelLayers.TESSERACT_LAYER));


    private static final ShatteredGreatswordItemModel SHATTERED_GREATSWORD_MODEL = new ShatteredGreatswordItemModel(Minecraft.getInstance().getEntityModels().bakeLayer(ModModelLayers.SHATTERED_GREATSWORD_LAYER));

    private static final ResurrectedJavelinItemModel RESURRECTED_JAVELIN_MODEL = new ResurrectedJavelinItemModel(Minecraft.getInstance().getEntityModels().bakeLayer(ModModelLayers.RESURRECTED_JAVELIN_LAYER));

    private static final TeleportMachineModel TELEPORT_MACHINE_MODEL = new TeleportMachineModel(Minecraft.getInstance().getEntityModels().bakeLayer(ModModelLayers.TELEPORT_MACHINE_LAYER));

    private static final SwingingAxeModel SWINGING_AXE_MODEL = new SwingingAxeModel(Minecraft.getInstance().getEntityModels().bakeLayer(ModModelLayers.SWINGING_AXE_LAYER));

    private static final SomberTrapdoorModel SOMBER_TRAPDOOR_MODEL = new SomberTrapdoorModel(Minecraft.getInstance().getEntityModels().bakeLayer(ModModelLayers.SOMBER_TRAPDOOR_LAYER));
    private static final ResourceLocation T_1 =
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/item/the_tesseract_base.png");
    private static final ResourceLocation T_2 =
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/item/the_tesseract_glow.png");


    private static final ResourceLocation SHATTERED_GREATSWORD =
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/beheaded_knight/beheaded_knight.png");


    private static final ResourceLocation RESURRECTED_JAVELIN =
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/item/resurrected_javelin.png");


    private static final ResourceLocation TELEPORT_MACHINE_1 =
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/item/teleport_machine_base.png");
    private static final ResourceLocation TELEPORT_MACHINE_2 =
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/item/teleport_machine_glow.png");

    public static final ResourceLocation SWINGING_AXE = new ResourceLocation(LegendaryMonsters.MOD_ID,
            "textures/block/swinging_axe.png");

    public static final ResourceLocation SOMBER_TRAPDOOR = new ResourceLocation(LegendaryMonsters.MOD_ID,
            "textures/block/swinging_axe.png");

    @Override
    public void renderByItem(ItemStack stack,
                             ItemDisplayContext ctx,
                             PoseStack poseStack,
                             MultiBufferSource buffer,
                             int packedLight,
                             int packedOverlay) {
        if (stack.getItem() == ModItems.TESSERACT.get()) {
            poseStack.pushPose();
            poseStack.translate(0.5F, 1.5F, 0.5F);
            poseStack.scale(1, -1, -1F);
            poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));

            VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(buffer, LMRenderTypes.entityCutoutNoCull(T_1), false, stack.hasFoil());
            TESSERACT_ITEM_MODEL.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay, 1, 1, 1, 1);
            VertexConsumer vertexConsumer2 = ItemRenderer.getFoilBufferDirect(buffer, LMRenderTypes.getGlowEyes(T_2), false, stack.hasFoil());
            TESSERACT_ITEM_MODEL.renderToBuffer(poseStack, vertexConsumer2, packedLight, packedOverlay, 1, 1, 1, 1);
            poseStack.popPose();
        }
        if (stack.getItem() == ModItems.SHATTERED_GREATSWORD.get()) {
            poseStack.pushPose();
            poseStack.translate(0.5F, 1.15F, 0.5F);
            float scale = 0.85f;
            poseStack.scale(scale, -scale, -scale);
            poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
            VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(buffer, LMRenderTypes.entityCutoutNoCull(SHATTERED_GREATSWORD), false, stack.hasFoil());
            SHATTERED_GREATSWORD_MODEL.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay, 1, 1, 1, 1);
            poseStack.popPose();
        }
        if (stack.getItem() == ModItems.RESURRECTED_JAVELIN.get()) {
            poseStack.pushPose();
            if (stack.getItem() instanceof ResurrectedJavelinItem item) {
                boolean isUsingStack = item.getDurationOfUse() > 0;
              //  System.out.println("DURATION: " + item.getDurationOfUse());
              //  poseStack.translate(0.5F, isUsingStack ? -1.5f : 0.5f, 0.5F);
             //  poseStack.mulPose(Axis.XP.rotationDegrees(isUsingStack ? 180 : 0));
                poseStack.translate(0.5F, 0.5f, 0.5F);
            }
            float scale = 0.85f;
            poseStack.scale(scale, -scale, -scale);
            VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(buffer, LMRenderTypes.entityCutoutNoCull(RESURRECTED_JAVELIN), false, stack.hasFoil());
            RESURRECTED_JAVELIN_MODEL.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay, 1, 1, 1, 1);
            poseStack.popPose();
        }
        if (stack.getItem() == ModBlocks.TELEPORT_MACHINE.get().asItem()) {

            poseStack.pushPose();
            //poseStack.translate(0.5F, 1.5F, 0.5F);

            // poseStack.scale(1, -1, -1F);

            // poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
            //VertexConsumer vertexConsumer = buffer.getBuffer(LMRenderTypes.entityCutoutNoCull(T_1));
            VertexConsumer vertexConsumer = ItemRenderer.getArmorFoilBuffer(buffer, LMRenderTypes.entityCutoutNoCull(TELEPORT_MACHINE_1), false, stack.hasFoil());
            TELEPORT_MACHINE_MODEL.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay, 1, 1, 1, 1);
            VertexConsumer vertexConsumer2 = ItemRenderer.getArmorFoilBuffer(buffer, LMRenderTypes.getGlowEyes(TELEPORT_MACHINE_2), false, stack.hasFoil());
            TELEPORT_MACHINE_MODEL.renderToBuffer(poseStack, vertexConsumer2, packedLight, packedOverlay, 1, 1, 1, 1);
            poseStack.popPose();
        }
        if (stack.is(ModBlocks.SWINGING_AXE.get().asItem())) {
            poseStack.pushPose();
            VertexConsumer vertexConsumer = ItemRenderer.getArmorFoilBuffer(buffer, LMRenderTypes.entityCutoutNoCull(SWINGING_AXE), false, stack.hasFoil());
            SWINGING_AXE_MODEL.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay, 1, 1, 1, 1);
            poseStack.popPose();
        }
        if (stack.is(ModBlocks.SOMBER_TRAPDOOR.get().asItem())) {
            poseStack.pushPose();
            VertexConsumer vertexConsumer = ItemRenderer.getArmorFoilBuffer(buffer, LMRenderTypes.entityCutoutNoCull(SOMBER_TRAPDOOR), false, stack.hasFoil());
            SOMBER_TRAPDOOR_MODEL.renderToBuffer(poseStack, vertexConsumer, packedLight, packedOverlay, 1, 1, 1, 1);
            poseStack.popPose();
        }
    }
}

