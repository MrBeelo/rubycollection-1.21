package net.mrbeelo.rubycollection.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.mrbeelo.rubycollection.Rubycollection;
import net.mrbeelo.rubycollection.block.ModBlocks;
import net.mrbeelo.rubycollection.effect.ModEffects;
import net.mrbeelo.rubycollection.enchantment.ModEnchantments;
import net.mrbeelo.rubycollection.fluid.ModFluids;
import net.mrbeelo.rubycollection.item.ModItemGroups;
import net.mrbeelo.rubycollection.item.ModItems;
import net.mrbeelo.rubycollection.potion.ModPotions;
import net.mrbeelo.rubycollection.sound.ModSounds;
import net.mrbeelo.rubycollection.villager.ModVillagers;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import net.minecraft.sound.SoundEvent;

public class ModTranslationProvider extends FabricLanguageProvider {
    public ModTranslationProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    private static void addText(@NotNull TranslationBuilder builder, @NotNull Text text, @NotNull String value) {
        if (text.getContent() instanceof TranslatableTextContent translatableTextContent) {
            builder.add(translatableTextContent.getKey(), value);
        } else {
            Rubycollection.LOGGER.warn("Cannot translate text: {}", text.getString());
        }
    }

    private static void addSoundEvent(@NotNull TranslationBuilder builder, @NotNull SoundEvent soundEvent, @NotNull String value) {
        String key = "sound." + soundEvent.getId().toString().replace(":", ".");
        builder.add(key, value);
    }

    private static void addVillager(@NotNull TranslationBuilder builder, @NotNull VillagerProfession villagerProfession, @NotNull String value) {
        String key = "entity.minecraft.villager." + villagerProfession.id();
        builder.add(key, value);
    }

    private static void addPotionTranslations(@NotNull TranslationBuilder builder, RegistryEntry<Potion> potionEntry, @NotNull String value) {
        Potion potion = potionEntry.value();
        Identifier potionId = Registries.POTION.getId(potion);

        if (potionId != null) {
            String baseKey = "item.minecraft.potion.effect." + potionId.getPath();
            builder.add(baseKey, "Potion of " + value); // Customize translation value

            String splashKey = "item.minecraft.splash_potion.effect." + potionId.getPath();
            builder.add(splashKey, "Splash Potion of " + value); // Customize translation value

            String lingeringKey = "item.minecraft.lingering_potion.effect." + potionId.getPath();
            builder.add(lingeringKey, "Lingering Potion of " + value); // Customize translation value

            String tippedArrowKey = "item.minecraft.tipped_arrow.effect." + potionId.getPath();
            builder.add(tippedArrowKey, "Tipped Arrow with " + value); // Customize translation value
        }
    }

    private static void addPainting(@NotNull TranslationBuilder builder, @NotNull String paintingId, @NotNull String paintingName, @NotNull String paintingAuthor) {
        String paintingKey = "painting.rubycollection." + paintingId + ".title";
        String paintingAuthorKey = "painting.rubycollection." + paintingId + ".author";
        builder.add(paintingKey, paintingName);
        builder.add(paintingAuthorKey, paintingAuthor);
    }

    private static void addMusicDisc(@NotNull TranslationBuilder builder, @NotNull String discId, @NotNull String discName, @NotNull String discDescription) {
        String discKey = "item.rubycollection." + discId;
        String discDescriptionKey = "item.rubycollection." + discId + ".desc";
        builder.add(discKey, discName);
        builder.add(discDescriptionKey, discDescription);
    }

    /*private static void addKartusCard(@NotNull TranslationBuilder builder, @NotNull KartusItem itemEntry, @NotNull String value) {
        Identifier itemId = Registries.ITEM.getId(itemEntry);
        int attackId = KartusItem.getAttack();
        int defenceId = KartusItem.getDefence();
        String kartusKey = "item.rubycollection." + itemId.getPath();
        builder.add(kartusKey, value + " (Attack: " + attackId + ", Defence: " + defenceId + ")");
    }
     */


    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.RUBY, "Ruby");
        translationBuilder.add(ModItems.RUBY_INGOT, "Ruby Ingot");
        translationBuilder.add(ModItems.RUBY_CLUSTER, "Ruby Cluster");
        translationBuilder.add(ModItems.RUBY_SHARD, "Ruby Shard");
        translationBuilder.add(ModItems.KOKAINA, "Kokaina");
        translationBuilder.add(ModItems.KOKAINA_SEED, "Kokaina Seed");
        translationBuilder.add(ModItems.RUBY_KNOCKER, "Overly named device featuring retractable hand able of pushing living entities away from entity using device");
        translationBuilder.add(ModItems.RUBY_SWORD, "Ruby Sword");
        translationBuilder.add(ModItems.RUBY_PICKAXE, "Ruby Pickaxe");
        translationBuilder.add(ModItems.RUBY_AXE, "Ruby Axe");
        translationBuilder.add(ModItems.RUBY_SHOVEL, "Ruby Shovel");
        translationBuilder.add(ModItems.RUBY_HOE, "Ruby Hoe");
        translationBuilder.add(ModItems.RUBY_BOW, "Ruby Bow");
        translationBuilder.add(ModItems.RUBY_HELMET, "Ruby Helmet");
        translationBuilder.add(ModItems.RUBY_CHESTPLATE, "Ruby Chestplate");
        translationBuilder.add(ModItems.RUBY_LEGGINGS, "Ruby Leggings");
        translationBuilder.add(ModItems.RUBY_BOOTS, "Ruby Boots");
        translationBuilder.add(ModBlocks.RUBY_BLOCK, "Ruby Block");
        translationBuilder.add(ModBlocks.RUBY_ORE, "Ruby Ore");
        translationBuilder.add(ModBlocks.DEEPSLATE_RUBY_ORE, "Deepslate Ruby Ore");
        translationBuilder.add(ModBlocks.NETHER_RUBY_ORE, "Nether Ruby Ore");
        translationBuilder.add(ModBlocks.END_RUBY_ORE, "End Ruby Ore");
        translationBuilder.add(ModBlocks.RUBY_STAIRS, "Ruby Stairs");
        translationBuilder.add(ModBlocks.RUBY_SLAB, "Ruby Slab");
        translationBuilder.add(ModBlocks.RUBY_BUTTON, "Ruby Button");
        translationBuilder.add(ModBlocks.RUBY_PRESSURE_PLATE, "Ruby Pressure Plate");
        translationBuilder.add(ModBlocks.RUBY_FENCE, "Ruby Fence");
        translationBuilder.add(ModBlocks.RUBY_FENCE_GATE, "Ruby Fence Gate");
        translationBuilder.add(ModBlocks.RUBY_WALL, "Ruby Wall");
        translationBuilder.add(ModBlocks.RUBY_DOOR, "Ruby Door");
        translationBuilder.add(ModBlocks.RUBY_TRAPDOOR, "Ruby Trapdoor");
        translationBuilder.add(ModEffects.HIGH.value(), "High");
        translationBuilder.add(ModItems.PISTOL, "Tactical Pistol");
        translationBuilder.add(ModItems.BULLET, "Bullet");
        translationBuilder.add(ModBlocks.PACKED_IRON_BLOCK, "Packed Iron Block");
        translationBuilder.add(ModItems.DEATH_AXE, "Death Axe");
        translationBuilder.add(ModItems.NUKE_BUTTON, "핵 버튼");
        translationBuilder.add(ModItems.MASTER_BEELO_STAFF, "Master Beelo Staff");
        translationBuilder.add(ModBlocks.SMOOTH_QUARTZ_RUBY_UPGRADER, "Smooth Quartz Ruby Upgrader");
        translationBuilder.add(ModBlocks.SMOOTH_QUARTZ_RUBY_DOWNGRADER, "Smooth Quartz Ruby Downgrader");
        translationBuilder.add(ModBlocks.PEDESTAL, "Pedestal");
        translationBuilder.add(ModItems.SNEK_SPAWN_EGG, "Snek Spawn Egg");
        translationBuilder.add(ModFluids.FROOTOP_BUCKET, "Bucket of Frootop");
        translationBuilder.add(ModItems.SC_AMMO, "Ammo Soul Card");
        translationBuilder.add(ModItems.SC_BOOK_OF_LIFE, "Book Of Life Soul Card");
        translationBuilder.add(ModItems.SC_DOMINION, "Dominion Soul Card");
        translationBuilder.add(ModItems.SC_ELEVATE, "Elevate Soul Card");
        translationBuilder.add(ModItems.SC_FIREBALL, "Fireball Soul Card");
        translationBuilder.add(ModItems.SC_FIST, "Fist Soul Card");
        translationBuilder.add(ModItems.SC_GODSPEED, "Godspeed Soul Card");
        translationBuilder.add(ModItems.SC_HEALTH, "Health Soul Card");
        translationBuilder.add(ModItems.SC_KATANA, "Katana Soul Card");
        translationBuilder.add(ModItems.SC_PURIFY, "Purify Soul Card");
        translationBuilder.add(ModItems.SC_STOMP, "Stomp Soul Card");
        translationBuilder.add(ModBlocks.RGB_BLOCK, "RGB Block");
        translationBuilder.addEnchantment(ModEnchantments.BANG_EFFECT_KEY, "Bang");
        addSoundEvent(translationBuilder, ModSounds.RUBY_BLOCK_BREAK, "Ruby Block Broken");
        addSoundEvent(translationBuilder, ModSounds.RUBY_BLOCK_FALL, "Ruby Block Fallen");
        addSoundEvent(translationBuilder, ModSounds.RUBY_BLOCK_HIT, "Ruby Block Hit");
        addSoundEvent(translationBuilder, ModSounds.RUBY_BLOCK_STEP, "Ruby Block Stepped On");
        addSoundEvent(translationBuilder, ModSounds.RUBY_BLOCK_PLACE, "Ruby Block Placed");
        addSoundEvent(translationBuilder, ModSounds.HIGH, "High Person Running");
        addSoundEvent(translationBuilder, ModSounds.PEW, "Gunshot");
        addText(translationBuilder, ModItemGroups.RUBY_ITEM_GROUP.getDisplayName(), "The Ruby Collection");
        addText(translationBuilder, ModItemGroups.BSMPS3_ARTIFACTS.getDisplayName(), "BSMPS3 Artifacts");
        addText(translationBuilder, ModItemGroups.NEON_WHITE_SOUL_CARDS.getDisplayName(), "Neon White Soul Cards");
        addVillager(translationBuilder, ModVillagers.RUBERT, "Rubert");
        addPotionTranslations(translationBuilder, ModPotions.KOKAINA, "Kokaina");
        addPainting(translationBuilder, "world", "The World Of Errors", "MrBeelo");
        addMusicDisc(translationBuilder, "xo_music_disc", "XO Music Disc", "XO (eden cover and remake)");

    }
}


