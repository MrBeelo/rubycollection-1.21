package net.mrbeelo.bsmpc.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.mrbeelo.bsmpc.entity.ModEntities;
import net.mrbeelo.bsmpc.entity.custom.BulletProjectileEntity;
import net.mrbeelo.bsmpc.item.ModItems;
import net.mrbeelo.bsmpc.sound.ModSounds;

import java.util.List;

public class PistolItem extends Item {
    public PistolItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        ItemStack gunStack = user.getStackInHand(hand);

        boolean hasBullet = false;
        for (int i = 0; i < user.getInventory().size(); i++) {
            ItemStack bulletStack = user.getInventory().getStack(i);
            if (bulletStack.getItem() == ModItems.BULLET) {
                bulletStack.decrement(1);
                hasBullet = true;
                break;
            }
        }

        if (hasBullet) {
            user.getItemCooldownManager().set(gunStack.getItem(), 30);
            BulletProjectileEntity bullet = new BulletProjectileEntity(ModEntities.BULLET_PROJECTILE, world);
            bullet.setPos(user.getX(), user.getEyeY() - 0.1, user.getZ());
            bullet.setOwner(user);
            bullet.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 4.0F, 1.0F);
            world.spawnEntity(bullet);
            user.getWorld().playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.PEW, user.getSoundCategory(), 4.0F, 1.0F);
        } else {
            user.sendMessage(Text.of("Out of bullets!"), true);
            user.getWorld().playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.MAGEMPTY, user.getSoundCategory(), 1.0F, 1.0F);
        }

        return TypedActionResult.success(gunStack);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(!Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Press §eShift§r to learn more!"));
        } else {
            tooltip.add(Text.literal("An item that when right clicked, fires a bullet, if the player has one."));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
