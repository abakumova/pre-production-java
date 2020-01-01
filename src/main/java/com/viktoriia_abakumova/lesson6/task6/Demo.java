package com.viktoriia_abakumova.lesson6.task6;

import static com.viktoriia_abakumova.lesson6.task6.subtask2.SubTask2.demoLinkedHashMap;
import static com.viktoriia_abakumova.lesson6.task6.subtask2.SubTask2.demoMap;

import com.viktoriia_abakumova.lesson6.task6.subtask1.TextAnalyzer;
import com.viktoriia_abakumova.lesson6.task6.subtask1.TextFileParser;
import com.viktoriia_abakumova.lesson6.task6.subtask3.ObjectSerializer;
import com.viktoriia_abakumova.lesson6.task6.subtask3.Product;

import java.io.NotSerializableException;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws NotSerializableException {
        executeTask1();
        executeTask2();
        executeTask3();
    }

    private static void executeTask1() {
        String filePath = "src\\main\\resources\\test.txt";
        boolean continueLoop = true;
        Scanner scan = new Scanner(System.in);

        while (continueLoop) {
            TextFileParser textFileParser = new TextFileParser();
            String text = textFileParser.parseFile(filePath);
            TextAnalyzer textAnalyzer = new TextAnalyzer(text);
            printMenu();
            int numberOfTheOperation = scan.nextInt();
            switch (numberOfTheOperation) {
                case 1: {
                    textAnalyzer.printTwoMostCommonWords();
                    break;
                }
                case 2: {
                    textAnalyzer.printThreeMostLongestWords();
                    break;
                }
                case 3: {
                    textAnalyzer.printFirstThreeWordsWithDuplications();
                    break;
                }
                case 4: {
                    continueLoop = false;
                    break;
                }
            }
        }
        scan.close();
    }

    private static void executeTask2() {
        demoMap();
        demoLinkedHashMap();
    }

    private static void executeTask3() throws NotSerializableException {
        Product laptop = new Product(1, "Asus Laptop", 1700.20, "Silver");
        Product mobilePhone = new Product(2, "Samsung phone", 1000, "Black");

        ObjectSerializer objectSerializer = new ObjectSerializer();
        objectSerializer.serialize(laptop, "asus_laptop");
        objectSerializer.serialize(mobilePhone, "samsung_phone");

        Product asus_laptop = objectSerializer.deserialize(Product.class, "asus_laptop");
        System.out.println(asus_laptop);

        Product samsung_phone = objectSerializer.deserialize(Product.class, "samsung_phone");
        System.out.println(samsung_phone);
    }

    private static void printMenu() {
        System.out.println("Enter number of the operation \n1) frequency \n2) length  \n3) duplicates \n4) exit ");
    }
}