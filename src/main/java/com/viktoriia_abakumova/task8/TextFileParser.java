package com.viktoriia_abakumova.task8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileParser {

    public String parseFile(String filename) {
        File file = new File(filename);
        StringBuilder text = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    text.append(line.trim().toLowerCase());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("There is no file by path: " + filename);
        }
        return text.toString();
    }
}
