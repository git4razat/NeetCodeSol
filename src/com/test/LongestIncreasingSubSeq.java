package com.test;

import java.util.Arrays;

public class LongestIncreasingSubSeq {

	/**
	 *  Time: O(n2)
		Space: O(n)
	 * 
	 */
	public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        
        for(int i=1; i< nums.length; i++) {
            for(int j=0; j<i; j++) {
            	if(nums[i]>nums[j]) {
                    dp[i]= Math.max(dp[i],dp[j]+1);
                }
            }
        }
        
        //System.out.println(Arrays.toString(dp));

        int maxi = 1;

        for(int len : dp) {
            maxi = Math.max(maxi,len);
        }

        return maxi;
    }
	
	public static void main(String[] args) {
		System.out.println("LIS::" + lengthOfLIS(new int[] {0,1,0,3,2,3}));
	}

}
