package net.miauczel.legendary_monsters.entity.client.Render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.Util;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.function.Function;

@OnlyIn(Dist.CLIENT)
public abstract class LMRenderTypes extends RenderType {
    public static ParticleRenderType PARTICLE_SHEET_TRANSLUCENT_NO_DEPTH = new ParticleRenderType() {
        public void begin(BufferBuilder p_217600_1_, TextureManager p_217600_2_) {
            RenderSystem.depthMask(false);
            RenderSystem.disableCull();
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            p_217600_1_.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.PARTICLE);
        }

        public void end(Tesselator p_217599_1_) {
            p_217599_1_.end();
        }

        public String toString() {
            return "PARTICLE_SHEET_TRANSLUCENT_NO_DEPTH";
        }
    };
    protected static final ShaderStateShard RENDERTYPE_BREEZE_WIND_SHADER = new ShaderStateShard(LMRenderTypes::getRendertypeBreezeWindShader);

    @Nullable
    public static ShaderInstance getRendertypeBreezeWindShader() {
        return rendertypeBreezeWindShader;
    }

    @Nullable
    private static ShaderInstance rendertypeBreezeWindShader;
    public LMRenderTypes(String nameIn, VertexFormat formatIn, VertexFormat.Mode drawModeIn, int bufferSizeIn, boolean useDelegateIn, boolean needsSortingIn, Runnable setupTaskIn, Runnable clearTaskIn) {
        super(nameIn, formatIn, drawModeIn, bufferSizeIn, useDelegateIn, needsSortingIn, setupTaskIn, clearTaskIn);
    }

    public static RenderType breezeWind(ResourceLocation p_311543_, float p_312161_, float p_310801_) {
        return create("breeze_wind", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 1536, false, true, RenderType.CompositeState.builder().setShaderState(RENDERTYPE_BREEZE_WIND_SHADER).setTextureState(new RenderStateShard.TextureStateShard(p_311543_, false, false)).setTexturingState(new RenderStateShard.OffsetTexturingStateShard(p_312161_, p_310801_)).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setCullState(NO_CULL).setLightmapState(LIGHTMAP).setOverlayState(NO_OVERLAY).createCompositeState(false));
    }
    public static final RenderType LIGHTNING_NO_CULL = create("lightning1",
            DefaultVertexFormat.POSITION_COLOR, VertexFormat.Mode.QUADS,
            256, false, true,
            RenderType.CompositeState.builder().setShaderState(RENDERTYPE_LIGHTNING_SHADER)
                    .setWriteMaskState(COLOR_DEPTH_WRITE).setTransparencyState(LIGHTNING_TRANSPARENCY)
                    .setOutputState(WEATHER_TARGET).setCullState(RenderStateShard.NO_CULL).createCompositeState(false));

    public static RenderType getGlowingEffect(ResourceLocation locationIn) {
        RenderStateShard.TextureStateShard shard = new RenderStateShard.TextureStateShard(locationIn, false, false);
        RenderType.CompositeState rendertype$state = CompositeState.builder().setTextureState(shard).setShaderState(RENDERTYPE_BEACON_BEAM_SHADER).setTransparencyState(TRANSLUCENT_TRANSPARENCY).setCullState(NO_CULL).setOverlayState(OVERLAY).setWriteMaskState(COLOR_WRITE).createCompositeState(false);
        return create("glow_effect", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, true, true, rendertype$state);
    }
    public static RenderType getFullBirght(ResourceLocation location){
        return ENTITY_FULLBRIGHT.apply(location);
    }

    public static RenderType getGlowEyes(ResourceLocation locationIn) {
        RenderStateShard.TextureStateShard renderstateshard$texturestateshard = new RenderStateShard.TextureStateShard(locationIn, false, false);
        return create("glow", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, false, true, RenderType
                .CompositeState.builder()
                .setShaderState(RENDERTYPE_EYES_SHADER)
                .setTextureState(renderstateshard$texturestateshard)
                .setTransparencyState(ADDITIVE_TRANSPARENCY)
                .setCullState(NO_CULL)
                .setWriteMaskState(COLOR_WRITE).
                createCompositeState(false));
    }
    private static final Function<ResourceLocation, RenderType> ENTITY_FULLBRIGHT = Util.memoize((p_286165_) -> {
        RenderType.CompositeState rendertype$compositestate = RenderType.CompositeState.builder()
                .setLightmapState(LIGHTMAP)
                .setShaderState(RENDERTYPE_ENTITY_TRANSLUCENT_CULL_SHADER)
                .setTextureState(new TextureStateShard(p_286165_, false, false))
                .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                .setLightmapState(NO_LIGHTMAP)
                .setOverlayState(NO_OVERLAY)
                .createCompositeState(true);
        return create("entity_full_bright", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, false, true, rendertype$compositestate);
    });

        public static final Function<ResourceLocation, RenderType>  LM_ENTITY_TRANSLUCENT_EMISSIVE = Util.memoize((p_286163_) -> {
            CompositeState rendertype$compositestate = RenderType.CompositeState.builder()
                    .setShaderState(RENDERTYPE_ENTITY_TRANSLUCENT_EMISSIVE_SHADER)
                    .setTextureState(new RenderStateShard.TextureStateShard(p_286163_, false, false))
                    .setTransparencyState(TRANSLUCENT_TRANSPARENCY)
                    .setCullState(NO_CULL)
                    .setWriteMaskState(COLOR_WRITE)
                    .setOverlayState(NO_OVERLAY)
                    .createCompositeState(true);
            return create("lm_entity_translucent_emissive", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, true, true, rendertype$compositestate);
        });
}