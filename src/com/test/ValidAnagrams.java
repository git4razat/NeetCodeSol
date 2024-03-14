package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagrams {
	
	public static void main(String[] args) {
		System.out.println(validAnagrams("car", "arc"));
	}
	
	//o(n), space o(n) - hashmap
	private static boolean validAnagrams(String s, String t) {
		
		Map<Character, Integer> count = new HashMap<>();
        
        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        
        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }
        
        // Check if any character has non-zero frequency
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }
        
        return true;
    }
	
	// o(nlogn)
	public boolean isAnagram2(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        return Arrays.equals(sChars, tChars);
    }

}
