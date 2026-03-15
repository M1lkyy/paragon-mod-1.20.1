package net.aditya.paragonmod;

import net.minecraft.network.protocol.game.ClientboundSetTimePacket;
import net.minecraft.server.commands.TimeCommand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.aditya.paragonmod.worldgen.feature.DoubleTree.MYSTICITY;

@Mod.EventBusSubscriber(modid = "paragonmod")
public class TimeByLook { // Note: You don't actually need to extend TimeCommand

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && event.getServer() != null) {
            ServerLevel serverLevel = event.getServer().getLevel(MYSTICITY);

            if (serverLevel != null && !serverLevel.players().isEmpty()) {
                if (serverLevel.getGameRules().getBoolean(GameRules.RULE_DAYLIGHT)) {
                    serverLevel.getGameRules().getRule(GameRules.RULE_DAYLIGHT).set(false, serverLevel.getServer());
                }
                ServerPlayer player = serverLevel.players().get(0);
                float yRot = player.getYRot();
                long mappedTime = (long) (((yRot + 180f) / 360f) * 24000.0f);
                mappedTime = Math.floorMod(mappedTime, 24000L);
                serverLevel.setDayTime(mappedTime);
                if (event.getServer().getTickCount() % 2 == 0) {
                    ClientboundSetTimePacket packet = new ClientboundSetTimePacket(
                            serverLevel.getGameTime(),
                            -mappedTime,
                            false
                    );

                    for (ServerPlayer p : serverLevel.players()) {
                        p.connection.send(packet);
                    }
                }
            }
        }
    }
}
