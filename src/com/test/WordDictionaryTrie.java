package com.test;

import java.util.HashMap;
import java.util.Map;


public class WordDictionaryTrie {
	
	class TrieNode {
        boolean isLeaf;
        HashMap<Character, TrieNode> children = new HashMap<>();
    }
    
    TrieNode root;
    
    public WordDictionaryTrie() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
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
    
    /** Returns if the word is in the data structure. 
     * A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return isMatch(root, word, 0);
    }
    
    // DFS Method
    private boolean isMatch(TrieNode trieNode, String word, int index) {
        if (word.length() <= index) {
            return trieNode.isLeaf;
        }
        
        char c = word.charAt(index);
        HashMap<Character, TrieNode> children = trieNode.children;
        if (c == '.') {
            boolean isValid = false;
            for (TrieNode tNode : children.values()) {
                if (isMatch(tNode, word, index + 1)) {
                    isValid = true;
                }
            }
            return isValid;
        } else {
        	if (children.containsKey(c)) {
            	return isMatch(children.get(c), word, index + 1);
            } else {
            	return false;
            }
        }
    }
    
    public static void main(String[] args) {
    	WordDictionaryTrie t = new WordDictionaryTrie();
    	t.addWord("amazon");
        t.addWord("amazon prime"); 
		t.addWord("amazing"); 			 
        t.addWord("amazing spider man"); 
        t.addWord("amazed");
        t.addWord("apple");
        
        System.out.println(t.search("app.e"));
        System.out.println(t.search("amaz.."));
        System.out.println(t.search("amazed"));
        System.out.println(t.search("app.x"));
	}

}
