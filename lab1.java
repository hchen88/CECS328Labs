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
		int n = scan.nextInt(); //Get user input
		System.out.println();
		
		a = new int[n];
		Random rand = new Random();
		for (int i = 0; i < a.length; i++) { // Put n to -n inside the array randomly
			a[i] = rand.nextInt(n * 2 + 1) - n;
		}
		
		Arrays.sort(a); //Sorts the array
		
		for (int i = 0; i < n; i++) { //Show the array
			System.out.println(a[i]);
		}
		
		long linearStart = System.nanoTime(); //Start the timer
		for(int i = 0; i < 100; i++) { //Linear search
			int key = a[rand.nextInt(n)];
			linearSearch(a, key);
			
		}
		long linearFinish = System.nanoTime(); //End the timer
		long avgLinear = (linearFinish - linearStart)/100; //Find the average linear time
		
		System.out.println("The average time for the Linear search is : " + avgLinear);
		
		long binaryStart = System.nanoTime(); //Start the timer
		for(int i = 0; i < 100; i++) { //Binary search
			int key = a[rand.nextInt(n)];
			Arrays.binarySearch(a, key);
		}
		long binaryFinish = System.nanoTime(); //End the timer
		double log2100 = Math.log10(100)/Math.log10(2);
		double avgBinary = (binaryFinish - binaryStart)/log2(100); //Find the average binary time
		
		System.out.println("The average time for the Binary search is : " + avgBinary);
		System.out.println();
		System.out.println("End of Part A");
		
	}
	
	public static void partB() {
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		int[] a; //Array a
		int key ;
		System.out.println("Part B: Worst Case Scenario");
		System.out.println("Enter a positive number: ");
		int n = scan.nextInt(); //Get user input
		System.out.println();
		
		a = new int[n];
		Random rand = new Random();
		for (int i = 0; i < a.length; i++) { // Put n to -n inside the array randomly
			a[i] = rand.nextInt(n * 2 + 1) - n;
		}
		
		Arrays.sort(a); //Sorts the array
				
		long linearStart = Math.abs(System.nanoTime()); //Start the timer
		linearSearch(a, 1000000);
		long linearFinish = Math.abs(System.nanoTime()); //End the timer
		long Linear = (linearFinish - linearStart); //Find the timer
		
		System.out.println("The worst time for the Linear search is : " + Linear);
		
		long binaryStart = Math.abs(System.nanoTime()); //Start the timer
		Arrays.binarySearch(a, 1000000);
		long binaryFinish = Math.abs(System.nanoTime()); //End the timer
		long Binary = (binaryFinish - binaryStart); //Find the timer
		
		System.out.println("The worst time for the Binary search is : " + Binary);
		
		int temp[] = {1,2};
		long start = Math.abs(System.nanoTime()); //Calculate the single line
		Arrays.binarySearch(temp, 3);
		long end = Math.abs(System.nanoTime());
		double diff = (end-start) * (Math.log10(100000000)/Math.log10(2)); //Calculate the n = 10^7
		
		System.out.println("The time it takes to run one step is : " + diff);
		System.out.println();
		System.out.println("End of Part B");	
	}
	
	public static int linearSearch(int[] arr, int key){    
        for(int i=0;i<arr.length;i++){    
            if(arr[i] == key){    
                return i;    
            }    
        }    
        return -1;    
    }  
}