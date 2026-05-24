package net.miauczel.legendary_monsters.entity.ProjectileEntityRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.SmallAnnihilationBombEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

// zamiast extends Model
public class SmallPowerBallBombModel
        extends EntityModel<SmallAnnihilationBombEntity> {

    private final ModelPart bone;
    private final ModelPart power_ball;
    public SmallPowerBallBombModel(ModelPart root) {
        this.power_ball = root.getChild("power_ball");

        this.bone = this.power_ball.getChild("bone");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition power_ball = partdefinition.addOrReplaceChild("power_ball", CubeListBuilder.create().texOffs(0, 28).addBox(-7.0F, -7.0F, -7.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(3.5F)), PartPose.offset(0.0F, 14.0F, 0.0F));

        PartDefinition bone = power_ball.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -13.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -4.0F, 6.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(SmallAnnihilationBombEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float secondsPerRevolution = 2.0f;
        float ticksPerRevolution = 20.0f * secondsPerRevolution;
        float radiansPerTick = ((float)Math.PI * 2F) / ticksPerRevolution;

        float rotation = (ageInTicks * radiansPerTick) % ((float)Math.PI * 2F);

        power_ball.xRot = rotation;
        //bone.xRot = (((float)Math.PI * 2F) - rotation) % ((float)Math.PI * 2F);

    }


    @Override
    public void renderToBuffer(PoseStack ps, VertexConsumer vb,
                               int light, int overlay,
                               float r, float g, float b, float a) {
        power_ball.render(ps, vb, light, overlay, r, g, b, a);
    }
}


