/**
	 * Programming Lab Assignment 1
	 * CECS 328 
	 * Professor Pouye Sedighian
	 * @author Howard Chen
	 * Date Created : October 5, 2018
	 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;


public class Lab1H{

		public static int linearSearch(int[] a, int key) {
			for ( int i = 0; i< a.length -1; i ++) {
				if(a[i] == key) {
					return i; // returns index found
				}	
			}
			
			return -1; // returns -1 if number not found
		}
		
		public static int binarySearch(int[] a, int key) {
			int left = 0, right = a.length - 1, m = 0;
			while (left <= right) {
				m = (int) Math.ceil((left + right)/2);
				if (a[m] > key) {
					right = m - 1;
				}else if (a[m] < key) {
					left = m + 1;
				}else if (a[m] == key) {
					return m;
				}
			}
			return m;	
		}
		
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			int n, key;
			Random r = new Random();
			double start, stop, binaryTime = 0.00, linearTime = 0.00;
			double bTotalTime = 0, lTotalTime = 0;
			
			//Part A	
			System.out.println("Please enter in a positive integer:");
			n = in.nextInt();
			int[] a = new int[n];
			
			for(int i = 0; i < a.length - 1; i ++) {
				
				a[i] = r.nextInt(1000 + 1 + 1000) - 1000;	  // generate random numbers -1000 to 1000
			}
			
			Arrays.sort(a);
			for(int i = 0; i < 100; i++) {
				key = a[r.nextInt(n)];
				start = System.nanoTime();
				Arrays.binarySearch(a, key);
				stop = System.nanoTime();
				binaryTime = stop - start;
				bTotalTime += binaryTime;
				start = System.nanoTime();
				linearSearch(a, key); // no need to return.
				stop = System.nanoTime();
				linearTime = stop - start;
				lTotalTime += linearTime;
				}
			
			System.out.println("Avergae Binary Search Time: " + bTotalTime/100 + " nanoseconds"
					+ "\nAverage Linear Search Time: " + lTotalTime/100 + " nanoseconds" );
			
			
			//Part B
			System.out.println("Please enter in a positive integer:");
			n = in.nextInt();
			System.out.println(n);
			a = new int[n];
			
			for(int i = 0; i < a.length - 1; i ++) {
				
				a[i] = r.nextInt(1000 + 1 + 1000) - 1000;	 // generate random numbers -1000 to 1000
			}
			
			Arrays.sort(a);
			key = 5000;
			a = new int[n];
			start = System.nanoTime();
			Arrays.binarySearch(a, key);
			stop = System.nanoTime();
			binaryTime = stop - start;
			
			int perStep = (int)(binaryTime / ((Math.log(n) / Math.log(2))));
			
			System.out.println("Time per step: " + perStep + " nanoseconds");

			System.out.println("Worst-Case Running Time for Binary Search when n = 10^5 : " 
								+ binaryTime + " nanoseconds");
			
			//Step 5 Calculating running time when n = 10^7
			float answer = (float) (perStep * (Math.log(Math.pow(10, 7)) / (Math.log(2))));
			System.out.println("Binary Search Worst-Case Running time  : " + answer  + " nanoseconds");
			
			answer = (float) (perStep* Math.pow(10, 7));
			
			System.out.println("Linear Search Worst-Case Running time  : " + answer  + " nanoseconds");
			
			
			
			
			
		}
	}
