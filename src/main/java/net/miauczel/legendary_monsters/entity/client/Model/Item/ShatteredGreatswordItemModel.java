package net.miauczel.legendary_monsters.entity.client.Model.Item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class ShatteredGreatswordItemModel extends EntityModel<Entity> {
    private final ModelPart broken_sword;

    public ShatteredGreatswordItemModel(ModelPart root) {
        this.broken_sword = root.getChild("broken_sword");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition broken_sword = partdefinition.addOrReplaceChild("broken_sword", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1817F, 23.3383F, 0.0232F, -1.5572F, -0.1251F, -0.0051F));

        PartDefinition cube_r1 = broken_sword.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(130, 180).addBox(62.0706F, 25.0214F, 5.0F, 0.0F, 7.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(62.0706F, 17.0214F, -54.0F, 0.0F, 22.0F, 51.0F, new CubeDeformation(0.0F))
                .texOffs(110, 172).addBox(61.5658F, 24.0214F, -19.0F, 1.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(156, 0).addBox(60.5658F, 22.0214F, -10.0F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(34, 142).addBox(60.5658F, 27.0214F, -7.0F, 3.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-57.827F, -36.2797F, 8.5F, 0.0F, 0.0F, 0.1309F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        broken_sword.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

}