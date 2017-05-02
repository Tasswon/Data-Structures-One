/** Author: Joseph Tassone
 *  Description: The class creates an reference based queue.
 */

public class QueueLinkedList implements QueueInterface{
	
	private Node tail;
	
	public QueueLinkedList(){}
	
	//Return true if tail is null
	@Override
	public boolean isEmpty() {
		return tail == null;
	}

	//Adds an item to the tail point of the list and connects it to the start
	@Override
	public void enqueue(Object newItem) throws QueueException {
		Node newNode = new Node(newItem, tail);
		
		if(isEmpty()) {
			newNode.setNext(newNode);
		}
		else {
			newNode.setNext(tail.getNext());
			tail.setNext(newNode);
		}
		tail = newNode;
	}
	
	//Removes the item at the start of the list
	//Throws an exception if the queue is empty
	//Returns the temp value which is at the start
	@Override
	public Object dequeue() throws QueueException {
		if(isEmpty()) {
			throw new QueueException("Dequeue: Queue is empty!");
		}
		Object temp = peek();
		if(tail == tail.getNext()) {
			tail = null;
		}
		else {
			tail.setNext(tail.getNext().getNext());
		}
		return temp;
	}

	//Clears the list
	@Override
	public void dequeueAll() {
		tail = null;
	}
	
	//Returns the item at the start of the list
	//Throws exception if the queue is empty
	@Override
	public Object peek() throws QueueException {
		if(!isEmpty()) {
			return tail.getNext().getItem();
		}
		throw new QueueException("Peek: Queue is empty!");
	}

}
