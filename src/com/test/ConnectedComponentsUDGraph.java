package com.test;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponentsUDGraph {
	
	List<Integer>[] adj;  
	
	// time - O(∣V∣+∣E∣)
	// space - O(∣V∣+∣E∣)
	public int countComponents(int n, int[][] edges) {
		adj = new ArrayList[n];
		int result = 0;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n ; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for (int[] edge: edges) {
			adj[edge[1]].add(edge[0]);
			// this is UD Graph
			adj[edge[0]].add(edge[1]);
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				// dfs
				visited[i] = true; 
				dfs(i, visited, edges);
				++result;
			}
		}
		return result;
	}
	
	private void dfs(int i, boolean[] visited, int[][] edges) {
		List<Integer> neighbors = adj[i];
		for (int k =0; k < neighbors.size(); k++) {
			int curr = neighbors.get(k);
			if (!visited[curr]) {
				visited[curr] = true;
				dfs(curr, visited, edges);
			}
		}
	}
	
	

}
