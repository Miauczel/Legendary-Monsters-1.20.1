package net.miauczel.legendary_monsters.worldgen.Structure.Custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.miauczel.legendary_monsters.worldgen.Structure.ModStructures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.Optional;
public class LMJigsawStructure extends Structure {
    public static final int MAX_TOTAL_STRUCTURE_RANGE = 1000;
    public static final Codec<LMJigsawStructure> CODEC = ExtraCodecs.validate(RecordCodecBuilder
            .mapCodec((p_227640_) -> p_227640_.group(settingsCodec(p_227640_),
                    StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter((p_227656_) -> p_227656_.startPool),
                    ResourceLocation.CODEC.optionalFieldOf("start_jigsaw_name").forGetter((p_227654_) -> p_227654_.startJigsawName),
                    Codec.intRange(0, 60).fieldOf("size").forGetter((p_227652_) -> p_227652_.maxDepth),
                    HeightProvider.CODEC.fieldOf("start_height").forGetter((p_227649_) -> p_227649_.startHeight),
                    Codec.BOOL.fieldOf("use_expansion_hack").forGetter((p_227646_) -> p_227646_.useExpansionHack),
                    Heightmap.Types.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter((p_227644_) -> p_227644_.projectStartToHeightmap),
                    Codec.intRange(1, MAX_TOTAL_STRUCTURE_RANGE).fieldOf("max_distance_from_center").forGetter((p_227642_) -> p_227642_.maxDistanceFromCenter))
                    .apply(p_227640_, LMJigsawStructure::new)), LMJigsawStructure::verifyRange).codec();

    private final Holder<StructureTemplatePool> startPool;
    private final Optional<ResourceLocation> startJigsawName;
    private final int maxDepth;
    private final HeightProvider startHeight;
    private final boolean useExpansionHack;
    private final Optional<Heightmap.Types> projectStartToHeightmap;
    private final int maxDistanceFromCenter;

    private static DataResult<LMJigsawStructure> verifyRange(LMJigsawStructure p_286886_) {
        byte var10000;
        switch (p_286886_.terrainAdaptation()) {
            case NONE:
                var10000 = 0;
                break;
            case BURY:
            case BEARD_THIN:
            case BEARD_BOX:
                var10000 = 12;
                break;
            default:
                throw new IncompatibleClassChangeError();
        }

        int $$1 = var10000;
        return p_286886_.maxDistanceFromCenter + $$1 > MAX_TOTAL_STRUCTURE_RANGE ? DataResult.error(() -> "LM Structure size including terrain adaptation must not exceed: " + MAX_TOTAL_STRUCTURE_RANGE) : DataResult.success(p_286886_);
    }
    public LMJigsawStructure(Structure.StructureSettings p_227627_, Holder<StructureTemplatePool> p_227628_, Optional<ResourceLocation> p_227629_, int p_227630_, HeightProvider p_227631_, boolean p_227632_, Optional<Heightmap.Types> p_227633_, int p_227634_) {
        super(p_227627_);
        this.startPool = p_227628_;
        this.startJigsawName = p_227629_;
        this.maxDepth = p_227630_;
        this.startHeight = p_227631_;
        this.useExpansionHack = p_227632_;
        this.projectStartToHeightmap = p_227633_;
        this.maxDistanceFromCenter = p_227634_;
    }

    public LMJigsawStructure(Structure.StructureSettings pSettings, Holder<StructureTemplatePool> pStartPool, int pMaxDepth, HeightProvider pStartHeight, boolean pUseExpansionHack, Heightmap.Types pProjectStartToHeightmap) {
        this(pSettings, pStartPool, Optional.empty(), pMaxDepth, pStartHeight, pUseExpansionHack, Optional.of(pProjectStartToHeightmap), MAX_TOTAL_STRUCTURE_RANGE);
    }

    public LMJigsawStructure(Structure.StructureSettings pSettings, Holder<StructureTemplatePool> pStartPool, int pMaxDepth, HeightProvider pStartHeight, boolean pUseExpansionHack) {
        this(pSettings, pStartPool, Optional.empty(), pMaxDepth, pStartHeight, pUseExpansionHack, Optional.empty(), MAX_TOTAL_STRUCTURE_RANGE);
    }

    public Optional<Structure.GenerationStub> findGenerationPoint(Structure.GenerationContext pContext) {
        ChunkPos $$1 = pContext.chunkPos();
        int $$2 = this.startHeight.sample(pContext.random(), new WorldGenerationContext(pContext.chunkGenerator(), pContext.heightAccessor()));
        BlockPos $$3 = new BlockPos($$1.getMinBlockX(), $$2, $$1.getMinBlockZ());
        return LMJigsawPlacement.addPieces(pContext, this.startPool, this.startJigsawName, this.maxDepth, $$3, this.useExpansionHack, this.projectStartToHeightmap, this.maxDistanceFromCenter);
    }

    public StructureType<?> type() {
        return ModStructures.LM_JIGSAW.get();
    }
}