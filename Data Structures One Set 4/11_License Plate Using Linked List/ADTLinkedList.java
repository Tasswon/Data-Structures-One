/** Name: Joseph Tassone
 *  Description: Class for a sorted linked list of strings, and
 *  all the methods that allow manipulation of the list. Utilizes
 *  circular nature and dummy node to eliminate special cases.
 */

public class ADTLinkedList {
	
	private Node dummy;
	
	public ADTLinkedList() {
		dummy = new Node(null, null, null);
		dummy.setNext(dummy);
		dummy.setPrevious(dummy);
	}
	
	//Returns whether the list is empty
	public boolean isEmpty() {
		return (dummy.getNext() == dummy);
	}	
	
	//Takes in a string and traverses the list until a specific point
	private Node find(String s) {
		Node curr = dummy.getNext();
		Node prev = dummy;
		
		while(curr != dummy && s.compareTo(curr.getItem()) > 0) {
			prev = curr;
			curr = curr.getNext();
		}	
		return prev;
	}
	
	//Takes in a position and traverses the list until the count equals the position
	private Node find(int pos) {
		Node curr = dummy.getNext();
		int count = 1;
		
		while(curr != dummy && count != pos) {
			curr = curr.getNext();
			count++;
		}
		return curr;
	}
	
	//Adds an item to its ordered point in the list
	//Throws an exception if a duplcate item is entered
	public void add(String s) throws ADTLicencePlateException{
		Node prev = find(s);
		if(s.equals(prev.getNext().getItem())) {
			throw new ADTLicencePlateException("You've entered a duplicate");
		}
		prev.setNext(new Node(s, prev.getNext(), prev));
		prev.getNext().getNext().setPrevious(prev.getNext());
	}
	
	//Removes an item from the list and adjusts the references for the removal
	//Throws an exception if the item isn't found
	public void remove(String s) throws ADTLicencePlateException{
		Node prev = find(s);
		if(prev.getNext() == dummy) {
			throw new ADTLicencePlateException("Item not found!");
		}
		prev.setNext(prev.getNext().getNext());
		prev.getNext().getNext().setPrevious(prev);
	}
	
	//Returns an item at a specific position in the list
	public String get(int pos) {
		Node curr = find(pos);
		return curr.getItem();
	}
	
	//Utilizes a counter to keep track of the number of relevant items (not dummy)
	public int size() {
		Node curr = dummy.getNext();
		int count = 0;
		
		while(curr != dummy) {
			curr = curr.getNext();
			count++;
		}	
		return count;
	}
	
	//Prints out the list in its ordered sequence
	public void print() {
		Node curr = dummy.getNext();
		Node prev = dummy;
		int count = 1;
		
		while(curr != dummy ) {
			System.out.println(count + ": " + curr.getItem());
			prev = curr;
			curr = curr.getNext();
			count++;
		}
	}
}
