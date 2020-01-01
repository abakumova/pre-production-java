package com.viktoriia_abakumova.lesson3.task3.reports;

import com.viktoriia_abakumova.lesson3.task3.entities.Student;
import com.viktoriia_abakumova.lesson3.task3.time.Time;

import java.util.Calendar;

import static com.viktoriia_abakumova.lesson3.task3.time.DateConstant.END_TIME_HOUR;
import static com.viktoriia_abakumova.lesson3.task3.time.DateConstant.START_TIME_HOUR;

public class ReportShort {

    public static void printReportShort(Student[] students, Calendar currentTime) {
        for (Student student : students) {
            printNameAndCourse(student);
            printStatusOfTheCourse(student, currentTime);
            printDaysRemaining(student, currentTime);
        }
    }

    private static void printNameAndCourse(Student student) {
        System.out.print(student.getNameStudent() + " - " + student.getCurriculumStudent().getNameCurriculum());
    }

    private static void printStatusOfTheCourse(Student student, Calendar currentTime) {
        if (Time.timeProgramPassed(student, currentTime)) {
            System.out.print(" complete ");
        } else {
            System.out.print(" not complete ");
        }
    }

    private static void printDaysRemaining(Student student, Calendar currentTime) {
        int workHours = Time.getDiffWorkTimeInHours(student, currentTime);
        int day = workHours / (END_TIME_HOUR - START_TIME_HOUR);
        int hours = workHours % (END_TIME_HOUR - START_TIME_HOUR);

        System.out.println(" " + day + " " + " day " + hours + " " + " hours ");
    }
}
