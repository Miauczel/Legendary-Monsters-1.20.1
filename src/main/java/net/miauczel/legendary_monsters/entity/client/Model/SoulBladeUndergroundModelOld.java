package net.miauczel.legendary_monsters.entity.client.Model;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity.SoulBladeEntity;
import net.miauczel.legendary_monsters.entity.animations.SoulBladeAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class SoulBladeUndergroundModelOld<T extends SoulBladeEntity> extends HierarchicalModel<T> {
    private final ModelPart bb_main;

    public SoulBladeUndergroundModelOld(ModelPart root) {
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bb_main = partdefinition.addOrReplaceChild(
                "bb_main",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 75.0F, 0.0F)
        );
        PartDefinition cube_r11 = bb_main.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 52).mirror().addBox(-2.0F, -13.0F, -1.0F, 3.0F, 18.0F, 2.0F,
                new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(36, 45).mirror().addBox(-3.5F, -3.5F, -1.5F, 7.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -11.9142F, 0.0F, 0.0F, 0.0F, -2.3562F));

        PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(10, 52).mirror().addBox(-5.5F, -5.5F, -0.01F, 9.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -62.5F, 0.0F, 0.0F, 0.0F, -2.3562F));

        PartDefinition cube_r3 = bb_main.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(58, 0).mirror().addBox(-2.5F, -2.5F, -1.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -60.9142F, -0.01F, 0.0F, 0.0F, -2.3562F));

        PartDefinition cube_r4 = bb_main.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(18, 0).mirror().addBox(-3.5F, -25.0F, -1.0F, 7.0F, 50.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -36.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

        PartDefinition cube_r5 = bb_main.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(56, 45).mirror().addBox(-5.5F, -4.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.5F, -12.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

        PartDefinition cube_r6 = bb_main.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(58, 13).mirror().addBox(-0.5F, -2.0F, -1.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, -12.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

        PartDefinition cube_r7 = bb_main.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-5.5F, -22.5F, 0.0F, 11.0F, 45.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -38.5F, 0.0F, 0.0F, 0.0F, -3.1416F));

        PartDefinition cube_r8 = bb_main.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(46, 55).mirror().addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, -12.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

        PartDefinition cube_r9 = bb_main.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(58, 7).mirror().addBox(-2.5F, -2.0F, -1.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5F, -12.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

        PartDefinition cube_r10 = bb_main.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(28, 55).mirror().addBox(-4.5F, -4.5F, -1.5F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 7.5F, 0.0F, 0.0F, 0.0F, 0.7854F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }


    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animate(entity.emergeAnimationState, SoulBladeAnimations.emerge, ageInTicks, 1.0F);
    }

    @Override
    public ModelPart root() {
        return bb_main;
    }
}
