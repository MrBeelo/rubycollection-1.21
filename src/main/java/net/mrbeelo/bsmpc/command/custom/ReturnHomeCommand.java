package net.mrbeelo.bsmpc.command.custom;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.mrbeelo.bsmpc.server.IEntityDataSaver;

public class ReturnHomeCommand {
    public static void register(CommandDispatcher<ServerCommandSource> serverCommandSourceCommandDispatcher,
                                CommandRegistryAccess commandRegistryAccess,
                                CommandManager.RegistrationEnvironment registrationEnvironment) {
        serverCommandSourceCommandDispatcher.register(CommandManager.literal("home")
                .then(CommandManager.literal("return").requires(serverCommandSource -> serverCommandSource.hasPermissionLevel(2)).executes(ReturnHomeCommand::run)));
    }

    private static int run(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        IEntityDataSaver player = (IEntityDataSaver)context.getSource().getPlayer();

        int[] homepos = player.getPersistentData().getIntArray("bsmpc.homepos");

        if(homepos.length != 0) {
            context.getSource().getPlayer().requestTeleport(homepos[0], homepos[1], homepos[2]);
            context.getSource().sendFeedback(() -> Text.literal("Player returned Home!"), false);
            return 1;
        } else {
            context.getSource().sendFeedback(() -> Text.literal("No Home Position has been Set!"), false);
            return -1;
        }
    }
}
