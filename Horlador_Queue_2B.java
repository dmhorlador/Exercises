package assignment;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Horlador_Queue_2B {
	//Global Variable
	public static int maxSize = 2; //Can Change the CAPACITY of Shopping Cart
	
	public static void main (String[]args) {
		Queue<String> cart = new LinkedList <String> (); //initialize Queue
		Scanner scan = new Scanner(System.in);
		
		System.out.println("------------ SHOPPING CART ------------");
		
		 while (true) {
			 if (cart.size()!= maxSize) {	
				 for (int i = 0; i < maxSize; i++) {	//add list in the cart
					addCart(cart, scan);
				 }
				 printCart(cart);		//display list after adding the desired size of cart 
			 } else {
				 for(int i = maxSize; i > 0; i-- ) {	//Delete the list based on the number of size depends on the user: 
					 addCart(cart,scan);				
					 System.out.println("Cart is full the item " + " < " + cart.poll() + " > " + "will be removed"); 
					 System.out.println();
					 printCart(cart);
				 }
				 break;
			 }
		 }
	}
	// Method for printing cart
	public static void printCart(Queue <String> cart) {
		System.out.println();
		System.out.println("======== Cart ========");
	
		for (String list: cart) {
			System.out.println(" ⚫ " + list);
		}
		System.out.println();	
	}
	//Method for adding cart
	public static void addCart(Queue<String> cart, Scanner scan) {
		System.out.print("Add item : ");
		String item = scan.nextLine();
		cart.offer(item);
		
		//Calling the Method for displaying items
		displayItem(cart,item);
		
	}
	//Display Items when add and if it is new
	public static void displayItem(Queue<String> cart, String item) {
		if (cart.size() <= maxSize) {
			System.out.println("You have added the item " + " < " + item + " > ");
			System.out.println();
		} else {
			System.out.println("You have added new item " + " < " + item + " > ");
			System.out.println();
		}
	}
	
}
	
