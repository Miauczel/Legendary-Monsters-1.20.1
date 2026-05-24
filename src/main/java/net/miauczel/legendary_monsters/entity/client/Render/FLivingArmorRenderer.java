package net.miauczel.legendary_monsters.entity.client.Render;
import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.knights.FLivingArmorEntity;
import net.miauczel.legendary_monsters.entity.client.Model.FLivingArmorModel;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FLivingArmorRenderer extends MobRenderer<FLivingArmorEntity, FLivingArmorModel<FLivingArmorEntity>> {
    private static final ResourceLocation IRON_TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/living_armor/living_armor_iron2.png");
    private static final ResourceLocation GOLDEN_TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/living_armor/living_armor_golden2.png");
    private static final ResourceLocation AMETHYST_TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/living_armor/living_armor_amethyst2.png");
    private static final ResourceLocation EMERALD_TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/living_armor/living_armor_emerald2.png");
    private static final ResourceLocation COPPER_TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/living_armor/living_armor_copper.png");
    private static final ResourceLocation DIAMOND_TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/living_armor/living_armor_diamond3.png");
    private static final ResourceLocation SCULK_TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/living_armor/living_armor_sculk.png");
    private static final ResourceLocation NETHERITE_TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/living_armor/living_armor_netherite.png");
    private static final ResourceLocation IRON_TEXTURE2 = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/living_armor/living_armor_iron2.png");


    public FLivingArmorRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FLivingArmorModel<>(pContext.bakeLayer(ModModelLayers.FLIVING_ARMOR_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(FLivingArmorEntity pEntity) {
        switch (pEntity.getTextureVariant()) {
            case 1:
                return GOLDEN_TEXTURE;
            case 2:
                return AMETHYST_TEXTURE;
            case 3:
                return EMERALD_TEXTURE;
            case 4:
                return COPPER_TEXTURE;
            case 5:
                return DIAMOND_TEXTURE;
            case 6:
                return SCULK_TEXTURE;
            case 7:
                return IRON_TEXTURE2;
            case 8:
                return NETHERITE_TEXTURE;
            default:
                return IRON_TEXTURE;
        }
    }

    @Override
    public void render(FLivingArmorEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
