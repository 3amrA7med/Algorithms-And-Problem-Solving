package com.playground.sorting;

import java.util.Arrays;

public class Sorting {

    static final int MAX_VALUE = 10000;
    static final int MIN_VALUE = -1000;

    public void run() {
        Integer[] arr = this.generateInputArray(1000, true);
        System.out.print("Original Array: ");
        System.out.println(Arrays.toString(arr));
        long startTime = System.nanoTime();
        Integer[] sortedArr = this.quickSort(arr, 0, arr.length-1);
        long endTime = System.nanoTime();
        System.out.print("Sorted Array: ");
        System.out.println(Arrays.toString(sortedArr));
        System.out.print("Sorted Correctly: ");
        System.out.println(this.isCorrect(sortedArr));
        System.out.print("Runtime:");
        System.out.println((double)(endTime-startTime)/1000000000);

    }

    Integer[] generateInputArray(int size, boolean randomFlag){
        Integer[] arr;
        if(randomFlag) {
            arr = new Integer[size];
            for (int i = 0; i < size; i++){
                arr[i] = (int) ((Math.random() * (MAX_VALUE - MIN_VALUE)) + MIN_VALUE);
            }
        }
        else {
            arr = new Integer[]{6505, 3319, 2450, -948, 7784, 4307, 9767, -602, 2199, 3157};
        }
        return arr;
    }

    Integer[] insertionSort(Integer[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && key < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }

    Integer[] selectionSort(Integer[] arr){
        for(int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for(int j = i; j < arr.length; j++) {
                if(arr[minIndex] > arr[j])
                    minIndex = j;
            }
            if(minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
        return arr;
    }

    Integer[] quickSort(Integer[] arr, int start, int end) {
        if(end>start) {
            int q = partition(arr, start, end);
            quickSort(arr, start, q - 1);
            quickSort(arr, q+1, end);
        }

        return arr;
    }

    int partition(Integer[] arr, int start, int end){
        int i = start;
        for(int k = start; k < end; k++) {
            if (arr[k] <= arr[end]) {
                swap(arr, k, i);
                i++;
            }
        }
        swap(arr, end, i);
        return i;
    }



    void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    boolean isCorrect(Integer[] arr) {
        int i = 0;
        while(i<arr.length-1 && arr[i]<=arr[i+1])
            i++;
        return i == arr.length-1;
    }
}
