/** Author: Joseph Tassone
 *  Description: The user enters a string and the program places an
 *  '*' between all repeating values 
 */

import java.util.Scanner;

public class PairStar {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		
		String str = input.next();
		
		System.out.print(pairStar(str));
	}
	
	//Takes in a string and places a * between repeating letters 
	public static String pairStar(String str) {
		if (str.length() < 2) {
			return str;
		}
		
		if (str.charAt(0) == str.charAt(1)) {
			return str.charAt(0) + "*" + pairStar(str.substring(1));
		}
		
		return str.charAt(0) + pairStar(str.substring(1));
	}
}