package net.miauczel.legendary_monsters.Particle.custom;

import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.*;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.ShriekParticle;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.checkerframework.checker.units.qual.K;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

import java.util.Locale;

public class TestTrail extends Particle {
    private static final ResourceLocation TRAIL_TEXTURE = new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/particle/trail.png");

    private final int EntityId;
    private final float width;
    private final float height;
    private final float initialYRot;
    private final float rotateByAge;
    public int trailProgress;
    public float r;
    public float g;
    public float b;

    public TestTrail(ClientLevel world, double x, double y, double z, float r, float g, float b, float width, float height, int EntityId) {
        super(world, x, y, z,r,g,b);
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
        this.r = r;
        this.g = g;
        this.b = b;

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
        trailProgress++;
        Entity from = this.getFromEntity();
        if(from == null){
            remove();
        }

    }

    @Override
    public void render(VertexConsumer pBuffer, Camera pRenderInfo, float pPartialTicks) {

        BufferBuilder bufferBuilder = new BufferBuilder(256);
        bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR_TEX);
        if (trailProgress != 0){
            PoseStack poseStack = new PoseStack();

        PoseStack.Pose PoseposeStack = poseStack.last();
        Matrix4f matrix4f = PoseposeStack.pose();
        BufferBuilder starter = new BufferBuilder(1);


        float size = 0.5f;
        poseStack.pushPose();
        pBuffer.vertex((float) x, (float) y, (float) z, r, g, b, 1F, (float) 1F, 1F, 1, 1, (float) x, (float) y, (float) z);
        // pBuffer.vertex(matrix4f, (float) this.x, (float) this.y, (float) this.z).color(r,g,b,1).uv(size,size).endVertex();
        poseStack.popPose();
        bufferBuilder.end();
    }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.CUSTOM;
    }

    @OnlyIn(Dist.CLIENT)
    public static final class OrbFactory implements ParticleProvider<TrailData> {

        @Override
        public Particle createParticle(TrailData typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            TestTrail particle;
            particle = new TestTrail(worldIn, x, y, z, typeIn.getR(), typeIn.getG(), typeIn.getB(), typeIn.getWidth(), typeIn.getHeight(),typeIn.getentityid());

            return particle;
        }
    }


    public static class TrailData implements ParticleOptions {
        public static final Deserializer<TrailData> DESERIALIZER = new Deserializer<TrailData>() {
            public TrailData fromCommand(ParticleType<TrailData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
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
                return new TrailData(r, g, b,width,height, EntityId);
            }

            public TrailData fromNetwork(ParticleType<TrailData> particleTypeIn, FriendlyByteBuf buffer) {
                return new TrailData(buffer.readFloat(), buffer.readFloat(), buffer.readFloat(), buffer.readFloat(), buffer.readFloat(),buffer.readInt());
            }
        };

        private final float r;
        private final float g;
        private final float b;
        private final float width;
        private final float height;
        private final int entityid;

        public TrailData(float r, float g, float b, float width, float height, int entityid) {
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
        public ParticleType<TrailData> getType() {
            return ModParticles.TEST_TRAIL.get();
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

        public static Codec<TrailData> CODEC(ParticleType<TrailData> particleType) {
            return RecordCodecBuilder.create((codecBuilder) -> codecBuilder.group(
                            Codec.FLOAT.fieldOf("r").forGetter(TrailData::getR),
                            Codec.FLOAT.fieldOf("g").forGetter(TrailData::getG),
                            Codec.FLOAT.fieldOf("b").forGetter(TrailData::getB),
                            Codec.FLOAT.fieldOf("width").forGetter(TrailData::getWidth),
                            Codec.FLOAT.fieldOf("height").forGetter(TrailData::getHeight),
                            Codec.INT.fieldOf("entityid").forGetter(TrailData::getentityid)
                    ).apply(codecBuilder, TrailData::new)
            );
        }
    }

}
