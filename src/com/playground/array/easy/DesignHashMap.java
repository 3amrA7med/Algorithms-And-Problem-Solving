package com.playground.array.easy;

/**
 * 706. Design HashMap
 * ====================
 * Design a HashMap without using any built-in hash table libraries.
 * Implement the MyHashMap class:
 * MyHashMap() initializes the object with an empty map.
 * void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
 * int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 */
public class DesignHashMap {

    /**
     * Runtime 17ms Beats 65.95%
     * Memory 54.69MB Beats 10.27%
     */
    final static int MAX_MAP_SIZE = (int) Math.pow(10, 6);
    Integer[] map;

    public DesignHashMap() {
        map = new Integer[MAX_MAP_SIZE + 1];
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        if(map[key] != null) return map[key];
        return -1;
    }

    public void remove(int key) {
        map[key] = null;
    }

}
