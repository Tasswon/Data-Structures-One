/** Author: Joseph Tassone
 *  Description: The class creates an interface for a queue which
 *  can utilize any data structure.
 */

public interface QueueInterface <T> {
	
	public boolean isEmpty();
	
	//Only throws QueueException for array based implementation
	public void enqueue(T newItem) throws QueueException;
	
	public T dequeue() throws QueueException;
	
	public void dequeueAll();
	
	public T peek() throws QueueException;
	
}
