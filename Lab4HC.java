import java.util.Random;
import java.util.Scanner;

public class Lab4HC {
	
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
	public static int quick_select(int[] array, int start, int end, int k) {
		Random rand = new Random();
		//subarray is on last element returns since its the kth elemnt
		
		if(start == end) {
			return array[start];
		}
		//chooses a random index from start to end.
		int pivotIndex = start + rand.nextInt();
		
		//partitions array
		pivotIndex = partition(array, start, end);
		
		//if the pivot index is the kth index
		if (k == pivotIndex)
			return array[k];
		//k is less than pivotIndex, recursive call to quick sort. updating end term
		else if (k < pivotIndex)
			return quick_select(array, start, pivotIndex -1, k);
		// if k  is more than the pivotIndex , another recursive call updating start
		else
			return quick_select(array, pivotIndex + 1 , end, k);
		
	}
	
	
	//Part B
	public static int quick_selectB(int[] array, int start, int end, int k) {
		Random rand = new Random();
		k = array.length - k;
		//subarray is on last element returns since its the kth elemnt
		if(start == end) {
			return array[start];
		}
		//chooses a random index from start to end.
		int pivotIndex = start + rand.nextInt();
		
		//partitions array
		pivotIndex = partition(array, start, end);
		
		//if the pivot index is the kth index
		if (k == pivotIndex)
			return array[k];
		//k is less than pivotIndex, recursive call to quick sort. updating end term
		else if (k < pivotIndex)
			return quick_select(array, start, pivotIndex -1, k);
		// if k  is more than the pivotIndex , another recursive call updating start
		else
			return quick_select(array, pivotIndex + 1 , end, k);
		
	}
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		String nString;
		double start, stop, insertionTime = 0.00, quickSortTime = 0.00, insertionTotal= 0.00, quickSortTotal = 0.00;
		int n, k = -1, totalTimes = 100;
		int[] sortedArray;
		
		
		//Part A		
		Random r = new Random(); 
		System.out.print("Please enter in a positive integer : ");
		nString = in.nextLine().trim();
		n = Integer.parseInt(nString);
		
		int[] array = new int[n];
		
		System.out.println("--------Generating Random Array with "
				+ n +  " elements-----");
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(100 + 1 + 100) - 100;	 // generate random numbers -1000 to 1000
		}
		
		for(int i = 0; i < array.length; i++) {
			if ( i < array.length -1) {
				System.out.print(array[i] + ", ");
			}else {
				System.out.print(array[i]);
			}
		}
		while(k < 0 || k > n ) {
			System.out.print("\nPlease enter a number between 1 to " + n 
					+ "(as the kth least element): " );
			nString = in.nextLine().trim();
			k = Integer.parseInt(nString);
		}
		
		System.out.println("The kth least element is " + 
				quick_select(array, 0 , n-1, k));
		
		//Part B
		System.out.println("The kth largest element is " + 
				quick_selectB(array, 0 , n-1, k));

		
	}
		
		
}
