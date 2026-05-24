package net.miauczel.legendary_monsters.entity.ProjectileEntityRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.FlyingArmorEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.TrackingBombEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FlyingArmorModel
        extends EntityModel<FlyingArmorEntity> {

    private final ModelPart root;
    public FlyingArmorModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-13.0F, -14.1111F, -13.0F, 26.0F, 26.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 12.1111F, -1.0F));

        PartDefinition cube_r1 = root.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 76).addBox(-21.5858F, 0.0F, -1.4142F, 23.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, -14.1111F, -13.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r2 = root.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(46, 76).addBox(-21.5858F, 0.0F, 1.4142F, 23.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, -14.1111F, 13.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r3 = root.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(46, 52).addBox(-1.4142F, 0.0F, 1.4142F, 23.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, -14.1111F, 13.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r4 = root.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 52).addBox(-1.4142F, 0.0F, -1.4142F, 23.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, -14.1111F, -13.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r5 = root.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(92, 71).addBox(-7.0F, -19.0F, -1.0F, 8.0F, 19.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.4142F, 11.8889F, -13.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r6 = root.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 100).addBox(-7.0F, -19.0F, 1.0F, 8.0F, 19.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.4142F, 11.8889F, 13.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition cube_r7 = root.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(92, 90).addBox(-1.0F, -19.0F, 1.0F, 8.0F, 19.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.4142F, 11.8889F, 13.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition cube_r8 = root.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(92, 52).addBox(-1.0F, -19.0F, -1.0F, 8.0F, 19.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.4142F, 11.8889F, -13.0F, 0.0F, 0.7854F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }
    @Override
    public void setupAnim(FlyingArmorEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float secondsPerRevolution = 1f;
        float ticksPerRevolution = 20.0f * secondsPerRevolution;
        float radiansPerTick = ((float)Math.PI * 2F) / ticksPerRevolution;

        float rotation = (ageInTicks * radiansPerTick) % ((float)Math.PI * 2F);

        root.xRot = (((float)Math.PI * 2F) - rotation) % ((float)Math.PI * 2F);
        root.yRot = (((float)Math.PI * 2F) - rotation) % ((float)Math.PI * 2F);

    }


    @Override
    public void renderToBuffer(PoseStack ps, VertexConsumer vb,
                               int light, int overlay,
                               float r, float g, float b, float a) {
        root.render(ps, vb, light, overlay, r, g, b, a);
    }
}


