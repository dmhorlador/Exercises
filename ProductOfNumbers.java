package horlador.activity3;
import java.util.Scanner;
public class ProductOfNumbers {
	
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		
		//user input for starting point
		System.out.print("Starting number: ");
		int start = scan.nextInt();
		//user input for ending number
		System.out.print("Ending number: ");
		int end = scan.nextInt();
		//print the Function getProduct()
		System.out.println("Product of all numbers within the range " + start + " to " + end + " is: " + getProduct(start,end));
		scan.close();	//close scan
	}
		
	public static int getProduct(int start, int end) {
		if (start == end) {		//base case
			return start;			//true	
		} else {				
			return end * getProduct (start, end - 1);	//false
		}
	}
	
}
