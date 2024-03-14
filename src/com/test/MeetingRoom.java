package com.test;

import java.util.Arrays;

public class MeetingRoom {
	
	// o(n log n) - sorting is there on start interval..
	public boolean canAttendMeetings(int[][] intervals) {
	    Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
	    
	    for (int i = 1; i < intervals.length; i++) {
	    	// if end of an interval is after start of next interval
	    	// then can't attend and return true
	    	if (intervals[i - 1][1] > intervals[0][i]) {
	    		return false;
	    	}
	    }
	    return true;
	    
	}
	
	
	public static void main(String[] args) {
		int[][] intervals = {
				{0,30},
				{5,10},
				{15,20}
		};
		
		MeetingRoom room = new MeetingRoom();
		System.out.println(room.canAttendMeetings(intervals));
	}

}
