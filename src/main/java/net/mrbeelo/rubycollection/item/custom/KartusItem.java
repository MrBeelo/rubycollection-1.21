package net.mrbeelo.rubycollection.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mrbeelo.rubycollection.Rubycollection;

import java.util.List;


public class KartusItem extends Item {
    public int attack;
    public int defence;

    public KartusItem(Settings settings, int attack, int defence) {
        super(settings);
        this.attack = attack;
        this.defence = defence;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("(Attack: " + getAttack() + " / Defence: " + getDefence() + ")"));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
