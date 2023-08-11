package com.playground.dynamic_programming.two_dimensions.medium;

import java.util.Arrays;

/**
 * 518. Coin Change II
 */
public class CoinChange2 {
    // 5% Runtime !! very bad(~200ms). and 50 % memory
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length];
        for(int i = 0; i <= amount; i++) Arrays.fill(dp[i], -1);
        return changeRec(amount, coins, 0, dp);
    }

    public int changeRec(int amount, int[] coins, int coinIndex, int[][] dp) {
        if(amount < 0) return 0;
        if(amount == 0) return 1;
        if(dp[amount][coinIndex] != -1) return dp[amount][coinIndex];

        dp[amount][coinIndex] = 0;
        for(int i = coinIndex; i < coins.length; i++) dp[amount][coinIndex] += changeRec(amount - coins[i], coins, i, dp);

        return dp[amount][coinIndex];
    }

    // 27% runtime ~10 ms, 58.8% memory
    public int changeBottomUp1(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        Arrays.fill(dp[0], 1);

        for(int i = 0; i  <amount + 1; i++)
            for(int j = coins.length - 1; j >= 0; j--) {
                dp[i][j] = dp[i][j+1];
                if(i - coins[j] >= 0) dp[i][j]+= dp[i - coins[j]][j];
            }

        return dp[amount][0];
    }


    // 36% (9ms), 62 memory.
    public int changeBottomUp2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        for(int i = coins.length - 1; i >= 0; i--) {
            int[] nextDp = new int[amount + 1];
            nextDp[0] = 1;
            for(int j = 1; j <= amount; j++) {
                nextDp[j] = dp[j];
                if(j - coins[i] >= 0) nextDp[j]+=nextDp[j - coins[i]];
            }
            dp = nextDp;
        }
        return dp[amount];
    }

    // Not my solution just a brilliant one.
    public int changeBottomUp3(int amount, int[] coins) {
        int[] arr = new int[amount+1];
        arr[0] = 1;
        for(int c : coins)
            for(int i = c; i <= amount; i++)
                arr[i] += arr[i-c];
        return arr[amount];
    }
}
