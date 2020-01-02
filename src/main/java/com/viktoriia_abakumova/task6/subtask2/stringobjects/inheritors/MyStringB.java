package com.viktoriia_abakumova.task6.subtask2.stringobjects.inheritors;

import com.viktoriia_abakumova.task6.subtask2.stringobjects.MyString;

public class MyStringB extends MyString {

    public MyStringB(String string) {
        super(string);
    }

    @Override
    public int hashCode() {
        int sum = 0;
        char[] chars = string.toCharArray();
        for (int i = 0; i < 4; i++) {
            sum += chars[i];
        }
        return sum;
    }

    @Override
    public String toString() {
        return this.string;
    }
}
