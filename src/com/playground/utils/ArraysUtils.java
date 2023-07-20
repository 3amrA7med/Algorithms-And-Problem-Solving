package com.playground.utils;

public class ArraysUtils {

    public boolean binarySearch(int[] arr, int value) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        int currentIndex;

        while(startIndex <= endIndex) {
            currentIndex = (endIndex - startIndex)/2;
            if(arr[currentIndex] == value) return true;
            else if(arr[currentIndex]>value) startIndex = currentIndex + 1;
            else endIndex = currentIndex - 1;
        }
        return false;
    }

    public void swapElementsInPlace(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
