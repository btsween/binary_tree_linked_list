package btll;

public class DoubleLinkedList {
	
	private Node head;
	private Node tail;
	private int size;
	
	public DoubleLinkedList(Node head, int size) {
		this.head = head;
		this.size = size;
	}
	
	public String toString() {
		String toString = head.toString();
		Node current = head.getRightNode();
		while(current!=head) {
			toString += current;
			current = current.getRightNode();
		}
		return toString;
	}

}
