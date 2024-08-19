package net.mrbeelo.bsmpc.command.custom;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.mrbeelo.bsmpc.sound.ModSounds;

public class IncorrectCommand {
    public static void register(CommandDispatcher<ServerCommandSource> serverCommandSourceCommandDispatcher,
                                CommandRegistryAccess commandRegistryAccess,
                                CommandManager.RegistrationEnvironment registrationEnvironment) {
        serverCommandSourceCommandDispatcher.register(CommandManager.literal("incorrect").executes(IncorrectCommand::run));
    }

    private static int run(CommandContext<ServerCommandSource> context) {
        PlayerEntity player = context.getSource().getPlayer();
        assert player != null;
        player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(), ModSounds.INCORRECT, player.getSoundCategory(), 5.0F, 1.0F);
        return 1;
    }
}
