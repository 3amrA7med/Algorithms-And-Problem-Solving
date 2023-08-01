package com.playground.binary_search.medium;

/**
 * 875. Koko Eating Bananas
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);
        int result = high;

        while(high >= low) {
            int mid = low + (high - low) / 2;

            if(calculateNumberOfHours(piles, mid) <= h) {
                result = Math.min(result, mid);
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return result;
    }


    // Fails in one test case if we found number of hours but we can do better with smaller number of bananas that will yield with the same hours..!!!!!!!!!!!
    public int minEatingSpeed2(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);

        int bestKHours = 0;
        int bestK = 0;

        while(high >= low) {
            int mid = low + (high - low) / 2;
            int hours = calculateNumberOfHours(piles, mid);
            if(hours == h) return mid;
            if(hours < h) {
                if(hours >= bestKHours) {
                    bestKHours = hours;
                    bestK = mid;
                }
                high = mid - 1;
            }
            else low = mid + 1;
        }

        return bestK;
    }

    private int calculateNumberOfHours(int[] piles, int k) {
        int hours = 0;
        for(int i = 0; i < piles.length; i++) {
            hours += Math.ceil((double)piles[i]/k);
        }
        return hours;
    }

    private int getMax(int[] arr) {
        int max = 0;
        for(int val: arr)
            max = Math.max(val, max);
        return max;
    }
}
