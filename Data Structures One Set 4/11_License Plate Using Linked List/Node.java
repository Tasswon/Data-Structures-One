/** Name: Joseph Tassone
 *  Description: Creates a node which holds an item and references
 *  to both the next and previous node. 
 */

public class Node implements Comparable <String>{
	
	private String item;
	private Node next;
	private Node previous;
	
	//Holds an item value, and references for both previous and next
	public Node(String item, Node next, Node previous) {
		this.item = item;
		this.next = next;
		this.previous = previous;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	@Override
	public int compareTo(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
