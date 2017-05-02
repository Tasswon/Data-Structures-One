/** Author: Joseph Tassone
 *  Description: Program addresses whether an entered string matches
 *  an a^n,b^n pattern.
 */

import java.util.Scanner;

public class Language {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayBased list = new ArrayBased();
		
		System.out.print("Enter a string: ");
		String s = input.next();
		
		//Loops the the check until the user enters "exit"
		while(true) {
			System.out.print(s + (check(s, list) ? " is" : " is not") + " in the language");
			System.out.print("\nEnter a string: ");
			s = input.next();
			if(s.equals("exit")) {
				System.out.print("BYE!");
				break;
			}
		}
	}
	
	//Method checks if the string follows the a^n, b^n pattern
	public static boolean check(String s, ArrayBased list) {
		
		//If the string is one character it returns false
		//If the string is two characters, it compares the two characters
		if(s.length() <= 2) {
			if(s.length() <= 1) {
				return false;
			}
			else if(s.charAt(0) != s.charAt(1)) {
				return true;
			}
		}
		
		//Copies same characters at the start of the string and puts them into the stack
		//Returns a substring of the remaining characters
		String sCopy = null;
		char charOne = s.charAt(0);
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == charOne) {
				list.push(s.charAt(i));
			}
			else {
				sCopy = s.substring(i);
				break;
			}
		}
		
		//The substring characters are counted and for each, a character from the stack is removed
		char charTwo = sCopy.charAt(0);
		for(int i = 0; i < sCopy.length(); i++) {
			if(sCopy.charAt(i) == charTwo) {
				if(list.isEmpty()) {
					return false;
				}
				list.pop();
			}
			else {
				return false;
			}
		}
		
		//Returns true if the stack is empty, and false if it isn't
		if(list.isEmpty()) {
			return true;
		}
		return false;
	}
}

