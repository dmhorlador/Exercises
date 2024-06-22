package horlador.activity8;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
public class OddOrEven {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		Stack <Integer> number = new Stack <Integer>();
		Queue<Integer> even = new LinkedList<Integer>();
		Queue <Integer> odd = new LinkedList <Integer>();
		
		System.out.print("input numbers: ");	//user input
		String input = scan.nextLine(); 
		
		convertToCharInt(input,number);		//calling the method for converting string to character to integer 
		process(number,even,odd);	//calling the method to process and printing as well
		scan.close();
	}
	// method for converting string to characters and change character into integer
	public static void convertToCharInt(String input, Stack <Integer> number) {
		char[] n = input.toCharArray();		//convert string to array character
		for (int i = 0; i < input.length(); i++) { 		//size of string
			int c = Character.getNumericValue(n[i]);	//array character will become number or integer
			number.push(c);			//push to the stack number
		}
	}
	// method in processing and checking
	public static void process(Stack <Integer> number,Queue<Integer> even,Queue <Integer> odd ) {
		System.out.print("Numbers: ");
		while(!number.isEmpty()) {
			int top = number.pop();
			System.out.print(top + ",");		//display every number from newest to oldest
			
			if (top % 2 == 0) {		//check if the number is even 
				even.offer(top);	//store in queue even
			}else {
				odd.offer(top);		//else, store in queue odd
			}	
		}
		printOdd(odd);		//calls method to print the odd
		printEven(even);	//calls method to print the even
	}
	//Method for printing even
	public static void printEven(Queue<Integer> even) {
		System.out.print("\nEven Numbers: ");
		while (!even.isEmpty()) {
			System.out.print(even.poll() + ",");
		}
	}
	//Method for printing odd
	public static void printOdd(Queue <Integer> odd) {
		System.out.print("\nOdd Numbers: ");
		while (!odd.isEmpty()) {
			System.out.print(odd.poll() + ",");
		}
	}
	
}


