/** Author: Joseph Tassone
 *  Description: The class creates an array based stack.
 */

public class ArrayBased <T> {
	
	private int MAX_SIZE = 10;
	private Object[] array = new Object [MAX_SIZE];
	private int top = 0;
	
	public ArrayBased(){}
	
	//Returns true if the top counter is 0
	public boolean isEmpty() {
		return top == 0;
	}
	
	//Adds an item to the top of the array and increments top
	//Throws an exception if the stack is full
	public void push(T item) {
		if(top == MAX_SIZE) {
			throw new EmptyStackException("The stack is full!");
		}
		array[top++] = item;
	}
	
	//Removes an item from the top of the array and decrements top
	//Throws an exception if the stack is empty
	public T pop () {
		if(isEmpty()) {
			throw new EmptyStackException("The stack is empty!");
		}
		T copyItem = (T) array[top--];
		return copyItem;
	}
	
	//Returns the value at the top point in the stack
	//Throws an exception if the stack is empty
	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException("The stack is empty!");
		}
		return (T) array[top];
	}
	
	//Clears the stack of all values
	public void popAll() {
		array = new String [MAX_SIZE];
	}
	
	
}
