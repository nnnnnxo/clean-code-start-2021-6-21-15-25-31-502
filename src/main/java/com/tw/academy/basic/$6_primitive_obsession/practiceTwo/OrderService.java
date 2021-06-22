package com.tw.academy.basic.$6_primitive_obsession.practiceTwo;


import java.util.HashMap;

public class OrderService {

    private HashMap<String, HashMap<String, HashMap<String, Integer>>> ordered = new HashMap<>();

    public String order(String id, String month, String time) {
        String[] timeArr = time.split("~");

        Time minTime = new Time(timeArr[0]);
        Time maxTime = new Time(timeArr[1]);
        if (hasBeenOrdered(id, month, minTime, maxTime)){
            return "Error: something wrong, please call the manager.";
        }

        HashMap<String, Integer> timeRange = new HashMap<>();
        setMaxHours(maxTime, timeRange);
        setMinHours(minTime, timeRange);
        HashMap<String, HashMap<String, Integer>> monthMap = new HashMap<>();
        monthMap.put(month, timeRange);
        getOrdered().put(id, monthMap);
        return "Success! You can use the No." + id + " court during " + month + " " + time + ".";
    }

    public boolean hasBeenOrdered(String id, String month, Time minTime, Time maxTime) {
        HashMap<String, HashMap<String, Integer>> countHasBook = getOrdered().getOrDefault(id, null);
        if (countHasBook != null) {
            HashMap<String, Integer> countHasBookInThisMonth = countHasBook.getOrDefault(month, null);
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

    private void setMinHours(Time minTime, HashMap<String, Integer> timeMap) {
        timeMap.put("min", minTime.getHours());
    }

    private void setMaxHours(Time maxTime, HashMap<String, Integer> timeMap) {
        timeMap.put("max", maxTime.getHours());
    }

    private Integer getMaxHours(HashMap<String, Integer> countHasBookInThisMonth) {
        return countHasBookInThisMonth.get("max");
    }

    private Integer getMinHours(HashMap<String, Integer> countHasBookInThisMonth) {
        return countHasBookInThisMonth.get("min");
    }

    /**
     * 已预定
     */
    public HashMap<String, HashMap<String, HashMap<String, Integer>>> getOrdered() {
        return ordered;
    }
}
