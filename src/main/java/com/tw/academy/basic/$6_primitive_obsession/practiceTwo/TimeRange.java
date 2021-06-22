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

    public Time getEndTime() {
        return endTime;
    }

    public Time getStartTime() {
        return startTime;
    }

    boolean isOverlap(TimeRange timeRange) {
        if ((Integer) timeRange.getStartHours() <= (Integer) getStartTime().getHours()
                && (Integer) getStartTime().getHours() <= (Integer) timeRange.getEndHours()) {
            return true;
        }
        return false;
    }

    boolean isContain(TimeRange timeRange) {
        if ((Integer) getStartHours() <= (Integer) timeRange.getEndTime().getHours()
                && (Integer) timeRange.getEndTime().getHours() <= (Integer) getEndHours()) {
            return true;
        }
        return false;
    }

    boolean isConflict(TimeRange requestTimeRange) {
        if (requestTimeRange.isOverlap(this)) return true;
        if (isContain(requestTimeRange)) return true;
        return false;
    }
}
