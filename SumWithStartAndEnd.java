package horlador.activity1;
import java.util.Scanner;
public class SumWithStartAndEnd {
	
	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		
		//user input for starting number
		System.out.print("Starting number: ");
		int start = scan.nextInt();
		//user input for ending number
		System.out.print("Ending number: ");
		int end = scan.nextInt();
		//print the output and Function getSum()
		System.out.print("The sum of all the integer numbers from " + start + " to " + end + " is: " + getSum(start,end));	
		
		scan.close();	//close scan
	}		
	
	public static int getSum (int start, int end ) {
		if(start == end) {	//base case
			return start;	// true
		} else {
			return end + getSum(start , end - 1);	//the function calls itself to meet the base case 
		}
	}
	
}

