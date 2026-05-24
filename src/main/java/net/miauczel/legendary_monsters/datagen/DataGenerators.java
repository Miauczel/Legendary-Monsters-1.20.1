package net.miauczel.legendary_monsters.datagen;


import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = LegendaryMonsters.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
       // System.out.println("Datagen Works");
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        ModBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new ModBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        CompletableFuture<HolderLookup.Provider> p_275729_;
        generator.addProvider(event.includeServer(), new ModItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeClient(), new ModBlockStatesProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModWorldGenProvider(packOutput,lookupProvider));


    }
    }