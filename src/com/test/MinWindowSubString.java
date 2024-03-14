package com.test;

import java.util.HashMap;

public class MinWindowSubString {

	public static void main(String[] args) {
		MinWindowSubString minWin = new MinWindowSubString();
		System.out.println(minWin.minWindow("ADOBECODEBANC", "ABC"));
	}

	//https://www.youtube.com/watch?v=e1HlptlipB0
	
	public String minWindow(String s, String t) {
		String ans = "";
		HashMap<Character, Integer> map2 = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			char ch = t.charAt(i);
			map2.put(ch, map2.getOrDefault(ch, 0) + 1);
		}
		//System.out.println("map2:" + map2);
		int mct = 0; // match count
		int dmct = t.length(); // Desired match count

		HashMap<Character, Integer> map1 = new HashMap<>();
		int i = -1;
		int j = -1;

		while (true) {
			boolean f1 = false;
			boolean f2 = false;

			// Acquire
			while (i < s.length() - 1 && mct < dmct) {
				i++;
				char ch = s.charAt(i);
				map1.put(ch, map1.getOrDefault(ch, 0) + 1);

				if (map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)) {
					mct++;
				}
				f1 = true;
			}

			// collect answers and release
			while (j < i && mct == dmct) {
				String pans = s.substring(j + 1, i + 1);
				if (ans.length() == 0 || pans.length() < ans.length()) {
					ans = pans;
				}
				j++;
				char ch = s.charAt(j);
				if (map1.get(ch) == 1) {
					map1.remove(ch);
				} else {
					map1.put(ch, map1.get(ch) - 1);
				}

				if (map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)) {
					mct--;
				}
				f2 = true;
			}

			if (f1 == false && f2 == false) {
				break;
			}
		}
		return ans;
	}

}
