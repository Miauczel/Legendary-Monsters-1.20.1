package net.miauczel.legendary_monsters.client.event.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.BossEvent;
import net.minecraftforge.client.event.CustomizeGuiOverlayEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class CustomBossBar {
    public static Map<Integer, CustomBossBar> customBossBars = new HashMap<>();

    static {

        customBossBars.put(0, new CustomBossBar(
                new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/gui/boss_bar/cloud_golem_bar_base.png"),
                new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/gui/boss_bar/cloud_golem_bar_overlay.png"),
                5, 16, 0, 10, -2, -13, 256, 32, 30, 182, ChatFormatting.WHITE));

        customBossBars.put(1, new CustomBossBar(
                new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/gui/boss_bar/cloud_golem_thunder_bar_base.png"),
                new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/gui/boss_bar/cloud_golem_thunder_bar_overlay.png"),
                5, 16, 0, 10, -2, -13, 256, 32, 30, 182, ChatFormatting.GRAY));
        customBossBars.put(2, new CustomBossBar(
                new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/gui/boss_bar/possessed_bar_base.png"),
                new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/gui/boss_bar/possessed_bar_overlay_0.png"),
                30, 64, 0, 6, -4, -6, 256, 64, 50, 178, ChatFormatting.AQUA));
        customBossBars.put(3, new CustomBossBar(
                new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/gui/boss_bar/the_warped_one_bar_base.png"),
                new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/gui/boss_bar/the_warped_one_bar_overlay.png"),
                5, 16, 0, 15, -3, -13, 256, 32, 40, 182, ChatFormatting.GREEN));

        customBossBars.put(4, new CustomBossBar(
                new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/gui/boss_bar/possessed_bar_base_red.png"),
                new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/gui/boss_bar/possessed_bar_overlay_1.png"),
                30, 64, 0, 6, -4, -6, 256, 64, 50, 178, ChatFormatting.RED));

    }

    private final ResourceLocation baseTexture;
    private final ResourceLocation overlayTexture;
    private final boolean hasOverlay;

    private final int baseHeight;
    private final int baseTextureHeight;
    private final int baseOffsetX;
    private final int baseOffsetY;
    private final int overlayOffsetX;
    private final int overlayOffsetY;
    private final int overlayWidth;
    private final int overlayHeight;

    private final int verticalIncrement;

    private final int getProgress;

    private final ChatFormatting textColor;

    public CustomBossBar(ResourceLocation baseTexture, ResourceLocation overlayTexture, int baseHeight, int baseTextureHeight, int baseOffsetX, int baseOffsetY, int overlayOffsetX, int overlayOffsetY, int overlayWidth, int overlayHeight, int verticalIncrement, int getProgress, ChatFormatting textColor) {
        this.baseTexture = baseTexture;
        this.overlayTexture = overlayTexture;
        this.hasOverlay = overlayTexture != null;
        this.baseHeight = baseHeight;
        this.baseTextureHeight = baseTextureHeight;
        this.baseOffsetX = baseOffsetX;
        this.baseOffsetY = baseOffsetY;
        this.overlayOffsetX = overlayOffsetX;
        this.overlayOffsetY = overlayOffsetY;
        this.overlayWidth = overlayWidth;
        this.overlayHeight = overlayHeight;
        this.verticalIncrement = verticalIncrement;
        this.getProgress = getProgress;
        this.textColor = textColor;
    }

    public ResourceLocation getBaseTexture() {
        return baseTexture;
    }

    public ResourceLocation getOverlayTexture() {
        return overlayTexture;
    }

    public boolean hasOverlay() {
        return hasOverlay;
    }

    public int getBaseHeight() {
        return baseHeight;
    }

    public int getBaseTextureHeight() {
        return baseTextureHeight;
    }

    public int getBaseOffsetX() {
        return baseOffsetX;
    }

    public int getBaseOffsetY() {
        return baseOffsetY;
    }

    public int getOverlayOffsetX() {
        return overlayOffsetX;
    }

    public int getOverlayOffsetY() {
        return overlayOffsetY;
    }

    public int getOverlayWidth() {
        return overlayWidth;
    }

    public int getOverlayHeight() {
        return overlayHeight;
    }

    public int getProgress() {
        return getProgress;
    }

    public int getVerticalIncrement() {
        return verticalIncrement;
    }

    public ChatFormatting getTextColor() {
        return textColor;
    }
    public MutableComponent bossName;
    public void setBossName(String name){
        bossName = Component.translatable(name);
    }
    public MutableComponent getBossName(CustomizeGuiOverlayEvent.BossEventProgress event) {

        switch ((int) Stream.of(customBossBars).count()) {
            case 4 -> {
                return Component.translatable("Orion, The Fractured Omen");
            }
            default -> {
                return event.getBossEvent().getName().copy().withStyle(getTextColor());
            }
        }
    }

    public void renderBossBar(CustomizeGuiOverlayEvent.BossEventProgress event) {
        GuiGraphics guiGraphics = event.getGuiGraphics();
        int y = event.getY();
        int i = Minecraft.getInstance().getWindow().getGuiScaledWidth();
        int j = y - 9;
        Minecraft.getInstance().getProfiler().push("CataclysmCustomBossBarBase");

        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, getBaseTexture());
        drawBar(guiGraphics, event.getX() + getBaseOffsetX(), y + getBaseOffsetY(), event.getBossEvent());
        Component component = event.getBossEvent().getName().copy().withStyle(getTextColor());
        Component name = getBossName(event);
        //  Component component = getBossName(event);
        Minecraft.getInstance().getProfiler().pop();
        int l = Minecraft.getInstance().font.width(component);
        int i1 = i / 2 - l / 2;
        int j1 = j;
        guiGraphics.drawString(Minecraft.getInstance().font, component, i1, j1, 16777215);


        if (hasOverlay()) {
            Minecraft.getInstance().getProfiler().push("CataclysmCustomBossBarOverlay");
            RenderSystem.setShaderTexture(0, getOverlayTexture());
            event.getGuiGraphics().blit(getOverlayTexture(), event.getX() + getBaseOffsetX() + getOverlayOffsetX(), y + getOverlayOffsetY() + getBaseOffsetY(), 0, 0, getOverlayWidth(), getOverlayHeight(), getOverlayWidth(), getOverlayHeight());
            Minecraft.getInstance().getProfiler().pop();
        }

        event.setIncrement(getVerticalIncrement());
    }

    private void drawBar(GuiGraphics guiGraphics, int x, int y, BossEvent event) {
        guiGraphics.blit(getBaseTexture(), x, y, 0, 0, getProgress(), getBaseHeight(), 256, getBaseTextureHeight());
        int i = (int) (event.getProgress() * (getProgress() + 1));
        if (i > 0) {
            guiGraphics.blit(getBaseTexture(), x, y, 0, getBaseHeight(), i, getBaseHeight(), 256, getBaseTextureHeight());
        }
    }
}
