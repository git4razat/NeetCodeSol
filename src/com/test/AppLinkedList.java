package com.test;

public class AppLinkedList {
	
	public static void main(String[] args) {
		
	}
	
	public static Node reverseList(Node root) {
		if (root.next == null) {
			return root;
		}
		Node currNode = root;
		Node rootNode = reverseList(root.next);
		currNode.next.next = currNode;
		currNode.next = null;
		return rootNode;
	}
	
	public static Node reverseIteratively(Node head) {
		if (head == null)
			return head;
		
		Node current = head;
		Node previous = null;
		Node next = null;
		
		while (current.next != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
			
		}
		head = previous;
		return head;
	}
}

class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
