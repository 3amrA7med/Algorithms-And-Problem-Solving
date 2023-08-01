package com.playground.binary_search.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 981. Time Based Key-Value Store
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
