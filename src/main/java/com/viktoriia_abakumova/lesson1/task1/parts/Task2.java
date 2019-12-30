package com.viktoriia_abakumova.lesson1.task1.parts;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.util.Arrays.asList;

public class Task2 {

    private Scanner scan;

    public Task2(Scanner scanner) {
        scan = scanner;
    }

    public void executeTask2() {
        int expectedNumberOfElements = getExpectedNumberOfWords();
        String[] words = getWords(expectedNumberOfElements);
        String maxRepetitiveChar = getMaxRepetitiveChars(words);
        System.out.println(maxRepetitiveChar);
    }

    private int getExpectedNumberOfWords() {
        System.out.println("Enter n - number of words");
        if (scan.hasNextInt()) {
            return Integer.parseInt(scan.nextLine());
        }

        return 0;
    }

    private String[] getWords(int expectedNumberOfElements) {
        System.out.println("Enter words with space in one line");
        String[] array = {""};
        String text = scan.nextLine();
        String[] words = text.split(" ");
        if (expectedNumberOfElements == words.length) {
            return text.split(" ", expectedNumberOfElements);
        } else {
            System.out.println("Number of expected words is differ from entered words");
            return array;
        }

    }

    private String getMaxRepetitiveChars(String[] words) {
        String wordMinCharVar = words[0];
        int sizeMinCharVar = new HashSet<>(asList(words[0].split(""))).size();

        for (String word : words) {
            Set<String> set = new HashSet<>(asList(word.split("")));
            if (set.size() < sizeMinCharVar) {
                wordMinCharVar = word;
                sizeMinCharVar = set.size();
            }
        }

        return wordMinCharVar;
    }
}
