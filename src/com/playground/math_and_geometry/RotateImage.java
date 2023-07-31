package com.playground.math_and_geometry;

/**
 * 48. Rotate Image
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if(matrix.length == 1) return;
        int l = 0;
        int r = matrix.length - 1;
        while(l < r) {
            int top = l;
            int bottom = r;
            for(int i = 0; i < r - l; i++) {
                // Save first value
                int temp = matrix[top][l + i];
                // Reverse rotation
                // Move bottom left to top left
                matrix[top][l + i] = matrix[bottom - i][l];
                // Move bottom right to bottom left;
                matrix[bottom - i][l] = matrix[bottom][r - i];
                // Move top right to bottom right
                matrix[bottom][r - i] = matrix[top + i][r];
                // Move top left to top right
                matrix[top+i][r] = temp;
            }
            r--;
            l++;
        }

    }
}
