package com.playground.array.string.medium;

/**
 * 1318. Minimum Flips to Make a OR b Equal to c
 * =====================================================
 * Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
 * Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.
 * =====================================
 * Example 1:
 * Input: a = 2, b = 6, c = 5
 * Output: 3
 * Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
 * Example 2:
 * Input: a = 4, b = 2, c = 7
 * Output: 1
 * Example 3:
 * Input: a = 1, b = 2, c = 3
 * Output: 0
 * ========================================
 * Constraints:
 * 1 <= a <= 10^9
 * 1 <= b <= 10^9
 * 1 <= c <= 10^9
 */
public class MinimumFlipsToMakeAOrBEqualToC {

    public void run() {
        System.out.println(this.minFlips1(1,2,3));
    }

    /**
     * Runtime 0ms Beats 100.00%
     * Memory 38.88MB Beats 86.40%
     */
    public int minFlips1(int a, int b, int c) {
        int minNumOfFlips = 0;
        while(a != 0 || b != 0 || c != 0) {
            int b1 = a & 1;
            int b2 = b & 1;
            int b3 = c & 1;

            if(b3 == 1) {
                if(b1 == 0 && b2 == 0) minNumOfFlips++;
            }
            else {
                if(b1 == 1) minNumOfFlips++;
                if(b2 == 1) minNumOfFlips++;
            }

            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }

        return minNumOfFlips;
    }

    /**
     * Runtime 1ms Beats 8.38%
     * Memory 39.33MB Beats 27.71%
     */
    public int minFlips2(int a, int b, int c) {

        String aStr = Integer.toBinaryString(a);
        String bStr = Integer.toBinaryString(b);
        String cStr = Integer.toBinaryString(c);

        int maxSize = Math.max(aStr.length(), Math.max(bStr.length(), cStr.length()));
        aStr = "0".repeat(maxSize - aStr.length()) + aStr;
        bStr = "0".repeat(maxSize - bStr.length()) + bStr;
        cStr = "0".repeat(maxSize - cStr.length()) + cStr;

        char[] aArr = aStr.toCharArray();
        char[] bArr = bStr.toCharArray();
        char[] cArr = cStr.toCharArray();

        int minNumFlips = 0;
        for(int i = 0; i < aArr.length; i++) {
            if(cArr[i] == '0') {
                if(aArr[i] == '1') minNumFlips++;
                if(bArr[i] == '1') minNumFlips++;
            }
            else
            if(aArr[i] == '0' && bArr[i] == '0') minNumFlips++;
        }

        return minNumFlips;
    }

    /**
     * Runtime 2ms Beats 8.38%
     * Memory 38.75MB Beats 92.54%
     */
    final static int MAX_BIT_SIZE = 30;
    public int minFlips4(int a, int b, int c) {
        String aStr = Integer.toBinaryString(a);
        String bStr = Integer.toBinaryString(b);
        String cStr = Integer.toBinaryString(c);

        aStr = "0".repeat(MAX_BIT_SIZE - aStr.length()) + aStr;
        bStr = "0".repeat(MAX_BIT_SIZE - bStr.length()) + bStr;
        cStr = "0".repeat(MAX_BIT_SIZE - cStr.length()) + cStr;

        char[] aArr = aStr.toCharArray();
        char[] bArr = bStr.toCharArray();
        char[] cArr = cStr.toCharArray();

        int minNumFlips = 0;
        for(int i = 0; i < aArr.length; i++) {
            if(cArr[i] == '0') {
                if(aArr[i] == '1') minNumFlips++;
                if(bArr[i] == '1') minNumFlips++;
            }
            else
            if(aArr[i] == '0' && bArr[i] == '0') minNumFlips++;
        }

        return minNumFlips;
    }
}
