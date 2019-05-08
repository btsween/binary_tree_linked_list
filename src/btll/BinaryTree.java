package btll;

public class BinaryTree {
	private Node head;
	private int size;
	
	public BinaryTree(Node head, int size) {
		this.head = head;
		this.size = size;
	}
	
	public BinaryTree(){};
	
	private void randomAdd(Node newNode, Node currentNode) {
		Boolean addDirection = (int)(Math.random()*100) > 50 ? true : false;
		if(addDirection) {
			System.out.println(currentNode);
			int filled = currentNode.addRight(newNode);
			if(filled == -1) {
				this.randomAdd(newNode, currentNode.getRightNode());
			}
		}else {
			int filled = currentNode.addLeft(newNode);
			if(filled == -1) {
				this.randomAdd(newNode, currentNode.getLeftNode());
			}
		}
	}
	
	public DoubleLinkedList binaryTreeToDLL() {
		treeToDLL(head);
		DoubleLinkedList dll = new DoubleLinkedList(head,2);
		return dll;
	}
	
	private Node treeToDLL(Node node) {
		Node left = node.getLeftNode();
		Node right = node.getRightNode();
		
		if(left==null && right==null) {
			node.setLeft(node);
			node.setRight(node);
			return node;
		}
		
		if(left!=null) {
			Node leftsRight = treeToDLL(left);
			Node leftsLeft = leftsRight.getRightNode();
			
			leftsRight.setRight(node);
			node.setRight(leftsRight);
			
			leftsLeft.setLeft(node);
			node.setRight(leftsLeft);
			
			System.out.println(leftsRight + "------");
		}
		if(right!=null) {
			Node rightsRight = treeToDLL(right);
			Node rightsLeft = rightsRight.getRightNode();
			
			node.getRightNode().setLeft(rightsRight);
			rightsRight.setRight(node.getRightNode());
			
			
			node.setRight(rightsLeft);
			rightsLeft.setLeft(node);
			
			System.out.println(node.getRightNode() + "------");
			return rightsRight;
		}
		return node;
	}
	
	public Node createRandomTree(int size) {
		this.size = size;
		this.head = new Node((int)(Math.random()*100));
		if(size<=1) {
			return head;
		}
		for(int i=0;i<size-1;i++) {
			this.randomAdd(new Node((int)(Math.random()*100)), head);
		}
		return head;
	}
	
	public String toString() {
		return toStringHelper(head);
	}
	
	private String toStringHelper(Node currentNode) {
		if(currentNode.getLeftNode() == null && currentNode.getRightNode() == null) {
			return currentNode.toString();
		}
		String toString = "";
		if(currentNode.getLeftNode() != null) {
			toString = toStringHelper(currentNode.getLeftNode()) + toString;
		}
		toString += currentNode;
		if(currentNode.getRightNode() != null) {
			toString += toStringHelper(currentNode.getRightNode());
		}
		return toString;
	}
	
	public Node getHead() {
		return head;
	}
	
	public int getSize() {
		return size;
	}
	
	public static void main(String args[]) {
		Node a = new Node(4);
		Node b = new Node(1);
		Node c = new Node(7);
		Node d = new Node(5);
		Node e = new Node(12);
		
		a.addLeft(b);
		a.addRight(c);
		c.addLeft(d);
		c.addRight(e);
		BinaryTree tree = new BinaryTree(a,5);
		
		DoubleLinkedList dll = tree.binaryTreeToDLL();
		System.out.println(dll.toString());
		
	}

}
