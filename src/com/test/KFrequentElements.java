package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class HeapNode {
	public int num;
	public int freq;

	public HeapNode(int num, int freq) {
		this.num = num;
		this.freq = freq;
	}
}

// time - o(nlogk), space - O(n + k)
public class KFrequentElements {
	
	public static int[] topKFrequent(int[] nums, int k) {
		
		final int n = nums.length;
		int[] result = new int[k];
		HashMap<Integer, Integer> freqMap = new HashMap<>();
		PriorityQueue<HeapNode> minHeap = new PriorityQueue<HeapNode>((a, b) -> {
			
			// if same freq them return highest number
			if (a.freq == b.freq) {
				return a.num - b.num;
			}
			
			return a.freq - b.freq;
		});

		for (int num : nums) {
			int freqForNum = freqMap.getOrDefault(num, 0);
			freqMap.put(num, ++freqForNum);
		}
		System.out.println(freqMap);

		for (int key : freqMap.keySet()) {
			int value = freqMap.get(key);
			HeapNode node = new HeapNode(key, value);
			minHeap.add(node);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		for (int i = 0; i < k; i++) {
			result[i] = minHeap.poll().num;
		}

		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,2,4,3,7,5,6,2,8,4,3,6,7};
		System.out.println(Arrays.toString(topKFrequent(nums, 3)));
		
	}
}
