package com.viktoriia_abakumova.task1.parts;

import java.util.Scanner;

import static java.lang.String.format;

public class Task3 {

    private static final String INPUT_MESSAGE = "Input number %s";
    private Scanner scan;
    private int a, b;
    private boolean isContinued = true;

    public Task3(Scanner scanner) {
        scan = scanner;
    }

    public void executeTask3() {
        askNumbers();
        while (isContinued) {
            System.out.println("Your numbers " + a + " " + b);
            doMainMenu();
        }
    }

    private void doMainMenu() {
        int n;
        int numberOfSign;

        System.out.println("1) Enter new numbers");
        System.out.println("2) Do operation");
        System.out.println("3) Exit");

        n = scan.nextInt();

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

                numberOfSign = scan.nextInt();
                doOperation(numberOfSign);
                break;
            }
            case 3: {
                System.out.println("Exit");
                isContinued = false;
                break;
            }
        }
    }

    private void askNumbers() {
        System.out.println(format(INPUT_MESSAGE, "A"));
        a = scan.nextInt();
        System.out.println(format(INPUT_MESSAGE, "B"));
        b = scan.nextInt();
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

    private int sum(int a, int b) {
        return (a + b);
    }

    private int subtraction(int a, int b) {
        return (a - b);
    }

    private int multiplication(int a, int b) {
        return (a * b);
    }

    private int division(int a, int b) {
        if (b == 0) {
            System.err.println("Divider is 0");
            return 0;
        } else {
            return (a / b);
        }
    }
}
