package com.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortMapUsingValueComparator {
	//https://devqa.io/java-sort-map/
	public static void main(String[] args) {
		/*Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("John", 25);
        unsortedMap.put("Alice", 30);
        unsortedMap.put("Bob", 20);*/
        
        HashMap<Integer, EName> hmap = new HashMap<Integer, EName>();
		EName name1 = new EName("Jayant", "Verma");
		EName name2 = new EName("Ajay", "Gupta");
		EName name3 = new EName("Mohan", "Sharma");
		EName name4 = new EName("Rahul", "Dev");

		hmap.put(9, name1);
		hmap.put(1, name2);
		hmap.put(6, name3);
		hmap.put(55, name4);

        // Sort the map by its values using a custom comparator
        /*List<Map.Entry<String, Integer>> entries = new ArrayList<>(unsortedMap.entrySet());
        entries.sort(Map.Entry.comparingByValue((a, b) -> {
        	return b - a;
        }));
        
        // Create a LinkedHashMap to maintain the order of insertion
        Map<String, Integer> sortedByValueMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            sortedByValueMap.put(entry.getKey(), entry.getValue());
        }*/
        
     // Sort the map by its values using Stream API
        Map<Integer, EName> sortedByValueMap = hmap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((a, b) -> {
                	return a.firstName.compareTo(b.firstName);
                }))
                .collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), LinkedHashMap::putAll);

        // Print the sorted map
        for (Map.Entry<Integer, EName> entry : sortedByValueMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
	}
	
	static class EName {
		String firstName;
		String lastName;
		public EName(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		@Override
		public String toString() {
			return "EName [firstName=" + firstName + ", lastName=" + lastName + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}
		
		
	}

}
