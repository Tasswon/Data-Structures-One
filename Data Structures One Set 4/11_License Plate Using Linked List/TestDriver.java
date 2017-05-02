/** Author: Joseph Tassone
 *  Description: Program generates 250 plates, and removes random ones
 *  until there are only 15 remaining. Allows manipulation of the remaining 
 *  plates.
 */

import java.awt.List;

public class TestDriver {
	public static void main(String [] args) {
				
		PlatePrime plate = new PlatePrime();

		//Creates 250 random license plates
		for(int i = 0; i < 250; i++) {

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
		
		plate.listCopy();
		
		//Randomly removes license plates until there are 15
		while(plate.size() != 15) {
			int pos = (int) ((Math.random() * (plate.size() - 1) + 1));
			plate.remove(plate.get(pos));
		}
		
		System.out.println();
		plate.listCopy();
		System.out.println(plate.get(14));
		System.out.println(plate.size());
	}
}