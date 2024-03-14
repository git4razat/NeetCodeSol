package com.test;

public class PrintTreeInSpiral {
	
	void printSpiral(BNode node)
	{
	    int h = height(node);
	    int i;

	    /* ltr -> left to right. If this variable is set
	       then the given label is traversed from left to
	       right */
	    boolean ltr = false;
	    for (i = 1; i <= h; i++) {
	        printGivenLevel(node, i, ltr);

	        /*Revert ltr to traverse next level in opposite
	         * order*/
	        ltr = !ltr;
	    }
	}

	
	/* Print nodes at a given level */
	void printGivenLevel(BNode node, int level, boolean ltr)
	{
	    if (node == null)
	        return;
	    if (level == 1)
	        System.out.print(node.data + " ");
	    else if (level > 1) {
	        if (ltr != false) {
	            printGivenLevel(node.left, level - 1, ltr);
	            printGivenLevel(node.right, level - 1, ltr);
	        }
	        else {
	            printGivenLevel(node.right, level - 1, ltr);
	            printGivenLevel(node.left, level - 1, ltr);
	        }
	    }
	}
	
	/* Compute the "height" of a tree -- the number of
	nodes along the longest path from the root node
	down to the farthest leaf node.*/
	int height(BNode node)
	{
	    if (node == null)
	        return 0;
	    else {

	        /* compute the height of each subtree */
	        int lheight = height(node.left);
	        int rheight = height(node.right);

	        /* use the larger one */
	        if (lheight > rheight)
	            return (lheight + 1);
	        else
	            return (rheight + 1);
	    }
	}

	
	public static void main(String[] args)
    {
		PrintTreeInSpiral tree = new PrintTreeInSpiral();
		BNode root = new BNode(1);
        root.left = new BNode(2);
        root.right = new BNode(3);
        root.left.left = new BNode(7);
        root.left.right = new BNode(6);
        root.right.left = new BNode(5);
        root.right.right = new BNode(4);
        System.out.println(
            "Spiral order traversal of Binary Tree is ");
        tree.printSpiral(root);
    }

}

class BNode {
	int data;
	BNode left;
	BNode right;
	public BNode(int data) {
		this.data = data;
	}
}


