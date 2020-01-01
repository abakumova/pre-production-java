package com.viktoriia_abakumova.lesson3.task3.helpers;

import com.viktoriia_abakumova.lesson3.task3.entities.Course;
import com.viktoriia_abakumova.lesson3.task3.entities.Curriculum;
import com.viktoriia_abakumova.lesson3.task3.entities.Student;

import java.util.Calendar;

import static com.viktoriia_abakumova.lesson3.task3.time.DateConstant.START_DATE1;
import static com.viktoriia_abakumova.lesson3.task3.time.DateConstant.START_DATE2;

public class Source {

    private static Course[] courses = createArrayOfCourses();

    public static Student[] initialize(Calendar currentTime) {
        Curriculum j2EEDeveloper = new Curriculum("J2EE Developer", courses[0], courses[1]);
        Curriculum javaDeveloper = new Curriculum("Java Developer", courses[2], courses[3], courses[4]);

        setCurrentTime(currentTime);
        Calendar startTime1;
        Calendar startTime2;
        startTime1 = (Calendar) currentTime.clone();
        startTime2 = (Calendar) currentTime.clone();
        startTime1.add(Calendar.DATE, START_DATE1);
        startTime2.add(Calendar.DATE, START_DATE2);

        Student[] students = new Student[]{
                new Student("Abakumova Viktoriia", j2EEDeveloper, startTime1),
                new Student("Ivanov Ivan", javaDeveloper, startTime2)
        };

        return students;
    }

    private static Course[] createArrayOfCourses() {
        Course[] courses = new Course[]{
                new Course("API", 16),
                new Course("SOAP", 24),
                new Course("Java", 8),
                new Course("Spring ", 16),
                new Course("JDBC", 16)
        };
        return courses;
    }

    private static void setCurrentTime(Calendar currentTime) {
        currentTime.set(Calendar.MILLISECOND, 0);
        currentTime.set(Calendar.SECOND, 0);
        currentTime.set(Calendar.MINUTE, 0);
    }
}
