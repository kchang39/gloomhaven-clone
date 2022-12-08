package gloomhaven.clone.cs401;

import java.util.Scanner;

public class GloomhavenCloneCS401 {
	
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	EnemyParty mobs = new EnemyParty(5, "MolePeople");
    	
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
    	party.pickHands();
    	
    	
    	int input;
    	AbilityCard[] abilityCards = new AbilityCard[party.getSize()];
    	//Scenario Text - Name, level, lore
    	//change the x,y coordinates for every player and monster to a starting position.
    	//edit the board to match player and monster positions
    	
    	
    	//check if party is alive.
    	do{
    		party.printParty();
    		
        	//players choose cards or rest.
    		for(int i = 0; i < party.getSize(); i++) {
    			if(party.getPlayer(i).isAlive()) {
    				do {
    					System.out.print("Player #" + (i+1) + ", choose an action. Long Rest(0) or Choose 2 Ability Cards(1): ");
    					input = scanner.nextInt();
    					if(input != 0 && input != 1) {
    						System.out.println("Error: Invalid Input.");
    					}
    				}while(input != 0 && input != 1);
    			
    				if(input == 0) {
    					party.getPlayer(i).longRest();
    				}
    				else {
    					//add ability card functionality 
    				}
    			}
    		}
    		
    	//enemies choose random ability cards.
    	
    	//establish initiative order.
    	//players and enemies take actions.
    		
    	}while(party.isAlive() && mobs.isAlive());//repeat until one party is dead.
    	
    	
    	if(!party.isAlive()) {
    		System.out.println("\n---GAME OVER---");
    	}
    	else if(!mobs.isAlive()) {
    		System.out.println("\n---QUEST COMPLETE---");
    		System.out.println("\n- All the molemen were eliminated");
    	}
    	
    	
    }
    
}
