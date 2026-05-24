package net.miauczel.legendary_monsters.Particle.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.client.particle.PlayerCloudParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public class Flame extends TextureSheetParticle {
    private final SpriteSet sprites;

    Flame(ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet pSprites) {
        super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
        this.sprites = pSprites;
        float f = 2.5F;
        float f1 = 1.0F - (float)(Math.random() * (double)0.3F);
        this.rCol = 1;
        this.gCol = 1;
        this.bCol = 1;
        this.quadSize *= 1.875F;
        int i = (int)(8.0D / (Math.random() * 0.8D + 0.3D));
        this.lifetime = 15;
        this.hasPhysics = false;
        this.setSpriteFromAge(pSprites);
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public float getQuadSize(float pScaleFactor) {
        return this.quadSize * Mth.clamp(((float)this.age + pScaleFactor) / (float)this.lifetime * 32.0F, 0.0F, 1.0F);
    }

    public void tick() {
        super.tick();
        if (!this.removed) {
            this.setSpriteFromAge(this.sprites);

        }

    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet pSprites) {
            this.sprites = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            return new Flame(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed, this.sprites);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class SneezeProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public SneezeProvider(SpriteSet pSprites) {
            this.sprites = pSprites;
        }

        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
            Particle particle = new Flame(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed, this.sprites);
            particle.setColor(200.0F, 50.0F, 120.0F);
            return particle;
        }
    }
}