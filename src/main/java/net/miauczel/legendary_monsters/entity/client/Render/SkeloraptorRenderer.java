package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.SkeloraptorEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.miauczel.legendary_monsters.entity.client.Model.SkeloraptorModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SkeloraptorRenderer extends MobRenderer<SkeloraptorEntity, SkeloraptorModel<SkeloraptorEntity>> {
    public SkeloraptorRenderer(EntityRendererProvider.Context context) {
        super(context, new SkeloraptorModel<>(context.bakeLayer(ModModelLayers.MINI_SKELETOSAURUS_LAYER)), 1.0f);
    }

    @Override
    public ResourceLocation getTextureLocation(SkeloraptorEntity entity) {
        return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/skeloraptor.png");
    }

    @Override
    public void render(SkeloraptorEntity entity, float entityYaw, float partialTicks, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.5f, 0.5f, 0.5f);
        }
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
