/** Name: Joseph Tassone
 *  Description: General creature object that contains gender and movement.
 */

public abstract class Creature {
	
	protected boolean gender;
	protected boolean movement;
	
	public Creature() {
	}
	
	public Creature(boolean gender, boolean movement) {
		this.gender = gender;
		this.movement = movement;
	}
	
	//Male is true, female is false
	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	//Hasn't moved is false, moved is true
	public boolean isMoving() {
		return movement;
	}
	
	public void setMovement(boolean movement) {
		this.movement = movement;
	}
	
}
