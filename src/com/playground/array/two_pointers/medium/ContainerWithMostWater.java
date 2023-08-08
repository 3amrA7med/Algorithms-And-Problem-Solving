package com.playground.array.two_pointers.medium;

/**
 * 11. Container With Most Water
 */
public class ContainerWithMostWater {

    /**
     * 4ms Beats 83.12%
     * 55.60mb Beats 72.44%
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while(l < r) {
            int width = r-l;
            int area;
            if(height[l] < height[r]) {
                area = width * height[l];
                l++;
            }
            else {
                area = width * height[r];
                r--;
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
