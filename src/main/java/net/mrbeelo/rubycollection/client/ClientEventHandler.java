package net.mrbeelo.rubycollection.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.fabricmc.api.ModInitializer;

import net.mrbeelo.rubycollection.effect.ModEffects;

public class ClientEventHandler implements ModInitializer {

    @Override
    public void onInitialize() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            PlayerEntity player = client.player;
            if (player != null && player.hasStatusEffect(ModEffects.HIGH)) {
                applyCustomNausea(player);
            }
        });
    }

    private void applyCustomNausea(PlayerEntity player) {
        float time = player.getWorld().getTime() / 20.0F;
        float strength = 5.0F;

        float offsetX = (MathHelper.sin(time * 0.5F) * 0.1F);
        float offsetY = (MathHelper.sin(time * 0.5F) * 0.1F * MathHelper.cos(time * 0.2F));
        player.setYaw(player.getYaw() + offsetX * strength);
        player.setPitch(player.getPitch() + offsetY * strength);
    }
}
