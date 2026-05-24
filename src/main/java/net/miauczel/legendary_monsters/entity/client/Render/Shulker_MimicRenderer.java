package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.ShulkerTower.Shulker_MimicEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.Shulker_MimicModel;
import net.miauczel.legendary_monsters.entity.client.layer.ShulkerMimic.ShulkerMimicGrabLayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class Shulker_MimicRenderer extends MobRenderer<Shulker_MimicEntity, Shulker_MimicModel<Shulker_MimicEntity>> {
    public Shulker_MimicRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new Shulker_MimicModel<>(pContext.bakeLayer(ModModelLayers.SHULKER_MIMIC_LAYER)), 1.5f);

        layers.add(new ShulkerMimicGrabLayer(this,pContext.getEntityRenderDispatcher()));
    }
public ResourceLocation DEFAULT = new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/shulker_mimic/shulker_mimic.png");
    public  ResourceLocation CRACKY = new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/shulker_mimic/crack/crack_1.png");
    public  ResourceLocation CRACKED = new ResourceLocation(LegendaryMonsters.MOD_ID,"textures/entity/shulker_mimic/crack/crack_2.png");

    public ResourceLocation getTextureLocation(Shulker_MimicEntity pEntity) {
        switch (pEntity.getPhase()){
            case 2 ->{
                return CRACKY;
            }
            case 3 -> {
                return CRACKED;
            }
            default -> {
                return DEFAULT;
            }
        }
    }

    @Override
    public void render(Shulker_MimicEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        float bodyXRotDeg = (model.head.xRot * Mth.RAD_TO_DEG) * 1;
        float bodyYRotDeg = (model.head.yRot * Mth.RAD_TO_DEG) * 1;

        pEntity.setPartXRot(-bodyXRotDeg);
        pEntity.setPartYRot(-bodyYRotDeg);
        pMatrixStack.scale(1.5f,1.5f,1.5f);
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
