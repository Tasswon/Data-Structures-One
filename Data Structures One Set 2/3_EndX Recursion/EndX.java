/** Author: Joseph Tassone
 *  Description: The user enters a string, and a new string is returned where all the
 *  lowercase 'x' chars have been moved to the end of the string
 */

import java.util.Scanner;

public class EndX {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		
		String str = input.next();
		
		System.out.println(endX(str));

	}
	
	//Takes in a string and places all x values at the end of the string
	public static String endX(String str) {

		if (str.length() == 0) {
			return str;
		}

		if (str.charAt(0) == 'x') {
			return endX(str.substring(1)) + "x";
		}

		return str.charAt(0) + endX(str.substring(1));
	}
}
