package com.ichphilipp.bedrockmining;

import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.*;
import org.slf4j.Logger;

@Mod(BedrockMining.MODID)
public class BedrockMining{
    public static final String MODID = "bedrockmining";

    public BedrockMining() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        ////////////////////////////////////////////
        //ForgeConfigSpec.DoubleValue destroyTime;
        //ForgeConfigSpec.DoubleValue explosionResistance;
        //ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        //destroyTime = COMMON_BUILDER
        //        .comment("ex.: Obsidian = 50, Stone = 1.5   default: 100 ")
        //        .defineInRange("destroyTime", 100.0F,-1.0F,10000.0F);
        //explosionResistance = COMMON_BUILDER
        //        .comment("ex.: Obsidian = 1200, Stone = 6   default: 3600 ")
        //        .defineInRange("explosionResistance", 3600.0F, 1.0F,100000000.0F);
        //ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, COMMON_BUILDER.build());
        ////////////////////////////////////////////
        DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");
        RegistryObject<Block> Bedrock = BLOCKS.register(
                "bedrock",
                () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                        .strength(50.0F, 3600.0F).noLootTable()));
        BLOCKS.register(eventBus);
        ////////////////////////////////////////////
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

        });
    }
}
