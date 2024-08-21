package net.mrbeelo.bsmpc.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.world.World;

public class BulletProjectileEntity extends ArrowEntity {
    public BulletProjectileEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void onHit(LivingEntity target) {
        super.onHit(target);
        this.discard();
    }

    @Override
    public void tick() {
        super.tick();
        if (this.inGround) {
            this.discard();
        }
    }
}
