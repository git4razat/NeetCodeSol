package com.test;

public class MaxSumSubArray {
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(getMaxSumSubArray(arr));
		
	}
	//https://www.youtube.com/watch?v=usxn9PV6Fdo
	// o(n)
	// 1 2 3 4
	/**
	 * 1 -  sum =  1, maxSum - 1
	 * 2 -  sum =   2, maxSum - 2
	 * -2 - sum = -1, maxSum - 2, finally sum = 0
	 * 4  - sum = 4, maxSum = 4
	 * 
	 */
	public static int getMaxSumSubArray(int[] arr) {
		int sum = 0;
		int maxSum = arr[0];
		
		for (int i = 0; i < arr.length - 1; i++) {
			sum = sum + arr[i];
			maxSum = Math.max(maxSum, sum);
			if (sum < 0) {
				sum = 0;
			}
		} 
		return maxSum;
	}

}
