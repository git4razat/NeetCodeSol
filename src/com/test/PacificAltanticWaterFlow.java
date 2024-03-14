package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAltanticWaterFlow {
	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		final int rows = heights.length;
		final int cols = heights[0].length;
		List<List<Integer>> ans = new ArrayList<>();
		boolean[][] seenPac = new boolean[rows][cols];
		boolean[][] seenAtl = new boolean[rows][cols];

		for (int i = 0; i < rows; ++i) {
			dfs(heights, i, 0, 0, seenPac);
			dfs(heights, i, cols - 1, 0, seenAtl);
		}

		for (int j = 0; j < cols; ++j) {
			dfs(heights, 0, j, 0, seenPac);
			dfs(heights, rows - 1, j, 0, seenAtl);
		}

		for (int i = 0; i < rows; ++i)
			for (int j = 0; j < cols; ++j)
				if (seenPac[i][j] && seenAtl[i][j])
					ans.add(new ArrayList<>(Arrays.asList(i, j)));

		return ans;
	}

	private void dfs(final int[][] heights, int i, int j, int h, boolean[][] seen) {
		if (i < 0 || i == heights.length || j < 0 || j == heights[0].length)
			return;
		if (seen[i][j] || heights[i][j] < h)
			return;

		seen[i][j] = true;
		dfs(heights, i + 1, j, heights[i][j], seen);
		dfs(heights, i - 1, j, heights[i][j], seen);
		dfs(heights, i, j + 1, heights[i][j], seen);
		dfs(heights, i, j - 1, heights[i][j], seen);
	}
}
