package net.mrbeelo.rubycollection.command.custom;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.mrbeelo.rubycollection.sound.ModSounds;
import net.mrbeelo.rubycollection.util.IEntityDataSaver;

import java.util.Objects;

public class GnomeCommand {
    public static void register(CommandDispatcher<ServerCommandSource> serverCommandSourceCommandDispatcher,
                                CommandRegistryAccess commandRegistryAccess,
                                CommandManager.RegistrationEnvironment registrationEnvironment) {
        serverCommandSourceCommandDispatcher.register(CommandManager.literal("gnome").executes(GnomeCommand::run));
    }

    private static int run(CommandContext<ServerCommandSource> context) {
        PlayerEntity player = context.getSource().getPlayer();
        assert player != null;
        player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.GNOME, player.getSoundCategory(), 5.0F, 1.0F);
        return 1;
    }
}
