package com.viktoriia_abakumova.lesson1.task1;

import com.viktoriia_abakumova.lesson1.task1.parts.Task1;
import com.viktoriia_abakumova.lesson1.task1.parts.Task2;
import com.viktoriia_abakumova.lesson1.task1.parts.Task3;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        new Demo().startApplication();
    }

    private void startApplication() {
        Scanner scanner = new Scanner(System.in);

        new Task1().executeTask1();
        new Task2(scanner).executeTask2();
        new Task3(scanner).executeTask3();

        scanner.close();
    }
}
