package com.test;

import java.util.Arrays;

public class RotateImageMatrix {
	
	public static void main(String[] args) {
		
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		System.out.println("Before Rotate::");
		printMatrix(matrix);
		rotateImage(matrix);
		
		System.out.println("After Rotate::");
		printMatrix(matrix);
	}
	
	// https://yuminlee2.medium.com/leetcode-48-rotate-image-973d0e85ffc6
	// time o(mn) space o(1)
	// A matrix can be rotated 90 by transpose and then reverse rows
	// Transpose - Transpose so that rows becomes cols and viceversa
	// Reverse (Flip Matrix Horizontally) - Reverse order of all cols and result will be rotated matrix by 90
	private static void rotateImage(int[][] matrix) {
        int N = matrix.length;
        int tmp;
        for(int i=0; i<N; i++) {
            for(int j=0; j<i; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N/2; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][N-1-j];
                matrix[i][N-1-j] = tmp;
            }
        }
	}
	
	private static void printMatrix(int[][] matrix) {
		for(int[] partialMatrix: matrix) {
	    	System.out.println(Arrays.toString(partialMatrix));
	    }
	}

}
