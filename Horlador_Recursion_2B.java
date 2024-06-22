package horlador.doane.starter;
import java.util.Scanner;
public class Horlador_Recursion_2B {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//user will input a number
		System.out.print("Input a number : ");
		int input = scan.nextInt();
		
		//print the Function getSumofInteger()
		System.out.print("The sum of numbers from 1 to " + input + " is : " + getSumofInteger(input));
		scan.close();	//close the scan
	}
	
	public static int getSumofInteger(int input) {
		if (input == 0) {	//base case
			return 0;		//true
		} else {
			return input + getSumofInteger(input - 1);	//false
		}
	}

}
