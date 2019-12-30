package com.viktoriia_abakumova.lesson3.task3.time;

import com.viktoriia_abakumova.lesson3.task3.entities.Curriculum;
import com.viktoriia_abakumova.lesson3.task3.entities.Student;

import java.util.Calendar;

import static com.viktoriia_abakumova.lesson3.task3.time.DateConstant.END_TIME_HOUR;
import static com.viktoriia_abakumova.lesson3.task3.time.DateConstant.START_TIME_HOUR;

public class Time {

    /**
     * *int Array contain holiday day in 2019 year
     */
    private static final int[] HOLIDAY = {1, 4, 5, 6, 7, 8, 53, 54, 67, 68, 123, 124, 130, 165, 309};

    /*int Array contain holiday day in 2019 year*/
    private static final int[] DAY_OFF = {37};

    /**
     * Procedure calculates end time for current student.
     *
     * @param startDate  - when student start to learn curriculum
     * @param curriculum - curriculum of student
     * @return time when student must end curriculum
     */
    public static Calendar getCountOfDaysAndHoursToEndOfCurriculum(Calendar startDate, Curriculum curriculum) {
        int amountWorkHours = curriculum.getSumHours();
        int currentHour = 0;
        Calendar tmpDate = (Calendar) startDate.clone();

        while (amountWorkHours != 0) {

            tmpDate.add(Calendar.HOUR, 1);
            currentHour = tmpDate.get(Calendar.HOUR_OF_DAY);

            // verify that course is not finished
            if ((currentHour > START_TIME_HOUR)
                    && (currentHour <= END_TIME_HOUR) && (!Time.isHoliday(tmpDate))) {
                amountWorkHours--;
            }
        }
        return tmpDate;
    }

    /**
     * If date does not start in work days and in work hours, procedure finds nearest work time.
     *
     * @param startDate Date
     * @return only date in work time
     */

    public static Calendar getStartDateOfCourse(Calendar startDate) {
        Calendar tmpDate = (Calendar) startDate.clone();
        int currentHour = tmpDate.get(Calendar.HOUR_OF_DAY);

        while ((currentHour < START_TIME_HOUR) || (currentHour >= END_TIME_HOUR) || (Time.isHoliday(tmpDate))) {
            tmpDate.add(Calendar.HOUR, 1);
            currentHour = tmpDate.get(Calendar.HOUR_OF_DAY);
        }
        return tmpDate;
    }

    /**
     * Procedure returns count of work hours between two date - end date and current date.
     *
     * @param student
     * @param currentTime
     * @return returns count of work hours between two date
     */
    public static int getDiffWorkTimeInHours(Student student, Calendar currentTime) {
        Calendar tmpDate1;
        Calendar tmpDate2;

        if (timeProgramPassed(student, currentTime)) {
            tmpDate1 = (Calendar) student.getEndDate().clone();
            tmpDate2 = (Calendar) currentTime.clone();
        } else {
            tmpDate1 = (Calendar) currentTime.clone();
            tmpDate2 = (Calendar) student.getEndDate().clone();
        }

        int workHoursBetween = 0;
        int currentHour = 0;

        while (tmpDate1.before(tmpDate2)) {
            tmpDate1.add(Calendar.HOUR, 1);
            currentHour = tmpDate1.get(Calendar.HOUR_OF_DAY);

            if ((currentHour > START_TIME_HOUR) && (currentHour <= END_TIME_HOUR) && (!Time.isHoliday(tmpDate1))) {
                workHoursBetween++;
            }
        }
        return workHoursBetween;
    }

    /**
     * Procedure returns true if current time is more than end time of learning.
     *
     * @param student
     * @param currentTime
     * @return return true if current time is more than end time of learning
     */
    public static boolean timeProgramPassed(Student student, Calendar currentTime) {
        boolean timeProgramPassed = false;

        long endDateStudentMS = student.getEndDate().getTimeInMillis();
        long currentDateMS = currentTime.getTimeInMillis();

        if (currentDateMS > endDateStudentMS) {
            timeProgramPassed = true;
        }
        return timeProgramPassed;
    }

    private static boolean isHoliday(Calendar day) {
        for (int i = 0; i < Time.HOLIDAY.length; i++) {
            if (day.get(Calendar.DAY_OF_YEAR) == HOLIDAY[i]) {
                return true;
            }
        }

        for (int i = 0; i < Time.DAY_OFF.length; i++) {
            if (day.get(Calendar.DAY_OF_YEAR) == DAY_OFF[i]) {
                return false;
            }
        }

        return (day.get(Calendar.DAY_OF_WEEK) == 7) || (day.get(Calendar.DAY_OF_WEEK) == 1);
    }
}
