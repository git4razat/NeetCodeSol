package com.test;


import java.util.*;

// check video first - https://www.youtube.com/watch?v=b7kKMSiFifo


//https://www.geeksforgeeks.org/find-winner-election-votes-represented-candidate-names/
// time o(n) - space o(n)

//https://www.geeksforgeeks.org/find-who-won-the-election-based-on-given-voting-system/

public class VotingApp {
    /* We have four Candidates with name as 'John',
      'Johnny', 'jamie', 'jackie'.
       The votes in String array are as per the
       votes casted. Print the name of candidates
       received Max vote. */
    public static String[] findWinner(String votes[])
    {
        // Insert all votes in a hashmap
    	// frequency map with name, count of votes
        Map<String, Integer> map
            = new HashMap<String, Integer>();
        for (String str : votes) {
            if (map.keySet().contains(str))
                map.put(str, map.get(str) + 1);
            else
                map.put(str, 1);
        }
 
        // Traverse through map to find the candidate
        // with maximum votes.
        int maxValueInMap = 0;
        String winner = "";
        for (String key : map.keySet()) {
            int val = map.get(key);
            if (val > maxValueInMap) {
                maxValueInMap = val;
                winner = key;
            }
 
            // If there is a tie, pick lexicographically
            // smaller.
            else if (val == maxValueInMap
                     && winner.compareTo(key) > 0)
                winner = key;
        }
        return new String[]{winner, maxValueInMap+""};
        //System.out.println(winner);
    }
 
    // Driver code
    public static void main(String[] args)
    {
        String[] votes
            = {"blake","andy","clark"};
 
        System.out.println(Arrays.toString(findWinner(votes)));
    }
}
