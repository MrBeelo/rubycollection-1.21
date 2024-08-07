package net.mrbeelo.rubycollection.sound;

import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.mrbeelo.rubycollection.Rubycollection;


public class ModSounds {

    //REGISTERING

    public static final SoundEvent RUBY_BLOCK_BREAK = register("ruby_block_break");
    public static final SoundEvent RUBY_BLOCK_STEP = register("ruby_block_step");
    public static final SoundEvent RUBY_BLOCK_PLACE = register("ruby_block_place");
    public static final SoundEvent RUBY_BLOCK_HIT = register("ruby_block_hit");
    public static final SoundEvent RUBY_BLOCK_FALL = register("ruby_block_fall");
    public static final SoundEvent HIGH = register("high");
    public static final SoundEvent PEW = register("pew");
    public static final SoundEvent MAGEMPTY = register("magempty");
    public static final SoundEvent BEEP = register("beep");
    public static final SoundEvent GNOME = register("gnome");
    public static final SoundEvent CORRECT = register("correct");
    public static final SoundEvent INCORRECT = register("incorrect");
    public static final SoundEvent XO = register("xo");
    public static final RegistryKey<JukeboxSong> XO_KEY = of("xo");

    public static final BlockSoundGroup RUBY_BLOCK_SOUNDS = new BlockSoundGroup(1f, 1f,
            ModSounds.RUBY_BLOCK_BREAK, ModSounds.RUBY_BLOCK_STEP, ModSounds.RUBY_BLOCK_PLACE,
            ModSounds.RUBY_BLOCK_HIT, ModSounds.RUBY_BLOCK_FALL);

    //METHODS

    private static RegistryKey<JukeboxSong> of(String name) {
        return RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Rubycollection.id(name));
    }

    private static SoundEvent register(String name) {
        return Registry.register(Registries.SOUND_EVENT, Rubycollection.id(name), SoundEvent.of(Rubycollection.id(name)));
    }

    public static void registerModSounds() {}
}
