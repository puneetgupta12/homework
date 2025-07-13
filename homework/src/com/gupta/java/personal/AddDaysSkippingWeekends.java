package com.gupta.java.personal;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AddDaysSkippingWeekends {

    public static LocalDate addDaysSkippingWeekends(LocalDate date, int days) {
        LocalDate result = date;
        int addedDays = 0;
        while (addedDays < days) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(addDaysSkippingWeekends(LocalDate.now(), 14));
    }
}
