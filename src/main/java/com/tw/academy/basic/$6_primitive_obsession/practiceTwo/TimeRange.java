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

    boolean isLeftOverlap(TimeRange timeRange) {
        return getStartHours() <= timeRange.getStartHours()
                && timeRange.getStartHours() <= getEndHours();
    }

    boolean isRightOverlap(TimeRange timeRange) {
        return getStartHours() <= timeRange.getEndHours()
                && timeRange.getEndHours() <= getEndHours();
    }

    boolean isConflict(TimeRange requestTimeRange) {
        if (isLeftOverlap(requestTimeRange)) return true;
        return isRightOverlap(requestTimeRange);
    }
}
