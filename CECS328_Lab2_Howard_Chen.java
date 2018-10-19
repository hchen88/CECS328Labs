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
		while (left <= right) {  // loops until left is greater than right
			m = (int) Math.ceil((left + right)/2); // finds the midpoint of array
			if (intArray[m] == 0) { // when the midpoint is a 0
				if(intArray[m+1] == 0) { // if the element after midpoint is still 0
					left = m + 1;
				}else if (intArray[m+1] == 1) { // if the element after midpoint is 1
					return m+1; // returns that index which is k
				}
			}else if (intArray[m] == 1) { // if the midpoint is 1
				if( intArray[m -1] == 1) { // checks the previous element 
					right = m -1; //moves scope of array
				} else if( intArray[m -1] == 0) { // if the previous element is 0 
					return m; //returns index , k.
				}
			}
		}
		return -1; // returns -1 if no index k is found.
	}
	/**
	* this method prompts the user to enter in a number 
	* then proceeds to find the 
	* squaroot using binary search method and returns the answer.
	* @return - the answer as an integer
	*/
	public static int squareRoot() {
		Scanner in = new Scanner(System.in); 
		String nString;
		System.out.print("Enter in an integer N: "); //prompts user to enter in an Int
		nString = in.nextLine().trim(); // input as string form
		int n = Integer.parseInt(nString);  //converts to integer
		int left = 0, right = n - 1, m = 0;  // declares and intializes leftbound, rightbound and midpoint.
		while (left <= right) { //loops until left is less than or equal to right.
			m = (int) Math.ceil((left + right)/2); // calulates midpoint 
			if (m*m > n) { // checks the left of n 
				right = m - 1;
			}else if (m*m < n) { // checks the right of n
				left = m + 1;
			}else if (m*m == n) { // if midpoint * midpoint is euqal to n 
				return m; //returns answer
			}
		}
		return m; // returns answer 
	}
	/**
	* the main where all the methods 
	* are implemented and tested.
	*
	*/
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
