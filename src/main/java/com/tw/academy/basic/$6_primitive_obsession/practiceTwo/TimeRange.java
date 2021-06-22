package com.tw.academy.basic.$6_primitive_obsession.practiceTwo;

public class TimeRange {
    private Time startTime;
    private Time endTime;

    public TimeRange() {
    }

    public TimeRange(Time startTime, Time endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartHours() {
        return startTime.getHours();
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public int getEndHours() {
        return endTime.getHours();
    }

    public void setEndTime(Time endHours) {
        this.endTime = endHours;
    }
}
