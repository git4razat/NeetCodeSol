package com.test;

import java.util.Arrays;

public class TwoSumB {
	
	public static void main(String[] args) {
		int[] inputArr = new int[] {2,7,11,15};
		int target = 18;
		System.out.println(Arrays.toString(twoSum(inputArr, target)));
	}
	
	// using pointers - leetcode 167
	// this is only applicable to sorted arrays
	// o(n)
	private static int[] twoSum(int[] arr, int target) {
		
		int l = 0;
		int h = arr.length - 1;
		
		while(l <= h) {
			int sum = arr[l] + arr[h];
			if (sum > target) {
				h--;
			} else if (sum < target) {
				l++;
			} else if (sum == target) {
				return new int[] {l+1,h+1};
			} else { // not found
				return null;
			}
		}
		return null;
	}

}
