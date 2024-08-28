package net.mrbeelo.bsmpc.effect.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.mrbeelo.bsmpc.BsmpC;
import net.mrbeelo.bsmpc.effect.ModEffects;
import net.mrbeelo.bsmpc.sound.ModSounds;
import java.util.HashSet;
import java.util.Set;

public class HighEffect extends StatusEffect {
    public HighEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    public final static Set<PlayerEntity> playersWithHighSound = new HashSet<>();

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity) {
            World world = entity.getWorld();
            if (!playersWithHighSound.contains(entity) && world instanceof ServerWorld) {
                playersWithHighSound.add((PlayerEntity) entity);
                if (entity instanceof ServerPlayerEntity serverPlayerEntity) {
                    //serverCommand((ServerWorld) world, player, "playsound bsmpc:high player @s ~ ~ ~ 50 1 1");
                    serverPlayerEntity.networkHandler.sendPacket(new net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket(RegistryEntry.of(ModSounds.HIGH), SoundCategory.PLAYERS, serverPlayerEntity.getX(), serverPlayerEntity.getY(), serverPlayerEntity.getZ(), 50F, 1F, serverPlayerEntity.getWorld().getRandom().nextLong()));
                }
            }
        }
        super.onApplied(entity, amplifier);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);
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
