package com.viktoriia_abakumova.lesson4.task4.calculators;

import com.viktoriia_abakumova.lesson4.task4.parsers.NumbersParser;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private static final int MAX_VALUE = 1000;

    public int add(String numbers) {
        List<Integer> terms = parseTerms(numbers);
        verifyListDoesNotContainsNegativeElements(terms);
        List<Integer> remainingTerms = removeElementsMoreThanMax(terms);
        return sumOf(remainingTerms);
    }

    private List<Integer> parseTerms(String input) {
        return new NumbersParser(input).parseIntegers();
    }

    private List<Integer> removeElementsMoreThanMax(List<Integer> terms) {
        List<Integer> remainingTerms = new ArrayList<>();
        for (Integer term : terms) {
            if (term <= MAX_VALUE) {
                remainingTerms.add(term);
            }
        }
        return remainingTerms;
    }

    private void verifyListDoesNotContainsNegativeElements(List<Integer> terms) {
        List<Integer> negatives = new ArrayList<>();
        for (Integer term : terms) {
            if (term < 0) {
                negatives.add(term);
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }
    }

    private int sumOf(List<Integer> terms) {
        int sum = 0;
        for (Integer term : terms) {
            sum += term;
        }
        return sum;
    }
}
