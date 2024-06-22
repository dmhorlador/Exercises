package horlador.activity5;
import java.util.Random;
import java.util.LinkedList;
import java.util.Scanner;
public class Raffle {
	public static String name;	//Global variable string for participants name
	public static void main (String [] args) {
		LinkedList <String> player = new LinkedList <String>();		//initialize list of players
		LinkedList <String> winnerList = new LinkedList <String>();	//initialize list of winners
		Scanner scan = new Scanner (System.in);
		
		while(true) {
			System.out.println("--------- Main Menu ---------");
			System.out.println("(A) Add a Participants");
			System.out.println("(R) Remove a Participants");
			System.out.println("(P) Pick a Winner");
			System.out.println("(D) Display Winners");
			System.out.println("(0) Exit");
			System.out.print("Choice: ");
			String choice = scan.nextLine();
			int noOfPrizes = 3;		//Organizer can change the total number of winners
			
			if (choice.equalsIgnoreCase("A")) {
				addParticipants(player,scan);				//Method for adding
			} else if(choice.equalsIgnoreCase("R")) {
				removeParticipants(player, scan);			//Method for removing or deleting
			} else if(choice.equalsIgnoreCase("P")) {
				if (winnerList.size() < noOfPrizes) {		// if the winnerlist size is greater than the prize
					pickWinner(player, scan, winnerList);	// Method for Picking a winner
				} else {
					System.out.println("All winner have been determined\n");
				}
			} else if(choice.equalsIgnoreCase("D")) {
				displayWinner(winnerList);					//Method for displaying r
			} else if(choice.equalsIgnoreCase("O")|| choice.equalsIgnoreCase("0")){
				break;		// break and will proceed to the Method for exit
			} else {
				System.out.println("Invalid, Please try again!\n");	
			}
		}
		System.out.print("\nYou are leaving the program...");
		exit();				//Method for exit
		scan.close();		//close scan
	}

	public static void addParticipants(LinkedList <String> player, Scanner scan) {
		System.out.println("\n~~~~~~~~~~ ADD PLAYER ~~~~~~~~~~");
		while(true) {
			System.out.print("\nDo want to ADD participant? (Y/N) : ");
			String input = scan.nextLine();
			
			if (input.equalsIgnoreCase("Y")) {
				System.out.println("--------------------------------------");
				System.out.print("Participant Name: ");
				name = scan.nextLine();		// user input for name
				
				if (isPlayerThere(player)){	//Method that checks if the player is already there
					System.out.println("Player is already exist");
				} else {
					player.add(name);			// name will store in the LinkedList player
					System.out.println("Added Successfully!");
				}
			} else if(input.equalsIgnoreCase("N")) {
				System.out.println("Adding end... \n");
				break;
			} else {
				System.out.println("Invalid Input! Please try Again!");
			}
		}
	}

	public static void removeParticipants(LinkedList <String> player, Scanner scan) {
		System.out.println("\n~~~~~~~~~~ REMOVE PLAYER ~~~~~~~~~~");
		while(true) {
			System.out.print("Do you want to REMOVE participant? (Y/N) : ");
			String input = scan.nextLine();
			
			if (input.equalsIgnoreCase("Y")) {
				if(player.isEmpty()) {		//if empty 
					System.out.print("No participant! Please ADD \n\n");
				} else {
					System.out.println("--------------------------------------");
					System.out.print("Remove Name : ");	
					name = scan.nextLine();		
					
					if (isPlayerThere(player)) {	//this Method checked if the participant is already there
						player.remove();			//if it is there then the player will be removed 
						System.out.print("Removed Successfully!\n\n");
					} else {
						System.out.print("Player not found\n\n");
					}
				}
			} else if (input.equalsIgnoreCase("N")) {
				System.out.println("Removing end... \n");
				break;
			} else {
				System.out.println("Invalid Input! Please try Again!\n");
			}
		}
	}
	//Boolean method that returns the value true/false to check if the player is there
	public static boolean isPlayerThere(LinkedList<String> player) {
		for(String p: player) {
			if(p.equalsIgnoreCase(name)) {		//ignore the case of name
				return true;					//true
			}
		}
		return false;							//false
	}
	
	public static void pickWinner(LinkedList <String> player, Scanner scan, LinkedList <String> winnerList) {
		Random random = new Random();	//initialize random
		if (player.isEmpty()) {			//if empty
			System.out.println("No participant! Please ADD\n");
		} else{
			int pick = random.nextInt(player.size()); 	//will randomly get the player if the player is not empty
			String winner = player.get(pick);			//The String winner will get the random player 
			winnerList.add(winner);						//winner will Store in the List of Winnerlist
			player.remove(pick);						//Then that player will be removed in the list of player
			System.out.println("Winner: " + winner + "\n");		//output the random winner one by one
		} 
	}
			
	public static void displayWinner(LinkedList <String> winnerList) {
		if (!winnerList.isEmpty()) {		//if it is not empty
			System.out.println("\n!!!!! WINNERS !!!!!");
			for(String win: winnerList) {				//display the winner
				System.out.println(" ⚫  "  + win);
			} 
		}else {
			System.out.print("Pick a Winner First");	//if not, it will tell the user to pick first
		}
	}
	//Method for exit
	public static void exit() {
		System.exit(0);
	}

}
