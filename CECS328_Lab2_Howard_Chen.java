import java.util.Scanner;

/**
 * Programming Lab Assignment 2
 * CECS 328 
 * Professor Pouye Sedighian
 * @author Howard Chen
 * Date Created : October 5, 2018
 */
public class Lab2H{

	/**
	 * This program prompts the user to enter in a random binary 
	 * array having the first K numbers equal to -0 and the rest are equal o 1.
	 * 
	 * @return
	 */
	
	public static int binarySearch() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter in a random binary array having the"
				+ " first K numbers equal to 0 and the rest equal to 1.");
		String binaryArrayString = in.nextLine().trim();
		int[] intArray = new int[binaryArrayString.length()];
		for(int i = 0; i< binaryArrayString.length(); i ++) {
			intArray[i] = Character.getNumericValue(binaryArrayString.charAt(i));		
		}
		int left = 0, right = intArray.length -1, m = 0;
		while (left <= right) {
			m = (int) Math.ceil((left + right)/2);
			if (intArray[m] == 0) {
				if(intArray[m+1] == 0) {
					left = m + 1;
				}else if (intArray[m+1] == 1) {
					return m+1;
				}
			}else if (intArray[m] == 1) {
				if( intArray[m -1] == 1) {
					right = m -1;
				} else if( intArray[m -1] == 0) {
					return m;
				}
			}
		}
		return -1;


	}
	public static int squareRoot() {
		Scanner in = new Scanner(System.in);
		String nString;
		System.out.print("Enter in an integer N: ");
		nString = in.nextLine().trim();
		int n = Integer.parseInt(nString);
		int left = 0, right = n - 1, m = 0;
		
		while (left <= right) {
			m = (int) Math.ceil((left + right)/2);
			if (m*m > n) {
				right = m - 1;
			}else if (m*m < n) {
				left = m + 1;
			}else if (m*m == n) {
				return m;
			}
		}
		return m;
	}
	public static void main(String [] args) {
		
		System.out.println( "Your number is : " + squareRoot());
		int binaryIndex = binarySearch();
		if( binaryIndex == -1) {
			System.out.println("k is not found in binaryArray : " );
		} else {
			System.out.println("k is found at : " + binaryIndex);
		}
		System.out.println(binaryIndex);
	}
}
