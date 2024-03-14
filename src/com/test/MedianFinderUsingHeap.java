package com.test;

import java.util.PriorityQueue;


//
//Time: O(nlog⁡n)
//Space: O(n)
//

public class MedianFinderUsingHeap {
	
	PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinderUsingHeap() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
    }
    
    public void addNum(int num) {
        if (maxHeap.size() == 0 || num < maxHeap.peek())
            maxHeap.add(num);
        else
            minHeap.add(num);

        // balance heaps
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek())/2;
        } else {
            return maxHeap.peek();
        }
    }

}
