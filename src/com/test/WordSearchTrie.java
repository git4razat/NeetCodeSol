package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// use trie defined in the same file
public class WordSearchTrie {
	
	private final Trie trie = new Trie();
    private final HashSet<String> result = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            trie.insert(word);
        }
        String prefix = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, prefix);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int i, int j, String prefix) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        char c = board[i][j];
        if (c != '*') {
            board[i][j] = '*';
            prefix = prefix + c;
            TrieNode n = trie.searchWord(prefix);
            if (n != null) {
                if (n.isLeaf) {
                    result.add(prefix);
                }
                dfs(board, i, j + 1, prefix);
                dfs(board, i + 1, j, prefix);
                dfs(board, i - 1, j, prefix);
                dfs(board, i, j - 1, prefix);
            }
            board[i][j] = c;
        }
    }

}


class TrieNode {
	HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	boolean isLeaf = false;
}

class Trie {
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		HashMap<Character, TrieNode> children = root.children;
		
		for(int i = 0 ; i < word.length(); i++) {
			TrieNode trieNode;
			char c = word.charAt(i);
			if(children.containsKey(c)) {
				trieNode = children.get(c);
			} else {
				trieNode = new TrieNode();
				children.put(c, trieNode);
			}
			children = trieNode.children;
			
			if(i == word.length() -1) {
				trieNode.isLeaf = true;
			}
		}
		
	}
	
	public TrieNode searchWord(String word) {
		HashMap<Character, TrieNode> children = root.children;
		TrieNode t = null;
		for(int i = 0; i < word.length(); i++) {
			
			char c = word.charAt(i);
			if(children.containsKey(c)) {
				t = children.get(c);
				children = t.children;
			} else {
				return null;
			}
		}
		return t;
	}

}
