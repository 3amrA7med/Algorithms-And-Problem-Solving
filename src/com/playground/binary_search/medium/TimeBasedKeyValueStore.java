package com.playground.binary_search.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 981. Time Based Key-Value Store
 * =====================================================
 * Design a time-based key-value data structure that can store multiple values for the same key
 * at different time stamps and retrieve the key's value at a certain timestamp.
 * Implement the TimeMap class:
 * TimeMap() Initializes the object of the data structure.
 * void set(String key, String value, int timestamp) Stores the key with the value at the given time timestamp.
 * String get(String key, int timestamp) Returns a value such that set was called previously,
 * with timestamp_prev <= timestamp. If there are multiple such values, it returns the value
 * associated with the largest timestamp_prev. If there are no values, it returns "".
 * =========================================================
 * Input
 * ["TimeMap", "set", "get", "get", "set", "get", "get"]
 * [[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
 * Output
 * [null, null, "bar", "bar", null, "bar2", "bar2"]
 * Explanation
 * TimeMap timeMap = new TimeMap();
 * timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
 * timeMap.get("foo", 1);         // return "bar"
 * timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
 * timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
 * timeMap.get("foo", 4);         // return "bar2"
 * timeMap.get("foo", 5);         // return "bar2"
 * =============================================================
 * 122ms Beats 98.55%
 * 118.51mb Beats 73.87%
 */
public class TimeBasedKeyValueStore {

    class Element {
        String val;
        int time;

        Element(String val, int time) {
            this.val = val;
            this.time = time;
        }
    }

    Map<String, List<Element>> map;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Element newElement = new Element(value, timestamp);
        List<Element> listOfElements =  map.getOrDefault(key, new ArrayList<>());
        listOfElements.add(newElement);
        map.put(key, listOfElements);
    }

    public String get(String key, int timestamp) {
        List<Element> elements = map.get(key);
        if(elements == null) return "";
        int l = 0;
        int h = elements.size() - 1;
        int index = -1;

        while(l <= h) {
            int m = l + (h - l) / 2;

            if(elements.get(m).time == timestamp) return elements.get(m).val;

            if(elements.get(m).time < timestamp) {
                l = m+1;
                index = m;
            }
            else h = m - 1;
        }

        if(index == -1) return "";
        return elements.get(index).val;
    }
}
