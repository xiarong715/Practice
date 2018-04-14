package cn.xia.java.bitree;

import java.util.LinkedList;
import java.util.List;

class BitNode {
	private Object data;
	private BitNode lChild;
	private BitNode rChild;
	public BitNode(Object data) {
		this.data = data;
	}
}

class BiTree {
	private class BitNode {
		private Object data;
		private BitNode lChild;
		private BitNode rChild;
		public BitNode(Object data) {
			this.data = data;
		}
		public void preOrderNode() {
			System.out.println(this.data);
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
			System.out.println(this.data);
			if (this.rChild != null) {
				this.rChild.inOrderNode();
			}
		}
	}
	//***************************
	private BitNode root; // �����
	private static List<BitNode> nodeList;
	public void createBiTree() {
		int [] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
		nodeList = new LinkedList<BitNode>();
		for (int x = 0; x < array.length; x ++) {
			nodeList.add(new BitNode(array[x])); // ��������
		}
		for (int pIndex = 0; pIndex < array.length / 2 - 1; pIndex ++) {
			nodeList.get(pIndex).lChild = nodeList.get(pIndex * 2 + 1); // ��������
			nodeList.get(pIndex).rChild = nodeList.get(pIndex * 2 + 2); // �����Һ���
		}
		
		int lIndex = array.length / 2 - 1;
		nodeList.get(lIndex).lChild = nodeList.get(lIndex * 2 + 1);
		if (array.length % 2 == 1) {
			nodeList.get(lIndex).rChild = nodeList.get(lIndex * 2 + 2); 
		}
		
		this.root = nodeList.get(0);
	}
	public void preOrder() {  // ǰ�����
		if (this.root != null) {
			this.root.preOrderNode();
		}
	}
	public void inOrder() {
		if (this.root != null) {
			this.root.inOrderNode();
		}
	}
}

public class TestBiTree {

	public static void main(String[] args) {
		BiTree bT = new BiTree();
		bT.createBiTree();
		bT.inOrder();
	}

}
