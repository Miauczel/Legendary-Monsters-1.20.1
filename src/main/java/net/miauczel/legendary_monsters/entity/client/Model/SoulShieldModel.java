// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
package net.miauczel.legendary_monsters.entity.client.Model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity.SoulShieldEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.AnimatedEntity.TheObliteratorCloneEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Animations.TheWarpedOneDuplicateAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.level.block.LeverBlock;


public class SoulShieldModel<T extends SoulShieldEntity> extends HierarchicalModel<T> {
    private final ModelPart shield;
    private final ModelPart bone;

    public SoulShieldModel(ModelPart root) {
        this.shield = root.getChild("shield");
        this.bone = this.shield.getChild("bone");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition shield = partdefinition.addOrReplaceChild("shield", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0928F, 10.2885F, 0.1982F, 0.0F, -0.7854F, -3.1416F));

        PartDefinition bone = shield.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(36, 19).addBox(-1.75F, -14.0F, -3.25F, 9.0F, 28.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(10, 49).addBox(-6.0F, -1.0F, -4.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0258F, 1.6803F, -0.7854F, 0.0F, -1.5708F));

        PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(10, 19).addBox(-5.0F, -27.0F, -1.0F, 11.0F, 28.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.75F, 13.0F, 2.75F, 0.0F, 1.5708F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }


    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
      //  this.animate(entity.getAnimationState("emerge"), TheWarpedOneDuplicateAnimations.shoot, ageInTicks, 1.0F);

        double posX = entity.getX();
        double posY = entity.getY();
        double posZ = entity.getZ();

        double destX = entity.getDestinationX();
        double destY = entity.getDestinationY();
        double destZ = entity.getDestinationZ();

        double dx = destX - posX;
        double dy = destY - posY;
        double dz = destZ - posZ;

        float yawDeg = (float) (Math.toDegrees(Math.atan2(dz, dx))) - 90F;
        float horizontalDist = (float) Math.sqrt(dx * dx + dz * dz);
        float pitchDeg = (float) (-Math.toDegrees(Math.atan2(dy, horizontalDist)));

        float yawRad = yawDeg * ((float) Math.PI / 180F);
        float pitchRad = pitchDeg * ((float) Math.PI / 180F);

        shield.xRot = pitchRad;
    }


    @Override
    public void renderToBuffer(PoseStack pMatrixStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        shield.render(pMatrixStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        PoseStack modelStack = pMatrixStack;

        // Skaluj model

    }

    @Override
    public ModelPart root() {
        return shield;
    }
}