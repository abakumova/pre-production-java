package com.viktoriia_abakumova.task10.command.inheritors;

import com.viktoriia_abakumova.task10.command.Command;

public class Multiplication extends Command {

    @Override
    public void execute(String n1, String n2) {
        out.println(parseData(n1) * parseData(n2));
    }
}
