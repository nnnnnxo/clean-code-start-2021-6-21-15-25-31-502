package com.tw.academy.basic.$6_primitive_obsession.practiceTwo;


import java.util.HashMap;

public class OrderService {

    /**
     * 已预定
     */
    public HashMap<String, HashMap<String, HashMap<String, Integer>>> ordered = new HashMap<>();

    public String order(String id, String month, String time) {
        String[] timeArr = time.split("~");

        Time minTime = new Time(timeArr[0]);
        Time maxTime = new Time(timeArr[1]);
        if (hasBeenOrdered(id, month, minTime, maxTime)){
            return "Error: something wrong, please call the manager.";
        }

        HashMap<String, Integer> timeMap = new HashMap<>();
        timeMap.put("max", maxTime.getHours());
        timeMap.put("min", minTime.getHours());
        HashMap<String, HashMap<String, Integer>> monthMap = new HashMap<>();
        monthMap.put(month, timeMap);
        ordered.put(id, monthMap);
        return "Success! You can use the No." + id + " court during " + month + " " + time + ".";
    }

    public boolean hasBeenOrdered(String id, String month, Time minTime, Time maxTime) {
        HashMap<String, HashMap<String, Integer>> countHasBook = ordered.getOrDefault(id, null);
        if (countHasBook != null) {
            HashMap<String, Integer> countHasBookInThisMonth = countHasBook.getOrDefault(month, null);
            if (countHasBookInThisMonth != null) {
                if (countHasBookInThisMonth.get("min") <= (Integer) minTime.getHours()
                        && (Integer) minTime.getHours() <= countHasBookInThisMonth.get("max")) {
                    return true;
                }
                if (countHasBookInThisMonth.get("min") <= (Integer) maxTime.getHours()
                        && (Integer) maxTime.getHours() <= countHasBookInThisMonth.get("max")) {
                    return true;
                }
            }
        }
        return false;
    }
}
