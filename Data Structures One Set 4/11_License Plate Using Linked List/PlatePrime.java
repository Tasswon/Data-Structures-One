/** Name: Joseph Tassone
 *  Description: Class for a sorted list of license plates
 *  and the associated methods for manipulating the list. 
 */

import java.util.regex.Pattern;

public class PlatePrime {
	
	private ADTLinkedList list = new ADTLinkedList();
	
	public PlatePrime() {
	}
	
	//Creates a list of license plates 
	//Throws an exception if the initial plate doesn't follow the proper structure
	public PlatePrime(String number) throws LicenseFormatException{
		if(Pattern.matches("[A-Z]{2}\\d{2}\\s[A-Z]{3}", number) == false) {
			throw new LicenseFormatException("Must follow format 'XX99 XXX'");
		}
		list.add(number);
	}
	
	//Determines if the list is empty
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	//Returns the size of the list
	public int size() {
		return list.size();
	}
	
	//Adds an item to the list
	//Throws an exception it doesn't follow the correct format
	public void add(String number)throws LicenseFormatException {
		if(Pattern.matches("[A-Z]{2}\\d{2}\\s[A-Z]{3}",number) == false) {
			throw new LicenseFormatException("Must follow format 'XX99 XXX'");
		}
		list.add(number);
	}
	
	//Removes an item to the list
	//Throws an exception it doesn't follow the correct format
	public void remove(String number) throws LicenseFormatException{
		if(Pattern.matches("[A-Z]{2}\\d{2}\\s[A-Z]{3}",number) == false) {
			throw new LicenseFormatException("Must follow format 'XX99 XXX'");
		}
		list.remove(number);
	}
	
	//Returns the value of an item at a particular point
	//Throws an exception if the index is out of bounds
	public String get(int pos) throws ADTLicencePlateException{
		if(pos > list.size() || pos < 1) {
			throw new ADTLicencePlateException("Invalid index number!");
		}
		return list.get(pos);
	}
	
	//Prints the list 
	public void listCopy() {
		list.print();
	}
}
