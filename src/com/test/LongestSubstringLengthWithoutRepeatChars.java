package com.test;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringLengthWithoutRepeatChars {
	
	public static void main(String[] args) {
		
	}
	
	private static int getMaxLength(String str) {
		int start= 0;
		int end = 0;
		int maxLength= 0;
		Set<Character> uniqueChars = new HashSet<Character>(); 
		while (end < str.length()) {
			if (uniqueChars.add(str.charAt(end))) {
				end++;
				maxLength = Math.max(maxLength, uniqueChars.size());
			} else {
				uniqueChars.remove(str.charAt(start));
				start++;
			}
		}
		return maxLength;
	}

}
