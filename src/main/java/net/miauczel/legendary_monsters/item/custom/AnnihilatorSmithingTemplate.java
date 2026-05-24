package net.miauczel.legendary_monsters.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AnnihilatorSmithingTemplate extends Item {
    public AnnihilatorSmithingTemplate(Properties pProperties) {
        super(pProperties);
    }

    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final Component ENDERITIUM_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation("enderitium_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component ENDERITIUM_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.enderitium_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component ENDERITIUM_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.enderitium_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component ENDERITIUM_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.netherite_upgrade.base_slot_description")));
    private static final Component ENDERITIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation("smithing_template.enderitium_upgrade.additions_slot_description")));

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("item.legendary_monsters.smithing_template.annihilator_upgrade1").withStyle(TITLE_FORMAT));
        pTooltipComponents.add(Component.literal(" "));
        pTooltipComponents.add(Component.translatable("item.legendary_monsters.smithing_template.annihilator_upgrade2").withStyle(TITLE_FORMAT));
        pTooltipComponents.add(Component.translatable("item.legendary_monsters.smithing_template.annihilator_upgrade3").withStyle(DESCRIPTION_FORMAT));
        pTooltipComponents.add(Component.translatable("item.legendary_monsters.smithing_template.annihilator_upgrade4").withStyle(TITLE_FORMAT));
        pTooltipComponents.add(Component.translatable("item.legendary_monsters.smithing_template.annihilator_upgrade5").withStyle(DESCRIPTION_FORMAT));
    }
}
