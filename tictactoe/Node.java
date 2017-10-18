package tictactoe;

public class Node {
	private TTTRecord data;
	private Node next;
	
	/*
	 * Constructor creates a node with a pointer containing an element
	 * @param elem
	 */
	
	public Node(TTTRecord data) {
		this.data = data;
		this.next = null;
	}
	
	/*
	 * method that sets the pointer to the next node
	 * @param node
	 */
	public void setNext(Node nextNode) {
		next = nextNode;
	}
	
	/*
	 * method that returns the next node that is being pointed to
	 * @return node that is being pointed to
	 */
	
	public Node getNext() {
		return this.next;
	}
	
	/*
	 * method that returns the element stored within the node
	 * @return element
	 */
	public TTTRecord getElement() {
		return this.data;
	}	
}
