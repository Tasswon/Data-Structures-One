/** Author: Joseph Tassone
 *  Description: Program creates a number of license plates
 *  which are added to a custom ADT.  
 */

import java.util.Scanner;

public class TestDriver {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
				
		Plate plate = new Plate();

		System.out.print("How many license plates would you like to print: ");
		int numberOfPlates = input.nextInt();

		//Creates 350 random license plates
		for(int i = 0; i < numberOfPlates; i++) {

			char first = (char) ((Math.random() * (91 - 65)) + 65);
			char second = (char) ((Math.random() * (91 - 65)) + 65);
			int third = (int) ((Math.random() * (10 - 1)) + 1);
			int fourth = (int) ((Math.random() * (10 - 1)) + 1);
			char fifth = (char) ((Math.random() * (91 - 65)) + 65);
			char sixth = (char) ((Math.random() * (91 - 65)) + 65);
			char seventh = (char) ((Math.random() * (91 - 65)) + 65);

			String randomPlate = first + "" + second + "" + third + fourth + " " + fifth + sixth + seventh;		
			plate.add(randomPlate);
		}

		getSortedList(plate.listCopy());
		plate.add("AA30 TDF");
		getSortedList(plate.listCopy());
	}

	//Prints out the license plates
	public static void getSortedList(String[] list) {
		for(int i = 0; i < list.length; i++) {
			System.out.println((i + 1) + ": " + list[i]);
		}
	}
}
