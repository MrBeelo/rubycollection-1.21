package net.mrbeelo.bsmpc.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class KokainaItem extends Item {
    public KokainaItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(!Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Press §eShift§r to learn more!"));
        } else {
            tooltip.add(Text.literal("A food item that gives the player a speed boost and various nautious"));
            tooltip.add(Text.literal("effects to the player when eaten."));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
