package net.mrbeelo.bsmpc.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.Objects;

import static net.mrbeelo.bsmpc.BsmpC.scheduleTicks;

public class JetpackItem extends ArmorItem {
    public int boostTime = 100;
    public JetpackItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof ServerPlayerEntity player && world instanceof ServerWorld serverWorld) {
            if (player.getInventory().getArmorStack(2).getItem() instanceof JetpackItem) {
                player.sendMessage(Text.of("Boost left: " + boostTime), true);
                if (player.isSneaking() && !player.isOnGround() && boostTime > 0) {
                    player.setVelocity(player.getVelocity().x, player.getVelocity().y + 0.1, player.getVelocity().z);
                    player.velocityModified = true;
                    boostTime--;
                    player.getInventory().getArmorStack(2).damage(1, serverWorld, player, item ->
                            Objects.requireNonNull(player).sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
                    player.getInventory().markDirty();
                } else if (boostTime < 100) {
                    boostTime++;
                } else {
                    boostTime = 100;
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
