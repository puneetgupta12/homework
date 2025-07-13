package com.gupta.java.personal;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class CompareDatesExcludingWeekends {

    public static boolean isWeekend(LocalDate timestamp) {
        DayOfWeek dayOfWeek = timestamp.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    public static LocalDateTime calculateTargetTimestamp(LocalDateTime referenceTimestamp, int daysToSubtract) {
        LocalDateTime targetTimestamp = referenceTimestamp.minusDays(daysToSubtract);

        long weekendCount = targetTimestamp.toLocalDate().datesUntil(referenceTimestamp.toLocalDate())
                .filter(date -> isWeekend(date))
                .count();

        return targetTimestamp.minusDays(weekendCount);
    }

    public static void main(String[] args) {
        LocalDateTime firstTimestamp = LocalDateTime.of(2023, 8, 6, 11, 10); // Example: August 1, 2023, 9:00 AM
        LocalDateTime currentTimestamp = LocalDateTime.now();

        LocalDateTime targetTimestamp = calculateTargetTimestamp(firstTimestamp, 14);

        boolean isFirstTimestamp14DaysPast = firstTimestamp.isBefore(targetTimestamp);

        if (isFirstTimestamp14DaysPast) {
            System.out.println("The first timestamp is 14 days or more in the past.");
        } else {
            System.out.println("The first timestamp is not 14 days in the past.");
        }
    }
}

