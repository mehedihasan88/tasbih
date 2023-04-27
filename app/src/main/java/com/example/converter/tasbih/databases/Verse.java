package com.example.converter.tasbih.databases;
import java.time.*;

import utilites.Time;

public class Verse {
    private int id;
    private final String startTime;
    private String endTime;
    private int target;
    private int count;

    public Verse() {
        this.startTime = LocalDateTime.now().toString();
        this.endTime = null;
    }
    public  Verse(String endTime, int target, int count) {
        Time time = new Time();
        this.startTime = time.getTime();
        this.endTime = endTime;
        this.target = target;
        this.count = count;
    }
    public int getId() {
        return this.id;
    }
    public String getStartTime() {
        return this.startTime;
    }
    public String getEndTime() {
        return this.endTime;
    }
    public int getTarget() {
        return this.target;
    }
    public int getCount() {
        return this.count;
    }

    public void setTarget(int target) {
        this.target = target;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public void setEndTime(String time){
        this.endTime = time;
    }
}
