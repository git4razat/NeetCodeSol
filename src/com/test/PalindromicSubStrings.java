package com.test;

public class PalindromicSubStrings {

	// Time: O(n2)
	// Space: O(1)
	public int countSubstrings(String str) {
		int result = 0;
		for (int i = 0; i < str.length(); ++i) {
			result = result + extendPalindromes(i, i, str);
			result = result + extendPalindromes(i, i + 1, str);
		}
		return result;
	}

	private int extendPalindromes(int low, int high, String str) {
		int count = 0;
		while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
			++count;
			--low;
			++high;
		}
		return count;
	}

}
