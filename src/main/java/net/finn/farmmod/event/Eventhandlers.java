package net.finn.farmmod.event;

import net.finn.farmmod.network.NetworkHandler;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.finn.farmmod.FarmMod;

@Mod.EventBusSubscriber(modid = FarmMod.MODID)
public class Eventhandlers {

    @SubscribeEvent
    public static void onPlayerOpenContainer(PlayerContainerEvent.Open event) {

        String playerName = event.getEntity().getName().getString();
        String inventoryName = event.getContainer().getType().getClass().getName();

        String message = playerName + "öffnet: " + inventoryName;

        System.out.println(message);
        NetworkHandler.sendData(message);
    }
    @SubscribeEvent
    public static void onServerPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        if (player instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) player;
            String playerName = serverPlayer.getScoreboardName();
            if (serverPlayer.level() instanceof ServerLevel) {
                String serverName = ((ServerLevel) serverPlayer.level()).getServer().getServerModName();

                String message = playerName + " betritt Server: " + serverName;
                System.out.println(message);
                NetworkHandler.sendData(message);
            }
        }
    }
}
