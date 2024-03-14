package com.test;

import java.util.Arrays;

public class ProductExceptSelf {
	
	public static void main(String[] args) {
		productExceptSelf(new int[] {4,2,3,4});
	}
	
	private static int[] productExceptSelf(int[] numsArr) {
		int[] product = new int[numsArr.length];
		int left = 1; int right = 1;
		
		for (int i = 0; i < numsArr.length; i++) {
			product[i] = left;
			left = left * numsArr[i];
		}
		
		for (int i = numsArr.length - 1; i >= 0 ; i--) {
			product[i] = product[i] * right;
			right = right * numsArr[i];
		}
		
		System.out.println("Arrray::" + Arrays.toString(product));
		
		return product;
	}

}
