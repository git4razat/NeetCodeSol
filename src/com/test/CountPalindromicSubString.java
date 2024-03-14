package com.test;

public class CountPalindromicSubString {
	private static boolean validPalindrome(String str) {

		int i = 0;
		int j = str.length() - 1;

		while (i <= j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			} else {
				i++;
				j--;
			}
		}
		return true;
	}

	public static int countAllPalindromeSubstrings(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String s1 = s.substring(i, j);
				if (validPalindrome(s1))
					count++;
					//System.out.println(s1);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String s = "aaa";
		System.out.println(countAllPalindromeSubstrings(s));
	}

}
