package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	public static void main(String[] args) {
		String[] words = {"pop","bat","tab","opp"};
        List<List<String>> res = groupAnagrams(words);
        // groupAnagramsEff is better approach
        System.out.println(res);
	}
	
	// o(nlogk)
	// n is number of strings and k is length of largest string..
	private static List<List<String>> groupAnagrams(String[] strs) {
		ArrayList<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, Integer> helper = new HashMap<String, Integer>();
        for (int i = 0; i < strs.length; i ++) {
            char[] tmpChar = strs[i].toCharArray();
            Arrays.sort(tmpChar);
            String tmp = new String(tmpChar);
            if (helper.containsKey(tmp)) {
                result.get(helper.get(tmp)).add(strs[i]);
                //continue;
            } else {
            	List<String> curr = new LinkedList<String>();
                curr.add(strs[i]);
                result.add(curr);
                helper.put(tmp, result.size() - 1);
            }
        }
        return result;
	}
	
	/*public List<List<String>> groupAnagramsEff(String[] strs) {
		Map<String, ArrayList<String>> mp = new HashMap();
		for (String s : strs) {
			String key = getkey(s);
			ArrayList<String> ll = mp.getOrDefault(key, new ArrayList<String>());
			ll.add(s);
			mp.put(key, ll);
		}
		List<List<String>> ans = new ArrayList();
		for (Map.Entry<String, ArrayList<String>> entry : mp.entrySet())
			ans.add(entry.getValue());
		return ans;
	}

	public String getkey(String s) {
		int prod = 1, xor = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			prod *= ch;
			xor ^= ch;
		}
		return prod + "-" + xor;
	}*/

}
