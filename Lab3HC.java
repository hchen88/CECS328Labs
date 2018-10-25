import java.util.Random;
import java.util.Scanner;

public class Lab3HC {
	/**
	 * this method finds the pivot, then divides/partitions the array into subarrays.
	 * @param array - the array to partition
	 * @param start - the start of the partition
	 * @param end - the end of the partition
	 * @return - returns the index of the partition
	 */
	public static int partition (int[] array, int start, int end) {
		//figure out pivot
		int midpoint = (int) Math.ceil(array.length/2);
		int pivotValue = 0, temp, pivotIndex = 0;
		int k = start -1;
		
		//median of the first, middle, and last to figure out pivot
		if(array[end] >= array[midpoint] && array[start] <= array[midpoint]
			|| array[end] <= array[midpoint] && array[start] >= array[midpoint]	) {
			pivotValue = array[midpoint];
			pivotIndex = midpoint;
		}
		if(array[midpoint] >= array[end] && array[end] >= array[start] ||
				array[midpoint] <= array[end] && array[end] <= array[start]) {
			pivotValue = array[end];
			pivotIndex = end;
		}
		
		if(array[midpoint] <= array[start] && array[end] >= array[start] ||
				array[midpoint] >= array[start] && array[end] <= array[start]) {
			pivotValue = array[start];
			pivotIndex = start;
		}
		
		//swap pivot with last index.	
		temp = array[end];
		array[end] = array[pivotIndex];
		array[pivotIndex] = temp;
		
	
		for( int i = start; i < end; i++) {
			if( array[i] <= pivotValue) {
				k++;// increments pointer
				//swap the elements
				temp = array[k];
				array[k] = array[i];
				array[i] = temp;
			}
		}
		//swaps out of place arrays
		temp = array[k+1];
		array[k+1] = array[end];
		array[end] = temp;
		
		return k+1; //returns partition index.
	}
	
	/**
	 * this method is used to sort each partition.
	 * @param array - the array to sort
	 * @param start - the start of the array
	 * @param end - the end index of the array
	 */
	public static void sort(int[] array, int start, int end)  {
		if (start < end)
		{
			int partitionIndex = partition(array, start, end);
			//recursive call dividing array
			sort(array, start, partitionIndex -1);
			sort(array, partitionIndex+1, end);
		}
		
	}

	/**
	 * this method calls the sort method which uses recursive quick_sort.
	 * @param array- the integer array to be sorted.
	 * @return - returns the sorted array
	 */
	public static int[] quick_sort(int[] array) {
		//calls sort to start sort.
		sort(array, 0, array.length-1); 
		return array;
	}
	
		
/**
 * this method takes an unsorted integer array of any size and sorts the array from least to greatest.
 * @param array - the unsorted array
 * @return the sorted integer array
 */
	public static int[] insertion_sort(int[] array) {
		
		for( int i = 0; i < array.length - 1; i++) {
			
			int currentNum = array[i]; //current number Index to check.
			int k = i-1; // previous index;
			//loops until correct index is found for number. starting from 0
			
			while (k >=0 && currentNum < array[k]) { 
				//swaps array if not in order
				array[k+1] = array[k];
				k--;
				
			}
			
			array[k+1]= currentNum; // places number in correctly place
			
		}
		
		return array; //returns array
		
	}
	
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		String nString;
		double start, stop, insertionTime = 0.00, quickSortTime = 0.00, insertionTotal= 0.00, quickSortTotal = 0.00;
		int n, totalTimes = 100;
		int range =5000, numberOfTimes = 100;
		//random object to generate random numbers
		Random r = new Random(); 
		System.out.println("Please enter in a positive integer :");
		nString = in.nextLine().trim();
		n = Integer.parseInt(nString);
		int[] array = new int[n];
		
		for(int i = 0; i < numberOfTimes; i++) {
			for(int j = 0; j < array.length - 1; j ++) {
				// generate random numbers -5000 to 5000
				array[j] = r.nextInt(range + 1 + range) - range;	 
			}
		//times the insertion sort algorithm
		start = System.nanoTime();
		int[] sortedArray = insertion_sort(array);
		stop = System.nanoTime();
		insertionTime = stop - start;
		insertionTotal += insertionTime;
		//times the quick sort algorithm
		start = System.nanoTime();
		sortedArray = quick_sort(array);
		stop = System.nanoTime();
		quickSortTime = stop - start;
		quickSortTotal += quickSortTime;
		}

		System.out.println("Average Time to Sort Random array with Insertion Sort: " + insertionTime/totalTimes + " nanoseconds" );
		System.out.println("Average Time to Sort Random array with Quick Sort Time: " + quickSortTime/totalTimes + " nanoseconds" );
		
		//calculates average time it takes per step.
		double perStep = insertionTotal/Math.pow(n, 2);
		// calculate number of instructions to run insertion sort.
		int numOfIntsructions = (int)Math.sqrt(1000000000/perStep); 
		//outputs all calculated instructions
		System.out.println("In one second, my computer can run " + numOfIntsructions 
				+ " instructions using insertion sort");

	}
}