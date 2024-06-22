package horlador.activity4;
import java.util.LinkedList;
import java.util.Scanner;

public class UpgradedStudentSubjectRecord {
	public static String subjectName;	//Global variable String for subject name;
	public static void main(String[] args)  {
		Scanner scan = new Scanner(System.in);						
		LinkedList <String> subjects = new LinkedList <String>();
		
			while(true) {
				System.out.println("------- Menu -------");
				System.out.println("(A) Add a Subject");
				System.out.println("(R) Drop a Subject");
				System.out.println("(D) Display Subjects");
				System.out.println("(E) EXIT");
				System.out.print("Choice: ");
				String choice = scan.nextLine();
				
				 if (choice.equalsIgnoreCase("a")){
					 addSubject(subjects,scan);		//calling Method to add Subject
				 } else if (choice.equalsIgnoreCase("r")){
					dropSubject(subjects,scan);		//calling Method to delete/remove Subject
					System.out.println();			//space to organize
				 } else if (choice.equalsIgnoreCase("d")){
					 displaySubject(subjects);		//calling Method to display Subjects
					 System.out.println();			//space to organize
				 } else if(choice.equalsIgnoreCase("e")) {
					 break;							//break to exit
				 } else {				
					 System.out.println("Input not found in the choices. Please Choose Again!\n"); //invalid input the user will ask again
				 }
			}
		//informing user to leave
		System.out.print("\nYou are leaving the program...");
		exit();			//Method for exiting
		scan.close();	//close scan
		
	}
	//Method in adding Subject
	public static void addSubject(LinkedList <String> subjects, Scanner scan) {
		System.out.print("Enter the Subject Name: ");
		subjectName = scan.nextLine();			//input Name of Subjects
		subjects.add(subjectName);
		System.out.println("Added Successfully!\n");	
	}
	//Method in dropping or removing subject
	public static void dropSubject(LinkedList <String> subjects, Scanner scan) {
		if (subjects.isEmpty()) {					//if Subjects is Empty
			System.out.print("You have not added any Subject\n");
		} else {									//if not, perform
			System.out.print("Drop Subject : ");
			subjectName = scan.nextLine();
			
			if (isSubjectThere(subjects)) {			//Method is true 
				subjects.remove();					//remove 
				System.out.print("Removed Successfully!\n");
			} else {								//if the subject not found
				System.out.print("Subject not Found\n");
			}	
		}	
	}
	//Method for determining if Subject is there
	public static boolean isSubjectThere(LinkedList <String> subjects) {
		for (String code: subjects) {					//for each subject that in the code
			if (code.equalsIgnoreCase(subjectName)) {	//code will ignore the case of input name
				return true;							//true
			}
		}
		return false;		//false
	}
	//Method for displaying the subjects
	public static void displaySubject(LinkedList <String> subjects) {
		if(subjects.size() >= 1) {	//true
			 getSubjects(subjects);	//call the method for printing all the Subjects
		 } else {
			 System.out.println("Add subject first!");	//false
		 }
	}
	//Method in printing subjects
	public static void getSubjects(LinkedList <String> subjects) {	
		System.out.println("\n Subjects added:");
		
		for (int i = 0; i < subjects.size(); i++) {
			System.out.println(" ⚫ " + subjects.get(i));
		}	
	}
	//Method for Exit
	public static void exit() {
		System.exit(0);
	}
	
}
