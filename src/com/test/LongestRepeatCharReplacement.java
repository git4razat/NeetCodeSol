package com.test;

import java.util.HashMap;

public class LongestRepeatCharReplacement {
	
	public static void main(String[] args) {
		String s = "ABAB";
		int k = 2;
		LongestRepeatCharReplacement obj = new LongestRepeatCharReplacement();
		System.out.println(obj.characterReplacement(s,k));
	}
	// o(n)
	public int characterReplacement(String s, int k) {
	        int start = 0;
	        int end = 0;
	        int mostFreq = 0;
	        int maxL = 0;
	        HashMap<Character, Integer> map = new HashMap<>();
	        while(end < s.length()) {
	            char c = s.charAt(end);
	            int freq = (map.get(c) != null) ? map.get(c) : 0;
	            map.put(c, ++freq);
	            // always keep track of the most feq occur char in map
	            mostFreq = Math.max(mostFreq, map.get(c));
	            // end - start + 1 : windowSize
	            int window = end - start + 1;
	            if (window - mostFreq <= k) {
	                maxL = Math.max(maxL, window);
	            } else {
	            	// remove start el from map... and start from next el... which will move start for window
	                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
	                start++;
	            }
	            end++;
	        }
	        return maxL;
    }
}
