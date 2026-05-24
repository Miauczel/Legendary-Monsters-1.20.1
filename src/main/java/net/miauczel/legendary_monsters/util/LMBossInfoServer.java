package net.miauczel.legendary_monsters.util;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.Message.MessageUpdateBossBar;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;

public class LMBossInfoServer extends ServerBossEvent {

    private int renderType;

    public LMBossInfoServer(Component component, BossEvent.BossBarColor bossBarColor, boolean dark, int renderType) {
        super(component, bossBarColor, BossBarOverlay.PROGRESS);
        this.setDarkenScreen(dark);
        this.renderType = renderType;

    }

    public boolean getIsDarkenSky() {
        return darkenScreen;
    }

    @Override
    public boolean shouldCreateWorldFog() {
        return super.shouldCreateWorldFog();
    }

    public void setRenderType(int renderType) {
        if (renderType != this.renderType) {
            this.renderType = renderType;
            LegendaryMonsters.sendMSGToAll(new MessageUpdateBossBar(this.getId(), renderType));
        }
    }

    public int getRenderType() {
        return this.renderType;
    }

    @Override
    public Component getName() {
        return super.getName();
    }

    @Override
    public void setName(Component pName) {
        super.setName(pName);
    }

    public void addPlayer(ServerPlayer serverPlayer) {
        LegendaryMonsters.sendNonLocal(new MessageUpdateBossBar(this.getId(), renderType), serverPlayer);
        super.addPlayer(serverPlayer);
    }

    public void removePlayer(ServerPlayer serverPlayer) {
        LegendaryMonsters.sendNonLocal(new MessageUpdateBossBar(this.getId(), -1), serverPlayer);
        super.removePlayer(serverPlayer);
    }

}

