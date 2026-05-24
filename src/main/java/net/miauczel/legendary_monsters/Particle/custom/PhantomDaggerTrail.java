package net.miauczel.legendary_monsters.Particle.custom;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Locale;

public class PhantomDaggerTrail extends AbstractNotGlowingTrailParticle{
    private static final ResourceLocation TRAIL_TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/particle/trail_soul.png");

    private final int EntityId;
    private final float width;
    private final float height;
    private final float initialYRot;
    private final float rotateByAge;

    public PhantomDaggerTrail(ClientLevel world, double x, double y, double z, float r, float g, float b, float width, float height, int EntityId) {
        super(world, x, y, z, 0, 0, 0,r,g,b);
        this.EntityId = EntityId;
        this.gravity = 0;
        this.lifetime = 20 + this.random.nextInt(20);
        initialYRot = random.nextFloat() * 360F;
        rotateByAge = (10 + random.nextFloat() * 10F) * (random.nextBoolean() ? -1F : 1F);
        this.width = width;
        this.height = height;
        Vec3 vec3 = getOrbitPosition();
        this.x = this.xo = vec3.x;
        this.y = this.yo = vec3.y;
        this.z = this.zo = vec3.z;
        this.xd = 0;
        this.yd = 0;
        this.zd = 0;
    }



    public Vec3 getEntityPosition(){
        Entity from = this.getFromEntity();
        if(from != null){
            return from.position();
        }
        return new Vec3(this.x, this.y, this.z);
    }


    public Entity getFromEntity() {
        return EntityId == -1 ? null : level.getEntity(EntityId);
    }

    public Vec3 getOrbitPosition(){
        Vec3 dinoPos = getEntityPosition();
        Vec3 vec3 = new Vec3(0, height, width).yRot((float)Math.toRadians(initialYRot + rotateByAge * age));
        return dinoPos.add(vec3);
    }

    public void tick() {
        super.tick();

        float fade = 1F - age / (float) lifetime;
        this.trailA = 1F * fade;
        Vec3 vec3 = getOrbitPosition();
        this.x = vec3.x;
        this.y = vec3.y;
        this.z = vec3.z;

        Entity from = this.getFromEntity();
        if(from == null){
            remove();
        }

    }

    public int sampleCount() {
        return 4;
    }

    public int sampleStep() {
        return 1;
    }

    @Override
    public float getTrailHeight() {
        return 0.5F;
    }

    public int getLightColor(float f) {
        return 240;
    }

    @Override
    public ResourceLocation getTrailTexture() {
        return TRAIL_TEXTURE;
    }

    @OnlyIn(Dist.CLIENT)
    public static final class OrbFactory implements ParticleProvider<PhantomDaggerTrail.OrbData> {

        @Override
        public Particle createParticle(PhantomDaggerTrail.OrbData typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            PhantomDaggerTrail particle;
            particle = new PhantomDaggerTrail(worldIn, x, y, z, typeIn.getR(), typeIn.getG(), typeIn.getB(), typeIn.getWidth(), typeIn.getHeight(),typeIn.getentityid());

            return particle;
        }
    }


    public static class OrbData implements ParticleOptions {
        public static final Deserializer<PhantomDaggerTrail.OrbData> DESERIALIZER = new Deserializer<PhantomDaggerTrail.OrbData>() {
            public PhantomDaggerTrail.OrbData fromCommand(ParticleType<PhantomDaggerTrail.OrbData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
                reader.expect(' ');
                float r = reader.readFloat();
                reader.expect(' ');
                float g = reader.readFloat();
                reader.expect(' ');
                float b = reader.readFloat();
                reader.expect(' ');
                float width = reader.readFloat();
                reader.expect(' ');
                float height = reader.readFloat();
                reader.expect(' ');
                int EntityId = reader.readInt();
                return new PhantomDaggerTrail.OrbData(r, g, b,width,height, EntityId);
            }

            public PhantomDaggerTrail.OrbData fromNetwork(ParticleType<PhantomDaggerTrail.OrbData> particleTypeIn, FriendlyByteBuf buffer) {
                return new PhantomDaggerTrail.OrbData(buffer.readFloat(), buffer.readFloat(), buffer.readFloat(), buffer.readFloat(), buffer.readFloat(),buffer.readInt());
            }
        };

        private final float r;
        private final float g;
        private final float b;
        private final float width;
        private final float height;
        private final int entityid;

        public OrbData(float r, float g, float b,float width, float height, int entityid) {
            this.r = r;
            this.g = g;
            this.b = b;
            this.width = width;
            this.height = height;
            this.entityid = entityid;
        }

        @Override
        public void writeToNetwork(FriendlyByteBuf buffer) {
            buffer.writeFloat(this.r);
            buffer.writeFloat(this.g);
            buffer.writeFloat(this.b);
            buffer.writeFloat(this.width);
            buffer.writeFloat(this.height);
            buffer.writeInt(this.entityid);
        }

        @Override
        public String writeToString() {
            return String.format(Locale.ROOT, "%s %.2f %.2f %.2f %.2f %.2f %d", BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()),
                    this.r, this.g, this.b,this.width,this.height,this.entityid);
        }

        @Override
        public ParticleType<PhantomDaggerTrail.OrbData> getType() {
            return ModParticles.PHANTOM_DAGGER_TRAIL.get();
        }

        @OnlyIn(Dist.CLIENT)
        public float getR() {
            return this.r;
        }

        @OnlyIn(Dist.CLIENT)
        public float getG() {
            return this.g;
        }

        @OnlyIn(Dist.CLIENT)
        public float getB() {
            return this.b;
        }

        @OnlyIn(Dist.CLIENT)
        public float getWidth() {
            return this.width;
        }

        @OnlyIn(Dist.CLIENT)
        public float getHeight() {
            return this.height;
        }

        @OnlyIn(Dist.CLIENT)
        public int getentityid() {
            return this.entityid;
        }

        public static Codec<PhantomDaggerTrail.OrbData> CODEC(ParticleType<PhantomDaggerTrail.OrbData> particleType) {
            return RecordCodecBuilder.create((codecBuilder) -> codecBuilder.group(
                            Codec.FLOAT.fieldOf("r").forGetter(PhantomDaggerTrail.OrbData::getR),
                            Codec.FLOAT.fieldOf("g").forGetter(PhantomDaggerTrail.OrbData::getG),
                            Codec.FLOAT.fieldOf("b").forGetter(PhantomDaggerTrail.OrbData::getB),
                            Codec.FLOAT.fieldOf("width").forGetter(PhantomDaggerTrail.OrbData::getWidth),
                            Codec.FLOAT.fieldOf("height").forGetter(PhantomDaggerTrail.OrbData::getHeight),
                            Codec.INT.fieldOf("entityid").forGetter(PhantomDaggerTrail.OrbData::getentityid)
                    ).apply(codecBuilder, PhantomDaggerTrail.OrbData::new)
            );
        }
    }

}
