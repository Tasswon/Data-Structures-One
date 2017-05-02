/** Name: Joseph Tassone
 *  Description: Creates license plates and stores them into 
 *  a sized data structure which can be manipulated (custom ADT).
 */


import java.util.regex.Pattern;

public class Plate {
	
	public final int MAX_SIZE = 20;
	
	private String [] license = new String[MAX_SIZE];
	private int listSize;
	
	
	public Plate() {
	}
	
	//Constructor for ADT, throws exception if the license isn't formatted correctly
	public Plate(String number) throws LicenseFormatException{
		
		if(Pattern.matches("[A-Z]{2}\\d{2}\\s[A-Z]{3}", number) == false) {
			throw new LicenseFormatException("Must follow format 'XX99 XXX'");
		}
		
		this.license[0] = number;
		this.listSize++;
	}
	
	//Determines whether a sorted list is empty
	public boolean isEmpty() {
		if(this.listSize == 0) {
			return true;
		}
		return false;
	}
	
	//Returns the number of items that are in a sorted list
	public int size() {
		return this.listSize;
	}
	
	//Inserts item into its proper sorted position in a sorted list
	//Throws an exception if the item cannot be placed on the list (full)
	//Throws an exception if the license is formatted incorrectly
	public void add(String number) throws ADTLicencePlateException{
		
		if(this.listSize == 20) {
			throw new ADTLicencePlateException("The list is full!");
		}
		
		if(Pattern.matches("[A-Z]{2}\\d{2}\\s[A-Z]{3}",number) == false) {
			throw new LicenseFormatException("Must follow format 'XX99 XXX'");
		}
		
		for(int i = 0; i < this.license.length; i++) {
			
			if(this.license[i] == null) {
				this.license[i] = number;
				this.listSize++;
				break;
			}
			
			if(number.compareTo(this.license[i]) == 0) {
				throw new ADTLicencePlateException("You've entered a duplicate license: " + number);
			}
			
			else if(number.compareTo(this.license[i]) < 0) {
				for(int j = this.size(); j > i; j--) {
					license[j] = license[j - 1];
				}
				
				this.license[i] = number;
				this.listSize++;
				break;
			}
		}
	}
	
	
	//Deletes item from a sorted list
	//Throws an exception if the item is not found
	public void remove(String number) throws ADTLicencePlateException{
		
		if(locateIndex(number) == -1) {
			throw new ADTLicencePlateException("Item not found!");
		}
		
		for(int i = 0; i < this.size(); i++) {
			if(this.license[i].equals(number)) {
				this.license[i] = null;
				
				for(int j = i; j < this.size() - 1; j++) {
					this.license[j] = this.license[j + 1];
				}
				this.license[this.size() - 1] = null;
				this.listSize--;
			}
		}
	}
	
	
	//Returns the item at position index of a sorted list
	//List is left unchanged by this operation
	//Throws an exception if the index is out of range
	public String get(int index) throws ADTLicencePlateException{
		
		if(index > this.listSize - 1) {
			throw new ADTLicencePlateException("Invalid index number!");
		}
		
		return this.license[index];
	}
	
	//Returns the position where the item belongs or exists 
	public int locateIndex(String number) {

		int low = 0;
		int high = this.listSize - 1;

		while(low <= high) {
			int middle = (low + high) / 2; 
			if (number.compareTo(license[middle]) > 0){
				low = middle + 1;
				
			} else if (number.compareTo(license[middle]) < 0){
				high = middle - 1;
				
			} else { 
				return middle; 
			}
		}
		return -1;
	}
	
	//Copy of original array is sent 
	public String [] listCopy() {
		
		String[] arrayCopy = new String[this.listSize];
		for(int i = 0; i < this.listSize; i++) {
			arrayCopy[i] = this.license[i];
		}
		
		return arrayCopy;
	}
}
