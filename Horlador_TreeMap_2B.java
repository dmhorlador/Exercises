package assignment;

import java.util.Scanner;
import java.util.TreeMap;

public class Horlador_TreeMap_2B {
	public static void main (String[]args) {
		TreeMap <String, String> phonebook = new TreeMap<>();
		Scanner scan = new Scanner (System.in);
		while (true) {
			mainMenu(phonebook,scan);
		}
	}
	
	public static void mainMenu(TreeMap <String,String> phonebook, Scanner scan) {
		while (true) {
			System.out.println("Option: ");
			System.out.println("(1) Add New Contact");
			System.out.println("(2) Delete Contact");
			System.out.println("(3) Update Contact Number");
			System.out.println("(4) Display All Contacts");
			System.out.println("(5) Exit");
			System.out.print("CHOICES: ");
			String choice = scan.nextLine();
			
			switch (choice) {
			case "1":
				addContact(scan,phonebook);
				break;
			case "2":
				deleteContact(phonebook,scan);
				break;
			case "3":
				System.out.print("Enter Contact Name: ");
				String name = scan.nextLine();

				updateContact(phonebook, scan, name);
				break;
			case "4": 
				display(phonebook);
				break;
			case "5":
				System.out.println("You Are Leaving the Program....");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Input\n");
			}
		}
	}
	
	public static void addContact (Scanner scan, TreeMap <String, String> phonebook) {
		System.out.print("Input Name: ");
		String name = scan.nextLine();
		
		if (nameIsThere(phonebook, name) ) {
			System.out.println("Existing name! \n");
			askUser(phonebook,scan,name);
		} else {
			System.out.print("Phone Number: ");
			String number = scan.nextLine();
			
			phonebook.put(name, number);
			System.out.println("Phone number added \n");
		}

	}

	public static void deleteContact (TreeMap <String, String> phonebook, Scanner scan) {
		System.out.print("Contact Name to Removed: ");
		String remove = scan.nextLine();
		
		if (nameIsThere(phonebook,remove)) {
			for (String deleteContact: phonebook.keySet()) {
				if(deleteContact.equalsIgnoreCase(remove)) {
					phonebook.remove(deleteContact);
					System.out.println("Successfully removed! \n");
					return;
				}
			}
		} else {
			System.out.println("Contact number not found! \n");
		}
	}
	
	public static boolean nameIsThere (TreeMap <String, String> phonebook, String name) {
		for (String person: phonebook.keySet()) {
			if (person.equalsIgnoreCase(name)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void askUser(TreeMap <String, String> phonebook, Scanner scan, String name) {
		System.out.println("(1) Edit the existing contact number");
		System.out.println("(2) Add new contact with different name");
		System.out.print("Choose: ");
		String choose = scan.nextLine();
		
		switch (choose) {
		case "1":
			editContact(scan,phonebook,name);
			break;
		case "2":
			System.out.print("New Contact Name: ");
			String newName = scan.nextLine();
			
			System.out.println("New Contact Number: ");
			String newNumber = scan.nextLine();
			
			phonebook.put(newName, newNumber);
			break;
		default:
			System.out.println("Invalid Input! \n");
			break;
		} 
		
	}
	
	public static void editContact(Scanner scan,TreeMap <String, String> phonebook, String name) {
		System.out.print("Enter updated contact number: ");
		String newContact = scan.nextLine();
		
		phonebook.replace(name, newContact);
		System.out.println("Updated! \n");
	}

	public static void display (TreeMap <String, String> phonebook) {
		if (phonebook.isEmpty()) {
			System.out.println("Empty please add! \n");
		} else {
			System.out.println("======== PHONEBOOK ========");
			for(String contact: phonebook.keySet()) {
				System.out.println("Phone name: " + contact + "\nPhone Number: " + phonebook.get(contact) + "\n");
			}
		}
	}
	
	public static void updateContact(TreeMap <String, String> phonebook, Scanner scan, String name) {
		if (nameIsThere(phonebook,name)) {
			System.out.print("New Contact Number: ");
			String updatedNumber = scan.nextLine();
			
			if(!numberThere(phonebook, updatedNumber)) {
				phonebook.replace(name, updatedNumber);
				System.out.println("Contact Number is Updated! \n");	
				
			} else {
				System.out.println("Number already exists! \n");
			}
		} else {
			System.out.println("Not found \n");
		}
	}
	
	public static boolean numberThere (TreeMap <String, String> phonebook, String updatedNumber) {
		for(String value: phonebook.values()) {
			if(value.contains(updatedNumber)) {
				return true;
			}
		}
		
		return false;
	}
}
