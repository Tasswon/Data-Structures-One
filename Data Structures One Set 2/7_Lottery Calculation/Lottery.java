/** Author: Joseph Tassone
 *  Description: Shows a lottery calculation that shows how much the user
 *  will receive in a given week, and the total to date for that week
 */

import java.util.Scanner;

public class Lottery {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a week: ");
		int week = input.nextInt();
		
		//Loops until the user enters 0 for the week value
		while(week != 0) {
			System.out.print("Week " + week + " pays $" + weekAmount(week));
			System.out.printf("\n%s%d%s%.2f%s","Week ", week, ", $", (lotteryTotal(week)), " has been received in total"); 
			
			System.out.print("\n\nEnter a week: ");
			week = input.nextInt();
		}
		
		System.out.println("Thank you!");
	}
	
	//Takes in the week value and returns the receiving value that week
	public static double weekAmount(int week) {
		if(week == 1) {
			return 0.01;
		}
		
		return 2 * weekAmount(week - 1);
	}
	
	//Takes in the week and returns the total amount to date for that week
	public static double lotteryTotal(int week) {
		if(week == 1) {
			return 0.01;
		}
		
		return weekAmount(week) + lotteryTotal(week - 1);
	} 
}
