package com.test;


public class ReverseLinkedList {
	
	class RNode {
		int data;
		RNode next;
	}
	
	public static void main(String[] args) {
		
	}
	
	private static RNode reverseLinkedList(RNode head) {
		if (head.next == null) {
			return head;
		}
		
		RNode node = head;
		RNode rootNode = reverseLinkedList(node.next);
		node.next.next = node.next;
		node.next = null;
		return rootNode;
	}
	
	private static RNode reverseIteratively(RNode head) 
    { 
		RNode prev = null; 
		RNode current = head; 
		RNode next = null; 
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        head = prev; 
        return head; 
    }
}
