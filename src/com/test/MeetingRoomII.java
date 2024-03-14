package com.test;

import java.util.Arrays;

public class MeetingRoomII {
	
	
	// o(nlogn)
	public int minMeetingRooms(int[][] intervals) {
        if (intervals == null) return 0;

        //sort all start index
        int[] starts = extract(intervals, 0);
        // sort all end index
        int[] ends = extract(intervals, 1);
        
        int count = 0, j = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[j]) count++;
            else j++;
        }
        
        return count;
    }
    
    private int[] extract(int[][] intervals, int index) {
        int[] array = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            array[i] = intervals[i][index];
        }
        Arrays.sort(array);
        return array;
    }
    
    public static void main(String[] args) {
    	
    	int[][] intervals = {
    			{0,30},
				{5,10},
				{10,15}
    	};
    	
    	MeetingRoomII room = new MeetingRoomII();
    	System.out.println(room.minMeetingRooms(intervals));
	}

}
