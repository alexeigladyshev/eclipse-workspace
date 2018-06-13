package edu.gmu.swe510.sorting;

/**
 * 
 * @author Alex Lawson
 * 
 * this class takes any generic class that implements Comparable interface, and sorts them
 * using the sort method
 *
 * @param <E>
 */

public class GenericSelectionSort<E extends Comparable<E>> {
	
	private E[] list;
	
	public GenericSelectionSort(E[] list){
		
		this.list = list; 
	}
	

	// sort generic array using selection sort
	public void selectionSort() {
		
		// loop over data.length - 1 elements
		for (int i = 0; i < list.length - 1; i++) {
			
			int smallest = i;
			// loop to find index of smallest element  
			for (int j = i + 1; j < list.length; j++) {
				if (list[smallest].compareTo((list[j])) > 0) {
					smallest = j;
				}
			}
			
			E swap = list[smallest];
	        list[smallest] = list[i];
	        list[i] = swap;
		}
	}
	
	//this method prints the array, each element on an individual line
	public void printArray() {

		for (int i = 0; i < list.length; i++) {
			System.out.printf(list[i] + "%n");
		}
	}
}