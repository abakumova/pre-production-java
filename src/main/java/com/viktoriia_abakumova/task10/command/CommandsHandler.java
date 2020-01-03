package com.viktoriia_abakumova.task10.command;

import com.viktoriia_abakumova.task10.command.inheritors.Addition;
import com.viktoriia_abakumova.task10.command.inheritors.Division;
import com.viktoriia_abakumova.task10.command.inheritors.Multiplication;
import com.viktoriia_abakumova.task10.command.inheritors.Subtraction;

import java.util.HashMap;
import java.util.Map;

public class CommandsHandler {

    private static Map<String, Command> commands = new HashMap<>();

    static {
        commands.put("Addition", new Addition());
        commands.put("Division", new Division());
        commands.put("Subtraction", new Subtraction());
        commands.put("Multiplication", new Multiplication());
    }

    public static Command getCommand(String command) {
        return commands.get(command);
    }
}
