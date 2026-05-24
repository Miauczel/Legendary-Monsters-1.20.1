package net.miauczel.legendary_monsters.Particle.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ShulkerConfettiParticle extends SimpleAnimatedParticle {
    ShulkerConfettiParticle(ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ, pSprites, 1.25F);
        this.friction = 0.6F;
        this.xd = pXSpeed;
        this.yd = pYSpeed;
        this.zd = pZSpeed;
        this.quadSize *= 0.75F;
        this.lifetime = 60 + this.random.nextInt(12);
        this.setSpriteFromAge(pSprites);
        if (this.random.nextInt(4) == 0) {
            this.setColor(0.2f, 0.0f, this.random.nextFloat() * 0.5F);
        } else {
            this.setColor(1f, 1f, this.random.nextFloat() * 1F);
        }

    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet pSprites) {
            this.sprites = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            return new ShulkerConfettiParticle(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed, this.sprites);
        }
    }
}