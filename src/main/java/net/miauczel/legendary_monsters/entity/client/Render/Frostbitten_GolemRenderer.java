package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.client.Model.Frostbitten_GolemModel;
import net.miauczel.legendary_monsters.entity.client.Glow.FrostbittenGolemEye;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Frostbitten_GolemEntity;

import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class Frostbitten_GolemRenderer extends MobRenderer<Frostbitten_GolemEntity, Frostbitten_GolemModel<Frostbitten_GolemEntity>> {
    public Frostbitten_GolemRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new Frostbitten_GolemModel<>(pContext.bakeLayer(ModModelLayers.FROSTBITTEN_GOLEM_LAYER)), 1.5f);
        this.addLayer(new EyesLayer<Frostbitten_GolemEntity, Frostbitten_GolemModel<Frostbitten_GolemEntity>>(this) {
            @Override
            public RenderType renderType() {
                return RenderType.eyes(new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/frostbitten_golem/glow/frostbitten_golem_glow.png"));
            }
        });
        ;
    }

    @Override
    public ResourceLocation getTextureLocation(Frostbitten_GolemEntity pEntity) {
        Frostbitten_GolemEntity.Crackiness crackiness = pEntity.getCrackiness();
        if (crackiness == Frostbitten_GolemEntity.Crackiness.MEDIUM) {
            return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/frostbitten_golem/crackiness/frostbitten_golem_crack2.png");
        }
        if (crackiness == Frostbitten_GolemEntity.Crackiness.HIGH) {
            return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/frostbitten_golem/crackiness/frostbitten_golem_crack3.png");
        }
        return new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/frostbitten_golem/frostbitten_golem.png");
    }



    @Override
    public void render(Frostbitten_GolemEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.scale(1.5f,1.5f,1.5f);
        Frostbitten_GolemEntity.Crackiness crackiness = pEntity.getCrackiness();


        this.layers.removeIf(layer -> layer instanceof FrostbittenGolemEye<Frostbitten_GolemEntity>);


        if (crackiness == Frostbitten_GolemEntity.Crackiness.MEDIUM || crackiness == Frostbitten_GolemEntity.Crackiness.HIGH) {

        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

}
