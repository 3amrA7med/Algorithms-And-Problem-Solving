package com.playground.binary_search.easy;

/**
 * 374. Guess Number Higher or Lower
 */
public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        int l = 1;
        int r = n;

        while(l <= r) {
            int m = l + (r-l) / 2;
            int guessNum = guess(m);
            if(guessNum == 0) return m;
            else if(guessNum == -1) r = m - 1;
            else l = m + 1;
        }

        // unused.
        return l;
    }

    private int guess(int num) {
        /*
         * You call a pre-defined API int guess(int num), which returns three possible results:
         * -1: Your guess is higher than the number I picked (i.e. num > pick).
         * 1:  Your guess is lower than the number I picked (i.e. num < pick).
         * 0:  your guess is equal to the number I picked (i.e. num == pick).
         */
        return 0;
    }
}
