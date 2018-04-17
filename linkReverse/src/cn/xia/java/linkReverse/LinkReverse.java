package cn.xia.java.linkReverse;

class Node {
	private Integer data;
	private Node next;
	public Node(Integer data) {
		this.data = data;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getNext() {
		return this.next;
	}
	public static void print(Node head) {
		if (head == null) {
			return ;
		}
		Node p = head.next;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();
	}
	public static Node reverseList(Node head) {
		if (head.next == null || head.next.next == null) {
			return head;
		}
		Node pre = null;
		Node p = head.next;
		Node latter = head.next.next;
		while (p != null) {
			p.next = pre;
			pre = p;
			p = latter;
			if (p != null) {
				latter = latter.next;
			}
		}
		head.next = pre;
		
		return head;
	}
	public static Node reverseListD(Node head) { // µ›πÈƒÊ–Ú¡¥±Ì
		return null;
	}
}

public class LinkReverse {
	public static void main(String[] args) {
		Node head = new Node(-1);
		Node p = head;
		for (int x = 0; x <= 10; x ++) {
			Node q = new Node(x);
			p.setNext(q);
			p = q;
		}
		Node.print(head);
		System.out.println("**********************************");
		Node.reverseList(head);
		Node.print(head);
	}

}
