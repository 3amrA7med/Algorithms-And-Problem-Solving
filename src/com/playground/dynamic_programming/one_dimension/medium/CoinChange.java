package com.playground.dynamic_programming.one_dimension.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 322. Coin Change
 */
public class  CoinChange {
    /**
     * VERY BAD 5% ~200ms
     */
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        Map<Integer, Integer> dp = new HashMap<>();
        int result = coinRec(dp, coins, amount);
        if(result == Integer.MAX_VALUE) return -1;
        else return result;
    }

    private int coinRec(Map<Integer, Integer> dp, int[] coins, int amount) {
        if(dp.containsKey(amount)) return dp.get(amount);
        if(amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;

        int val = Integer.MAX_VALUE;
        for(int i =0; i < coins.length; i++)
            val = Math.min(coinRec(dp, coins, amount - coins[i]) , val);

        if(val == Integer.MAX_VALUE) dp.put(amount, Integer.MAX_VALUE);
        else dp.put(amount, val + 1);
        return dp.get(amount);
    }

    // 20ms 55%
    public int coinChangeBottomUp(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        for(int i =1; i <= amount; i++) {
            dp[i] = amount + 1;
            for(int j = 0; j < coins.length; j++) {
                if(i - coins[j] > 0) dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                else if(i - coins[j] == 0) dp[i] = 1;
            }
        }
        if(dp[amount] == amount + 1) return -1;
        else return dp[amount];
    }

}
