package com.viktoriia_abakumova.task6.subtask2.stringobjects.inheritors;

import com.viktoriia_abakumova.task6.subtask2.stringobjects.MyString;

public class MyStringA extends MyString {

    public MyStringA(String string) {
        super(string);
    }

    @Override
    public int hashCode() {
        return string.length();
    }

    @Override
    public String toString() {
        return this.string;
    }
}
