package net.mrbeelo.bsmpc.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.mrbeelo.bsmpc.BsmpC;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModArmorMaterials {

    //REGISTERING

    public static final RegistryEntry<ArmorMaterial> RUBY = register("ruby", Map.of(
                    ArmorItem.Type.HELMET, 5,
                    ArmorItem.Type.CHESTPLATE, 9,
                    ArmorItem.Type.LEGGINGS, 8,
                    ArmorItem.Type.BOOTS, 4
            ),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.ofItems(ModItems.RUBY),
            4,
            0.2F,
            false);

    //METHODS

    public static RegistryEntry<ArmorMaterial> register(String id, Map<ArmorItem.Type, Integer> defencePoints,
                                                        int enchantability, RegistryEntry<SoundEvent> equipSound,
                                                        Supplier<Ingredient> repairIngredient, float toughness,
                                                        float knockbackResistance, boolean dyeable) {
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(BsmpC.id(id), "", dyeable)
        );

        var material = new ArmorMaterial(defencePoints, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance);
        material = Registry.register(Registries.ARMOR_MATERIAL, BsmpC.id(id), material);

        return RegistryEntry.of(material);
    }

    public static void registerModArmorMaterials() {}
}






