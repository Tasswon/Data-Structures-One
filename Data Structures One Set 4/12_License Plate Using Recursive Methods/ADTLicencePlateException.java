/** Name: Joseph Tassone
 *  Description: Custom exception class if the license plate 
 *  cannot be found or the list is full.
 */

public class ADTLicencePlateException extends RuntimeException{
	
	public ADTLicencePlateException(String message) {
       super(message);
    }
}