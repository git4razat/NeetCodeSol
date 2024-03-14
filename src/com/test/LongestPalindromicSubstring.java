package com.test;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String str) {
        if (str.length() <= 1)
			return str;
		String result = "";
		for (int i = 1; i < str.length(); i++) {
			// Consider odd length
			result = getLPS(i, i, str, result);
			// Consider even length
			result = getLPS(i-1, i, str, result);
		}
		return result;
    }

    public String getLPS(int low, int high, String str, String result) {
    	while(low >= 0 && high< str.length() && str.charAt(low) == str.charAt(high)) {
            low--;
            high++;
        }
        String palindrome = str.substring(low + 1, high);
        if (palindrome.length() > result.length()) {
            result = palindrome;
        }
        return result;
    }
}
