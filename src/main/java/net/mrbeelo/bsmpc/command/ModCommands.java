package net.mrbeelo.bsmpc.command;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.mrbeelo.bsmpc.command.custom.*;

public class ModCommands {
    public static void registerModCommands() {
        CommandRegistrationCallback.EVENT.register(SetHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(ReturnHomeCommand::register);
        CommandRegistrationCallback.EVENT.register(GnomeCommand::register);
        CommandRegistrationCallback.EVENT.register(CorrectCommand::register);
        CommandRegistrationCallback.EVENT.register(IncorrectCommand::register);
    }
}
