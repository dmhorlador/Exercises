package assignment;
import java.util.Scanner;
import java.util.TreeSet;
public class Horlador_TreeSet_B {
	public static void main (String [] args) {
		TreeSet <String> book = new TreeSet <>();	//initialize TreeSet
		Scanner scan = new Scanner (System.in);
		while(true) {	
			System.out.println("☛☛☛☛☛☛☛ Options ☚☚☚☚☚☚☚");
			System.out.println("(A) Add Book of Words");
			System.out.println("(D) Delete Words");
			System.out.println("(P) Display Words");
			System.out.println("(E) Exit");
			System.out.print("Choice: ");
			String choice = scan.nextLine();
			
			if (choice.equalsIgnoreCase("A")) {	
				addWord(scan, book);					//method for adding	
			} else if (choice.equalsIgnoreCase("D")) {
				deleteWord(scan,book);					//method for deleting
			} else if (choice.equalsIgnoreCase("P")) {
				display(book);							//method for displaying list of words
			} else if (choice.equalsIgnoreCase("E")) {
				System.out.println("You are leaving the program... \n");	//exit
				System.exit(0);
			} else {
				System.out.println("Invalid input \n");	//invalid if not in the choices
			}	
		}	
	}
	//Method for adding book of words
	public static void addWord(Scanner scan, TreeSet<String> book) {
		System.out.print("Add your word: ");
		String addedWord = scan.nextLine();		//user input 
		
		if (wordThere(book,addedWord)) {		//if the word is there, to prevent duplication
			System.out.println("Word already exist! \n");
		} else {								//if not
			book.add(addedWord);				//add the word in book	
			System.out.println("The word « " + addedWord + " » is Successfully Added! \n");
		}
	}
	//Method for checking if the word is already there
	public static boolean wordThere (TreeSet <String> book, String addedWord) {
		for (String words: book) {			//check each word in the book
			if (words.equalsIgnoreCase(addedWord)) {	//if there, it will ignore the case of the added word
				return true;				//return true
			}
		}
		return false;						//false
	}
	//Method for deleting/removing words
	public static void deleteWord(Scanner scan, TreeSet <String> book) {
		System.out.print("Delete word: ");
		String remove = scan.nextLine();		//user input
		
		if(wordThere(book,remove)) {			//Method for checking if the word is there, if true
			for(String removedWord: book) {		//for each book,
				if(removedWord.equalsIgnoreCase(remove)) {
					book.remove(removedWord);	//remove the removedWord in the book
					System.out.println("The word « " + remove + " » is Successfully removed! \n");
					return;
				}
			}
		} else {
			System.out.println("Word doesn't found \n");
		}
	}
	//Method in Displaying the book of words
	public static void display(TreeSet <String> book) {
		if(book.isEmpty()) {		//if empty
			System.out.println("Empty, Please add word first \n");
		} else {
			System.out.println("\n✿✿✿✿ Book of Words ✿✿✿✿");
			for (String bookOfWords: book) {
				System.out.println(" ➜ " + bookOfWords);
			}
			System.out.println("✿✿✿✿✿✿✿✿✿✿✿✿✿✿✿✿✿✿✿✿✿✿ \n");
		}
	}
}
