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
public class GoldenHalbertModel extends Model {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/golden_halbert_entity.png");
    private final ModelPart root;

    public GoldenHalbertModel(ModelPart pRoot) {
        super(RenderType::entityTranslucent);
        this.root = pRoot;
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition spear_axe = partdefinition.addOrReplaceChild("spear_axe", CubeListBuilder.create(), PartPose.offsetAndRotation(11.8003F, 13.0827F, -0.5F, 0.0F, 1, 0.0F));

        PartDefinition blade2 = spear_axe.addOrReplaceChild("blade2", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.5F, -9.0F, -6.5F, 0.0F, 90F, 0.0F));

        PartDefinition cube_r1 = blade2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(124, 1).addBox(-8.25F, -8.75F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 86).addBox(-18.25F, -11.75F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 77).addBox(-17.25F, -12.75F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(62, 56).addBox(-16.25F, -13.75F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(81, 27).addBox(-15.25F, -10.75F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 22).addBox(-14.25F, -9.75F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 85).addBox(-13.25F, -9.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(119, 93).addBox(-12.25F, -9.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 37).addBox(-8.25F, -3.75F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(13, 34).addBox(-7.25F, -2.75F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(70, 43).addBox(-8.25F, -2.75F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 41).addBox(-9.25F, -4.75F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(21, 5).addBox(-9.25F, -9.75F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 116).addBox(-10.25F, -10.75F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(62, 110).addBox(-11.25F, -10.75F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9497F, 11.6673F, 6.5F, 0.0F, 0.0F, 0.7854F));

        PartDefinition end_blade = spear_axe.addOrReplaceChild("end_blade", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.5F, -9.0F, -6.5F, 0.0F, -90F, 0.0F));

        PartDefinition stick = spear_axe.addOrReplaceChild("stick", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.5F, -9.0F, -6.5F, 0.0F, -90F, 0.0F));

        PartDefinition cube_r2 = stick.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(66, 63).addBox(16.75F, 13.25F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(62, 66).addBox(15.75F, 12.25F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(14.75F, 11.25F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(13.75F, 10.25F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(12.75F, 9.25F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(11.75F, 8.25F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(10.75F, 7.25F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(9.75F, 6.25F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(8.75F, 5.25F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(7.75F, 4.25F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(6.75F, 3.25F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(25, 69).addBox(5.75F, 2.25F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(25, 69).addBox(4.75F, 1.25F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(25, 69).addBox(3.75F, 0.25F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(25, 69).addBox(2.75F, -0.75F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(25, 69).addBox(1.75F, -1.75F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(19, 73).addBox(0.75F, -2.75F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-0.25F, -3.75F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.25F, -4.75F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.25F, -5.75F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(37, 64).addBox(-3.25F, -6.75F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(29, 69).addBox(-4.25F, -7.75F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 63).addBox(-5.25F, -8.75F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(29, 73).addBox(-6.25F, -9.75F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 81).addBox(-7.25F, -10.75F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 77).addBox(-8.25F, -11.75F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(98, 12).addBox(-6.25F, -14.75F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(97, 18).addBox(-5.25F, -14.75F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(121, 32).addBox(-7.25F, -14.75F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(77, 24).addBox(-8.25F, -14.75F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 77).addBox(-9.25F, -12.75F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(54, 66).addBox(-15.25F, -17.75F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 81).addBox(-14.25F, -17.75F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 81).addBox(-13.25F, -16.75F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 77).addBox(-12.25F, -15.75F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 81).addBox(-11.25F, -14.75F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 81).addBox(-10.25F, -13.75F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9497F, 11.6673F, 6.5F, 0.0F, 0.0F, 0.7854F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        this.root.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
    }
}
