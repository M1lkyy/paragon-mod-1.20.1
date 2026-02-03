package net.aditya.paragonmod;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.aditya.paragonmod.ParagonMod.MOD_ID;

public class ModItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    // Actual items
    public static RegistryObject<Item> RAW_CITRINE = ITEMS.register("raw_citrine", () -> new Item(new Item.Properties().requiredFeatures()));


    // BlockItems
    public static final RegistryObject<Item> CITRINE_ORE_BLOCK_ITEM = ITEMS.register("citrine_ore",
            () -> new BlockItem(ModBlocks.CITRINE_ORE.get(), new Item.Properties()));

    public static void registerItems(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
