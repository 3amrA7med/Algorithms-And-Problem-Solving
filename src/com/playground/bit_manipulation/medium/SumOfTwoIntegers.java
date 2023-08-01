package com.playground.bit_manipulation.medium;

/**
 * 371. Sum of Two Integers
 */
public class SumOfTwoIntegers {

    /**
     * -ms Beats 100.00%
     * 39.14mb Beats 76.08%
     */
    public int getSum(int a, int b) {
        int carry = b;
        int result = a;

        while(carry != 0) {
            int temp = result ^ carry;
            carry = (result & carry) << 1;
            result = temp;
        }

        return result;
    }
}
