package net.mrbeelo.bsmpc.entity.client.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.mrbeelo.bsmpc.entity.ModDamageTypes;
import net.mrbeelo.bsmpc.entity.custom.SnekEntity;
import net.mrbeelo.bsmpc.sound.ModSounds;

public class SnekAttackGoal extends MeleeAttackGoal {
    private final SnekEntity entity;
    private int attackDelay = 10;
    private int ticksUntilNextAttack = 5;
    private boolean shouldCountTillNextAttack = false;

    public SnekAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((SnekEntity) mob);
    }

    @Override
    public void start() {
        super.start();
        //resetAttackCooldown();
        attackDelay = 10;
        ticksUntilNextAttack = 5;
    }

    @Override
    protected void attack(LivingEntity pEnemy) {
        if (isEnemyWithinAttackDistance(pEnemy)) {
            shouldCountTillNextAttack = true;

            if(isTimeToStartAttackAnimation()) {
                entity.setAttacking(true);
            }

            if(isTimeToAttack()) {
                this.mob.getLookControl().lookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performAttack(pEnemy);
                pEnemy.getWorld().playSound(null, pEnemy.getBlockPos(), ModSounds.MUA, SoundCategory.HOSTILE, 3F, 1F);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy) {
        return this.entity.distanceTo(pEnemy) <= 2f;
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.getTickCount(attackDelay * 2);
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        World world = pEnemy.getWorld();
        //this.mob.tryAttack(pEnemy);
        DamageSource damageSource = new DamageSource(
                world.getRegistryManager()
                        .get(RegistryKeys.DAMAGE_TYPE)
                        .entryOf(ModDamageTypes.TATER_DAMAGE));
        pEnemy.damage(damageSource, 5.0f);
    }

    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}