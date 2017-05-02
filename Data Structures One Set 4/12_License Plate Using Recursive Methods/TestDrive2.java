/** Author: Joseph Tassone
 *  Description: Program creates a list of license plates
 *  and allows the user to manipulate the list.
 */

public class TestDrive2 {
	public static void main(String [] args) {
		
		PlatePrime2 plate = new PlatePrime2();
		
		plate.add("AA11 XXX");
		plate.add("BB11 XXX");
		plate.add("EE11 XXX");
		plate.add("SS11 XXX");
		plate.add("DD11 XXX");
		
		plate.listCopy();
		
		System.out.println();

		plate.reverse();
		plate.listCopy();
		
		System.out.println();

		plate.reverse2();
		plate.listCopy();
	}
}
