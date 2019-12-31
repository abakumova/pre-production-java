package com.viktoriia_abakumova.lesson6.task6.subtask2;

import com.viktoriia_abakumova.lesson6.task6.subtask2.stringobjects.MyString;
import com.viktoriia_abakumova.lesson6.task6.subtask2.stringobjects.inheritors.MyStringA;
import com.viktoriia_abakumova.lesson6.task6.subtask2.stringobjects.inheritors.MyStringB;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SubTask2 {

    public static void demoMap() {
        Map<MyString, Product> mapA = new HashMap<>();
        fullMapA(mapA);
        printMap(mapA);

        System.out.println();

        Map<MyString, Product> mapB = new LinkedHashMap<>();
        fullMapA(mapB);
        printMap(mapB);
    }

    public static void demoLinkedHashMap() {
        Map<MyString, Product> mapA = new HashMap<>();
        fullMapB(mapA);
        printMap(mapA);

        System.out.println();

        Map<MyString, Product> mapB = new LinkedHashMap<>();
        fullMapB(mapB);
        printMap(mapB);
    }

    private static void printMap(Map<MyString, Product> map) {
        for (Map.Entry<MyString, Product> entry : map.entrySet()) {
            System.out.println(String.format("Key: %s, value: %s",
                    entry.getKey(), entry.getValue()));
        }
    }

    private static void fullMapA(Map<MyString, Product> map) {
        map.put(new MyStringA("qwerty"), new Product(1));
        map.put(new MyStringA("asdfg"), new Product(2));
        map.put(new MyStringA("zxcvbn"), new Product(3));
    }

    private static void fullMapB(Map<MyString, Product> map) {
        map.put(new MyStringB("qwerty"), new Product(1));
        map.put(new MyStringB("asdfg"), new Product(2));
        map.put(new MyStringB("zxcvbn"), new Product(3));
    }
}
