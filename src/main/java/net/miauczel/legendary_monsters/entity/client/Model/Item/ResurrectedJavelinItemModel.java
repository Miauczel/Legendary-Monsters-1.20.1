package net.miauczel.legendary_monsters.entity.client.Model.Item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class ResurrectedJavelinItemModel extends EntityModel<Entity> {
    private final ModelPart javelin;

    public ResurrectedJavelinItemModel(ModelPart root) {
        this.javelin = root.getChild("javelin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition javelin = partdefinition.addOrReplaceChild("javelin", CubeListBuilder.create().texOffs(61, 114).mirror().addBox(-0.5F, -0.5F, -25.6465F, 2.0F, 2.0F, 62.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(127, 133).mirror().addBox(0.5F, -8.5F, -37.6465F, 0.0F, 17.0F, 26.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(85, 137).mirror().addBox(0.5F, -10.5F, 8.3536F, 0.0F, 21.0F, 49.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 21.2678F, -0.3536F, 1.5708F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        javelin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

}