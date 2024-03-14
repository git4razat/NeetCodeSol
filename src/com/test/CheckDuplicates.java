package com.test;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class CheckDuplicates {
	
	public static void main(String[] args) {
		int[] inputArr = new int[] {1,2,3,4};
		System.out.println(hasDuplicates(inputArr));
	}
	
	public static boolean hasDuplicates(int[] arr) {
		
		HashSet<Integer> set = new LinkedHashSet<Integer>();
		for (int value: arr) {
			boolean result = set.add(value);
			if (!result) return true;
		}
		return false;
	}

}
