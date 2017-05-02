/** Name: Joseph Tassone
 *  Description: Extends the creature object, and creates a mouse object.
 */

public class Mouse extends Creature{
	
	//Sets a random gender to the mouse
	public Mouse() {
		
		super.movement = false;
		
		int genderPick = (int) (Math.random() * 2); 
		if (genderPick == 0) {
			super.gender = true;
		}
	}
	
	//Represents the mouse object as M
	public String toString() {
		if (super.isGender() == true) {
			return "M";
		}
		else {
			return "m";
		}
	}
}
