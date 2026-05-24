package net.miauczel.legendary_monsters.entity.client.Model.BlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.block.blockentity.SomberTrapdoorBlockEntity;
import net.miauczel.legendary_monsters.block.custom.SomberTrapdoorBlock;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.BlockEntity.SomberTrapdoorAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class SomberTrapdoorModel extends HierarchicalModel<Entity> {
    private final ModelPart root;
    private final ModelPart door_left;
    private final ModelPart door_right;
    private final ModelPart lock1;

    public SomberTrapdoorModel(ModelPart root) {
        this.root = root.getChild("root");
        this.door_left = this.root.getChild("door_left");
        this.door_right = this.root.getChild("door_right");
        this.lock1 = this.root.getChild("lock1");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-66.0F, -7.0F, -24.0F, 6.0F, 7.0F, 48.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).mirror().addBox(-24.0F, -7.0F, -24.0F, 6.0F, 7.0F, 48.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(42.0F, 15.0F, 0.0F));

        PartDefinition cube_r1 = root.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(108, 0).mirror().addBox(-3.0F, -3.5F, -24.0F, 6.0F, 7.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-18.0F, -3.5F, 21.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r2 = root.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(108, 0).addBox(-3.0F, -3.5F, -24.0F, 6.0F, 7.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-66.0F, -3.5F, 21.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r3 = root.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(108, 0).mirror().addBox(-3.0F, -3.5F, 6.0F, 6.0F, 7.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-36.0F, -3.5F, -21.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r4 = root.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(108, 0).addBox(-3.0F, -3.5F, 6.0F, 6.0F, 7.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-48.0F, -3.5F, -21.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition door_left = root.addOrReplaceChild("door_left", CubeListBuilder.create().texOffs(0, 97).addBox(-18.0F, -2.6667F, -18.0F, 18.0F, 6.0F, 36.0F, new CubeDeformation(0.0F))
                .texOffs(108, 45).addBox(-10.0F, -11.6667F, -9.0F, 0.0F, 7.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(108, 25).addBox(-12.0F, -4.6667F, -9.0F, 4.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-24.0F, -3.3333F, 0.0F));

        PartDefinition door_right = root.addOrReplaceChild("door_right", CubeListBuilder.create().texOffs(0, 55).addBox(0.0F, -3.0F, -18.0F, 18.0F, 6.0F, 36.0F, new CubeDeformation(0.0F))
                .texOffs(108, 45).mirror().addBox(10.0F, -12.0F, -9.0F, 0.0F, 7.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(108, 25).mirror().addBox(8.0F, -5.0F, -9.0F, 4.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-60.0F, -3.0F, 0.0F));

        PartDefinition lock1 = root.addOrReplaceChild("lock1", CubeListBuilder.create().texOffs(0, 0).addBox(7.0F, -1.0F, 6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-55.0F, -7.0F, -12.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }


    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(Entity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        super.renderToBuffer(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
    }

    public void animateBlock(SomberTrapdoorBlockEntity somberTrapdoorBlockEntity, float pTicks) {
        root().getAllParts().forEach(ModelPart::resetPose);
        float ageInTicks = somberTrapdoorBlockEntity.tickCount + pTicks;
        int property = somberTrapdoorBlockEntity.getBlockState().getValue(SomberTrapdoorBlock.LOCKS_UNLOCKED);

        switch (property) {
            case 0 -> {
                lock1.visible = true;
            }
            case 1, 2 -> {
                lock1.visible = false;
            }

        }

        animate(somberTrapdoorBlockEntity.getAnimationState("open"), SomberTrapdoorAnimations.open, ageInTicks, 1);
        animate(somberTrapdoorBlockEntity.getAnimationState("idle"), SomberTrapdoorAnimations.idle, ageInTicks, 1);
    }
}
