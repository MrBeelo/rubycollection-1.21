package net.mrbeelo.rubycollection.item.custom.neon_white;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class SCGodspeedItem extends Item {
    public SCGodspeedItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) {
            return TypedActionResult.pass(user.getStackInHand(hand));
        }

        ItemStack heldStack = user.getStackInHand(hand);

        if (user != null && world != null) {
            // Calculate the direction the player is looking
            float yaw = user.getYaw();
            float pitch = user.getPitch();

            // Convert yaw to radians
            double yawRad = Math.toRadians(yaw);

            // Calculate the forward direction vector (ignoring pitch for vertical movement)
            double x = -Math.sin(yawRad);
            double z = Math.cos(yawRad);

            Vec3d forward = new Vec3d(x, 0, z).normalize();

            user.addVelocity(forward.x * 40, 0, forward.z * 40);
            user.velocityModified = true;
            heldStack.decrement(1);
            user.getInventory().markDirty();
        }

        return TypedActionResult.success(heldStack);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(!Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Press §eShift§r to learn more!"));
        } else {
            tooltip.add(Text.literal("A §eNeon White Soul Card§r that boosts the player forward when right clicked and deletes itself."));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
