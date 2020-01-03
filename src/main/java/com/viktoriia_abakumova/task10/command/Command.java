package com.viktoriia_abakumova.task10.command;

import java.io.PrintWriter;

public abstract class Command {
    protected PrintWriter out;

    public abstract void execute(String n1, String p2);

    protected int parseData(String param) {
        return Integer.parseInt(param);
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }
}
