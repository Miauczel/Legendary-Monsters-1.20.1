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

import java.util.function.Function;

@OnlyIn(Dist.CLIENT)
public class ResurrectedJavelinModel extends Model {
    public static final ResourceLocation TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/item/resurrected_javelin.png");
    private final ModelPart javelin;

    public ResurrectedJavelinModel(ModelPart root) {
        super(RenderType::entityCutoutNoCull);
        this.javelin = root.getChild("javelin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition javelin = partdefinition.addOrReplaceChild("javelin", CubeListBuilder.create().texOffs(61, 114).mirror().addBox(-0.5F, -0.5F, -25.6465F, 2.0F, 2.0F, 62.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(127, 133).mirror().addBox(0.5F, -8.5F, -37.6465F, 0.0F, 17.0F, 26.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(85, 137).mirror().addBox(0.5F, -10.5F, 8.3535F, 0.0F, 21.0F, 49.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 21.2678F, -41.3535F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }
    @Override
    public void renderToBuffer(PoseStack pPoseStack, VertexConsumer pBuffer, int pPackedLight, int pPackedOverlay, float pRed, float pGreen, float pBlue, float pAlpha) {
        this.javelin.render(pPoseStack, pBuffer, pPackedLight, pPackedOverlay, pRed, pGreen, pBlue, pAlpha);
    }
}
