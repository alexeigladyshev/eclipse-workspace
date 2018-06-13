import java.util.Arrays;
import java.security.SecureRandom;

/**
 * 
 * @author Alex Lawson
 * 
 * I got the core code from this website:
 * https://www.javatpoint.com/bubble-sort-in-java
 * 
 * Bubble Sort has efficiency O(n^2)
 * Any changes I made to the original code, I make comments in the code
 * 
 */

public class BubbleSort {
	
	public static void main(String[] args) {
		
		//SIZE and MAX are two constants I use to create an array of random integers
		final int SIZE = 25;
		final int MAX = 600;
		SecureRandom random = new SecureRandom();
		
		Integer[] array = new Integer[SIZE]; 
		
		//creates an array between -MAX/2 TO MAX/2 - 1
		for(int i=0; i< array.length; i++) {
			array[i] = random.nextInt(MAX) - MAX/2;
		}
		

		System.out.printf("**Bubble Sort**%n%n");
		
		//print the array using Functional Programming before sorting
		System.out.printf("Array Before Bubble Sort%n%s%n%n",Arrays.asList(array));

		bubbleSort(array);// sort array elements using bubble sort

		//print the array using Functional Programming after sorting
		System.out.printf("Array After Bubble Sort%n%s%n%n",Arrays.asList(array));
	
	}
	
	static void bubbleSort(Integer[] array) {
		
		//use this temporary variable to swap elements during the sort
		int temp = 0;
		int len = array.length;
		for (int i = 0; i < len; i++) {
			
			//you start with j=1 because you compare the j-th element and j-1 element
			for (int j = 1; j < (len - i); j++) {
				
				if (array[j - 1] > array[j]) {
					
					// swap elements using the temporary place-holder
					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}

			}
		}
	}
	
}