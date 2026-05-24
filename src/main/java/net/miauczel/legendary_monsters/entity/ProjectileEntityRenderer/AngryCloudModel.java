package net.miauczel.legendary_monsters.entity.ProjectileEntityRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AngryCloudModel<T extends Entity> extends HierarchicalModel<T> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/bomb_dune.png");
    private final ModelPart root;

    public AngryCloudModel(ModelPart pRoot) {
        super(RenderType::entityCutout);
        this.root = pRoot;
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-18.0F, -32.0F, 3.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 32).addBox(-20.0F, -29.0F, 14.0F, 11.0F, 11.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(46, 32).addBox(-10.0F, -29.0F, -1.0F, 11.0F, 11.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, 24.0F, -11.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }
    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        this.root.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(T pEntity, float limbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

        float $$6 = limbSwing * 2.0F;
        float f1 = 3.1415927F - $$6 * 6.35F * 3.1415927F;
        float f2 = 3.1415927F + $$6 * 0.35F * 3.1415927F;
        if ($$6 > 1.0F) {
            $$6 = 1.0F;
        }
        float $$7 = (limbSwing + Mth.sin(limbSwing * 2.7F)) * 0.6F * 12.0F;
        f1 = 24.0F - $$7;
        $$6 = 1.0F - $$6 * $$6 * $$6;
    }

}
