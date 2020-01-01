package com.viktoriia_abakumova.lesson1.task1.parts;

public class Task1 {

    private int[] array = {5, 8, -7, -3, 8, 4, 2, 7, 9, -5, 1, 0, -1, -4, -3, 10, 2, 4, -8, -2};

    public void executeTask1() {
        printArray();
        multiplePositiveNumberBeforeNegative();
        printArray();
    }

    private void multiplePositiveNumberBeforeNegative() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < 0 && array[i] > 0) {
                array[i] *= 3;
            }
        }
    }

    private void printArray() {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
