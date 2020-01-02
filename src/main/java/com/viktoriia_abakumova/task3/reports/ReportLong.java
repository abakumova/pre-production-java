package com.viktoriia_abakumova.task3.reports;

import com.viktoriia_abakumova.task3.entities.Course;
import com.viktoriia_abakumova.task3.entities.Student;
import com.viktoriia_abakumova.task3.time.Time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Formatter;

import static com.viktoriia_abakumova.task3.time.DateConstant.END_TIME_HOUR;
import static com.viktoriia_abakumova.task3.time.DateConstant.START_TIME_HOUR;

public class ReportLong {

    private static final int LENGTH_WORD_CURRENT_DATE = 15;

    public static void printReportLong(Student[] students, Calendar currentTime) {
        int wideReport = getWideReport(students);
        String line = getLine(wideReport);
        StringBuilder sb = new StringBuilder();
        Formatter fmt = new Formatter(sb);
        for (Student currentStudent : students) {
            int minWideSecondColumn = wideReport - LENGTH_WORD_CURRENT_DATE;
            String lineFormatter = "%-" + LENGTH_WORD_CURRENT_DATE + "s %" + minWideSecondColumn + "s\n";

            fmt.format(line + "\n");
            fmt.format(lineFormatter, "current time", getDateToString(currentTime));
            fmt.format(lineFormatter, "start date", getDateToString(currentStudent.getStartDate()));
            fmt.format(lineFormatter, "finish date", getDateToString(currentStudent.getEndDate()));
            fmt.format(lineFormatter, "student", currentStudent.getNameStudent());
            fmt.format(lineFormatter, "CURRICULUM", currentStudent.getCurriculumStudent().getNameCurriculum());
            fmt.format(line + "\n");
            int i = 1;
            int lengthHoursCourse = 4;
            int lengthNumberCourse = 3;
            lineFormatter = "%-" + (wideReport - lengthHoursCourse - lengthNumberCourse) + "s %" + lengthHoursCourse + "s\n";
            for (Course currentCourse : currentStudent.getCurriculumStudent().getCoursesInCurriculum()) {
                fmt.format(i + ". " + lineFormatter, currentCourse.getNameCourse(), currentCourse.getDurationHours());
                i++;
            }
            fmt.format(line + "\n");
            fmt.format("TOTAL " + currentStudent.getCurriculumStudent().getSumHours() + "\n");
            if (Time.timeProgramPassed(currentStudent, currentTime)) {
                fmt.format("complete ");
            } else {
                fmt.format("not complete ");
            }
            int workHours = Time.getDiffWorkTimeInHours(currentStudent, currentTime);
            int day = workHours / (END_TIME_HOUR - START_TIME_HOUR);
            int hours = workHours % (END_TIME_HOUR - START_TIME_HOUR);
            fmt.format(day + " day " + hours + " hours " + "\n\n");
            System.out.println(sb.toString());
            sb.setLength(0);
        }
        fmt.close();
    }

    private static String getDateToString(Calendar time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return dateFormat.format(time.getTime());
    }

    private static int getWideReport(Student[] students) {
        int wideReportLength = 32;
        int tmpWideReport = 0;

        for (Student currentStudent : students) {
            int lengthNameStudent = currentStudent.getNameStudent().length();
            int lengthCurriculumStudent = currentStudent.getCurriculumStudent().getNameCurriculum().length();

            if (lengthNameStudent > lengthCurriculumStudent) {
                tmpWideReport = lengthNameStudent;
            } else {
                tmpWideReport = lengthCurriculumStudent;
            }

            if ((tmpWideReport + LENGTH_WORD_CURRENT_DATE) > wideReportLength) {
                wideReportLength = tmpWideReport + LENGTH_WORD_CURRENT_DATE;
            }
        }
        return wideReportLength;
    }

    private static String getLine(int wideReport) {
        StringBuilder line = new StringBuilder(wideReport);
        for (int i = 0; i <= wideReport; i++) {
            line.append("-");
        }
        return line.toString();
    }
}
