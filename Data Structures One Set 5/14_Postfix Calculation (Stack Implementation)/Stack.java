/** Author: Joseph Tassone
 *  Description: The class creates an reference based stack.
 */

public class Stack <T>{
	
	private Node<T> head;
	
	public Stack(){}
	
	//Returns true if the head node is null
	public boolean isEmpty() {
		return head == null;
	}
	
	//Adds an item to the start of the stack (head)
	public void push(T item) {
		head = new Node(item, head);
	}
	
	//Makes the node after head the head, which removes the old one
	//Throws an exception if the stack is empty
	public T pop () {
		if(isEmpty()) {
			throw new EmptyStackException("The stack is empty!");
		}
		T copyItem = head.getItem();
		head = head.getNext();
		return copyItem;
	}
	
	//Returns the item value in the head node
	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException("The stack is empty!");
		}
		return head.getItem();
	}
	
	//Clears the stack
	public void popAll() {
		head = null;
	}
	
	
}
