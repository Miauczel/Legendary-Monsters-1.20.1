package net.miauczel.legendary_monsters.sound;

import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedBoss;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMonster;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;

public class BossMusicPlayer  {
    public static SoundBossMusic bossMusic;

public static void playBossMusic(IAnimatedBoss entity) {
    if (!ModConfig.MOB_CONFIG.canPlayBossMusic.get()) return;

    SoundEvent soundEvent = entity.getBossMusic();
    if (soundEvent != null && entity.isAlive() ) {
        Player player = Minecraft.getInstance().player;
        if (bossMusic != null) {
            float f2 = Minecraft.getInstance().options.getSoundSourceVolume(SoundSource.RECORDS);
            if (f2 <= 0) {
                bossMusic = null;
            }
            else if (bossMusic.getBoss() == entity && !entity.canPlayerHearMusic(player)) {
                bossMusic.setBoss(null);
            }
            else if (bossMusic.getBoss() == null && bossMusic.getSoundEvent() == soundEvent) {
                bossMusic.setBoss(entity);
            }
        } else {
            if (entity.canPlayerHearMusic(player)) {
                bossMusic = new SoundBossMusic(entity.getBossMusic(), entity);
            }
        }
        if (bossMusic != null && !Minecraft.getInstance().getSoundManager().isActive(bossMusic)) {
            Minecraft.getInstance().getSoundManager().play(bossMusic);
        }
    }
}

public static void stopBossMusic(IAnimatedMonster entity) {
    if (!ModConfig.MOB_CONFIG.canPlayBossMusic.get()) return;

    if (bossMusic != null && bossMusic.getBoss() == entity)
        bossMusic.setBoss(null);
}
}