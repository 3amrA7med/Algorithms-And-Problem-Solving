package com.playground.array.string.easy;

/**
 * 1768. Merge Strings Alternately
 */
public class MergeStringsAlternately {

    /**
     * 1ms Beats 78.10%
     * 40.92mb Beats 54.37%
     */
    public String mergeAlternately(String word1, String word2) {
        char[] w1Arr = word1.toCharArray();
        char[] w2Arr = word2.toCharArray();
        char[] res = new char[w1Arr.length + w2Arr.length];

        int i1 = 0;
        int i2 = 0;
        int resI = 0;

        boolean w1Flag = true;

        while(resI < res.length) {
            if(i2 == w2Arr.length || i1 < w1Arr.length && w1Flag)
                res[resI++] = w1Arr[i1++];
            else if(i1 == w1Arr.length || i2 < w2Arr.length && !w1Flag)
                res[resI++] = w2Arr[i2++];
            w1Flag = !w1Flag;
        }

        return new String(res);
    }
}
