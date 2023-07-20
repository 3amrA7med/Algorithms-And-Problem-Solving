package com.playground.sliding_window.array;

public class BestTimeToBuyAndSellStock {


    public int solution(int[] prices) {
        if (prices.length < 2) return 0;
        int leftPointer = 0, rightPointer = 1; // left = sell, right = buy.
        int maxProfit = 0;
        int calculatedProfit;
        while (rightPointer < prices.length) {
            calculatedProfit = prices[rightPointer] - prices[leftPointer];
            if (calculatedProfit > maxProfit)
                maxProfit = calculatedProfit;
            if (prices[rightPointer] < prices[leftPointer])
                leftPointer = rightPointer;
            rightPointer++;
        }
        return maxProfit;
    }
}
