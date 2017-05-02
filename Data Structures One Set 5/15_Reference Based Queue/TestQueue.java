/** Author: Joseph Tassone
 *  Description: Program adds a selection of names to a queue, and
 *  prints them out and counts the number of names.
 */

public class TestQueue {
	public static void main(String [] args) {
		QueueLinkedList list = new QueueLinkedList();
		
		list.enqueue("Bill Thompson");
		list.enqueue("William Shake");
		list.enqueue("Jim Jimson");
		list.enqueue("Lile Higgings");
		list.enqueue("Tyle Tylerson");
		list.enqueue("Joe Patterson");
		list.enqueue("Kate Kittens");
		list.enqueue("Dory Nimo");
		list.enqueue("Murdock J Carter");
		list.enqueue("Lelo Stiches");
		list.enqueue("Ronald McDonald");
		list.enqueue("Arthur Noname");
		list.enqueue("Iam Runin");
		list.enqueue("Otto Nams");
		list.enqueue("Don Hurray");
		
		System.out.println("The number of items: " + countQueue(list));
		displayQueue(list); 
	}
	
	//The method prints out all the names in the queue
	public static void displayQueue(QueueLinkedList list) {
		list.enqueue(null);
		String temp;
		while((temp = (String) list.dequeue()) != null) {
			System.out.print("[" + temp + "]");
			list.enqueue(temp);
		}
	}
	
	//The method counts the number of names and returns the count
	public static int countQueue(QueueLinkedList list) {
		int size = 0;
		list.enqueue(null);
		String temp;
		while((temp = (String) list.dequeue()) != null) {
			list.enqueue(temp);
			size++;
		}
		return size;
	}
}
