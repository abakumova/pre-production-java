package com.viktoriia_abakumova.task3.template_generator;

import java.util.Scanner;

public class TemplateGenerator {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the template");
        String template = scan.nextLine();
        System.out.println("Enter the name");
        String name = scan.nextLine();
        scan.close();
        if (name == null) {
            System.err.println("Name is null");
        } else {
            printResult(template, name);
        }
    }

    private static void printResult(String template, String string) {
        int k = template.indexOf('$');
        int j = template.indexOf('}');
        String substring = template.substring(0, k);
        substring += template.substring(j + 1);
        System.out.printf(substring + "%s", string);
    }
}
