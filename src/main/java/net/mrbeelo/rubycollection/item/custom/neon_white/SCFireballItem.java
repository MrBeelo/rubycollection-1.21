package net.mrbeelo.rubycollection.item.custom.neon_white;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class SCFireballItem extends Item {
    public SCFireballItem(Settings settings) {
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

            // Convert yaw and pitch to radians
            double yawRad = Math.toRadians(yaw);
            double pitchRad = Math.toRadians(pitch);

            // Calculate the forward direction vector
            double x = -Math.sin(yawRad) * Math.cos(pitchRad);
            double z = Math.cos(yawRad) * Math.cos(pitchRad);
            double y = -Math.sin(pitchRad);

            Vec3d forward = new Vec3d(x, y, z).normalize();

            // Apply velocity to the player in the forward direction with a slower speed
            user.addVelocity(forward.x * 2, forward.y * 1.2, forward.z * 2); // Adjust multiplier for desired speed
            user.velocityModified = true;

            // Decrement the item stack
            heldStack.decrement(1);

            // Update the player's inventory to reflect the change
            user.getInventory().markDirty();
        }

        return TypedActionResult.success(heldStack);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (!Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Press §eShift§r to learn more!"));
        } else {
            tooltip.add(Text.literal("A §eNeon White Soul Card§r that boosts the player forward and vertically when right clicked and deletes itself."));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
