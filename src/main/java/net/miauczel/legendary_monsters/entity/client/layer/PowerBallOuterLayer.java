package net.miauczel.legendary_monsters.entity.client.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.AnnihilationBombEntity;
import net.miauczel.legendary_monsters.entity.ProjectileEntityRenderer.PowerBallBombModel;
import net.miauczel.legendary_monsters.entity.client.Render.LMRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public class PowerBallOuterLayer extends RenderLayer<AnnihilationBombEntity, PowerBallBombModel> {
    private static final ResourceLocation LOCATION =
            new ResourceLocation(LegendaryMonsters.MOD_ID,
                    "textures/entity/the_warped_one/ball/outer_ball_layer.png");

    public PowerBallOuterLayer(RenderLayerParent<AnnihilationBombEntity, PowerBallBombModel> renderer) {
        super(renderer);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, AnnihilationBombEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {


            RenderType eyes = LMRenderTypes.getGlowEyes(LOCATION);
        VertexConsumer VertexConsumer = bufferIn.getBuffer(eyes);


    this.getParentModel().renderToBuffer(matrixStackIn, VertexConsumer, 15728640, OverlayTexture.NO_OVERLAY, 1, 1f, 1f, 1f);
}
}