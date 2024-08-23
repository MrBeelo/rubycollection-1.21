package net.mrbeelo.bsmpc.effect.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.mrbeelo.bsmpc.effect.ModEffects;
import net.mrbeelo.bsmpc.sound.ModSounds;
import java.util.HashSet;
import java.util.Set;

import static net.minecraft.block.entity.BeaconBlockEntity.playSound;
import static net.mrbeelo.bsmpc.BsmpC.serverCommand;


public class HighEffect extends StatusEffect {
    public HighEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    public final static Set<PlayerEntity> playersWithHighSound = new HashSet<>();

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            World world = player.getWorld();
            if (!playersWithHighSound.contains(player) && world instanceof ServerWorld) {
                playersWithHighSound.add(player);
                serverCommand((ServerWorld) world, player, "playsound bsmpc:high player @s ~ ~ ~ 50 1 1");
            }
        }
        super.onApplied(entity, amplifier);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);

        // Apply nausea effect directly to simulate the effect
        if (entity instanceof PlayerEntity) {
            applyCustomNausea((PlayerEntity) entity);
            simulateNauseaEffect(entity);
        }
        return true;
    }

    private void applyCustomNausea(PlayerEntity player) {
        float time = player.getWorld().getTime() / 10.0F;
        float strength = 20.0F;

        float offsetX = (MathHelper.sin(time * 1.0F) * 0.2F);
        float offsetY = (MathHelper.sin(time * 1.0F) * 0.2F * MathHelper.cos(time * 0.4F));
        player.setYaw(player.getYaw() + offsetX * strength);
        player.setPitch(player.getPitch() + offsetY * strength);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    private void simulateNauseaEffect(LivingEntity pEntity) {
        if (pEntity instanceof PlayerEntity) {
            float yaw = pEntity.getYaw();
            float pitch = pEntity.getPitch();
            yaw += (float) ((Math.random() - 0.5) * 7);
            pitch += (float) ((Math.random() - 0.5) * 3);
            pEntity.setYaw(yaw);
            pEntity.setPitch(pitch);
            pEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 80, 0, false, false, false));
        }
    }
}
