package com.tw.academy.basic.$6_primitive_obsession.practiceTwo;


import java.util.HashMap;

public class OrderService {

    /**
     * 已预定
     */
    public HashMap<String, HashMap<String, HashMap<String, Integer>>> ordered = new HashMap<>();

    public String order(String id, String month, String time) {
        String[] timeArr = time.split("~");

        Time min = new Time(getTime(timeArr, 0));
        Time max = new Time(getTime(timeArr, 1));
        if (hasBeenOrdered(id, month, min, max)){
            return "Error: something wrong, please call the manager.";
        }

        HashMap<String, Integer> timeMap = new HashMap<>();
        timeMap.put("max", getHours(max));
        timeMap.put("min", getHours(min));
        HashMap<String, HashMap<String, Integer>> monthMap = new HashMap<>();
        monthMap.put(month, timeMap);
        ordered.put(id, monthMap);
        return "Success! You can use the No." + id + " court during " + month + " " + time + ".";
    }

    public Boolean hasBeenOrdered(String id, String month, Time minTime, Time maxTime) {
        HashMap<String, HashMap<String, Integer>> countHasBook = ordered.getOrDefault(id, null);
        if (countHasBook != null) {
            HashMap<String, Integer> countHasBookInThisMonth = countHasBook.getOrDefault(month, null);
            if (countHasBookInThisMonth != null) {
                if (countHasBookInThisMonth.get("min") <= (Integer) getHours(minTime)
                        && (Integer) getHours(minTime) <= countHasBookInThisMonth.get("max")) {
                    return true;
                }
                if (countHasBookInThisMonth.get("min") <= (Integer) getHours(maxTime)
                        && (Integer) getHours(maxTime) <= countHasBookInThisMonth.get("max")) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getHours(String time) {
        return Integer.parseInt(time.split(":")[0]);
    }

    private int getHours(Time time) {
        return Integer.parseInt(time.getTime().split(":")[0]);
    }

    private String getTime(String[] timeArr, int i) {
        return timeArr[i];
    }
}
