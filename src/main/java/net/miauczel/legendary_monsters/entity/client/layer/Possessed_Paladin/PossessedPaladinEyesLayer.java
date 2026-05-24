package net.miauczel.legendary_monsters.entity.client.layer.Possessed_Paladin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.PossessedPaladin.PossessedPaladinEntity;
import net.miauczel.legendary_monsters.entity.client.Model.NewPossessedPaladinModel;
import net.miauczel.legendary_monsters.entity.client.Render.PossessedPaladinRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PossessedPaladinEyesLayer extends RenderLayer<PossessedPaladinEntity, NewPossessedPaladinModel<PossessedPaladinEntity>> {
    private static final ResourceLocation EYES_1 = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/posessed_paladin/posessed_paladin_glow.png");

    private static final ResourceLocation EYES_2 = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/posessed_paladin/posessed_paladin_glow_p2.png");

    public PossessedPaladinEyesLayer(PossessedPaladinRenderer renderIn) {
        super(renderIn);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, PossessedPaladinEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        RenderType eyes = renderType(entity);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);
        if (entity.getAttackState() != 34)
            this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.5f);
    }

    @Override
    protected ResourceLocation getTextureLocation(PossessedPaladinEntity pEntity) {
        return pEntity.getPhase() >= 2 ? EYES_2 : EYES_1;
    }

    public RenderType renderType(PossessedPaladinEntity possessedPaladinEntity) {
        return RenderType.eyes(getTextureLocation(possessedPaladinEntity));
    }
}