package net.miauczel.legendary_monsters.entity.client.Model;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class SoulHandModel<T extends Entity> extends HierarchicalModel<T> {
    private final ModelPart hand;
    public SoulHandModel(ModelPart hand) {

        this.hand = hand.getChild("hand");




    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition hand = partdefinition.addOrReplaceChild("hand", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(-2.5F, -9.0F, -3.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }



    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        float $$6 = limbSwing * 2.0F;
        float oryl = 3.1415927F - $$6 * 6.35F * 3.1415927F;
        float boryl = 3.1415927F + $$6 * 0.35F * 3.1415927F;
        if ($$6 > 1.0F) {
            $$6 = 1.0F;
        }
        float $$7 = (limbSwing + Mth.sin(limbSwing * 2.7F)) * 0.6F * 12.0F;
        oryl = 24.0F - $$7;
        $$6 = 1.0F - $$6 * $$6 * $$6;
        this.hand.y = oryl;



    }

    @Override
    public ModelPart root() {
        return hand;
    }
}
