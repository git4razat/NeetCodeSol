package com.test;

public class MaxProductSubArray {
	
	public static void main(String[] args) {
		int[] arr = new int[] {2,3,-2,-4,5};
		
		System.out.println(getMaxProduct(arr));
	}
	
	//https://www.youtube.com/watch?v=Y6B-7ZctiW8 - must watch
	//https://dev.to/rohithv07/leetcode-152-maximum-product-subarray-4c6k
	// o(n)
	private static int getMaxProduct(int[] arr) {
		int prefixProduct = 1;
		int suffixProduct = 1;
		int maxProduct = arr[0];
		for (int i = 0; i < arr.length; i++) {
			prefixProduct = ((prefixProduct == 0) ? 1 : prefixProduct) * arr[i];
			suffixProduct = ((suffixProduct == 0) ? 1 : suffixProduct) * arr[arr.length - i - 1];
			maxProduct = Math.max(maxProduct, Math.max(suffixProduct, prefixProduct));
		}
		return maxProduct;
	}
}
 