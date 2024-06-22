package assignment;
import java.util.Scanner;
import java.util.LinkedList;
public class Horlador_LinkedLists_2B {
	
	public static void main(String[] args)  {
		Scanner scan = new Scanner(System.in);						
		LinkedList <String> subject = new LinkedList <String>();
//			clearScreen();
			while(true) {
				System.out.println("Add");
				System.out.println("DROP");
				System.out.println("DISPLAY");
				System.out.println("EXIT");
				System.out.print("Choice: ");
				String choice = scan.nextLine();
				
				if (choice.equalsIgnoreCase("add")){
					 addSubject(subject, scan);
				 } else if (choice.equalsIgnoreCase("drop")){
					dropSubject(subject, scan);
				 } 
				 else if (choice.equalsIgnoreCase("display")){
					 displaySubject(subject);
				 }else if(choice.equalsIgnoreCase("exit")) {
					 break;
				 } else {
						 System.out.println("Input not found in the choices. Please Choose Again!"); //invalid input the user will ask again
				 }
			}
				
			System.out.print("\nYou are leaving the program...");
			exit();
			scan.close();			//close scan
	}

	
	public static void addSubject(LinkedList <String> subject, Scanner scan) {
		
		System.out.print("Enter the Subject Name: ");
		String name = scan.nextLine();			//input Name of Subjects
		subject.add(name);
			
//		scan.close();
	}
	
	public static void dropSubject(LinkedList <String> subject, Scanner scan) {

		System.out.print("drop : ");
		String name = scan.nextLine();
		for (int i=0; i < subject.size();i++) {
			 if(subject.get(i).equalsIgnoreCase(name)) {
				 subject.remove(i);
			 } else {
				 System.out.println("invalid subject!");
			 }	
		}
		 
//		 scan.close();
	}
	
	public static void displaySubject(LinkedList <String> subject) {
		
		if(subject.size() >= 1) {
			 getSubjects(subject);
		 } else {
			 System.out.println("Add subject first!");
		 }
	}

	public static void getSubjects(LinkedList <String> subject) {	
		//Print all the added subjects
		System.out.println("--------------------------------------");
		System.out.print("Subjects added: \n");
		
		for (int i = 0; i < subject.size(); i++) {
			System.out.println(" ~ " + subject.get(i));
		}	
	}

	public static void exit() {
		System.exit(0);
	}
}