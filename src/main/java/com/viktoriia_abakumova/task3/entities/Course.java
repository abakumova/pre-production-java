package com.viktoriia_abakumova.task3.entities;

public class Course {

    private String nameCourse;
    private int durationHours;

    public Course(String nameCourse, int durationHours) {
        this.nameCourse = nameCourse;
        this.durationHours = durationHours;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public int getDurationHours() {
        return durationHours;
    }

    @Override
    public String toString() {
        return "Course [nameCourse=" + nameCourse + ", durationHours=" + durationHours + "]";
    }
}