/** Author: Joseph Tassone
 *  Description: Program creates calculator for assessing 
 *  postfix formatted equations.
 */

import java.util.Scanner;

public class PostfixCalculator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//The user enters an equation which is then stored in a string array
		System.out.print("Enter a formula (maintain spaces) : ");
		String formula = input.nextLine();
		String[] formulaArray = formula.split("\\s+");
		System.out.println("The answer is " + answer(formulaArray));	
	}
	
	//Method goes through each operand and operator of the postfix equation
	//Evaluates an answer using stack based on the values
	//Uses variables for -, /, ^, and % as order matters 
	public static String answer(String[] formulaArray) {
		Stack list = new Stack();
		for(int i = 0; i < formulaArray.length; i++) {

			if(formulaArray[i].equals("+")) {
				list.push((double)list.pop() + (double)list.pop());
			}
			else if(formulaArray[i].equals("-")) {
				double x = (double) list.pop();
				double y = (double) list.pop();
				list.push(y - x);
			}
			else if(formulaArray[i].equals("*")) {
				list.push((double)list.pop() * (double)list.pop());
			}
			else if(formulaArray[i].equals("/")) {
				double x = (double) list.pop();
				double y = (double) list.pop();
				list.push(y / x);
			}
			else if(formulaArray[i].equals("%")) {
				double x = (double) list.pop();
				double y = (double) list.pop();
				list.push(y % x);	
			}
			else if(formulaArray[i].equals("^")) {
				double x = (double) list.pop();
				double y = (double) list.pop();
				list.push(Math.pow(y, x));	
			}
			else {
				list.push(Double.parseDouble(formulaArray[i]));
			}
		}
		//Returns the final value left in the stack (should only be one)
		return Double.toString((Double)list.peek());
	}
}
