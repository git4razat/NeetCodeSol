package com.test;

public class FindMinInRotatedSortedArray {
	
	public static void main(String[] args) {
		int[] nums = {4,5,1,2,3};
		System.out.println(getMinFromArray(nums));
	}
	
	// https://www.youtube.com/watch?v=l1hBhx9CUAQ
	// o(log n)
	private static int getMinFromArray(int[] nums) {
		int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (nums[high] < nums[mid]) {// right part is unsorted
                low = mid + 1;
            } else {//left part is unsorted
                high = mid;
            }
        }
        return nums[low];
	}
}
