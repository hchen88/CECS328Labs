//Jessica HIlario
//CECS 328
import java.util.*;

public class lab1 {
	public static void main(String [] args) {
		partA();
		System.out.println();
		partB();
	}
	
	public static void partA() {
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		int[] a; //Array a
		System.out.println("Part A: Average Case Scenario");
		System.out.println("Enter a positive number: ");
		int s = scan.nextInt(); //Get user input
		System.out.println();
		int n = 1000;
		a = new int[s];
		Random rand = new Random();
		for (int i = 0; i < a.length; i++) { // From 1000 to -1000 inside the array randomly
			a[i] = rand.nextInt(n + 1 + n) - n;
		}
		
		Arrays.sort(a); //Sorts the array
		
		showArray(a, s);
		
		long linearStart = System.nanoTime(); //Start the timer
		for(int i = 0; i < 100; i++) { //Linear search
			int key = a[rand.nextInt(s)];
			linearSearch(a, key);
			
		}
		long linearFinish = System.nanoTime(); //End the timer
		long avgLinear = (linearFinish - linearStart)/n; //Find the timer
		
		System.out.println("The average time for the Linear search is : " + avgLinear);
		
		long binaryStart = System.nanoTime(); //Start the timer
		for(int i = 0; i < 100; i++) { //LBinary search
			int key = a[rand.nextInt(s)];
			binarySearch(a, key);
		}
		
		long binaryFinish = System.nanoTime(); //End the timer
		double log2100 = Math.log10(n)/Math.log10(2);
		double avgBinary = (binaryFinish - binaryStart)/log2100; //FInd the timer
		
		System.out.println("The average time for the Binary search is : " + avgBinary);
		System.out.println();
		System.out.println("End of Part A");
		
	}
	
	public static void partB() {
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		int[] a; //Array a
		System.out.println("Part B: Worst Case Scenario");
		System.out.println("Enter a positive number: ");
		int s = scan.nextInt(); //Get user input
		System.out.println();
		int n = 1000, key = 5000;
		
		a = new int[s];
		Random rand = new Random();
		for (int i = 0; i < a.length; i++) { // Put n to -n inside the array randomly
			a[i] = rand.nextInt(n + 1 + n) - n;
		}
		
		Arrays.sort(a); //Sorts the array
				
		long linearStart = Math.abs(System.nanoTime()); //Start the timer
		linearSearch(a, key);
		long linearFinish = Math.abs(System.nanoTime()); //End the timer
		long Linear = (linearFinish - linearStart); //Find the timer
		
		System.out.println("The worst time for the Linear search is : " + Linear);
		
		long binaryStart = Math.abs(System.nanoTime()); //Start the timer
		binarySearch(a, key);
		long binaryFinish = Math.abs(System.nanoTime()); //End the timer
		long Binary = (binaryFinish - binaryStart); //Find the timer
		
		System.out.println("The worst time for the Binary search is : " + Binary);
		
		int temp[] = {1,2};
		long start = Math.abs(System.nanoTime()); //Calculate the single line
		binarySearch(temp, 3);
		long end = Math.abs(System.nanoTime());
		double diff = (end-start) * (Math.log10(100000000)/Math.log10(2)); //Calculate the n = 10^7
		
		System.out.println("The time it takes to run one step is : " + diff);
		System.out.println();
		System.out.println("End of Part B");	
	}
	
	//Performs linear search
	public static int linearSearch(int[] arr, int key){    
        for(int i=0;i<arr.length;i++){    
            if(arr[i] == key){    
                return i;    
            }    
        }    
        return -1;    
    }  
	
	//Performs Binary search
	public static int binarySearch(int[] arr, int key) {
		int l = 0, r = arr.length - 1, mid = 0;
		while (l <= r) {
			mid = (int) Math.ceil((l+r)/2);
			
			//Return if the key is at the middle
			if (arr[mid] == key) {
				return mid;
			}
			
			//If the element is smaller than the mid, than change the right
			else if (arr[mid] > key) {
				r = mid - 1;
			}
			
			//If the element is bigger than the mid, than change the left
			else if (arr[mid] < key) {
				l = mid + 1;
			}
		}
		
		return mid;
	}
	
	// Shows the array
	public static void showArray(int[] a, int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(a[i]);
		}
	}
}
