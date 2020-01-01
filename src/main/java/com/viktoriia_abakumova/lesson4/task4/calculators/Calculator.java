package com.viktoriia_abakumova.lesson4.task4.calculators;

import java.util.Scanner;

import static java.lang.String.format;

public class Calculator {

    private static final String INPUT_MESSAGE = "Input number %s";
    private Scanner scanner = new Scanner(System.in);
    private int a, b;
    private boolean isContinued = true;

    public Calculator() {
    }

    public int sum(int a, int b) {
        return (a + b);
    }

    public int subtraction(int a, int b) {
        return (a - b);
    }

    public int multiplication(int a, int b) {
        return (a * b);
    }

    public int division(int a, int b) {
        return (a / b);
    }

    private void doMainMenu() {
        int n;
        int numberOfSign;

        System.out.println("1) Enter new numbers");
        System.out.println("2) Do operation");
        System.out.println("3) Exit");

        n = scanner.nextInt();

        switch (n) {
            case 1: {
                System.out.println("Enter new numbers");
                askNumbers();
                break;
            }
            case 2: {
                System.out.println("Do operation");
                System.out.println("    1 +");
                System.out.println("    2 -");
                System.out.println("    3 *");
                System.out.println("    4 /");
                System.out.println("Input digit:");

                numberOfSign = scanner.nextInt();
                doOperation(numberOfSign);
                break;
            }
            case 3: {
                System.out.println("Exit");
                scanner.close();
                isContinued = false;
                break;
            }
        }
    }

    private void askNumbers() {
        System.out.println(format(INPUT_MESSAGE, "A"));
        a = scanner.nextInt();
        System.out.println(format(INPUT_MESSAGE, "B"));
        b = scanner.nextInt();
    }

    private void doOperation(int numberOfOperation) {

        switch (numberOfOperation) {
            case 1: {
                System.out.println(sum(a, b));
                break;
            }
            case 2: {
                System.out.println(subtraction(a, b));
                break;
            }
            case 3: {
                System.out.println(multiplication(a, b));
                break;
            }
            case 4: {
                System.out.println(division(a, b));
                break;
            }
            case 5: {
                doMainMenu();
                break;
            }
        }
    }
}
