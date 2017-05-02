/** Name: Joseph Tassone
 *  Description: Custom exception class if an invalid date is entered.
 */

public class BadDateException extends RuntimeException{
	
	public BadDateException(String message) {
		super(message);
	}
}
