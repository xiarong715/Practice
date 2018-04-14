package cn.xia.java.link;

public class Link {
	private class Node {
		private Object data;
		private Node next;
		public Node(Object data) {
			this.data = data;
		}
		public void addNode(Node newNode) {
			if (newNode == null) {
				return ;
			}
			
			if (this.next == null) {
				this.next = newNode;
			} else {
				this.next.addNode(newNode);
			}
		}
		public Object getNode(int index) {
			if (Link.this.foot == index) {
				return this.data;
			}
			Link.this.foot++;
			return this.next.getNode(index);
		}
		public boolean containsNode(Object data) {
			if (this.data.equals(data)) {
				return true;
			}
			
			if (this.next != null) {
				return this.next.containsNode(data);
			} else {
				return false;
			}
		}
		public void removeNode(Node previous, Object data) {
			if (this.data.equals(data)) {
				previous.next = this.next;
			} else {
				this.next.removeNode(this, data);
			}
		}
		public void toArrayNode() {
			Link.this.retData[Link.this.foot++] = this.data;
			if (this.next != null) {
				this.next.toArrayNode();
			}
		}
		public void printNode() {
			if (this != null) {
				System.out.println(this.data);
				if (this.next != null) {
					this.next.printNode();
				}
			}
		}
	}
	//********************************
	private Node root;
	private int count;
	private int foot;
	private Object [] retData;
	public void add(Object obj) {
		if (obj == null) {
			return ;
		}
		Node newNode = new Node(obj);
		if (this.root == null) { // �����Ϊ��
			this.root = newNode;
		} else {              	// ����Node�ദ��
			this.root.addNode(newNode);
		}
		this.count++;
	}
	public int size() {
		return this.count;
	}
	public boolean isEmpty() {
		return this.count == 0;
	}
	public void clean() {
		this.root = null;
		this.count = 0;
	}
	public Object get(int index) {
		if (this.count <= index) {
			return null;
		}
		this.foot = 0;
		return this.root.getNode(index);
	}
	public boolean contains(Object data) {
		if (data == null || this.root == null) {
			return false;
		}
		return this.root.containsNode(data);
	}
	public void remove(Object data) {
		if (this.contains(data)) { // �ҵ�Ҫɾ��������
			if (this.root.equals(data)) { // Ҫɾ���Ľ���Ϊ�����
				this.root = this.root.next;
			} else { // ����Node�ദ��
				this.root.next.removeNode(this.root, data);
			}
			this.count--;
		}
	}
	public Object [] toArray() {
		if (this.count == 0) {
			return null;
		}
		retData = new Object[this.count];
		this.foot = 0;
		this.root.toArrayNode();
		
		return retData;
	}
	public void print() {
		if (this.root != null) {
			this.root.printNode();
		}
	}
}
