package com.playground.binary_search.hard;

/**
 * 4. Median of Two Sorted Arrays
 */
public class MedianOfTwoSortedArrays {

    public void run(){
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }

    /**
     * 2ms Beats 97.64%
     * 44.76mb Beats 55.39%
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Make nums1 holds the array with the smaller value.
        if(nums2.length < nums1.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int leftPartitionSize = (nums2.length + nums1.length) / 2;
        boolean evenFlag = (nums2.length + nums1.length) % 2 == 0;

        int l = 0;
        int r = nums1.length;

        while(l <= r) {
            int m = l + (r - l) / 2;
            int n = leftPartitionSize - m;

            int nums1Left  = (m>0)             ? nums1[m-1]: Integer.MIN_VALUE;
            int nums1Right = (m < nums1.length)? nums1[m]: Integer.MAX_VALUE;

            int nums2Left  = (n>0)             ? nums2[n-1]: Integer.MIN_VALUE;
            int nums2Right = (n < nums2.length)? nums2[n]: Integer.MAX_VALUE;


            if(!evenFlag && nums1Left <= nums2Right && nums2Left <= nums1Right) return Math.min(nums1Right, nums2Right);
            if(evenFlag && nums1Left <= nums2Right && nums2Left <= nums1Right)
                return (Math.min(nums1Right, nums2Right) + Math.max(nums1Left, nums2Left)) / 2.0;

            if(nums1Left <= nums2Right) l = m + 1;
            else r = m - 1;
        }

        return 0.0;
    }
}
