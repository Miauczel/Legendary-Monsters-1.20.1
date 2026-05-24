package net.miauczel.legendary_monsters.entity.ProjectileEntityRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ThrownPhantomDaggerEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static net.miauczel.legendary_monsters.util.MathUtils.radAngle;

@OnlyIn(Dist.CLIENT)
public class ThrownPhantomDaggerModel extends HierarchicalModel<ThrownPhantomDaggerEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/posessed_paladin/phantom_dagger.png");
    private final ModelPart dagger;

    public ThrownPhantomDaggerModel(ModelPart root) {
        super(RenderType::entityTranslucentEmissive);
        this.dagger = root.getChild("dagger");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition dagger = partdefinition.addOrReplaceChild("dagger", CubeListBuilder.create().texOffs(7, 11).addBox(-1.0F, -2.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(2, 1).addBox(-1.5F, -12.0F, 0.0F, 3.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(8, 7).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(8, 4).addBox(-4.5F, -4.0F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(8, 1).addBox(0.5F, -4.0F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition cube_r1 = dagger.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(1, 12).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }


    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {

        this.dagger.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
    }

    @Override
    public ModelPart root() {
        return dagger;
    }

    public void rotateModel(ThrownPhantomDaggerEntity pEntity, float partialTicks) {
        //dagger.getAllParts().forEach(ModelPart::resetPose);
        LivingEntity owner = (LivingEntity) pEntity.getOwner();
        if (owner != null) {
            Vec3 ownerPos = new Vec3(owner.getX(), owner.getY() + 1, owner.getZ());
            Vec3 dx = ownerPos.subtract(pEntity.position());
            float yBodyRot = radAngle(pEntity.getViewYRot(partialTicks));
            double toLerp = yBodyRot + Mth.atan2(dx.z, dx.x);
            dagger.yRot = radAngle(Mth.rotLerp(0.15f, 0, yBodyRot));
            dagger.xRot = radAngle(90);
            dagger.zRot = radAngle(0);
        } else dagger.yRot = 0;
    }


    @Override
    public void setupAnim(ThrownPhantomDaggerEntity thrownPhantomDagger, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.dagger.yRot = netHeadYaw * ((float) Math.PI / 180F);
        this.dagger.xRot = (float) (90 * Math.PI / 180);
        this.dagger.zRot = headPitch * ((float) Math.PI / 180F);
    }
}
