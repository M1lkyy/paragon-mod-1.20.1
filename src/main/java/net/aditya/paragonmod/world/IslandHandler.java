package net.aditya.paragonmod.world;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.*;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

@Mod.EventBusSubscriber(modid = "paragonmod")
public class IslandHandler extends Structure {
    public static final ResourceKey<Level> MYSTICITY = ResourceKey.create(
            Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath("paragonmod", "mysticity")
    );

    public IslandHandler(StructureSettings settings) {
        super(settings);
    }

    @SubscribeEvent
    public static void loadedDimension() {
        // add code later
    }

    @Override
    protected @NotNull Optional<GenerationStub> findGenerationPoint(GenerationContext generationContext) {
        return Optional.empty();
    }

    @Override
    public @NotNull StructureType<?> type() {
        return null;
    }
}

