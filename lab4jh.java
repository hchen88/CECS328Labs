/*
Jessica Hilario
CECS 328
Lab 4
*/

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class lab4jh {
	public static void main(String[] args) {
		//Step 1: Request the user to enter a positive integer and call it n
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a positive number for the length of the array: ");
		int n = scan.nextInt();
		System.out.println();
		
		//Step 2: Generate n random integers between -100 to 100 and save them in array a
		int[] a = new int[n];
		generate_elements(a,n);
		
		//Step 3: Print the generated array
		printArray(a);
		
		//Step 4: Request the user to enter a number between 1 to n as the kth least element
		System.out.print("Enter a number between 1 and " + n + " as the kth least element: ");
		int k = scan.nextInt();
		System.out.println();
		
		//Print the kth least element
		System.out.println("The kth least element is " + Quick_select(a, 0, n-1, k-1));
		System.out.println();
		
		System.out.print("Enter a number between 1 and " + n + " as the kth max element: ");
		k = scan.nextInt();
		System.out.println();
		
		//Returns the max k numbers from an unsorted array
		int[] mxk = maxK(a, k - 1);
		printArray(mxk);
	}
	
	public static int Quick_select(int[] a, int left, int right, int k) { //Recursion
	
		//If the list contains only one element
		if (left == right) {
			return a[left];
		}
		
		//Select a random pivot index between left and right
		int pivotIndex = new Random().nextInt(right - left + 1) + left;
		
		//Pivot Index is now in its final sorted form when being through partition to find the division
		pivotIndex = partition(a, left, right, pivotIndex);

		if (k == pivotIndex) {
			return a[pivotIndex];
		}
		else if (k < pivotIndex) {
			return Quick_select(a, left, pivotIndex - 1, k);
		}
		else {
			return Quick_select(a, pivotIndex + 1, right, k);
		}
	}
	
	
	public static int[] maxK(int[]a, int k) {
		int[] ans = new int[k + 1];
		int index = a.length - 1;
		int t = Quick_select(a, 0, a.length - 1, index);
		ans[0] = t; //Store the kth lest element first
		for (int i = 1; i <= k; i++) {
			ans[i] = a[index - i]; //Increment the kth index until it reaches the end
		}
		
		return ans;
	}
	
	public static int partition(int[] arr, int low, int high, int index) {
		//Get the pivot
		int pivot = arr[index];
		
		//Move pivot to the end
		swap(arr, index, high); 
		int pIndex = low;
	
		for (int i = low; i <= high - 1; i++) {
			if (arr[i] <= pivot) {
				swap(arr, i, pIndex);
				pIndex++;
			}
		}
		//Move pivot to its final place
		swap(arr, pIndex, high);
		return pIndex;
	}
	
	public static void generate_elements(int[] arr, int n) {
		Random rand = new Random();
		int s = 100;
	
		for(int i = 0; i < n; i++) {
			arr[i] = rand.nextInt(s + 1 + s) - s;
		}
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void printArray(int[] a) {
		System.out.println(Arrays.toString(a));
	}
	
}