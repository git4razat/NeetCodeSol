package com.test;

import java.util.Arrays;

// time -  o(|coins||amount|)
// space - o(|amount|)
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
        // dp[i] := the minimum number of coins to make up i
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 1, dp.length, amount + 1);

        for (int i = 1; i <= amount; ++i) // amount = 7 -  1,2,3,4,5,6,7
        	for (int coin : coins) // 1,2,5
	            if (coin <= i) // 1 < 1,2,5
	            	dp[i] = Math.min(dp[i], dp[i - coin] + 1);

        return (dp[amount] == (amount + 1)) ? -1 : dp[amount];
    }
}
