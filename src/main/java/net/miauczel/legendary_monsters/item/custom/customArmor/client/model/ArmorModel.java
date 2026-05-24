package net.miauczel.legendary_monsters.item.custom.customArmor.client.model;

import net.minecraft.world.entity.LivingEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class ArmorModel extends HumanoidModel<LivingEntity> {
    public final ModelPart leftBoot;
    public final ModelPart rightBoot;

    public final ModelPart belt;

    public ArmorModel(ModelPart pRoot) {
        super(pRoot);
        this.leftBoot = pRoot.getChild("left_boot");
        this.rightBoot = pRoot.getChild("right_boot");

        this.belt = pRoot.getChild("belt");
    }

    public ArmorModel(ModelPart pRoot, Function<ResourceLocation, RenderType> pRenderType) {
        super(pRoot, pRenderType);
        this.leftBoot = pRoot.getChild("left_boot");
        this.rightBoot = pRoot.getChild("right_boot");

        this.belt = pRoot.getChild("body").getChild("belt");
    }

    @Override
    public void setAllVisible(boolean pVisible) {
        super.setAllVisible(pVisible);
        this.leftBoot.visible = pVisible;
        this.rightBoot.visible = pVisible;
        this.belt.visible = pVisible;
    }

    /**
     * makes only one part visible for rendering
     */
    public void partVisible(EquipmentSlot slot) {
        this.setAllVisible(false);
        switch (slot) {
            case HEAD:
                this.head.visible = true;
                this.hat.visible = true;
                break;
            case CHEST:
                this.body.visible = true;
                this.rightArm.visible = true;
                this.leftArm.visible = true;
                this.belt.visible = true;
                break;
            case LEGS:
                this.leftLeg.visible = true;
                this.rightLeg.visible = true;
                break;
            case FEET:
                this.leftBoot.visible = true;
                this.rightBoot.visible = true;
        }
    }

    @Override
    public void setupAnim(LivingEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        super.setupAnim(pEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);

        float f = 1.0F;
        if (pEntity.getFallFlyingTicks() > 4) {
            f = (float) pEntity.getDeltaMovement().lengthSqr();
            f /= 0.2F;
            f *= f * f;
        }

        if (f < 1.0F) {
            f = 1.0F;
        }

        if (this.crouching) {
            this.belt.xRot = 0.5F;
            this.belt.y = 3.2F;
        } else {
            belt.xRot = 0;
            belt.y = 0;
        }
        belt.xRot = body.xRot;
        belt.y = body.y;

        this.rightBoot.xRot = Mth.cos(pLimbSwing * 0.6662F) * 1.4F * pLimbSwingAmount / f;
        this.leftBoot.xRot = Mth.cos(pLimbSwing * 0.6662F + (float) Math.PI) * 1.4F * pLimbSwingAmount / f;
        this.rightBoot.yRot = 0.005F;
        this.leftBoot.yRot = -0.005F;
        this.rightBoot.zRot = 0.005F;
        this.leftBoot.zRot = -0.005F;
        if (this.riding) {
            this.rightBoot.xRot = -1.4137167F;
            this.rightBoot.yRot = ((float) Math.PI / 10F);
            this.rightBoot.zRot = 0.07853982F;
            this.leftLeg.xRot = -1.4137167F;
            this.leftLeg.yRot = (-(float) Math.PI / 10F);
            this.leftLeg.zRot = -0.07853982F;
        }
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack stack, @NotNull VertexConsumer consumer, int packedLight, int packedOverlay, float r, float g, float b, float a) {
        super.renderToBuffer(stack, consumer, packedLight, packedOverlay, r, g, b, a);
        this.leftBoot.render(stack, consumer, packedLight, packedOverlay, r, g, b, a);
        this.rightBoot.render(stack, consumer, packedLight, packedOverlay, r, g, b, a);

        this.belt.render(stack, consumer, packedLight, packedOverlay, r, g, b, a);
    }
}

