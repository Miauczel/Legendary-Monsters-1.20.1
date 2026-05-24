package net.miauczel.legendary_monsters.entity.client.Model;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class IceSpikeModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart icespike3;
    public IceSpikeModel(ModelPart icespike3) {

        this.icespike3 = icespike3.getChild("icespike3");




    }

    public static LayerDefinition createLayerDefinition() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition icespike3 = partdefinition.addOrReplaceChild("icespike3", CubeListBuilder.create().texOffs(0, 0).addBox(-3.7493F, -16.9291F, -4.6581F, 7.0F, 21.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(28, 0).addBox(-6.7493F, -5.9291F, -5.6581F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 28).addBox(-6.7493F, -8.9291F, 0.3419F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(24, 24).addBox(1.2507F, -8.9291F, -5.6581F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(36, 14).addBox(1.2507F, -5.9291F, 0.3419F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9955F, 20.0715F, 0.7706F, 0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        float $$6 = limbSwing * 2.0F;
        float f1 = 3.1415927F - $$6 * 6.35F * 3.1415927F;
        float f2 = 3.1415927F + $$6 * 0.35F * 3.1415927F;
        if ($$6 > 1.0F) {
            $$6 = 1.0F;
        }
        float $$7 = (limbSwing + Mth.sin(limbSwing * 2.7F)) * 0.6F * 12.0F;
        f1 = 24.0F - $$7;
        $$6 = 1.0F - $$6 * $$6 * $$6;
        this.icespike3.y = f1;



    }

    @Override
    public ModelPart root() {
        return icespike3;
    }
}
