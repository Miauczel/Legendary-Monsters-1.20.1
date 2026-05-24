package net.miauczel.legendary_monsters.entity.client.Model;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class TornadoModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart bone4;
    private final ModelPart bone3;
    private final ModelPart bone2;
    private final ModelPart bone;

    public TornadoModel(ModelPart root) {
        this.root = root.getChild("root");
        this.bone4 = this.root.getChild("bone4");
        this.bone3 = this.root.getChild("bone3");
        this.bone2 = this.root.getChild("bone2");
        this.bone = this.root.getChild("bone");
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(3.0F, 24.0F, -3.0F));

        PartDefinition bone4 = root.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(-63, -32).addBox(-17.0F, -4.5F, -17.0F, 34.0F, 9.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -31.5F, 3.0F));

        PartDefinition bone3 = root.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(-47, -24).addBox(-13.0F, -4.5F, -13.0F, 26.0F, 9.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -22.5F, 3.0F));

        PartDefinition bone2 = root.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(-31, -16).addBox(-9.0F, -4.5F, -9.0F, 18.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -13.5F, 3.0F));

        PartDefinition bone = root.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(-15, -8).addBox(-5.0F, -4.5F, -5.0F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -4.5F, 3.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        float b6 = limbSwing * 2.0F;
        root.yRot = 1+limbSwing;


        //this.animate(entity.getAnimationState("emerge"), IceSpikeAdvancedAnimations.emerge2, ageInTicks, 1.0F);


    }

    @Override
    public ModelPart root() {
        return root;
    }
}
