package net.mrbeelo.rubycollection.item;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.mrbeelo.rubycollection.Rubycollection;
import net.mrbeelo.rubycollection.block.ModBlocks;
import net.mrbeelo.rubycollection.components.ModDataComponentTypes;
import net.mrbeelo.rubycollection.entity.ModEntities;
import net.mrbeelo.rubycollection.item.custom.*;
import net.mrbeelo.rubycollection.item.custom.neon_white.*;
import net.mrbeelo.rubycollection.sound.ModSounds;

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
    public static final SwordItem RUBY_SWORD = register("ruby_sword", new SwordItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RUBY, 3, -2.4f)))); //2 BONUS DMG INSTEAD OF 1
    public static final PickaxeItem RUBY_PICKAXE = register("ruby_pickaxe", new PickaxeItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.RUBY, 0, -2.8f))));
    public static final AxeItem RUBY_AXE = register("ruby_axe", new AxeItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.RUBY, 5, -2.9f)))); //2 BONUS DMG INSTEAD OF 1
    public static final ShovelItem RUBY_SHOVEL = register("ruby_shovel", new ShovelItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.RUBY, 0.5f, -3f))));
    public static final HoeItem RUBY_HOE = register("ruby_hoe", new HoeItem(ModToolMaterials.RUBY, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.RUBY, -6f, 0f))));
    public static final BowItem RUBY_BOW = register("ruby_bow", new BowItem(new Item.Settings().maxDamage(200)));
    public static final ArmorItem RUBY_HELMET = register("ruby_helmet", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(45))));
    public static final ModArmorItem RUBY_CHESTPLATE = register("ruby_chestplate", new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(45))));
    public static final ArmorItem RUBY_LEGGINGS = register("ruby_leggings", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(45))));
    public static final ArmorItem RUBY_BOOTS = register("ruby_boots", new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(45))));
    public static final SwordItem RUBY_KNOCKER = register("ruby_knocker", new SwordItem(ModToolMaterials.RUBY, new Item.Settings().maxDamage(100).attributeModifiers(AttributeModifiersComponent.builder().add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, new EntityAttributeModifier(Rubycollection.id("effect.knockback"), 30.0, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.MAINHAND).build())));
    public static final Item PISTOL = register("pistol", new PistolItem(new Item.Settings().maxCount(1)));
    public static final Item BULLET = register("bullet", new Item(new Item.Settings()));
    public static final DeathAxeItem DEATH_AXE = register("death_axe", new DeathAxeItem(new Item.Settings().attributeModifiers(DeathAxeItem.createAttributeModifiers(ToolMaterials.IRON, 997, -3.5f))));
    public static final NukeButtonItem NUKE_BUTTON = register("nuke_button", new NukeButtonItem(new Item.Settings().maxCount(1)));
    public static final MBSItem MASTER_BEELO_STAFF = register("master_beelo_staff", new MBSItem(new Item.Settings().maxCount(1).component(ModDataComponentTypes.MBS_STAGE, 0)));
    public static final Item SNEK_SPAWN_EGG = register("snek_spawn_egg", new SpawnEggItem(ModEntities.SNEK, 0x78fa40, 0x5ed32b, new Item.Settings()));
    public static final Item XO_MUSIC_DISC = register("xo_music_disc", new Item(new Item.Settings().jukeboxPlayable(ModSounds.XO_KEY)));
    public static final Item SC_AMMO = register("sc_ammo", new SCAmmoItem(new Item.Settings()));
    public static final Item SC_BOOK_OF_LIFE = register("sc_book_of_life", new SCBookOfLifeItem(new Item.Settings().maxCount(3)));
    public static final Item SC_DOMINION = register("sc_dominion", new Item(new Item.Settings().maxCount(3)));
    public static final Item SC_ELEVATE = register("sc_elevate", new SCElevateItem(new Item.Settings().maxCount(3)));
    public static final Item SC_FIREBALL = register("sc_fireball", new SCFireballItem(new Item.Settings().maxCount(3)));
    public static final Item SC_FIST = register("sc_fist", new AxeItem(ToolMaterials.IRON, new Item.Settings().maxCount(1).attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.IRON, 2, -2.9f))));
    public static final Item SC_GODSPEED = register("sc_godspeed", new SCGodspeedItem(new Item.Settings().maxCount(3)));
    public static final Item SC_HEALTH = register("sc_health", new SCHealthItem(new Item.Settings()));
    public static final Item SC_KATANA = register("sc_katana", new SwordItem(ToolMaterials.IRON, new Item.Settings().maxCount(1).attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.IRON, 2, -2.4f))));
    public static final Item SC_PURIFY = register("sc_purify", new SCPurifyItem(new Item.Settings().maxCount(3)));
    public static final Item SC_STOMP = register("sc_stomp", new SCStompItem(new Item.Settings().maxCount(3)));
    public static final PokeBallItem POKE_BALL = register("poke_ball", new PokeBallItem(new Item.Settings()));


    //METHODS

    public static <T extends Item> T register(String name, T item) {
        return Registry.register(Registries.ITEM, Rubycollection.id(name), item);
    }

    public static void registerModItems() {}
}
