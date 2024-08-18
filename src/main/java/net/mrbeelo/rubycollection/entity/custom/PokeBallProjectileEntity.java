package net.mrbeelo.rubycollection.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.EndermiteEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.mrbeelo.rubycollection.entity.ModEntities;
import net.mrbeelo.rubycollection.item.ModItems;

public class PokeBallProjectileEntity extends ThrownItemEntity {
    public PokeBallProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public PokeBallProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.POKE_BALL_PROJECTILE, livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.POKE_BALL;
    }

    /*@Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

     */

    @Override
    protected void onCollision(HitResult hitResult) {
        if(!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);

            Vec3d hitPos = hitResult.getPos();
            BlockPos blockPos = new BlockPos((int) hitPos.x, (int) hitPos.y, (int) hitPos.z);
            World world = this.getWorld();
            SnekEntity snek = ModEntities.SNEK.create(world);

            if (snek != null) {
                snek.setPosition(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                world.spawnEntity(snek);
        }

        this.discard();
        super.onCollision(hitResult);
    }
}}
