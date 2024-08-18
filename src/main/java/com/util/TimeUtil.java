package com.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeUtil {
    public String getNowTime() {
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formatedNow = now.format(formatter);
        return formatedNow;
    }

    public String totalPlayTime(String start, String end) {
        String[] startTimeArr = start.split(":");
        String[] endTimeArr = end.split(":");

        LocalTime startTime = LocalTime.of(Integer.parseInt(startTimeArr[0]), Integer.parseInt(startTimeArr[1]));
        LocalTime endTime = LocalTime.of(Integer.parseInt(endTimeArr[0]), Integer.parseInt(endTimeArr[1]));
        long hoursBetween = ChronoUnit.HOURS.between(startTime, endTime);
        long minutesBetween = ChronoUnit.MINUTES.between(startTime, endTime) % 60;


        return hoursBetween + "시간 " + minutesBetween + "분 ";
    }

    public void slowPrinter(String printMessage, int printTime) {
        for (int i = 0; i < printMessage.length(); i++) {
            char c = printMessage.charAt(i);

            if (c == '\n') {
                System.out.println();
            } else {
                System.out.print(c);
            }

            try {
                Thread.sleep(printTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
