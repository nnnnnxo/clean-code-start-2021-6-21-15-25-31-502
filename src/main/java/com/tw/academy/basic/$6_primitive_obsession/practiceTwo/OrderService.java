package com.tw.academy.basic.$6_primitive_obsession.practiceTwo;


import java.util.HashMap;

public class OrderService {

    private HashMap<String, HashMap<String, TimeRange>> ordered = new HashMap<>();

    public String order(String id, String month, String time) {
        String[] timeArr = time.split("~");

        Time minTime = new Time(timeArr[0]);
        Time maxTime = new Time(timeArr[1]);
        if (hasBeenOrdered(id, month, minTime, maxTime)){
            return "Error: something wrong, please call the manager.";
        }

        TimeRange timeRange = new TimeRange();
        setMaxHours(maxTime, timeRange);
        setMinHours(minTime, timeRange);
        HashMap<String, TimeRange> monthMap = new HashMap<>();
        monthMap.put(month, timeRange);
        getOrdered().put(id, monthMap);
        return "Success! You can use the No." + id + " court during " + month + " " + time + ".";
    }

    public boolean hasBeenOrdered(String id, String month, Time minTime, Time maxTime) {
        HashMap<String, TimeRange> countHasBook = getOrdered().getOrDefault(id, null);
        if (countHasBook != null) {
            TimeRange countHasBookInThisMonth = countHasBook.getOrDefault(month, null);
            if (countHasBookInThisMonth != null) {
                if (getMinHours(countHasBookInThisMonth) <= (Integer) minTime.getHours()
                        && (Integer) minTime.getHours() <= getMaxHours(countHasBookInThisMonth)) {
                    return true;
                }
                if (getMinHours(countHasBookInThisMonth) <= (Integer) maxTime.getHours()
                        && (Integer) maxTime.getHours() <= getMaxHours(countHasBookInThisMonth)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void setMinHours(Time startTime, TimeRange timeRange) {
        timeRange.setStartHours(startTime.getHours());
    }

    private void setMaxHours(Time endTime, TimeRange timeRange) {
        timeRange.setEndHours(endTime.getHours());
    }

    private Integer getMaxHours(TimeRange timeRange) {
        return timeRange.getEndHours();
    }

    private Integer getMinHours(TimeRange timeRange) {
        return timeRange.getStartHours();
    }

    /**
     * 已预定
     */
    public HashMap<String, HashMap<String, TimeRange>> getOrdered() {
        return ordered;
    }
}
