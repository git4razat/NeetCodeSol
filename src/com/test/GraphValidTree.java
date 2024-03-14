package com.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphValidTree {
	
	public boolean validTree(int n, int[][] edges) {
        if (n == 0) return false;

        Map<Integer, Set<Integer>> graph = buildGraph(n, edges);
        Set<Integer> visited = new HashSet<>();

        // dfs(graph, visited, i, -1) and validate cycle
        if (!dfs(graph, visited, 0, -1)) return false;
        
        // validate if all edge connected: # of visited node should match graph size        
        return visited.size() == graph.size();
    }
    
    // build graph in form of adjacent list
    private Map<Integer, Set<Integer>> buildGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.putIfAbsent(i, new HashSet<>());
        
        for (int[] edge: edges) { // undirected, add edge to both nodes
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    // dfs: mark visited nodes, and keep dfs into children nodes
    private boolean dfs(Map<Integer, Set<Integer>> graph, Set<Integer> visited, int curr, int pre) {
        if (visited.contains(curr)) return false;
        visited.add(curr);
        for (int child : graph.get(curr)) {
            if (child == pre) continue;
            if (!dfs(graph, visited, child, curr)) return false;
        }
        return true;
    }

}
