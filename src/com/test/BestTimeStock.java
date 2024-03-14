package com.test;

public class BestTimeStock {
	
	// best time to buy and sell stock to get max profit...
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {7,1,5,3,6,4};
		System.out.println(getMaxProfit(arr));
	}
	
	// o(n)
	private static int getMaxProfit(int[] arr) {
		int buy = 0, sell = 0;
		int maxProfit = 0;
		while (sell < arr.length) {
			if (arr[sell] > arr[buy]) {
				int profit = arr[sell] - arr[buy];
				maxProfit = Math.max(maxProfit, profit);
			} else {
				buy = sell;
			}
			sell++;
		}
		return maxProfit;
	}

}
