package net.mrbeelo.bsmpc.event;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.mrbeelo.bsmpc.item.ModItems;

public class EntityDeathListener implements ServerLivingEntityEvents.AfterDeath {

    @Override
    public void afterDeath(LivingEntity entity, DamageSource damageSource) {
        Entity attacker = damageSource.getAttacker();
        if (attacker instanceof PlayerEntity playerAttacker && (playerAttacker.getMainHandStack().getItem().equals(ModItems.RUBY_SWORD) || playerAttacker.getOffHandStack().getItem().equals(ModItems.RUBY_SWORD))) {
            playerAttacker.sendMessage(Text.of(playerAttacker.getName().getString() + " killed a " + entity.getName().getString() + " with a Ruby Sword; " + playerAttacker.getName().getString() + " is very cruel."));
            //TODO: MAKE CUSTOM METHOD FOR TRANSFORMING THE PLAYER
        }
    }
}
