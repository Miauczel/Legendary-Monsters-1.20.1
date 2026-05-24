package net.miauczel.legendary_monsters.entity.ProjectileEntityRenderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SpearModel extends Model {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/monstrous_spear_entity.png");
    private final ModelPart root;

    public SpearModel(ModelPart pRoot) {
        super(RenderType::entityTranslucent);
        this.root = pRoot;
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -24.0F, -3.0F, 0.0F, 10.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-4.0F, -24.0F, 0.5F, 7.0F, 10.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-4.0F, -24.0F, 0.5F, 7.0F, 10.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(46, -9).addBox(-0.5F, -13.0F, 1.0F, 0.0F, 10.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(23, 22).addBox(-1.0F, -15.0F, 0.0F, 1.0F, 23.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        this.root.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
    }
}
