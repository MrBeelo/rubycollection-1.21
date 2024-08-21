package net.mrbeelo.bsmpc.entity.custom;

import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class PurifyBombProjectileEntity extends ArrowEntity {

    public PurifyBombProjectileEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void onHit(LivingEntity target) {
        super.onHit(target);
        // Custom behavior when it hits a target
    }

    @Override
    public void tick() {
        super.tick();
        if (this.inGround) {
            this.inGroundTime++;
            if (this.inGroundTime >= 40) {  // 2 seconds (40 ticks)
                this.explode();
            }
        }
    }

    private void explode() {
        this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 2.0F, World.ExplosionSourceType.NONE);
        this.discard(); // Remove the entity after the explosion
    }
}
