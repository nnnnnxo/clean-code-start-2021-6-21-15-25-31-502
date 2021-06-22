package com.tw.academy.basic.$6_primitive_obsession.practiceTwo;

public class TimeRange {
    private Time startTime;
    private int endHours;

    public int getStartHours() {
        return startTime.getHours();
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public int getEndHours() {
        return endHours;
    }

    public void setEndHours(int endHours) {
        this.endHours = endHours;
    }
}
