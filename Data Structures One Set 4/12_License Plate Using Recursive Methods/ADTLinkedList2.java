/** Name: Joseph Tassone
 *  Description: Class for a sorted linked list of strings, and
 *  all the methods that allow manipulation of the list. Utilizes
 *  circular nature and dummy node to eliminate special cases. Add,
 *  remove, and get utilize recursive solutions. 
 */


public class ADTLinkedList2 {
	
	private Node dummy;
	
	public ADTLinkedList2() {
		dummy = new Node(null, null, null);
		dummy.setNext(dummy);
		dummy.setPrevious(dummy);
	}
	
	//Returns whether the list is empty
	public boolean isEmpty() {
		return (dummy.getNext() == dummy);
	}	

	//Passes values to the helper method to properly remove the item
	//Throws an exception if the list is empty
	public void remove(String s) {
		if (isEmpty()) {
			throw new ADTLicencePlateException("The list is emptpy!");
		}
		removeHelper(s, dummy.getNext(), dummy);
	}
	
	//Searches for an item equal to the input, and removes it
	//Throws an exception if the item isn't found
	private void removeHelper(String s, Node curr, Node prev) {
		if(curr == dummy) {
			throw new ADTLicencePlateException("Item not found!");
		}

		if (s.equals(curr.getItem())) {
			prev.setNext(prev.getNext().getNext());
			prev.getNext().getNext().setPrevious(prev);
			return;
		} 
		removeHelper(s, curr.getNext(), prev.getNext());
	}
	
	//Passes values to the helper method to properly add the item
	public void add(String s) {
		if (isEmpty()) {
			dummy.setNext(new Node(s, dummy, dummy));
			return;
		}
		addHelper(s, dummy.getNext(), dummy);
	}
	
	//Searches for an item less than the input and adds before it
	private void addHelper(String s, Node curr, Node prev) {
		if (curr == dummy || s.compareTo(curr.getItem()) < 0) {
			prev.setNext(new Node (s, curr, prev));
			curr.setPrevious(prev.getNext());
			return;
		} 
		addHelper(s, curr.getNext(), prev.getNext());
	}
	
	//Passes values to the helper method to properly retrieve the item
    public String get(int pos) { 
        return getHelper(pos, dummy.getNext());
    }
    
    //Searches for an item until position equals zero, and then returns the item
    private String getHelper(int pos, Node curr) {
        if (pos == 1) {
            return curr.getItem();
        }
        return getHelper(pos - 1, curr.getNext());
    }

    //Iterative reversing
    //Passes the node two steps from the dummy to the helper
    public void reverse() {
    	reverseHelper(dummy.getNext().getNext());
    }
    
    //Takes in a node and traverses the list until dummy is hit
    //n equals the swapped values as it passes through the list
    private void reverseHelper(Node n){
		while(n != dummy) {
			n = swap(n.getPrevious());
		}
	}
    
    //Recursive reversing
    //Passes the node two steps from the dummy to the helper
	public void reverse2() {
		reverseHelper2(dummy.getNext().getNext());
	}
	
	//Takes in a node and traverses the list until dummy is hit
	//the previous of n is passed to the swap method and altered
	//Since recursion functions in reverse, dummy must also be switched at the end
	private void reverseHelper2(Node n){
		swap(n.getPrevious());
		if(n == dummy) {
			swap(dummy);
		}
		else {
			reverseHelper2(n.getNext());
		}
	}
	
	//Swaps the values with the temporary node and returns the new n
	private Node swap(Node n) {
		Node temp = n.getPrevious();
		n.setPrevious(n.getNext());
		n.setNext(temp);
		return n;
	}
	
	//Returns the size of the list
	public int size() {
		Node curr = dummy.getNext();
		int count = 0;
		
		while(curr != dummy) {
			curr = curr.getNext();
			count++;
		}	
		return count;
	}
	
	//Prints out all the values of the list
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
