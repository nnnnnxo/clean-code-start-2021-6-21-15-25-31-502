package com.tw.academy.basic.$6_primitive_obsession.practiceTwo;


import java.util.HashMap;

public class OrderService {

    /**
     * 已预定
     */
    public HashMap<String, HashMap<String, HashMap<String, Integer>>> ordered = new HashMap<>();

    public String order(String id, String month, String time) {
        String[] timeArr = time.split("~");

        String minTime = timeArr[0];
        String maxTime = timeArr[1];
        if (hasBeenOrdered(id, month, minTime, maxTime)){
            return "Error: something wrong, please call the manager.";
        }

        HashMap<String, Integer> timeMap = new HashMap<>();
        timeMap.put("max", Integer.parseInt(getHours(maxTime)));
        timeMap.put("min", Integer.parseInt(getHours(minTime)));
        HashMap<String, HashMap<String, Integer>> monthMap = new HashMap<>();
        monthMap.put(month, timeMap);
        ordered.put(id, monthMap);
        return "Success! You can use the No." + id + " court during " + month + " " + time + ".";
    }

    public Boolean hasBeenOrdered(String id, String month, String minTime, String maxTime) {
        HashMap<String, HashMap<String, Integer>> countHasBook = ordered.getOrDefault(id, null);
        if (countHasBook != null) {
            HashMap<String, Integer> countHasBookInThisMonth = countHasBook.getOrDefault(month, null);
            if (countHasBookInThisMonth != null) {
                if (countHasBookInThisMonth.get("min") <= (Integer) Integer.parseInt(getHours(minTime))
                        && (Integer) Integer.parseInt(getHours(minTime)) <= countHasBookInThisMonth.get("max")) {
                    return true;
                }
                if (countHasBookInThisMonth.get("min") <= (Integer) Integer.parseInt(getHours(maxTime))
                        && (Integer) Integer.parseInt(getHours(maxTime)) <= countHasBookInThisMonth.get("max")) {
                    return true;
                }
            }
        }
        return false;
    }

    private String getHours(String time) {
        return time.split(":")[0];
    }
}
