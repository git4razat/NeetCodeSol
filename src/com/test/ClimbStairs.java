package com.test;

public class ClimbStairs {
	// DP
	// o(n) - time
	// o(1) - space
	public int climbStairs(int n) {
		int one = 1;
		int two = 1;

		for (int i = 2; i <= n; i++) {
			int temp = one + two;
			two = one;
			one = temp;
		}
		return one;
	}

}
