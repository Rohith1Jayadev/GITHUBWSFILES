package com.rohith.github.datastructures;

public class TreeTest {

	public static void main(String[] args) {

		CustomBinarySearchTree tree = new CustomBinarySearchTree(20);

		tree.addNode(8);
		tree.addNode(4);
		tree.addNode(12);
		tree.addNode(10);
		tree.addNode(14);
		tree.addNode(22);

		tree.printInOrder();

		
		System.out.println("Tree is Height Balanced" + tree.getKthSmallestElement(0));
	}

}
