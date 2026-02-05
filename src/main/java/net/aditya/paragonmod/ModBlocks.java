package net.aditya.paragonmod;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.aditya.paragonmod.ParagonMod.MOD_ID;

public class ModBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    public static RegistryObject<Block> CITRINE_ORE = BLOCKS.register("citrine_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)
                    .requiresCorrectToolForDrops()
                    .strength(3f)
            ));

    public static void registerBlocks(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
