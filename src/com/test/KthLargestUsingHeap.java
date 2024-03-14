package com.test;

import java.util.PriorityQueue;

public class KthLargestUsingHeap {
	
	PriorityQueue<Integer> minHeap;
	
	// largest - use min heap 
	// smallest - use max heap
	
	public KthLargestUsingHeap() {
		minHeap  = new PriorityQueue<Integer>();
		//maxHeap = new PriorityQueue<Integer>((a,b) -> { return b - a;});
	}
	
	// o(nlogk)
	int findKthLargest(int[] nums, int k) {
		// 3 10 13 2 5, k = 3
		for (int num: nums) {
			minHeap.add(num);// add and check if size > k, pop in that case... min el will be moved out....
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		
		return minHeap.peek();
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 10, 13, 2 ,5};
		int k = 3;
		KthLargestUsingHeap obj = new KthLargestUsingHeap();
		int result = obj.findKthLargest(nums, k);
		System.out.println(result);
	}

}
