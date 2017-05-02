/** Author: Joseph Tassone
 *  Description: A custom exception for if the queue is empty.
 */

public class QueueException extends RuntimeException{
	
	public QueueException(String s) {
		super(s);
	}
}
