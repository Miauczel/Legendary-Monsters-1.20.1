package net.miauczel.legendary_monsters.entity.client.Model.Item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class TheTesseractItemModel extends EntityModel<Entity> {
    private final ModelPart bone;
    private final ModelPart bone2;

    public TheTesseractItemModel(
    ModelPart root) {
        this.bone = root.getChild("bone");
        this.bone2 = root.getChild("bone2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(12, 41).addBox(-9.0F, 3.0F, 7.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 29).addBox(-10.0F, -3.0F, 5.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, -12).addBox(-8.0F, -32.0F, 2.0F, 0.0F, 29.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 41).addBox(-9.5F, 3.0F, 6.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(24, 8).addBox(-8.0F, -3.0F, 13.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(24, 13).addBox(-8.0F, -3.0F, -3.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(24, 18).addBox(-8.0F, 11.0F, 5.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(34, 36).addBox(-9.0F, -3.0F, 3.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 24.0F, -8.0F));

        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(20, 31).mirror().addBox(-2.001F, -0.001F, 0.001F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.5F, 0.0F, 3.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(20, 36).addBox(-2.001F, -0.001F, -1.999F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, 0.0F, 13.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(26, 36).mirror().addBox(7.0F, -3.0F, 11.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-8.0F, 24.0F, -8.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

}