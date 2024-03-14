package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2,2, -1, -4 };
		System.out.println(threeSum(nums));
	}

	// here we are trying for target 0.. so that sum of tripplet is 0
	// O(n2)
	// additional o(n logn) if array is not sorted
	public static List<List<Integer>> threeSum(int[] nums) {
		// Sort the array
		Arrays.sort(nums);
		// Length of the array
		int n = nums.length;
		// Resultant list
		List<List<Integer>> triplets = new ArrayList<>();
		// Loop for each element of the array
		for (int i = 0; i < n; i++) {
			// Skip the duplicates
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			// Left and right pointers
			int j = i + 1;
			int k = n - 1;
			// Loop for all the remaining pairs
			while (j < k) {
				if (nums[i] + nums[j] + nums[k] == 0) {
					triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					// Never let j refer to the same value twice (in an output) to avoid duplicates
					while (j < k && nums[j] == nums[j - 1]) {
						j++;
					}
				} else if (nums[i] + nums[j] + nums[k] < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		return triplets;
	}
}
