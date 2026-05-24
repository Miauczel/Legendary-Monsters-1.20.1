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
public class SmallCloudModel extends Model {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/bomb_dune.png");
    private final ModelPart root;

    public SmallCloudModel(ModelPart pRoot) {
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
}
