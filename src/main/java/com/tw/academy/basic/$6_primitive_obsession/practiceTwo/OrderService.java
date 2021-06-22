package com.tw.academy.basic.$6_primitive_obsession.practiceTwo;


import java.util.HashMap;

public class OrderService {

    private HashMap<String, HashMap<String, TimeRange>> ordered = new HashMap<>();

    public String order(String id, String month, String time) {
        String[] timeArr = time.split("~");

        Time startTime = new Time(timeArr[0]);
        Time endTime = new Time(timeArr[1]);
        TimeRange requestTimeRange = new TimeRange();
        requestTimeRange.setStartTime(startTime);
        requestTimeRange.setEndTime(endTime);
        if (hasBeenOrdered(id, month, new TimeRange(startTime, endTime))){
            return "Error: something wrong, please call the manager.";
        }

        HashMap<String, TimeRange> monthMap = new HashMap<>();
        monthMap.put(month, requestTimeRange);
        getOrdered().put(id, monthMap);
        return "Success! You can use the No." + id + " court during " + month + " " + time + ".";
    }

    public boolean hasBeenOrdered(String id, String month, TimeRange requestTimeRange) {
        HashMap<String, TimeRange> countHasBook = getOrdered().getOrDefault(id, null);
        if (countHasBook != null) {
            TimeRange orderedTimeRange = countHasBook.getOrDefault(month, null);
            if (orderedTimeRange != null) {
                if (requestTimeRange.isOverlap(orderedTimeRange)) return true;
                if (orderedTimeRange.isContain(requestTimeRange)) return true;
            }
        }
        return false;
    }

    private void setMinHours(Time startTime, TimeRange timeRange) {
        timeRange.setStartTime(startTime);
    }

    private void setMaxHours(Time endTime, TimeRange timeRange) {
        timeRange.setEndTime(endTime);
    }

    /**
     * 已预定
     */
    public HashMap<String, HashMap<String, TimeRange>> getOrdered() {
        return ordered;
    }
}
