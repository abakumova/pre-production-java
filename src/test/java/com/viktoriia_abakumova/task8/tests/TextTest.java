package com.viktoriia_abakumova.task8.tests;

import com.viktoriia_abakumova.task8.TextAnalyzer;
import com.viktoriia_abakumova.task8.TextFileParser;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class TextTest {

    private static final OutputStream OUT_CONTENT = new ByteArrayOutputStream();
    private static final OutputStream ERR_CONTENT = new ByteArrayOutputStream();
    private static final String FILE_PATH = "src\\main\\resources\\test.txt";
    private TextFileParser textFileParser = new TextFileParser();
    private String text = textFileParser.parseFile(FILE_PATH);
    private TextAnalyzer textAnalyzer = new TextAnalyzer(text);

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(OUT_CONTENT));
        System.setErr(new PrintStream(ERR_CONTENT));
    }

    @Test
    public void testFrequency() {
        String expectedAnswer = "magna -> 4\r\nlorem -> 4\r\n";
        textAnalyzer.printTwoMostCommonWords();
        Assertions.assertEquals(expectedAnswer, OUT_CONTENT.toString(),
                "Expected frequency should be " + expectedAnswer + ", but actual is " + OUT_CONTENT.toString());
    }

    @Test
    public void testLength() {
        String expectedAnswer = "consectetur -> 11\r\nadipiscing -> 10\r\nincididunt -> 10\r\n";
        textAnalyzer.printThreeMostLongestWords();
        Assertions.assertEquals(expectedAnswer, OUT_CONTENT.toString(),
                "Expected 3 the most longest words should be " + expectedAnswer + ", but actual is " + OUT_CONTENT.toString());
    }

    @Test
    public void testDuplicates() {
        String expectedAnswer = "OD\r\nTE\r\nTU\r\n";
        textAnalyzer.printFirstThreeWordsWithDuplications();
        Assertions.assertEquals(expectedAnswer, OUT_CONTENT.toString(),
                "Expected 3 words duplicates should be " + expectedAnswer + ", but actual is " + OUT_CONTENT.toString());
    }

    @AfterAll
    public static void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}
