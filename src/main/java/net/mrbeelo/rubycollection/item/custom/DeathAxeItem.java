package net.mrbeelo.rubycollection.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvents;

public class DeathAxeItem extends AxeItem {
    public DeathAxeItem(Settings settings) {
        super(ToolMaterials.IRON, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.getWorld().playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), SoundEvents.BLOCK_ANVIL_LAND, attacker.getSoundCategory(), 4.0F, 1.0F);
        stack.decrement(1);
        return true;
    }
}
