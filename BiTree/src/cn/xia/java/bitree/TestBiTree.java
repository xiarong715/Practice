package cn.xia.java.bitree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class BiTree {
	private class BitNode {
		private Object data;
		private BitNode lChild;
		private BitNode rChild;
		private boolean visited;
		public BitNode(Object data) {
			this.data = data;
			this.visited = false;
		}
		public void preOrderNode() {
			System.out.print(this.data + " ");
			if (this.lChild != null) {
				this.lChild.preOrderNode();
			}
			if (this.rChild != null) {
				this.rChild.preOrderNode();				
			}
		}
		public void inOrderNode() {
			if (this.lChild != null) {
				this.lChild.inOrderNode();
			}
			System.out.print(this.data + " ");
			if (this.rChild != null) {
				this.rChild.inOrderNode();
			}
		}
		public void postOrderNode() {
			if (this.lChild != null) {
				this.lChild.postOrderNode();
			}
			if (this.rChild != null) {
				this.rChild.postOrderNode();
			}
			System.out.print(this.data + " ");
		}
	}
	//***************************
	private BitNode root; // 根结点
	private static List<BitNode> nodeList;
	public void createBiTree() {
		int [] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
		nodeList = new LinkedList<BitNode>();
		for (int x = 0; x < array.length; x ++) {
			nodeList.add(new BitNode(array[x])); // 存入链表
		}
		for (int pIndex = 0; pIndex < array.length / 2 - 1; pIndex ++) {
			nodeList.get(pIndex).lChild = nodeList.get(pIndex * 2 + 1); // 建立左孩子
			nodeList.get(pIndex).rChild = nodeList.get(pIndex * 2 + 2); // 建立右孩子
		}
		
		int lIndex = array.length / 2 - 1;
		nodeList.get(lIndex).lChild = nodeList.get(lIndex * 2 + 1);
		if (array.length % 2 == 1) {
			nodeList.get(lIndex).rChild = nodeList.get(lIndex * 2 + 2); 
		}
		
		this.root = nodeList.get(0);
	}
	public void preOrderD() {  // 前序编历
		if (this.root != null) {
			this.root.preOrderNode();
		}
	}
	public void inOrderD() {
		if (this.root != null) {
			this.root.inOrderNode();
		}
	}
	public void postOrderD() {
		if (this.root != null) {
			this.root.postOrderNode();
		}
	}
	public void preOrder() {
		if (this.root != null) {
			Stack<BitNode> stack = new Stack<BitNode>(); 
			BitNode b = this.root;
			while(b != null || !stack.isEmpty()) {
				if (b != null) {
					System.out.print(b.data+ " ");
					stack.push(b);
					b = b.lChild;
				} else {
					b = stack.pop();
					b = b.rChild;
				}
			}
		}
	}
	public void inOrder() { // 中序编历，非递归 
		if (this.root != null) {
			Stack<BitNode> stack = new Stack<BitNode>();
			BitNode b = this.root;
			while (b != null || !stack.isEmpty()) {
				if (b != null) {
					stack.push(b);
					b = b.lChild;
				} else {
					b = stack.pop();
					System.out.print(b.data + " ");
					b = b.rChild;
				}
			}
		}
	}
	public void postOrder() {
		if (this.root != null) {
			Stack<BitNode> stack = new Stack<BitNode>();
			BitNode b = this.root;
			while (b != null || !stack.isEmpty()) {
				if (b != null) {
					stack.push(b);
					b = b.lChild;
				} else {
					b = stack.peek(); // 偷看一眼
					if (b.rChild != null && b.visited == false) { //保证每个节点访问一次
						b.visited = true;
						b = b.rChild;
					} else {  // 没有右孩子，则出栈并访问 
						b = stack.pop();
						System.out.print(b.data + " ");
						b = null;  // 没有右孩子，且访问过了，
					}
				}
			}
		}
	}
	public void levelOrder() {
		Queue<BitNode> queue = new LinkedList<BitNode>();
		if (this.root != null) {
			queue.add(this.root);
			while (!queue.isEmpty()) {
				BitNode bitNode = queue.poll();
				System.out.print(bitNode.data + " ");
				if (bitNode.lChild != null) {
					queue.add(bitNode.lChild);
				}
				if (bitNode.rChild != null) {
					queue.add(bitNode.rChild);
				}
			}
		}
	}
}

public class TestBiTree {
	public static void main(String[] args) {
		BiTree bT = new BiTree();
		bT.createBiTree();
		bT.postOrder();
	}
}
