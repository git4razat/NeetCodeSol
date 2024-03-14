package com.test;

import java.util.ArrayList;
import java.util.List;

// time complexity DFS - o(|E|+|V|)
// space -  o(|E|+|V|)
public class CloneGraph {
	
	class Node {
		int value;
		List<Node> neighbors;
		
		public Node() {
			this.neighbors = new ArrayList<Node>();
		}
		
		public Node(int value) {
			this.value = value;
			this.neighbors = new ArrayList<Node>();
		}
		
		public Node(int value, List<Node> neighbours) {
			this.value = value;
			this.neighbors = neighbours;
		}
	}
	
	Node[] visited;
	// clone means deep copy.. that why create new node for each vertex and edge and then return
	// node i.e. from visited array
	public Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}
		visited = new Node[101];//assuming graph size is between 1-100
		return dfs(node);
	}
	
	public Node dfs(Node node) {
		// return if already visited...
		if (visited[node.value] != null) {
			return visited[node.value];
		}
		// else create new clone node..
		visited[node.value] = new Node(node.value);
		for (Node n: node.neighbors) {
			visited[node.value].neighbors.add(dfs(n));
		}
		return visited[node.value];
	}
}
