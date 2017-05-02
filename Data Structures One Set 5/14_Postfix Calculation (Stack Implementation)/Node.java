/** Author: Joseph Tassone
 *  Description: The node class for creating a 
 *  reference based stack.
 */

public class Node<T> {
	private T item;
	private Node next;
	
	public Node(T item, Node next) {
		this.item = item;
		this.next = next;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
