package net.miauczel.legendary_monsters.entity.ProjectileEntityRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.FlyingArmorEntity;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FlyingArmorRenderer extends EntityRenderer<FlyingArmorEntity> {
    public static final ResourceLocation TEXTURE_DOWN_LEFT = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/flying_armor/armor_projectile_2.png");

    public static final ResourceLocation TEXTURE_DOWN_RIGHT = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/flying_armor/armor_projectile_1.png");

    public static final ResourceLocation TEXTURE_UPPER_RIGHT = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/the_warped_one/flying_armor/armor_projectile_3.png");
    private final FlyingArmorModel model;

    public FlyingArmorRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new FlyingArmorModel(pContext.bakeLayer(ModModelLayers.FLYING_ARMOR_LAYER));

    }

    @Override
    public void render(FlyingArmorEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
        float secondsPerRevolution = 0.5f;
        float ticksPerRevolution = 20.0f * secondsPerRevolution;
        float radiansPerTick = ((float)Math.PI * 2F) / ticksPerRevolution;
pMatrixStack.translate(0,1.25,0);
        float rotation = (pPartialTicks * radiansPerTick) % ((float)Math.PI * 2F);
        pMatrixStack.mulPose(Axis.XP.rotationDegrees(180F));
        model.setupAnim(pEntity, 0, 0, pEntity.tickCount + pPartialTicks, 0, 0);

            float uniformScale = 1;
    pMatrixStack.scale(uniformScale,uniformScale,uniformScale);
            VertexConsumer VertexConsumer2 = pBuffer.getBuffer(this.model.renderType(getTextureLocation(pEntity)));

        model.renderToBuffer(pMatrixStack, VertexConsumer2, pPackedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        pMatrixStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(FlyingArmorEntity pEntity) {
        switch ((int) pEntity.getTexture()){
            case 1 -> {
                return TEXTURE_DOWN_LEFT;
            }
            case 2 -> {
                return TEXTURE_DOWN_RIGHT;
            }
            case 3 -> {
                return TEXTURE_UPPER_RIGHT;
            }
            default -> {
                return TEXTURE_DOWN_LEFT;
            }
        }
    }
}
