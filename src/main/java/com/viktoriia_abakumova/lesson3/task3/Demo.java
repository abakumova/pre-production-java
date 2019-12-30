package com.viktoriia_abakumova.lesson3.task3;

import com.viktoriia_abakumova.lesson3.task3.entities.Student;
import com.viktoriia_abakumova.lesson3.task3.reports.ReportLong;
import com.viktoriia_abakumova.lesson3.task3.reports.ReportShort;
import com.viktoriia_abakumova.lesson3.task3.helpers.Source;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Demo {

    public static void main(String[] args) {
        Calendar currentTime = new GregorianCalendar();
        System.out.println("show Short Report");
        Demo.startApp(0, currentTime);
        System.out.println("show Long Report");
        Demo.startApp(1, currentTime);
        System.out.println("show all Reports");
        Demo.startApp(2, currentTime);
    }

    private static void startApp(int arg, Calendar currentTime) {
        Student[] students = Source.initialize(currentTime);

        switch (arg) {
            case 0:
                ReportShort.printReportShort(students, currentTime);
                break;
            case 1:
                ReportLong.printReportLong(students, currentTime);
                break;
            case 2:
                ReportShort.printReportShort(students, currentTime);
                ReportLong.printReportLong(students, currentTime);
                break;
        }
    }
}
