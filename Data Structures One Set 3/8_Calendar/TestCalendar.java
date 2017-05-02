/** Author: Joseph Tassone
 *  Description: Program allows user to enter a date
 *  and manipulate its variables or print it out.
 */

public class TestCalendar {
	public static void main(String[] args) {
		
		Calendar test = new Calendar(7, 16, 2016);
		System.out.println(test.displayWords());
		System.out.println(test.displayNumbers());
		
		test.advanceDay();
		System.out.println(test.displayWords());
		System.out.println(test.displayNumbers());
		
		test.reduceMonth();
		test.reduceYear();
		System.out.println(test.displayWords());
		System.out.println(test.displayNumbers());
	}
}
