package com.playground.heap.medium;

/**
 * 2542. Maximum Subsequence Score
 */
public class MaximumSubsequenceScore {


    /*
    wrong for this question but will be right if the subsequence must be contiguous
    public long maxScore(int[] nums1, int[] nums2, int k) {
        if(nums1.length < k) return 0;
        PriorityQueue<Long> scores = new PriorityQueue<>((a,b) -> Long.compare(b,a));

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i = 0; i < k - 1; i ++) {
            sum+=nums1[i];
            if(min > nums2[i]) {
                min = nums2[i];
                minIndex = i;
            }
        }

        int popedNumber = 0;
        for(int i = k-1; i < nums1.length; i++) {
            sum += nums1[i] - popedNumber;
            popedNumber = nums1[i - k + 1];
            if(nums2[i] <= min) {
                min = nums2[i];
                minIndex = i;
            }
            else if(minIndex + k - 1 < i) {
                min = Integer.MAX_VALUE;
                for(int j = minIndex+1; j <= i; j++) {
                    if(min > nums2[j]) {
                        min = nums2[j];
                        minIndex = i;
                    }
                }
            }
            scores.offer(Long.valueOf(sum*min));
        }

        return scores.peek();
    }
     */
}
