package com.test;

public class WordSearchMatrix {
	public static void main(String[] args) {
		char[][] board = { 
				{ 'A', 'B', 'E' },
				{ 'C', 'D', 'N' },
				{ 'F', 'G', 'T' } 
		};
		System.out.println(exist(board, "END"));
	}

	// o(mn) - time and no extra space o(1)
	public static boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; ++i)
			for (int j = 0; j < board[0].length; ++j)
				if (dfs(board, word, i, j, 0))
					return true;
		return false;
	}

	private static boolean dfs(char[][] board, String word, int i, int j, int s) {
		if (i < 0 || i == board.length || j < 0 || j == board[0].length)
			return false;
		if (board[i][j] != word.charAt(s) || board[i][j] == '*')
			return false;
		if (s == word.length() - 1)
			return true;
		char cache = board[i][j];
		board[i][j] = '*';
		final boolean isExist = 
				dfs(board, word, i + 1, j, s + 1) || //
				dfs(board, word, i - 1, j, s + 1) || //
				dfs(board, word, i, j + 1, s + 1) || //
				dfs(board, word, i, j - 1, s + 1);
		board[i][j] = cache;
		return isExist;
	}

}
