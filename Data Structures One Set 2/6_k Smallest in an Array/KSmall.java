/** Author: Joseph Tassone
 *  Description: Enters an array and returns the kth smallest value from the array
 */

import java.util.Arrays;

public class KSmall{
	public static void main(String[] args) {
		
		int [] array = {14, 5, 21, 17, 6, 2, 22, 15, 7, 13};
		System.out.print("The 3rd smallest item is: " + helper(3, array, 0, array.length - 1));
		
		System.out.print("\nShows array doesn't change: " + Arrays.toString(array));
	}
	
	//Takes in the original array and creates a copy to be used in the kSmall method	
	public static int helper(int k, int [] array, int first, int last) {

		int [] array2 = Arrays.copyOf(array, array.length);

		return kSmall(k, array2, 0, array2.length - 1);
	}
	
	//Takes in an array and determines the kSmallest point of the array
	public static int kSmall(int k, int [] array, int first, int last) {
		
		int pivotIndex = partition(array, first, last);
		
		if(k < pivotIndex - first + 1) {
			return kSmall(k, array, first, pivotIndex - 1);
		}
		
		else if (k == pivotIndex - first + 1) {
			return array[pivotIndex];
		}
		
		else {
			return kSmall(k - (pivotIndex - first + 1), array, pivotIndex + 1, last);
		}
	}
	
	//Partitioning the array based on the pivot into smaller and larger numbers
	public static int partition(int [] array, int first, int last) {
		
		int pivot = array[first];
 		
		while (first < last) {
			while (array[first] < pivot) { 
				first++;
			}
			
			while (array[last] > pivot) {
				last--;
			}
			
			int temp = array[first];
			array[first] = array[last];
			array[last] = temp;
		}
		return first;
	}
}
