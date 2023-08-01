package com.playground.binary_search.medium;

/**
 * 74. Search a 2D Matrix
 */
public class SearchA2DMatrix {

    // 100%%
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int h = matrix.length - 1;

        while(l <= h) {
            int mid = (h+l) / 2;

            if(matrix[mid][0] == target) return true;
            if(mid < matrix.length - 1 && matrix[mid][0] < target && matrix[mid + 1][0] > target) {
                l = mid;
                break;
            }
            else if(mid < matrix.length - 1 && matrix[mid][0] < target && matrix[mid + 1][0] <= target)
                l = mid + 1;
            else h = mid - 1;
        }

        int row = l;
        l = 0;
        h = matrix[0].length - 1;

        while(l <= h) {
            int mid = (h+l) / 2;
            if(matrix[row][mid] == target) return true;
            if(matrix[row][mid] < target) l = mid + 1;
            else h = mid - 1;
        }

        return false;

    }
}
