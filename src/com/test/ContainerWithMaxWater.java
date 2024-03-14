package com.test;

public class ContainerWithMaxWater {
	
	public static void main(String[] args) {
		System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
	}
	
	//https://www.youtube.com/watch?v=w7ftYsZtIbs&t=563s
	//O(n)
	private static int maxArea(int[] height) {
		int left  = 0;
		int right = height.length - 1;
		int maxArea = 0;
		while (left < right) {
            int length = Math.min(height[left], height[right]);
            int width = right - left;
            int area = length * width;
            maxArea = Math.max(area, maxArea);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
		return maxArea;
	}
}
