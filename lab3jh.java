/*
Jessica Hilario
CECS 328
Lab 3
*/

import java.util.*;

public class lab3jh {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//Step 1: Request user to enter a positive integer and call it n (n = 1000)
		System.out.println("Enter a positive integer ");
		int n = scan.nextInt(); //Get user input
	
		//Initialize array a
		int[] a = new int[n];
	
		//Calculate the average-running time of quick sort
		average_runningQuickSort(a, n);
	
		//Calculate the average-running time of insertion sort
		average_runningInsertionSort(a, n);
	}
	
	//Step 2: Generate n random integers between -5000 to 5000 and save them in array a
	public static void generate_elements(int[] arr, int n) {
		Random rand = new Random();
		int s = 5000;
	
		for(int i = 0; i < n; i++) {
			arr[i] = rand.nextInt(s + 1 + s) - s;
		}
	}

	public static void average_runningQuickSort(int[] arr, int n) {
		int lines = 100;
		double log2lines = Math.log10(lines)/Math.log10(2);
		long genTotal = 0;
		long start = System.nanoTime();
	
		//Step 4: Repeat steps 2 and 3 for 100 times to determine the average-running time
		for (int i = 0; i < lines; i++) {
		
			//Calulate time to generate elements
			long gstart = System.nanoTime();
			//Step 2
			generate_elements(arr,n);
			long gstop = System.nanoTime();
			genTotal  = genTotal + (gstop - gstart);
			//Step 3: Call quick sort to sort the function
			quick_sort(arr, 0, n -1);
		
		}

		//Calculate the average-running time of quick_sort
		long stop = System.nanoTime();
		long running_time = (stop - start) - genTotal; //Substract the time it took to generate element and calculate the running time
		//Step 5: Print the finish time
		System.out.println("<Running time for quick sort... " + running_time + " ns>");
	
		//Step 7: calculate how many instructions your machine/laptop can run in a second using step 5 and 6 using the quick sort
		double perstep = running_time/(lines*log2lines); //time in 1 step in nanoseconds
		double instructions = 1/perstep;
	
		System.out.println("The instructions my laptop can run in a second for quick sort is " + instructions);
		System.out.println();
	}

	public static void average_runningInsertionSort(int[] arr, int n) {
		int lines = 100;
		double lines2 = Math.pow(lines,2.0);
		long genTotal = 0;
		long start = System.nanoTime();
	
		//Step 4: Repeat steps 2 and 3 for 100 times to determine the average-running time
		for (int i = 0; i < lines; i++) {
			
			//Calulate time to generate elements
			long genStart = System.nanoTime();
			// Step 2
			generate_elements(arr,n);
			long genStop = System.nanoTime();
			genTotal  = genTotal + (genStop-genStart);
			//Step 3: Call insertion sort to sort the function
			insertion_sort(arr, n);
		
		}

		//Calculate the average-running time of insertion_sort
		long stop = System.nanoTime();
		long running_time = (stop - start) - genTotal; //Substract the time it took to generate element and calculate the running time
		//Step 5: Print the finish time
		System.out.println("<Running time for insertion sort... " + running_time + " ns>");
	
		//Step 7: calculate how many instructions your machine/laptop can run in a second using step 5 and 6 using the quick sort
		double perstep = running_time/lines2; //time in 1 step
		double instructions = 1/perstep;
	
		System.out.println("The instructions my laptop can run in a second for insertion sort is " + instructions);
		System.out.println();
	}

	public static void insertion_sort(int[] arr, int n) {
		int key;
		for (int i = 1; i < n; i++) {
			//The ith index of the element in the array will be the key
			key = arr[i];
			int j = i - 1;
		
			//Move elements that are greater than the key
			while (j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j - 1;
			}
			arr[j+1] = key;
		}
	}

	public static void quick_sort(int[] arr, int low, int high) {
		if (low < high) {
			//Partition the array
			int p = partition(arr, low, high);
			quick_sort(arr, low, p -1);
			quick_sort(arr, p + 1, high);
		}
	}

	public static int partition(int[] arr, int low, int high) {
		int[] medianof3 = new int[3];
		int median = (low + high) / 2;
		medianof3[1] = low;
		medianof3[0] = high;
		medianof3[2] = median;
		
		Arrays.sort(medianof3);
		//Get the pivot
		int pivot = medianof3[1];
		int s = low - 1;
	
		for (int i = low; i <= high - 1; i++) {
			if (arr[i] <= pivot) {
				s++;
				swap(arr[s], arr[i]);
			}
		}
		swap(arr[s+1], arr[high]);
		return s + 1;
	}

	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
}
