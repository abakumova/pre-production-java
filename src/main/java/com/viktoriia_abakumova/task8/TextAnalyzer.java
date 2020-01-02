package com.viktoriia_abakumova.task8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class TextAnalyzer {

    private String text;

    public TextAnalyzer(String text) {
        this.text = text;
    }

    public void printTwoMostCommonWords() {
        Arrays.stream(text.split("\\."))
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(2)
                .forEach(e -> System.out.println(String.format("%s -> %d", e.getKey(), e.getValue())));
    }

    public void printThreeMostLongestWords() {
        Arrays.stream(text.split("\\."))
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .sorted((o1, o2) -> Integer.compare(o2.length(), o1.length()))
                .limit(3)
                .forEach(w -> System.out.println(String.format("%s -> %d", w, w.length())));
    }

    public void printFirstThreeWordsWithDuplications() {
        Arrays.stream(text.split("\\."))
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toSet())
                .stream()
                .sorted(Comparator.comparingInt(String::length))
                .map(s -> new StringBuilder(s.toUpperCase()))
                .limit(3)
                .forEach(s -> System.out.println(s.reverse()));
    }
}
