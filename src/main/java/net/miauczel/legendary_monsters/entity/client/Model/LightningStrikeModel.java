package net.miauczel.legendary_monsters.entity.client.Model;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class LightningStrikeModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart bone;
    public LightningStrikeModel(ModelPart bone) {

        this.bone = bone.getChild("bone");




    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-18.0F, 92.0F, 3.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 32).addBox(-20.0F, 90.0F, 14.0F, 11.0F, 11.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(46, 32).addBox(-10.0F, 90.0F, -1.0F, 11.0F, 11.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, 24.0F, -11.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(T pEntity, float limbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

        float $$6 = limbSwing * 2.0F;
        float oryl = 3.1415927F - $$6 * 6.35F * 3.1415927F;
        float boryl = 3.1415927F + $$6 * 0.35F * 3.1415927F;
        if ($$6 > 1.0F) {
            $$6 = 1.0F;
        }
        float $$7 = (limbSwing + Mth.sin(limbSwing * 2.7F)) * 0.6F * 12.0F;
        oryl = 24.0F - $$7;
        $$6 = 1.0F - $$6 * $$6 * $$6;
    }


    @Override
    public ModelPart root() {
        return bone;
    }
}
