package net.miauczel.legendary_monsters.entity.client.Model.BlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class TeleportMachineModel extends HierarchicalModel<Entity> {
    private final ModelPart bone;
    private final ModelPart eye;

    public TeleportMachineModel(ModelPart root) {
        this.bone = root.getChild("bone");
        this.eye = this.bone.getChild("eye");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(12, 26).addBox(-3.0F, -13.0F, 0.0F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(24, 26).addBox(-16.0F, -13.0F, 0.0F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-15.0F, -12.0F, 1.0F, 14.0F, 12.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(36, 26).addBox(-16.0F, -13.0F, 13.0F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(48, 26).addBox(-3.0F, -13.0F, 13.0F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 24.0F, -8.0F));

        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 37).addBox(0.0F, -16.0F, 0.0F, 0.0F, 16.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(24, 53).addBox(0.0F, -18.0F, -6.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 16.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 37).addBox(0.0F, -16.0F, 0.0F, 0.0F, 16.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(12, 53).addBox(0.0F, -18.0F, -6.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, 0.0F, 16.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 37).addBox(0.0F, -16.0F, -6.0F, 0.0F, 16.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 53).addBox(0.0F, -18.0F, 0.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 53).addBox(0.0F, -4.0F, 0.0F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(24, 37).addBox(0.0F, -2.0F, -6.0F, 0.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition eye = bone.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(40, 56).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -13.0F, 8.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

@Override
    public ModelPart root() {
        return bone;
    }

    @Override
    public void setupAnim(Entity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
super.renderToBuffer(pPoseStack,pBuffer,pPackedLight,pPackedOverlay,pRed,pGreen,pBlue,pAlpha);
    }
}
