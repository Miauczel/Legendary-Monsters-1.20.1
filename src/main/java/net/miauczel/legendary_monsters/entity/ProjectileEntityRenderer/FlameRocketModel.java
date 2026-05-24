package net.miauczel.legendary_monsters.entity.ProjectileEntityRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.FlameRocketEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.FlyingArmorEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FlameRocketModel
        extends EntityModel<FlameRocketEntity> {

    private final ModelPart root;
    public FlameRocketModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1F, 16.6F, -9.05F, 0.0F, 3.1416F, 0.0F));

        PartDefinition cube_r1 = root.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 42).addBox(-9.5F, -39.0F, 0.0F, 19.0F, 26.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -26.0F, -1.5708F, 0.0F, -2.1817F));

        PartDefinition cube_r2 = root.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 42).addBox(-9.5F, -39.0F, 0.0F, 19.0F, 26.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -26.0F, -1.5708F, 0.0F, -0.7854F));

        PartDefinition small = root.addOrReplaceChild("small", CubeListBuilder.create(), PartPose.offset(0.1F, 0.4F, -21.45F));

        PartDefinition cube_r3 = small.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 8).addBox(0.0F, -7.0F, -9.5F, 0.0F, 14.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r4 = small.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 8).addBox(0.0F, -7.0F, -9.5F, 0.0F, 14.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }




    @Override
    public void renderToBuffer(PoseStack ps, VertexConsumer vb,
                               int light, int overlay,
                               float r, float g, float b, float a) {
        root.render(ps, vb, light, overlay, r, g, b, a);
    }

    @Override
    public void setupAnim(FlameRocketEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

    }
}


