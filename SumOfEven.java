package horlador.activity2;
import java.util.Scanner;
public class SumOfEven {
	
	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		
		//user input for starting number
		System.out.print("Starting number: ");
		int start = scan.nextInt();
		
		//user input for ending number
		System.out.print("Ending number: ");
		int end = scan.nextInt();
		
		if (start <= end) {		//check if starting number is greater than or equal to ending number, if true then print and perform the function getSumofEven()
			System.out.print("Sum of all even numbers from " + start + " to " + end + " is: " + getSumofEven(start,end));
		} else {
			System.out.println("Ending number should be greater than or equal to Starting number");
		}
		//close scan
		scan.close();
	}
	
	public static int getSumofEven(int start, int end){
		if((start == end) && (start % 2 == 0)) {
			return start;		//return start if starting and ending are equal and both are EVEN
		} else if((start == end) && (start % 2 != 0)) {
			return 0;			//return 0 if both starting and ending are equal but are ODD
		} else if (start % 2 == 0) {
			return start + getSumofEven (start + 1, end);	// return the starting number and adding it if it is even
		} else {
			return getSumofEven (start + 1, end);	//if not starting number will be added by 1 to continue the process until we meet the base case
		}
	}
	
}


