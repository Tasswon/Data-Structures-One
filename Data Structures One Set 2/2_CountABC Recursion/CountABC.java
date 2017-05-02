/** Author: Joseph Tassone
 *  Description: The user enters string and the program 
 *  returns the number of instances of aba and abc
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class CountABC {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		
		String str = input.next();
		
		System.out.println("Number of aba and abc substrings: " + countAbc(str));

	}
	
	//Takes in a string and returns the number of instances of aba and abc
	public static int countAbc(String str) {
		
		if(str.length() < 3) {
			return 0;
		}
		
		if (str.substring(0 , 3).equals("abc") || str.substring(0, 3).equals("aba")) {
			return 1 + countAbc(str.substring(2));
		}
		
		return countAbc(str.substring(1));
	}
}