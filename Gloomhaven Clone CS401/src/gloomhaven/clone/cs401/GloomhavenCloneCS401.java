package gloomhaven.clone.cs401;

import java.util.Scanner;

public class GloomhavenCloneCS401 {
	
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	String partyName;
    	int partySize;
    	
    	System.out.print("Enter the name of your party: ");
    	partyName = scanner.nextLine();
    	do {
    		System.out.print("Enter the number of players in your party(1 - 4): ");
    		partySize = scanner.nextInt();
    		if(partySize > 4 || partySize <= 0) {
    			System.out.println("Error: Invalid Input.");
    		}
    	}while(partySize > 4 || partySize <= 0);
    	
    	Party party = new Party(partyName, partySize);
    	
    	
    	
    	//Scenario Text - Name, level, lore
    	
    	//check if party is alive.
    	
    	//players choose cards or rest.
    	//enemies choose random ability cards.
    	
    	//establish initiative order.
    	//players and enemies take actions.
    	
    	//repeat
    	
    	
    	
    }
    
}
