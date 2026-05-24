package net.miauczel.legendary_monsters.sound;

import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMonster;
import net.miauczel.legendary_monsters.entity.client.ControlledAnim;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;

public class SoundBossMusic extends AbstractTickableSoundInstance {
    private IAnimatedMonster boss;
    private int ticksExisted = 0;
    private int timeUntilFade;

    private final SoundEvent soundEvent;
    ControlledAnim volumeControl;

    public SoundBossMusic(SoundEvent sound, IAnimatedMonster boss) {
        super(sound, SoundSource.RECORDS,boss.getRandom());
        this.boss = boss;
        this.soundEvent = sound;
        this.attenuation = Attenuation.NONE;
        this.looping = true;
        this.delay = 0;
        this.x = boss.getX();
        this.y = boss.getY();
        this.z = boss.getZ();

        volumeControl = new ControlledAnim(40);
        volumeControl.setTimer(20);
        volume = volumeControl.getAnimationFraction();
        timeUntilFade = 80;
    }

    public boolean canPlaySound() {
        return BossMusicPlayer.bossMusic == this;
    }

    public void tick() {
        if (boss == null || !boss.isAlive() || boss.isSilent()) {
            if (boss != null && !boss.isAlive()) timeUntilFade = 0;
            boss = null;
            if (timeUntilFade > 0) timeUntilFade--;
            else volumeControl.decreaseTimer();
        }
        else {
            volumeControl.increaseTimer();
            timeUntilFade = 60;
        }

        if (volumeControl.getAnimationFraction() < 0.025) {
            stop();
            BossMusicPlayer.bossMusic = null;
        }

        volume = (float) (volumeControl.getAnimationFraction() / ModConfig.MOB_CONFIG.BossMusicVolumeMultiplier.get());

        if (ticksExisted % 100 == 0) {
            Minecraft.getInstance().getMusicManager().stopPlaying();
        }
        ticksExisted++;
    }

    public void setBoss(IAnimatedMonster boss) {
        this.boss = boss;
    }

    public IAnimatedMonster getBoss() {
        return boss;
    }

    public SoundEvent getSoundEvent() {
        return soundEvent;
    }
}