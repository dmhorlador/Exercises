package assignment;
import java.util.Stack;
public class Horlador_Stack_2B {
	public static void main (String [] args) {
		Stack <Character> character = new Stack <Character>(); //initialize stacks
		
		String input = "Data Structures and Algorithms"; 	
		System.out.println("Input: " + input);				//print the original value
		
		transformStr(input,character);		//calling the method for transforming String to Character
		
		System.out.print("Output: ");
		print(character);					//calling the method to PRINT the reverse value
		
	}
	//Method for Transforming String to Character
	public static void transformStr(String input, Stack <Character> character) {
		char[] c = input.toCharArray();		//Convert the given string into a character array 	
		for (int i = 0; i < input.length(); i++) {	//getting the size of the given String value
			character.push(c[i]);	//pushing each character into the stack 
		}	
	}
	//Method for listing/displaying data in character stack 
	public static void print(Stack <Character> character) {
		while(!character.empty()) {
			System.out.print(character.pop());
		}
	}
}
