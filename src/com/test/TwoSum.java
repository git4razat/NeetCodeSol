package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static void main(String[] args) {
		int[] inputArr = new int[] {2,7,11,15};
		int target = 18;
		System.out.println(Arrays.toString(TwoSum.getTwoSum(inputArr, target)));
	}
	
	private static int[] getTwoSum(int[] arr, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			int diff = target - arr[i];
			if (map.containsKey(diff)) {
				return new int[] {map.get(diff), i};
			}
			
			map.put(arr[i], i);
		}
		return null;
	}
	
	
	// array - new int[] {1,2}

}
