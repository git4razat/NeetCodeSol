package com.test;

public class SumOfTwoBinary {
	
	public static void main(String[] args) {
		System.out.println(getSum(9,11));
	}
	
	// this will use bit manipulation
	// https://www.youtube.com/watch?v=gG3aJrbszFI
	private static int getSum(int a, int b) {
		while (b != 0) {
			int temp = a & b;
			a = a ^ b;
			b = temp << 1;
		}
		return a;
	}
}
