package com.test;

import java.util.ArrayList;
import java.util.List;

public class UnionIntersectionArrays {
	
	// union of two sorted arrays
		// {1,2,3,4}, {3,4,5,6} => {1,2,3,4,5,6}
		int[] getUnion(int[] arr1, int[] arr2) {
			int[] result = new int[arr1.length + arr2.length]; // or take a list
			int i = 0, j = 0, k = 0;

			while (i < arr1.length && j < arr2.length) {
				if (arr1[i] < arr2[j]) {
					result[k] = arr1[i];
					i++;
					k++;
				} else if (arr1[i] > arr2[j]) {
					result[k] = arr2[j];
					j++;
					k++;
				} else { // equals, consider only i or j and not both for result but increment all pointers;
					result[k] = arr1[i];
					k++;
					i++;
					j++;
				}
			}

			while (i < arr1.length) {
				result[k] = arr1[i];
				i++;
				k++;
			}

			while (j < arr2.length) {
				result[k] = arr2[j];
				j++;
				k++;
			}
			return result;
		}

		// intersection of two sorted arrays
		// {1,2,3,4}, {3,4,5,6} => {3,4}
		// should remove duplicates
		// if not sorted Sort arr1[] and arr2[]. This step takes O(mLogm + nLogn) time.
		int[] getIntersection(int[] arr1, int[] arr2) {
			List<Integer> result = new ArrayList<Integer>();
			int i = 0, j = 0, k = 0;

			while (i < arr1.length && j < arr2.length) {
				if (arr1[i] < arr2[j]) {
					i++;
				} else if (arr1[i] > arr2[j]) {
					j++;
				} else {
					// result[k] = arr1[i];
					// if (!result.contains((arr1[i]))) {
					// result.add(arr1[i]);
					// }
					result.add(arr1[i]);
					i++;
					j++;
				}
			}

			int[] finalRes = result.stream().mapToInt(x -> (int) x).toArray();
			return finalRes;
		}

}
