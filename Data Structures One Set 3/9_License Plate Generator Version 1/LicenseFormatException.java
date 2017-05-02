/** Name: Joseph Tassone
 *  Description: Custome exception for if the license is incorrectly
 *  formatted.
 */


public class LicenseFormatException extends RuntimeException{
	
	public LicenseFormatException(String message) {
       super(message);
    }
}
 
