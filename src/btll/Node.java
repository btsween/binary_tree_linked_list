package btll;

public class Node {
	private int value;
	private Node leftNode = null;
	private Node rightNode = null;
	
	public Node(int value){
		this.value = value;
	}
	
	public int addLeft(Node leftNode) {
		if(this.leftNode != null) {
			return -1;
		}
		this.leftNode = leftNode;
		return 1;
	}
	
	public int addRight(Node rightNode) {
		if(this.rightNode != null) {
			return -1;
		}
		this.rightNode = rightNode;
		return 1;
	}
	
	public void setRight(Node rightNode) {
		this.rightNode = rightNode;
	}
	
	public void setLeft(Node leftNode) {
		this.leftNode = leftNode;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public Node getLeftNode() {
		return leftNode;
	}
	
	public Node getRightNode() {
		return rightNode;
	}
	
	public String toString() {
		String toString = "Value: " + value + " ";
		if(leftNode != null) {
			toString += "left: " + leftNode.getValue() + " ";
		}
		if(rightNode != null) {
			toString += "right " + rightNode.getValue() + " ";
		}
		return toString;
	}
	
	public static void main(String args[]) {
		Node a = new Node(5);
		a.addLeft(new Node(2));
		a.addRight(new Node(7));
		System.out.println(a);
	}

}

