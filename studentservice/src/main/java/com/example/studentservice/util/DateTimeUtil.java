package com.example.studentservice.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Updated from my Spring starter example
@Component
public class DateTimeUtil {
    public static final String RS_DATE = "d.M.uuuu.";
    public static final String RS_TIME = "HH:mm:ss";
    public static final String RS_DATE_TIME = RS_DATE + " " + RS_TIME;

    public static final String ISO_DATE = "uuuu-MM-dd";
    public static final String ISO_TIME = "HH:mm:ss.SSSSSSSSS";
    public static final String ISO_DATE_TIME = ISO_DATE + "'T'" + ISO_TIME;

    private final Map<String, DateTimeFormatter> formatterPool = new HashMap<>();

    public DateTimeUtil() {
        DateTimeFormatter rsDateFormatter = DateTimeFormatter.ofPattern(RS_DATE).withResolverStyle(ResolverStyle.STRICT);
        DateTimeFormatter rsTimeFormatter = DateTimeFormatter.ofPattern(RS_TIME).withResolverStyle(ResolverStyle.STRICT);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(RS_DATE_TIME).withResolverStyle(ResolverStyle.STRICT);

        formatterPool.put(RS_DATE, rsDateFormatter);
        formatterPool.put(RS_TIME, rsTimeFormatter);
        formatterPool.put(RS_DATE_TIME, formatter);

        formatterPool.put(ISO_DATE, DateTimeFormatter.ISO_LOCAL_DATE);
        formatterPool.put(ISO_TIME, DateTimeFormatter.ISO_LOCAL_TIME);
//        DateTimeFormatter isoFormatter = DateTimeFormatter.ofPattern(ISO_DATE_TIME).withResolverStyle(ResolverStyle.STRICT);
        formatterPool.put(ISO_DATE_TIME, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public LocalDate parseDate(String dateStr) {
        return parseDate(dateStr, ISO_DATE);
    }

    public LocalDate parseDate(String dateStr, String pattern) {
        return LocalDate.parse(dateStr, getFormatter(pattern));
    }

    public LocalTime parseTime(String timeStr) {
        return parseTime(timeStr, ISO_TIME);
    }

    public LocalTime parseTime(String timeStr, String pattern) {
        return LocalTime.parse(timeStr, getFormatter(pattern));
    }

    public LocalDateTime parseDateTime(String dateTimeStr) {
        return parseDateTime(dateTimeStr, ISO_DATE_TIME);
    }

    public LocalDateTime parseDateTime(String dateTimeStr, String pattern) {
        return LocalDateTime.parse(dateTimeStr, getFormatter(pattern));
    }

    public String format(LocalDate date) {
        return format(date, ISO_DATE);
    }

    public String format(LocalDate date, String pattern) {
        return date.format(getFormatter(pattern));
    }

    public String format(LocalTime time) {
        return format(time, ISO_TIME);
    }

    public String format(LocalTime time, String pattern) {
        return time.format(getFormatter(pattern));
    }

    public String format(LocalDateTime dateTime) {
        return format(dateTime, ISO_DATE_TIME);
    }

    public String format(LocalDateTime dateTime, String pattern) {
        return dateTime.format(getFormatter(pattern));
    }

    private DateTimeFormatter getFormatter(String pattern) {
        if (!formatterPool.containsKey(pattern)) {
            formatterPool.put(pattern, DateTimeFormatter.ofPattern(pattern).withResolverStyle(ResolverStyle.STRICT));
        }
        return formatterPool.get(pattern);
    }

    public static void main(String[] args) {
        DateTimeUtil dateService = new DateTimeUtil();
        System.out.println("Formatter pool size: " + dateService.formatterPool.size());

//        String strNow = "8.2.2023. 05:06:07";
        String strNow = "2023-02-08T05:06:07.111111111";
//        LocalDateTime now = LocalDateTime.now();
        LocalDateTime now = dateService.parseDateTime(strNow);
        System.out.println("Now (implicit toString): " + now + "\n");

        String pattern1 = "MM/dd/uuuu. HH:mm:ss";
        String pattern2 = "MMM/dd/uuuu. h:mm a";
        String pattern3 = "dd.MM.uuuu. HH:mm:ss";
        String pattern4 = "d.M.uuuu. HH:mm:ss";         // rs
        String pattern5 = "uuuu-MM-dd'T'HH:mm:ss.SSSSSSSSS";   // ISO
        List<String> patterns = List.of(RS_DATE_TIME, ISO_DATE_TIME, pattern1, pattern2, pattern3, pattern4, pattern5);

        for (String pattern : patterns) {
            System.out.println("Pattern: " + pattern);

            String strDate = dateService.format(now, pattern);
            System.out.println("Formatted:                  " + strDate);
            LocalDateTime parsedNow = dateService.parseDateTime(strDate, pattern);
            System.out.println("Parsed (implicit toString): " + parsedNow);

            System.out.println("Formatter pool size: " + dateService.formatterPool.size());
            System.out.println("-".repeat(50) + "\n");
        }
    }
}


