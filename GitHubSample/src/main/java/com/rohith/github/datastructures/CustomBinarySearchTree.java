package com.rohith.github.datastructures;

import java.util.Stack;

public class CustomBinarySearchTree {

	public static class TreeNode {

		private int data;

		private TreeNode left, right;

		public TreeNode(int data) {

			this.data = data;
			this.left = null;
			this.right = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}

	}

	private TreeNode root;

	public CustomBinarySearchTree(int data) {

		this.root = new TreeNode(data);
	}

	public CustomBinarySearchTree(TreeNode root) {

		this.root = root;
	}

	public TreeNode root() {

		return this.root;
	}

	/**
	 * 
	 * API to check whether the Tree is height balanced
	 * 
	 * @return boolean
	 * 
	 */
	public boolean isHeightBalance() {

		return isHeightBalanced(this.root);
	}

	private boolean isHeightBalanced(TreeNode root) {

		if (null == root) {

			return true;
		}

		int lh = height(root.getLeft());

		int rh = height(root.getRight());

		return ((Math.abs(lh - rh) == 1 && isHeightBalanced(root.getLeft()) && isHeightBalanced(root.getRight())));

	}

	
	public int height(){
		
		return height(this.root);
	}
	private int height(TreeNode node) {

		if (node == null) {

			return 0;
		}

		int lh = height(node.getLeft());
		
		int rh= height(node.getRight());
		
		
		if(rh>lh){
			
			return rh + 1;
		}else{
			
		return 	lh+1;
		}
	
	}

	/**
	 * 
	 * API for adding a node
	 * 
	 * @param data
	 */
	public void addNode(int data) {

		if (null == this.root) {

			System.out.println("Initialize the tree first");

			return;
		}

		insertData(this.root, data);

	}

	private void insertData(TreeNode node, int data) {

		if(data < node.getData()) {

			if (null == node.getLeft()) {

				TreeNode temp = new TreeNode(data);
				
				node.setLeft(temp);

			} else {

				insertData(node.getLeft(), data);
			
			}

		} else if(data>node.getData()) {

			if (null == node.getRight()) {
				TreeNode temp = new TreeNode(data);
				node.setRight(temp);

			} else {
				insertData(node.getRight(), data);

			}

		}

	}

	public void printInOrder() {

		if (null == this.root) {

			return;
		}

		printInOrder(this.root);
	}

	private void printInOrder(TreeNode node) {

		if (null == node) {

			return;
		}

		printInOrder(node.getLeft());
		System.out.print(node.getData() + " ");
		printInOrder(node.getRight());

	}

	
	public int getKthSmallestElement(int k){
		
		if(null==this.root){
			return Integer.MIN_VALUE;
		}
		
		Stack<Integer> elementStack = new Stack<Integer>();
		
		getKthSmallestElement(k,elementStack,this.root);
		
		int data = 0;
		
	
		int size = elementStack.size();
		
		if(size<k||k<=0){
			
			return Integer.MIN_VALUE;
		}

		int i=0; 
		while(!elementStack.isEmpty()&&i<=(size-k)){
			
			data=elementStack.pop();
			i++;
		}
		return data;
	}

	private void getKthSmallestElement(int k, Stack<Integer> elementStack, TreeNode node) {
		
		
		if(null==node){
			return ;
		}
		
		getKthSmallestElement(k,elementStack,node.getLeft());
		elementStack.push(node.getData());
		getKthSmallestElement(k, elementStack, node.getRight());
	}
}
