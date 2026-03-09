package net.aditya.paragonmod.worldgen.feature;


import net.minecraft.client.multiplayer.chat.report.ReportEnvironment;
import net.minecraft.client.telemetry.events.WorldLoadEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.Objects;


public class DoubleTree {
    public static final ResourceKey<Level> MYSTICITY = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("paragonmod", "mysticity"));
    public static void place(ServerPlayer player) {
        BlockPos pos = new BlockPos(0, 60, 0);
        ResourceKey<Level> dim = player.level().dimension();
        ServerLevel myst = Objects.requireNonNull(player.level().getServer()).getLevel(MYSTICITY);

        if (dim.equals(MYSTICITY) && myst.getBlockState(pos).isAir()) {
            StructureTemplate template = myst.getStructureManager()
                    .getOrCreate(new ResourceLocation("paragonmod", "double_tree"));
            template.placeInWorld(myst, pos, pos, new StructurePlaceSettings(), myst.random, 2);
        }
    }
}
