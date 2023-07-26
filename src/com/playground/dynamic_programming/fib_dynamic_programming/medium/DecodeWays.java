package com.playground.dynamic_programming.fib_dynamic_programming.medium;

import java.util.Arrays;

/**
 * 91. Decode Ways
 */
public class DecodeWays {

    public void run() {
        System.out.println(numDecodingsFibDp("12"));
    }

    /**
     * 1ms Beats 95.29%
     * 40.62mb Beats 82.92%
     */
    public int numDecodingsFibDpBest(String s) {

        char[] arr = s.toCharArray();
        int resLen1 = 1;
        int resLen2 = 0;
        for(int i = arr.length - 1; i >= 0; i--) {
            int temp = 0;
            if(arr[i] == '0') temp = 0;
            else {
                temp = resLen1;
                if(checkIfValidTwoDigits(arr, i))
                    temp += resLen2;
            }
            resLen2 = resLen1;
            resLen1 = temp;
        }

        return resLen1;
    }

    private boolean checkIfValidTwoDigits(char[] arr, int i) {
        return (i + 1 < arr.length &&
                (
                        arr[i] == '1' || (arr[i] == '2' && arr[i+1] != '9' && arr[i+1] != '8' && arr[i+1] != '7')
                )
        );
    }

    /**
     * 5ms Beats 9.45%
     * 41.43mb Beats 10.87%
     * @param s
     * @return
     */
    public int numDecodingsFibDp(String s) {
        char[] arr = s.toCharArray();
        int resLen1 = 1;
        int resLen2 = 0;
        for(int i = arr.length - 1; i >= 0; i--) {
            int temp;
            if(arr[i] == '0') temp = 0;
            else {
                temp = resLen1;
                if(i + 1 < arr.length && Integer.parseInt(String.valueOf(arr[i]) + arr[i+1]) <= 26)
                    temp += resLen2;
            }
            resLen2 = resLen1;
            resLen1 = temp;
        }

        return resLen1;
    }

    int[] decodingsDp;

    /**
     * 6ms Beats 8.66%
     * 41.27mbBeats 19.22%
     * @param s
     * @return
     */
    public int numDecodings1(String s) {
        if(s.charAt(0) == '0') return 0;
        decodingsDp = new int[s.length()];
        Arrays.fill(decodingsDp, -1);
        return numDecodingsTopDown1(s.toCharArray(), 0);
    }

    private int numDecodingsTopDown1(char[] characters, int index) {
        if(index == characters.length) return 1;
        if(index == characters.length + 1) return 0;
        if(decodingsDp[index] >= 0) return decodingsDp[index];

        if(characters[index] == '0') return 0;
        if(index + 1 < characters.length && Integer.parseInt(String.valueOf(characters[index]) + characters[index + 1]) > 26)
            decodingsDp[index] = numDecodingsTopDown1(characters, index + 1);
        else
            decodingsDp[index] = numDecodingsTopDown1(characters, index + 1) + numDecodingsTopDown1(characters, index + 2);

        return decodingsDp[index];
    }

    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        decodingsDp = new int[s.length()];
        return numDecodingsTopDown(s.toCharArray(), 0);
    }

    /**
     * 130ms Beats 5.15%, best 1ms  === Because of notsaving zero state.
     * 44.59mb Beats 5.12% est 40
     * @param characters
     * @param index
     * @return
     */
    private int numDecodingsTopDown(char[] characters, int index) {
        if(index == characters.length) return 1;
        if(index == characters.length + 1) return 0;
        if(decodingsDp[index] > 0) return decodingsDp[index];

        if(characters[index] == '0') return 0;
        if(index + 1 < characters.length && Integer.parseInt(String.valueOf(characters[index]) + characters[index + 1])  > 26)
            decodingsDp[index] = numDecodingsTopDown(characters, index + 1);
        else
            decodingsDp[index] = numDecodingsTopDown(characters, index + 1) + numDecodingsTopDown(characters, index + 2);

        return decodingsDp[index];
    }
}
