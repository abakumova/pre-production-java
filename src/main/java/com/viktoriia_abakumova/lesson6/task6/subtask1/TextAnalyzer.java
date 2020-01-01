package com.viktoriia_abakumova.lesson6.task6.subtask1;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.util.Comparator;

public class TextAnalyzer {

    private String text;

    public TextAnalyzer(String text) {
        this.text = text;
    }

    /**
     * Prints two most common words and number of repetitions.
     * Sorted by alphabet, descending.
     */
    public void printTwoMostCommonWords() {
        Map<String, Integer> commonWords = new HashMap<>();

        String[] sentences = text.split("\\.");
        for (String sentence : sentences) {
            String[] sentenceWords = sentence.split(" ");
            for (String sentenceWord : sentenceWords) {
                Integer wordFrequency = commonWords.getOrDefault(sentenceWord, 0);
                commonWords.put(sentenceWord, ++wordFrequency);
            }
        }

        commonWords.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(2)
                .forEach(e -> System.out.println(String.format("%s -> %d", e.getKey(), e.getValue())));
    }

    /**
     * Prints three the most longest words.
     * Sorted by length, descending.
     */
    public void printThreeMostLongestWords() {
        Set<String> uniqueWords = new HashSet<>();

        String[] sentences = text.split("\\.");
        for (String sentence : sentences) {
            String[] sentenceWords = sentence.split(" ");
            Collections.addAll(uniqueWords, sentenceWords);
        }

        uniqueWords.stream()
                .sorted((o1, o2) -> Integer.compare(o2.length(), o1.length()))
                .limit(3)
                .forEach(w -> System.out.println(String.format("%s -> %d", w, w.length())));
    }

    /**
     * Prints the first three words that have duplications in backwards in upper case.
     * Sorted by length, ascending
     */
    public void printFirstThreeWordsWithDuplications() {
        Set<String> uniqueWords = new HashSet<>();
        String[] sentences = text.split("\\.");
        for (String sentence : sentences) {
            String[] sentenceWords = sentence.split(" ");
            for (String sentenceWord : sentenceWords) {
                if (!sentenceWord.isEmpty()) {
                    uniqueWords.add(sentenceWord);
                }
                if (uniqueWords.size() == 3) {
                    break;
                }
            }
        }

        uniqueWords.stream()
                .filter(s -> !s.isEmpty())
                .sorted(Comparator.comparingInt(String::length))
                .map(s -> new StringBuilder(s.toUpperCase()))
                .limit(3)
                .forEach(s -> System.out.println(s.reverse()));
    }
}
