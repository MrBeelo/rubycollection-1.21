package net.mrbeelo.bsmpc.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.InteractionEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import static net.mrbeelo.bsmpc.BsmpC.hasTag;

public class LazerEntity extends InteractionEntity {

    public LazerEntity(EntityType<? extends LazerEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        World world = this.getWorld();
        if (world instanceof ServerWorld serverWorld) {
            for (LivingEntity livingEntity : serverWorld.getEntitiesByClass(LivingEntity.class, this.getBoundingBox().expand(0.3), e -> true)) {
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 1));
            }
        }
        super.tick();
    }
}
