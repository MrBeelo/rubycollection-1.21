package net.mrbeelo.rubycollection.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.mrbeelo.rubycollection.item.ModItems;
import net.mrbeelo.rubycollection.sound.ModSounds;

public class PistolItem extends Item {
    public PistolItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        // Ensure we don't execute this code on the client to prevent desync.
        if (world.isClient) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        ItemStack gunStack = user.getStackInHand(hand);



        // Find and decrement the bullet stack
        boolean hasBullet = false;
        for (int i = 0; i < user.getInventory().size(); i++) {
            ItemStack bulletStack = user.getInventory().getStack(i);
            if (bulletStack.getItem() == ModItems.BULLET) {
                bulletStack.decrement(1);
                hasBullet = true;
                break;
            }
        }

        // If a bullet was found and decremented, shoot the arrow
        if (hasBullet) {
            // Create and shoot an arrow
            ArrowEntity arrow = new ArrowEntity(EntityType.ARROW, world);
            arrow.setPos(user.getX(), user.getEyeY() - 0.1, user.getZ());
            arrow.setOwner(user);
            arrow.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 3.0F, 1.0F);
            world.spawnEntity(arrow);
            user.getWorld().playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.PEW, user.getSoundCategory(), 4.0F, 1.0F);
        } else {
            // Notify the player they are out of bullets
            user.sendMessage(Text.of("Out of bullets!"), true);
            user.getWorld().playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.MAGEMPTY, user.getSoundCategory(), 1.0F, 1.0F);
        }

        // Return the gun item stack wrapped in TypedActionResult.success
        return TypedActionResult.success(gunStack);
    }
}
