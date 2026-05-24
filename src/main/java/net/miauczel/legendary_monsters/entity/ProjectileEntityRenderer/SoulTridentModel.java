package net.miauczel.legendary_monsters.entity.ProjectileEntityRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SoulTridentModel extends Model {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/resurrected_knight/javelin.png");
    private final ModelPart trident;

    public SoulTridentModel(ModelPart root) {
        super(RenderType::entityTranslucentEmissive);
        this.trident = root.getChild("trident");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition trident = partdefinition.addOrReplaceChild("trident", CubeListBuilder.create().texOffs(71, 124).addBox(-1.0F, -1.0F, -16.1429F, 2.0F, 2.0F, 37.0F, new CubeDeformation(0.0F))
                .texOffs(72, 126).addBox(0.0F, -14.5F, -53.1429F, 0.0F, 29.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 18.0F, 1.1429F, 3.1416F, 0.0F, 0.0F));

        PartDefinition cube_r1 = trident.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(112, 149).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, -17.1429F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r2 = trident.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(122, 180).addBox(0.0F, -4.0F, -6.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.1429F, 3.1416F, 0.0F, 1.5708F));

        PartDefinition cube_r3 = trident.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(122, 180).addBox(0.0F, -4.0F, -6.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 31.8571F, 3.1416F, 0.0F, 1.5708F));

        PartDefinition cube_r4 = trident.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(122, 180).addBox(0.0F, -4.0F, -6.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.1429F, 3.1416F, 0.0F, 0.0F));

        PartDefinition cube_r5 = trident.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(122, 180).addBox(0.0F, -4.0F, -6.0F, 0.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 23.8571F, -3.1416F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }
    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        this.trident.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
    }
}
