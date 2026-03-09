package net.aditya.paragonmod;

import net.aditya.paragonmod.worldgen.feature.DoubleTree;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.aditya.paragonmod.worldgen.feature.DoubleTree.MYSTICITY;

@Mod.EventBusSubscriber(modid = "paragonmod")
public class TimeByLook {
    @SubscribeEvent
    public static void TimeChanger(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            if (event.player instanceof ServerPlayer player) {
                if (!event.side.isClient()) {
                    ServerLevel serverLevel = (ServerLevel) event.player.level();
                    float yRot = player.getYRot();
                    ResourceKey<Level> dim = serverLevel.dimension();
                    System.out.println("DIM:" + serverLevel.dimension().location());
                    long mappedTime = (long) ((yRot + 180f) / 360f * 24000f);
                    System.out.println("YAW: " + yRot + " | TIME: " + mappedTime);
                    System.out.println("Server time: " + serverLevel.getDayTime());
                    if (serverLevel.dimension().location().equals(ResourceLocation.fromNamespaceAndPath("paragonmod", "mysticity"))) {
                        serverLevel.setDayTime(mappedTime);
                    }
                }
            }
        }
    }
}
