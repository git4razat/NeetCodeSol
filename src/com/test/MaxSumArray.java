package com.test;

public class MaxSumArray {
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(getMaxSumArray(arr));
		
	}
	
	private static int getMaxSumArray(int[] arr) {
		int max = arr[0];
		int temp = arr[0];
		for (int i =1 ; i < arr.length; i++) {
			temp = Math.max((temp + arr[i]),arr[i]);
			max=  Math.max(max, temp);
		}
		return max;
	}

}
