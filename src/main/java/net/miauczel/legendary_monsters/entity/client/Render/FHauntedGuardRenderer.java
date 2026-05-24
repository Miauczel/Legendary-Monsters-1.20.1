package net.miauczel.legendary_monsters.entity.client.Render;
import com.mojang.blaze3d.vertex.PoseStack;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.knights.FHauntedGuardEntity;
import net.miauczel.legendary_monsters.entity.client.Model.FHauntedGuardModel;
import net.miauczel.legendary_monsters.entity.client.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FHauntedGuardRenderer extends MobRenderer<FHauntedGuardEntity, FHauntedGuardModel<FHauntedGuardEntity>> {
    private static final ResourceLocation IRON_TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/haunted_guard/haunted_guard_iron.png");
    private static final ResourceLocation GOLDEN_TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/haunted_guard/haunted_guard_golden.png");
    private static final ResourceLocation AMETHYST_TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/haunted_guard/haunted_guard_amethyst.png");
    private static final ResourceLocation EMERALD_TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/haunted_guard/haunted_guard_emerald.png");
    private static final ResourceLocation COPPER_TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/haunted_guard/haunted_guard_copper.png");
    private static final ResourceLocation DIAMOND_TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/haunted_guard/haunted_guard_diamond.png");
    private static final ResourceLocation SCULK_TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/haunted_guard/haunted_guard_sculk.png");
    private static final ResourceLocation NETHERITE_TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/haunted_guard/haunted_guard_netherite.png");
    private static final ResourceLocation IRON_TEXTURE2 = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/variant/haunted_guard/haunted_guard_iron.png");


    public FHauntedGuardRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FHauntedGuardModel<>(pContext.bakeLayer(ModModelLayers.FHAUNTED_GUARD_LAYER)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(FHauntedGuardEntity pEntity) {
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
    public void render(FHauntedGuardEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
