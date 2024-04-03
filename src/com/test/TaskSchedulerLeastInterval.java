package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskSchedulerLeastInterval {

	// o(log n) - time
	// o(n) - space (due to heap & list/queue)
	public int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> task_counter = new HashMap<>();
		for (Character task : tasks) {
			task_counter.put(task, task_counter.getOrDefault(task, 0) + 1);
		}

		// add the frequency of all tasks to pq (Priority-Queue)
		// use reverseOrder to account for max-heap implementation
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
		maxHeap.addAll(task_counter.values());

		int time = 0;

		while (maxHeap.size() > 0) {
			List<Integer> add_back = new ArrayList<>();
			// loop for grabbing n tasks from pq or for idle itme only
			for (int i = 0; i <= n; i++) {

				// for grabbing n tasks from pq
				if (maxHeap.size() > 0) {
					int count = maxHeap.poll(); // retrieves max and removes an element from pq.
					count--;
					if (count > 0) { // needs add_back
						add_back.add(count);
					}
				}

				time = time + 1; // accounts for idle time and real task too.
				if (maxHeap.size() == 0 && add_back.size() == 0) { // this accounts when the last run of tasks is done and no
																// more tasks to ensure no idle runs happen when no
																// tasks to schecule.
					break;
				}

			}
			maxHeap.addAll(add_back);

		}
		return time;

	}

}
