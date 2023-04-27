package utilites;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
    private int year;
    private int month;
    private int date;
    private int hour;
    private int minute;
    private int second;
    private String time;

    public Time() {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatStyle = DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss");
        String formattedTime = time.format(formatStyle);
        this.year = time.getYear();
        this.month = time.getMonthValue();
        this.date = time.getDayOfMonth();
        this.hour = time.getHour();
        this.minute = time.getMinute();
        this.second = time.getSecond();
        this.time = formattedTime;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public String getTime() {
        return time;
    }

    public static String getCurrentTime() {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatStyle = DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss");
        return time.format(formatStyle);
    }
 }
