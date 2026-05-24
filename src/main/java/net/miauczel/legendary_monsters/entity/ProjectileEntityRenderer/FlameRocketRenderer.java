package net.miauczel.legendary_monsters.entity.ProjectileEntityRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.FlameRocketEntity;
import net.miauczel.legendary_monsters.entity.client.Render.LMRenderTypes;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FlameRocketRenderer extends EntityRenderer<FlameRocketEntity> {
    private static final ResourceLocation[] FLAME_ROCKET_TEXTURES = new ResourceLocation[] {
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/flame_rocket/flame_rocket_0.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/flame_rocket/flame_rocket_1.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/flame_rocket/flame_rocket_2.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/flame_rocket/flame_rocket_3.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/flame_rocket/flame_rocket_4.png"),
    };
    private final FlameRocketModel model;

    public FlameRocketRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new FlameRocketModel(pContext.bakeLayer(ModModelLayers.FLAME_ROCKET_LAYER));

    }

    @Override
    public void render(FlameRocketEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        int total = FLAME_ROCKET_TEXTURES.length;
        float fps = 10.0F;
        int frame = (int)((pEntity.tickCount * fps) / 20.0F) % total;

        RenderType eyes = LMRenderTypes.entityTranslucent(FLAME_ROCKET_TEXTURES[frame]);
        VertexConsumer vertexconsumer = pBuffer.getBuffer(eyes);
        this.model.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY,
                1.0F, 1.0F, 1.0F, 1.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(FlameRocketEntity pEntity) {
        int total = FLAME_ROCKET_TEXTURES.length;
        float fps = 10.0F;
        int frame = (int)((pEntity.tickCount * fps) / 20.0F) % total;
        return FLAME_ROCKET_TEXTURES[frame];
    }
}
