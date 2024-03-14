 package com.test;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {

	
	//Encode - length DELIMITER(#) string
	public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs.size(); i++) {
            String str = strs.get(i);
            int length = str.length();
            sb.append(length + "#" + str);
        }
        return sb.toString();
    }

	// Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<String>();
        StringBuffer sb = new StringBuffer(s);

        int endIndex = 0;
        while (endIndex < s.length()) {
        	// 3#app4#test
            int index = sb.toString().indexOf('#', endIndex); // @note: first `#` after index i - 1
            int length = Character.getNumericValue(sb.charAt(endIndex));
            endIndex = index + length + 1;
            String str = sb.substring(index + 1, endIndex);
            list.add(str);
        }
        System.out.println("List::" + list);
        return list;
    }
    
    public static void main(String[] args) {
		EncodeDecode obj = new EncodeDecode();
		obj.decode("3#app4#test");
	}
}
