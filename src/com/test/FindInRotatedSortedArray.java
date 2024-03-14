package com.test;

public class FindInRotatedSortedArray {
	
	public static void main(String[] args) {
		System.out.println(findIndexOfElement(new int[] {1}, 0));
	}
	
	// https://www.youtube.com/watch?v=DpS8iWXh4k0
	
	private static int findIndexOfElement(int[] arr, int k) {
		
		int low = 0;
		int high = arr.length -1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == k) {
				// bingo
				return mid;
			} else if (arr[low] <= arr[mid])  { // left array is sorted
				if (arr[low] <= k && k < arr[mid]) {// in sorted part
					high = mid - 1;
				} else {// not in sorted part
					low = mid + 1;
				}
			} else { // right array is sorted
				if (arr[mid] < k && k <= arr[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}
}
