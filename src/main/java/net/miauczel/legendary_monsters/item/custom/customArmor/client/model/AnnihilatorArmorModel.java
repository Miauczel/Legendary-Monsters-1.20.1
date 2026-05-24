package net.miauczel.legendary_monsters.item.custom.customArmor.client.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.world.entity.EquipmentSlot;

public class AnnihilatorArmorModel extends ArmorModel{
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart hat;
    private final ModelPart right_boot;
    private final ModelPart left_boot;
    private final ModelPart body;
    private final ModelPart right_leg;
    private final ModelPart left_leg;
    private final ModelPart head;
    private final ModelPart belt;

    public AnnihilatorArmorModel(ModelPart root) {
        super(root);
        this.left_arm = root.getChild("left_arm");
        this.right_arm = root.getChild("right_arm");
        this.hat = root.getChild("hat");
        this.right_boot = root.getChild("right_boot");
        this.left_boot = root.getChild("left_boot");
        this.body = root.getChild("body");
        this.right_leg = root.getChild("right_leg");
        this.left_leg = root.getChild("left_leg");
        this.head = root.getChild("head");
        this.belt = root.getChild("belt");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.01F)).mirror(false)
                .texOffs(40, 32).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.511F)).mirror(false)
                .texOffs(43, 51).mirror().addBox(4.0F, 2.35F, 0.5F, 4.0F, 12.0F, 1.0F, new CubeDeformation(0.511F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.01F))
                .texOffs(40, 32).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.511F))
                .texOffs(43, 51).addBox(-8.0F, 2.35F, 0.5F, 4.0F, 12.0F, 1.0F, new CubeDeformation(0.511F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

        PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.0F))
                .texOffs(0, 56).addBox(-4.0F, -18.0F, -4.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(1.0F))
                .texOffs(16, 56).addBox(-12.75F, -12.0F, 1.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(1.0F))
                .texOffs(16, 56).mirror().addBox(4.75F, -12.0F, 1.0F, 8.0F, 8.0F, 0.0F, new CubeDeformation(1.0F)).mirror(false)
                .texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_boot = partdefinition.addOrReplaceChild("right_boot", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

        PartDefinition left_boot = partdefinition.addOrReplaceChild("left_boot", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(1.0F))
                .texOffs(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.51F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

        PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition belt = partdefinition.addOrReplaceChild("belt", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }



}
