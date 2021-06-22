package com.tw.academy.basic.$6_primitive_obsession.practiceTwo;


import java.util.HashMap;

public class OrderService {

    private final HashMap<String, HashMap<String, TimeRange>> ordered = new HashMap<>();

    public String order(String id, String month, String time) {
        String[] timeArr = time.split("~");

        Time startTime = new Time(timeArr[0]);
        Time endTime = new Time(timeArr[1]);
        TimeRange requestTimeRange = new TimeRange();
        requestTimeRange.setStartTime(startTime);
        requestTimeRange.setEndTime(endTime);
        if (hasBeenOrdered(id, month, requestTimeRange)){
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
                return orderedTimeRange.isConflict(requestTimeRange);
            }
        }
        return false;
    }

    /**
     * 已预定
     */
    public HashMap<String, HashMap<String, TimeRange>> getOrdered() {
        return ordered;
    }
}
