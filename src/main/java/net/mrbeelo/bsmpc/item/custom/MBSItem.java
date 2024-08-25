package net.mrbeelo.bsmpc.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.decoration.InteractionEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.PositionFlag;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.mrbeelo.bsmpc.components.ModDataComponentTypes;
import net.mrbeelo.bsmpc.entity.ModEntities;
import net.mrbeelo.bsmpc.entity.custom.BulletProjectileEntity;
import net.mrbeelo.bsmpc.particle.ModParticles;
import org.joml.Vector3f;

import java.util.*;

import static net.mrbeelo.bsmpc.BsmpC.*;


public class MBSItem extends Item {
    public MBSItem(Settings settings) {
        super(settings);
    }

    private int lazerDuration = 0;
    private int glowingDuration = 0;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (world.isClient()) {
            return TypedActionResult.success(stack);
        }

        int count = stack.getOrDefault(ModDataComponentTypes.MBS_STAGE, 0);

        if (!user.isSneaking()) {
            stack.set(ModDataComponentTypes.MBS_STAGE, ++count);

            if (count == 0) {
                Text beelium = Text.literal("Beelium").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 215 << 8 | 0)));
                user.sendMessage(beelium, true);
            }

            if (count == 1) {
                Text aggresium = Text.literal("Aggresium").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 0 << 8 | 0)));
                user.sendMessage(aggresium, true);
            }

            if (count == 2) {
                Text mobilium = Text.literal("Mobilium").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 255 << 8 | 0)));
                user.sendMessage(mobilium, true);
            }

            if (count == 3) {
                Text protisium = Text.literal("Protisium").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0 << 16 | 255 << 8 | 255)));
                user.sendMessage(protisium, true);
            }

            if (count == 4) {
                Text beelium = Text.literal("Beelium").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 215 << 8 | 0)));
                user.sendMessage(beelium, true);
            }

            if (count >= 4) {
                stack.set(ModDataComponentTypes.MBS_STAGE, 0);
            }
        }


        if (user.isSneaking()) {
            if (!user.getItemCooldownManager().isCoolingDown(stack.getItem())) {
                user.getItemCooldownManager().set(stack.getItem(), 500);

                if (count == 0) {
                    Text beeliumA = Text.literal("Beelium Activated!").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 215 << 8 | 0)));
                    user.sendMessage(beeliumA, true);
                    //serverCommand((ServerWorld) world, user, "effect give @s resistance 5 255");
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6, 255));
                    //serverCommand((ServerWorld) world, user, "effect give @s slowness 5 255");
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5, 255));
                    //serverCommand((ServerWorld) world, user, "execute at @s run summon lightning_bolt ~ ~ ~");
                    Entity bolt = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                    bolt.setPos(user.getX(), user.getY(), user.getZ());
                    world.spawnEntity(bolt);
                    //serverCommand((ServerWorld) world, user, "effect give @e[distance=..10] levitation 5 2");
                    double radius = 10.0;
                    for (Entity entity : world.getEntitiesByClass(Entity.class, user.getBoundingBox().expand(radius), e -> true)) {
                        // Check if the entity is an instance of LivingEntity
                        if (entity instanceof LivingEntity livingEntity) {
                            if (livingEntity.squaredDistanceTo(user) <= radius * radius) {
                                // Apply levitation effect
                                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 100, 2)); // 100 ticks = 5 seconds, amplifier 2
                            }
                        }
                    }
                    glowingDuration = 140;
                }

                if (count == 1) {
                    Text aggresiumA = Text.literal("Aggresium Activated!").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 0 << 8 | 0)));
                    user.sendMessage(aggresiumA, true);
                    for (int i = 3; i <= 18; i++) {
                        //serverCommand((ServerWorld) world, user, "execute at @s run summon interaction ^ ^ ^" + i + " {width:1b,height:1b,limit:1,Tags:['lazer" + i + "','lazer']}");
                        InteractionEntity interaction = new InteractionEntity(EntityType.INTERACTION, world);
                        interaction.setBoundingBox(new Box(1, 1, 1, 2, 2, 2));
                        interaction.addCommandTag("lazer" + i);
                        interaction.addCommandTag("lazer");
                        interaction.setPos(getBlockInFrontX(user, i), getBlockInFrontY(user), getBlockInFrontZ(user, i));
                        world.spawnEntity(interaction);
                    }
                    lazerDuration = 140;
                }

                if (count == 2) {
                    Text mobiliumA = Text.literal("Mobilium Activated!").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(255 << 16 | 255 << 8 | 0)));
                    user.sendMessage(mobiliumA, true);
                    for (int i = 1; i <= 10; i++) {
                        //serverCommand((ServerWorld) world, user, "particle dust{color:[1.000,0.920,0.000],scale:1} ^ ^ ^" + i + " 0.12 0.12 0.12 1 500");
                        Vector3f color = new Vector3f(1.0f, 0.92f, 0.0f);
                        ((ServerWorld) world).spawnParticles((ServerPlayerEntity) user, new DustParticleEffect(color, 1.0f), true, getBlockInFrontX(user, i), getBlockInFrontY(user), getBlockInFrontZ(user, i), 200, 0.5, 0.5, 0.5, 0.2);
                    }
                    //serverCommand((ServerWorld) world, user, "tp @s ^ ^ ^25");
                    user.teleport(getBlockInFrontX(user, 10), getBlockInFrontY(user), getBlockInFrontZ(user, 10), false);
                    //serverCommand((ServerWorld) world, user, "summon minecraft:creeper ^ ^ ^10 {Fuse:0,ignited:1b}");
                    world.createExplosion(user, user.getX(), user.getY(), user.getZ(), 7.0F, World.ExplosionSourceType.TNT);
                }

                if (count == 3) {
                    Text protisiumA = Text.literal("Protisium Activated!").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0 << 16 | 255 << 8 | 255)));
                    user.sendMessage(protisiumA, true);
                    //serverCommand((ServerWorld) world, user, "execute as @s run effect give @e[distance=..10] regeneration 7 3");
                    double radius = 10.0;
                    for (Entity entity : world.getEntitiesByClass(Entity.class, user.getBoundingBox().expand(radius), e -> true)) {
                        // Check if the entity is an instance of LivingEntity
                        if (entity instanceof LivingEntity livingEntity) {
                            if (livingEntity.squaredDistanceTo(user) <= radius * radius) {
                                // Apply levitation effect
                                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 140, 3)); // 100 ticks = 5 seconds, amplifier 2
                            }
                        }
                    }
                    //serverCommand((ServerWorld) world, user, "execute at @s run particle dust{color:[0.000,1.000,0.880],scale:1} ~ ~ ~ 5 0.1 5 1 10000");
                    Vector3f color = new Vector3f(0.000f, 1.000f, 0.880f);
                    ((ServerWorld) world).spawnParticles((ServerPlayerEntity) user, new DustParticleEffect(color, 1.0f), true, user.getX(), user.getY(), user.getZ(), 1000, 5, 0.1, 5, 1);
                }
            }
        }
        return TypedActionResult.success(stack);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player && !world.isClient && world instanceof ServerWorld) {
            serverCommand((ServerWorld) world, player, "execute at @e[type=minecraft:interaction,tag=lazer] if entity @e[distance=..1.7] run execute as @e[distance=..1.7] run effect give @s instant_damage 1 1");

            if (lazerDuration > 0) {
                lazerDuration--;
            }

            if (lazerDuration == 1) {
                for (int i = 3; i <= 18; i++) {
                    //serverCommand((ServerWorld) world, player, "execute at @s run kill @n[tag=lazer" + i + ", distance=..200]");
                    double killRadius = 30.0;
                    for (InteractionEntity iEntity : world.getEntitiesByClass(InteractionEntity.class, player.getBoundingBox().expand(killRadius), e -> true)) {
                        if (iEntity.squaredDistanceTo(player) <= killRadius * killRadius) {
                            if(hasTag(iEntity, "lazer" + i)) {
                                iEntity.kill();
                            }
                        }
                    }
                }
            }

            if (lazerDuration > 1) {
                for (int i = 3; i <= 18; i++) {
                    if (world instanceof ServerWorld serverWorld){
                        serverCommand((ServerWorld) world, player, "execute at @s run particle dust{color:[1.000,0.000,0.000],scale:1} ^ ^ ^" + i + " 0.25 0.25 0.25 1 1000");
                        //Vector3f color = new Vector3f(1.000f, 0.000f, 0.00f);
                        //((ServerWorld) world).spawnParticles(new DustParticleEffect(color, 1.0f), getBlockInFrontX(player, i), player.getY() + 1, getBlockInFrontZ(player, i), 30, 0.3, 0.3, 0.3, 1);
                        serverCommand((ServerWorld) world, player, "execute at @s run tp @e[tag=lazer" + i + ", limit=1, sort=nearest] ^ ^ ^" + i);
                        /*double teleportRadius = 60.0;
                        for (InteractionEntity iEntity : world.getEntitiesByClass(InteractionEntity.class, player.getBoundingBox().expand(teleportRadius), e -> true)) {
                            if (iEntity.squaredDistanceTo(player) <= teleportRadius * teleportRadius) {
                                if(hasTag(iEntity, "lazer" + i)) {
                                    iEntity.teleport(serverWorld, getBlockInFrontX(player, i), player.getY() + 1, getBlockInFrontZ(player, i), EnumSet.noneOf(PositionFlag.class), player.getYaw(), 1f);
                                }
                            }
                        }
                         */
                    }
                }
            }

            if (glowingDuration > 0) {
                glowingDuration--;
                //serverCommand((ServerWorld) world, player, "execute as @s at @e[distance=..10] run particle dust{color:[1.000,0.480,0.000],scale:1} ~ ~ ~ 0.6 0.6 0.6 1 50");
                double glowingRadius = 10.0;
                for (Entity rEntity : world.getEntitiesByClass(Entity.class, player.getBoundingBox().expand(glowingRadius), e -> true)) {
                    if (rEntity.squaredDistanceTo(player) <= glowingRadius * glowingRadius) {
                        Vector3f color = new Vector3f(1.000f, 0.480f, 0.00f);
                        ((ServerWorld) world).spawnParticles(new DustParticleEffect(color, 1.0f), rEntity.getX(), rEntity.getY(), rEntity.getZ(), 1000, 0.7, 0.7, 0.7, 1);
                    }
                }
            }
        }
    }
}
