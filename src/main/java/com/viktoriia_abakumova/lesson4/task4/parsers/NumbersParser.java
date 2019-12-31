package com.viktoriia_abakumova.lesson4.task4.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;

public class NumbersParser {

    private static final Pattern SEPARATOR_DEFINITION_PATTERN = Pattern.compile("^(//(.)\n).*$");
    private static final String NO_NUMBERS_REGEX = "^(//.\n)?$";
    private static final String DEFAULT_SEPARATOR_REGEX = "[,\n]";

    private final String numbersString;
    private List<String> terms;

    public NumbersParser(String input) {
        this.numbersString = input;
        terms = new ArrayList<>();
    }

    public List<Integer> parseIntegers() {
        if (inputContainsNumbers()) {
            parseNumbers();
        }
        return termsAsIntegers();
    }

    private void parseNumbers() {
        terms.clear();
        String separator = DEFAULT_SEPARATOR_REGEX;
        String numbers = numbersString;
        Matcher separatorDefinitionMatcher = SEPARATOR_DEFINITION_PATTERN.matcher(numbersString);
        if (separatorDefinitionMatcher.matches()) {
            separator = Pattern.quote(separatorDefinitionMatcher.group(2));
            numbers = numbersString.substring(separatorDefinitionMatcher.group(1).length());
        }
        terms.addAll(asList(numbers.split(separator)));
    }

    private boolean inputContainsNumbers() {
        return !numbersString.matches(NO_NUMBERS_REGEX);
    }

    private List<Integer> termsAsIntegers() {
        List<Integer> numbers = new ArrayList<>();
        for (String stringTerm : terms) {
            numbers.add(toInteger(stringTerm));
        }
        return numbers;
    }

    private Integer toInteger(String input) {
        return Integer.valueOf(input);
    }
}
