package com.playground.sliding_window.string;

/**
 * 1888 in LeetCode
 */
public class MinimumNumberOfFlipsToMakeTheBinaryStringAlternating {


    public void run() {

        System.out.println(minFlips2("10001100101000000"));
    }


    public int minFlips(String s) {
        StringBuilder allCombinationsString = new StringBuilder(s).append(s);

        StringBuilder target1 = new StringBuilder();
        StringBuilder target2 = new StringBuilder();

        for(int i = 0; i < allCombinationsString.length(); i++) {
            target1.append((i%2==0) ? '1' : '0');
            target2.append((i%2==0) ? '0' : '1');
        }

        int minDifference = allCombinationsString.length();
        int target1Diff = 0, target2Diff = 0;
        int leftIndex = 0;

        for(int rightIndex = 0; rightIndex < allCombinationsString.length(); rightIndex++) {
            if (allCombinationsString.charAt(rightIndex) != target1.charAt(rightIndex))
                target1Diff++;
            if (allCombinationsString.charAt(rightIndex) != target2.charAt(rightIndex))
                target2Diff++;

            if((rightIndex - leftIndex + 1) > s.length()) {
                if (allCombinationsString.charAt(leftIndex) != target1.charAt(leftIndex))
                    target1Diff--;
                if (allCombinationsString.charAt(leftIndex) != target2.charAt(leftIndex))
                    target2Diff--;

                leftIndex ++;
            }

            if ((rightIndex - leftIndex + 1) == s.length()) // window size
                minDifference = Math.min(Math.min(minDifference, target2Diff), target1Diff);

            }

        return minDifference;
    }

    /**
     * much faster because of using char array also slightly better in memory.
     */
    public int minFlips2(String s) {
        int windowSize = s.length();
        char[] allCombinationsString = (s + s ).toCharArray();
        char[] target1 =new char[2*windowSize];
        char[] target2 =new char[2*windowSize];

        for(int i = 0; i < allCombinationsString.length; i++) {
            target1[i] = (i%2==0) ? '1' : '0';
            target2[i] = (i%2==0) ? '0' : '1';
        }

        int minDifference = allCombinationsString.length;
        int target1Diff = 0, target2Diff = 0;
        int leftIndex = 0;

        for(int rightIndex = 0; rightIndex < allCombinationsString.length; rightIndex++) {
            if (allCombinationsString[rightIndex] != target1[rightIndex])
                target1Diff++;
            if (allCombinationsString[rightIndex] != target2[rightIndex])
                target2Diff++;

            if((rightIndex - leftIndex + 1) > s.length()) {
                if (allCombinationsString[leftIndex] != target1[leftIndex])
                    target1Diff--;
                if (allCombinationsString[leftIndex] != target2[leftIndex])
                    target2Diff--;

                leftIndex ++;
            }

            if ((rightIndex - leftIndex + 1) == s.length()) // window size
                minDifference = Math.min(Math.min(minDifference, target2Diff), target1Diff);

        }

        return minDifference;
    }
}
