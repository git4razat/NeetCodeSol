package com.test;

import java.util.PriorityQueue;

public class KthLargestInStream {

	private final int k;
	private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	// o(nlogk)
	public KthLargestInStream(int k, int[] nums) {
        this.k = k;
		for (final int num : nums)
			heapify(num);
    }
    
    public int add(int val) {
        heapify(val);
		return minHeap.peek();
    }
    
    private void heapify(int val) {
		minHeap.add(val);
		if (minHeap.size() > k)
			minHeap.poll();
	}
}