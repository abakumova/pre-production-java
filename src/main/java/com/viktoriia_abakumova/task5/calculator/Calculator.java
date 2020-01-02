package com.viktoriia_abakumova.task5.calculator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import static java.lang.String.format;

import java.util.Scanner;

public class Calculator {

    private static final Logger log = (Logger) LogManager.getLogger(Calculator.class);
    private static final String INPUT_MESSAGE = "Input number %s";
    private static String level;
    private Scanner scanner = new Scanner(System.in);
    private int a, b;
    private boolean isContinued = true;

    public Calculator() {
        log.debug("The calculator is created!");
    }

    public void executeTask() {
        log.info("Method executeTask!");
        askNumbers();
        while (isContinued) {
            System.out.println("Your numbers " + a + " " + b);
            doMainMenu();
        }
    }

    private void doMainMenu() {
        log.info("Method doMainMenu!");
        int n;
        int numberOfSign;

        System.out.println("1) Enter new numbers");
        System.out.println("2) Do operation");
        System.out.println("3) Ask logging level");
        System.out.println("4) Exit");

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
                level = askLogLevel();
                if (level.equals("info")) {
                    log.setLevel(Level.INFO);
                } else if (level.equals("debug")) {
                    log.setLevel(Level.DEBUG);
                } else if (level.equals("warn")) {
                    log.setLevel(Level.WARN);
                } else if (level.equals("error")) {
                    log.setLevel(Level.ERROR);
                }
                break;
            }
            case 4: {
                System.out.println("Exit");
                scanner.close();
                isContinued = false;
                break;
            }
        }
    }

    private void askNumbers() {
        log.info("Method askNumbers!");
        System.out.println(format(INPUT_MESSAGE, "A"));
        a = scanner.nextInt();
        System.out.println(format(INPUT_MESSAGE, "B"));
        b = scanner.nextInt();
    }

    private String askLogLevel() {
        log.info("Method askLogLevel!");
        System.out.println("Enter logging level DEBUG INFO WARN ERROR");
        level = scanner.next();
        return level;
    }

    private void doOperation(int numberOfOperation) {
        log.info("Method doOperation!");

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
        log.info("Method sum!");
        return (a + b);
    }

    private int subtraction(int a, int b) {
        log.info("Method subtraction!");
        return (a - b);
    }

    private int multiplication(int a, int b) {
        log.info("Method multiplication!");
        return (a * b);
    }

    private int division(int a, int b) {
        log.info("Method division!");
        log.warn("Checking the divider!");
        if (b == 0) {
            log.error("Divider is 0");
            System.err.println("Divider is 0");
            return 0;
        } else {
            return (a / b);
        }
    }
}
