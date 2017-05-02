/** Name: Joseph Tassone
 *  Description: Extends the creature object, and creates a cat object.
 */

public class Cat extends Creature{
	
	final private String COLOUR;
	
	//Creates a cat object and sets a random gender and an unchangable colour 
	public Cat() {
		
		super.movement = false;
		
		int genderPick = (int) (Math.random() * 2); 
		if (genderPick == 0) {
			super.gender = true;
		}
		else {
			super.gender = false;
		}
		
		String [] randomColour = {"black", "white", "grey", "orange"};
		this.COLOUR = randomColour[(int) (Math.random() * 4)];
	}
	
	//Represents the object by its colour
	public String toString() {
		if (super.isGender() == true) {
			if (this.COLOUR.equals("black")) {
				return "B";
			}
			else if (this.COLOUR.equals("white")) {
				return "W";
			}
			else if (this.COLOUR.equals("grey")) {
				return "G";
			}
			else {
				return "O";
			}
		}
		else {
			if (this.COLOUR.equals("black")) {
				return "b";
			}
			else if (this.COLOUR.equals("white")) {
				return "w";
			}
			else if (this.COLOUR.equals("grey")) {
				return "g";
			}
			else {
				return "o";
			}
		}
	}
}
