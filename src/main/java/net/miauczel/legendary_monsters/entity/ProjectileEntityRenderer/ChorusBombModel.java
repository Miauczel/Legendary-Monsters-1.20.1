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
public class ChorusBombModel extends Model {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/bomb_chorus.png");
    private final ModelPart root;

    public ChorusBombModel(ModelPart pRoot) {
        super(RenderType::entityCutout);
        this.root = pRoot;
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 26).addBox(-6.375F, -2.0F, -6.375F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-6.875F, -2.5F, -6.875F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(36, 26).addBox(-3.375F, -4.0F, -3.375F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.375F, -10.0F, 0.375F, 0.0F, 0.0F, -3.1416F));

        PartDefinition cube_r1 = root.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.125F, -5.0F, 1.125F, -0.4031F, 0.268F, 0.5558F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        this.root.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
    }
}
