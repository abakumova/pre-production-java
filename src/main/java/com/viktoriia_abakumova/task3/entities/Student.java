package com.viktoriia_abakumova.task3.entities;

import com.viktoriia_abakumova.task3.time.Time;

import java.util.Calendar;

public class Student {

    private String nameStudent;
    private Curriculum curriculumStudent;
    private Calendar startDate;
    private Calendar endDate;

    public Student(String nameStudent, Curriculum curriculumStudent, Calendar startDate) {
        this.nameStudent = nameStudent;
        this.curriculumStudent = curriculumStudent;
        this.startDate = Time.getStartDateOfCourse(startDate);
        this.endDate = Time.getCountOfDaysAndHoursToEndOfCurriculum(startDate, curriculumStudent);
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public Curriculum getCurriculumStudent() {
        return curriculumStudent;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Student [nameStudent=" + nameStudent + ", curriculumStudent=" + curriculumStudent.getNameCurriculum()
                + ", startDate=" + startDate.get(Calendar.DAY_OF_YEAR) + ", endDate="
                + endDate.get(Calendar.DAY_OF_YEAR) + "]";
    }
}
