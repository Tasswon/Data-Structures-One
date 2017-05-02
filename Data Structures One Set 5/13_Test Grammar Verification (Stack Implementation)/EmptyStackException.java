/** Author: Joseph Tassone
 *  Description: Custom exception for if a stack is empty or full.
 */

public class EmptyStackException extends RuntimeException {
	
	public EmptyStackException(String message) {
		super(message);
	}
}
