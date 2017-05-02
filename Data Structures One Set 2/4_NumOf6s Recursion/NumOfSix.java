/** Author: Joseph Tassone
 *  Description: An array is generated with random number and 
 *  the program counts number of times the array contains a six
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class NumOfSix {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("How large would you like to make the array: ");
		
		int arraySize = input.nextInt();
		
		int [] array = new int[arraySize];
		
		for(int i = 0; i < array.length; i++) {
			
			int randomNumber = (int) (1 + Math.random() * (10 - 1));
			array[i] = randomNumber;
		}
		
		System.out.println(Arrays.toString(array));
		System.out.println("Number of sixes in the array: " + numOf6s(array, 0));
	}
	
	//Takes in an array and an index, and counts the number of sixes from that index
	public static int numOf6s(int[] nums, int index) { 
		
		if(index > nums.length - 1) {
			return 0;
		}
		
		if (nums[index] == 6) {
			return 1 + numOf6s(nums, index + 1);
		}
		return numOf6s(nums, index + 1);
	}
}
