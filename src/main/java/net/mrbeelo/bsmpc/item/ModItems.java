package net.mrbeelo.bsmpc.item;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.mrbeelo.bsmpc.BsmpC;
import net.mrbeelo.bsmpc.block.ModBlocks;
import net.mrbeelo.bsmpc.components.ModDataComponentTypes;
import net.mrbeelo.bsmpc.entity.ModEntities;
import net.mrbeelo.bsmpc.item.custom.*;
import net.mrbeelo.bsmpc.sound.ModSounds;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<ItemConvertible> BLACKLIST = new ArrayList<>();

    //REGISTERING

    public static final Item RUBY = register("ruby", new Item(new Item.Settings().maxCount(86)));
    public static final Item RUBY_INGOT = register("ruby_ingot", new Item(new Item.Settings()));
    public static final Item RUBY_CLUSTER = register("ruby_cluster", new Item(new Item.Settings()));
    public static final Item RUBY_SHARD = register("ruby_shard", new Item(new Item.Settings()));
    public static final Item KOKAINA_SEED = register("kokaina_seed", new AliasedBlockItem(ModBlocks.KOKAINA_CROP, new Item.Settings()));
    public static final KokainaItem KOKAINA = register("kokaina", new KokainaItem(new Item.Settings().maxCount(16).food(ModFoodItems.KOKAINA_COMPONENT)));
    public static final SwordItem RUBY_SWORD = register("ruby_sword", new SwordItem(RubyToolMaterial.RUBY, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(RubyToolMaterial.RUBY, 3, -2.4f)))); //2 BONUS DMG INSTEAD OF 1
    public static final PickaxeItem RUBY_PICKAXE = register("ruby_pickaxe", new PickaxeItem(RubyToolMaterial.RUBY, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(RubyToolMaterial.RUBY, 0, -2.8f))));
    public static final AxeItem RUBY_AXE = register("ruby_axe", new AxeItem(RubyToolMaterial.RUBY, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(RubyToolMaterial.RUBY, 5, -2.9f)))); //2 BONUS DMG INSTEAD OF 1
    public static final ShovelItem RUBY_SHOVEL = register("ruby_shovel", new ShovelItem(RubyToolMaterial.RUBY, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(RubyToolMaterial.RUBY, 0.5f, -3f))));
    public static final HoeItem RUBY_HOE = register("ruby_hoe", new HoeItem(RubyToolMaterial.RUBY, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(RubyToolMaterial.RUBY, -6f, 0f))));
    public static final BowItem RUBY_BOW = register("ruby_bow", new BowItem(new Item.Settings().maxDamage(200)));
    public static final ArmorItem RUBY_HELMET = register("ruby_helmet", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(45))));
    public static final ModArmorItem RUBY_CHESTPLATE = register("ruby_chestplate", new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(45))));
    public static final ArmorItem RUBY_LEGGINGS = register("ruby_leggings", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(45))));
    public static final ArmorItem RUBY_BOOTS = register("ruby_boots", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(45))));
    public static final SwordItem RUBY_KNOCKER = register("ruby_knocker", new SwordItem(RubyToolMaterial.RUBY, new Item.Settings().maxDamage(100).attributeModifiers(AttributeModifiersComponent.builder().add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, new EntityAttributeModifier(BsmpC.id("effect.knockback"), 30.0, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).build())));
    public static final Item PISTOL = register("pistol", new PistolItem(new Item.Settings().maxCount(1)));
    public static final Item BULLET = register("bullet", new Item(new Item.Settings()));
    public static final DeathAxeItem DEATH_AXE = register("death_axe", new DeathAxeItem(new Item.Settings().attributeModifiers(DeathAxeItem.createAttributeModifiers(ToolMaterials.IRON, 4997, -3.5f))));
    public static final NukeButtonItem NUKE_BUTTON = register("nuke_button", new NukeButtonItem(new Item.Settings().maxCount(1)));
    public static final MBSItem MASTER_BEELO_STAFF = register("master_beelo_staff", new MBSItem(new Item.Settings().maxCount(1).component(ModDataComponentTypes.MBS_STAGE, 0)));
    public static final Item XO_MUSIC_DISC = register("xo_music_disc", new Item(new Item.Settings().jukeboxPlayable(ModSounds.XO_KEY)));
    public static final Item RANDOM_ARTIFACT = register("random_artifact", new RandomArtifactItem(new Item.Settings().maxCount(1)));
    public static final PokeBallItem POKE_BALL = register("poke_ball", new PokeBallItem(new Item.Settings()));
    public static final Item WARDEN_HORN = register("warden_horn", new Item(new Item.Settings()));
    public static final SwordItem WARDEN_SWORD = register("warden_sword", new SwordItem(WardenToolMaterial.WARDEN_HORN, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(WardenToolMaterial.WARDEN_HORN, 3, -2.4f))));
    public static final ArmorItem SNEK_HELMET = register("snek_helmet", new ArmorItem(ModArmorMaterials.SNEK, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(50))));
    public static final ModArmorItem SNEK_CHESTPLATE = register("snek_chestplate", new ModArmorItem(ModArmorMaterials.SNEK, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(50))));
    public static final ArmorItem SNEK_LEGGINGS = register("snek_leggings", new ArmorItem(ModArmorMaterials.SNEK, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(50))));
    public static final ArmorItem SNEK_BOOTS = register("snek_boots", new ArmorItem(ModArmorMaterials.SNEK, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(50))));
    public static final Item SNEK_SCALE = register("snek_scale", new Item(new Item.Settings()));
    public static final Item SNEK_SPAWN_EGG = register("snek_spawn_egg", new SpawnEggItem(ModEntities.SNEK, 0x78fa40, 0x5ed32b, new Item.Settings()));
    public static final Item BLOB_SPAWN_EGG = register("blob_spawn_egg", new SpawnEggItem(ModEntities.BLOB, 0x7bd4ff, 0xffa7a4, new Item.Settings()));
    public static final Item PYRO_SPAWN_EGG = register("pyro_spawn_egg", new SpawnEggItem(ModEntities.PYRO, 0x3e3e42, 0xd21129, new Item.Settings()));
    public static final JetpackItem JETPACK = register("jetpack", new JetpackItem(ModArmorMaterials.JETPACK, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(20000)));


    //METHODS

    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registries.ITEM, BsmpC.id(name), item);
    }

    public static void registerModItems() {}
}
