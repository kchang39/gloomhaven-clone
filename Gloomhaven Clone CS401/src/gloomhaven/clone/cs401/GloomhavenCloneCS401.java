package gloomhaven.clone.cs401;

import static java.lang.Math.sqrt;
import java.util.Scanner;
import java.util.Random;

public class GloomhavenCloneCS401 {
	
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	EnemyParty mobs = new EnemyParty(5, "MolePeople");
    	
    	String partyName;
    	int partySize;
        
        int x1, x2, y1, y2, type;
        Random rng = new Random();
        boolean validMove;
        
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
    	AbilityCard[] topAbilityCardsP = new AbilityCard[party.getSize()];//Player chosed cards
    	AbilityCard[] botAbilityCardsP = new AbilityCard[party.getSize()];
    	
    	EnemyAbilityCard[] AbilityCardsE = new EnemyAbilityCard[mobs.getSize()];//Enemy chosen cards
    	
    	int damage = 0, movement = 0;
    	String enemyTitle, playerTitle;//used for printing outputs.
    	
    	//Scenario Text - Name, level, lore
    	//change the x,y coordinates for every player and monster to a starting position.
    	//edit the board to match player and monster positions
        System.out.print("Enter length of board: ");
        x2 = scanner.nextInt();
        System.out.print("Enter height of board: ");
        y2 = scanner.nextInt();
        
        Board board = new Board();
        board.initializeBoardSize(x2, y2);
        PrintBoard print = new PrintBoard;
        
        for(int i = 0; i < mobs.getSize(); i++){
            do{
                x1 = rng.nextInt(x2);
                y1 = rng.nextInt(y2);
                type = board.CheckObjectTypeInTile(x1, y1);
                if(type == 0){
                    mobs.getEnemy(i).move(x1, y1);
                    board.updateTile(x1, y1, 2, i);
                }
            }while(type != 0);
        }
        
        print.Print(board);
        
    	for(int i = 0; i < party.getSize(); i++){
            int temp = i+1;
            do{
                System.out.print("Enter party member " + temp +"'s starting x coordinate: ");
                x1 = scanner.nextInt();
                System.out.print("Enter party member " + temp +"'s starting y coordinate: ");
                y1 = scanner.nextInt();
                type = board.CheckObjectTypeInTile(x1, y1);
                if(type != 0){
                    System.out.println("Invalid coordinates.");
                }
            }while(type != 0);
            party.getPlayer(i).move(x1, y1);
            board.updateTile(x1, y1, 1, i);
        }
    	
    	print.Print(board);
    	
    	do{//checks if party is alive.
    		party.printParty();
    		
        	//players choose cards or rest.
    		for(int i = 0; i < party.getSize(); i++) {
    			if(party.getPlayer(i).isAlive()) {
    				do {
    					System.out.print(party.getPlayer(i).getName() + ", choose an action. Long Rest(0) or Choose 2 Ability Cards(1): ");
    					input = scanner.nextInt();
    					if(input != 0 && input != 1) {
    						System.out.println("Error: Invalid Input.");
    					}
    				}while(input != 0 && input != 1);
    			
    				if(input == 0) {//Long Rest action.
    					party.getPlayer(i).longRest();
    					topAbilityCardsP[i] = new AbilityCard();
    					botAbilityCardsP[i] = new AbilityCard();
    				}
    				else {//choosing ability cards
    					party.getPlayer(i).getDeck().showHand();
    					System.out.println("Choose a card for top abilities.");
    					topAbilityCardsP[i] = party.getPlayer(i).chooseAbilityCard();
    					System.out.println("Choose a card for bottom abilities.");
    					botAbilityCardsP[i] = party.getPlayer(i).chooseAbilityCard();
    				}
    			}
    		}
    		
    		//enemies choose random ability cards.
    		for(int i = 0; i < mobs.getSize(); i++) {
    			AbilityCardsE[i] = mobs.drawAbilityCard(i);
    		}
    	
    		//players and enemies take actions based on initiative order.
    		party.printParty();
    		mobs.printEnemies();
    		for(int a = 1; a <= 99; a++) {
    			for(int b = 0; b < party.getSize(); b++) {
    				playerTitle = "Init(" + party.getPlayer(b).getInitiative() + "): " + party.getPlayer(b).getName();
    				
    				if(topAbilityCardsP[b].getInitiative() == a) {
    					System.out.println(playerTitle + " uses " + topAbilityCardsP[b].getName() + " and " + botAbilityCardsP[b].getName());
    					
    					if(botAbilityCardsP[b].getBotHeal() != 0) {
    						System.out.println(playerTitle + " heals for " + botAbilityCardsP[b].getBotHeal() + ".");
    						party.getPlayer(b).healDmg(botAbilityCardsP[b].getBotHeal());
    					}
    					if(botAbilityCardsP[b].getBotShield() != 0) {
    						System.out.println(playerTitle + " gains " + botAbilityCardsP[b].getBotShield() + " points of shield.");
    						party.getPlayer(b).addShield(botAbilityCardsP[b].getBotShield());
    					}
    					if(topAbilityCardsP[b].getBotMovement() != 0 || botAbilityCardsP[b].getBotMovement() != 0) {
    						movement = topAbilityCardsP[b].getBotMovement() + botAbilityCardsP[b].getBotMovement();
    						System.out.println(playerTitle + " can move " + movement + " space(s).");
    						//----NOTES FOR AARON----
    						//move functionality for players
        					//you can use party.getPlayer(b).move(x, y);
    						//ask the user what coordinats they want to move to and check if that is valid
                                                do{
                                                    
                                                    System.out.print("Enter x coordinate: ");
                                                    x1 = scanner.nextInt();
                                                    System.out.print("Enter y coordinate: ");
                                                    y1 = scanner.nextInt();
                                                    
                                                    x2 = party.getPlayer(b).getX();
                                                    y2 = party.getPlayer(b).getY();
                                                    
                                                    
                                                    int distance = board.getDistance(x1, y1, x2, y2);
                                                    if(distance <= movement){
                                                        if (x1 <= board.getXsize() && x1 >= 0 && y1 > board.getYsize() && y1 >= 0){
                                                            validMove = board.Move(x2, y2, x1, y1);
                                                        }else{
                                                            validMove = false;
                                                        }
                                                        
                                                        if(validMove = false){
                                                            System.out.println("Invalid move.");
                                                        }else{
                                                            party.getPlayer(b).move(x1, y1);
                                                        }
                                                    }
                                                    
                                                }while(validMove = false);
                                                print.Print(board);
    						
    					}
    					if(topAbilityCardsP[b].getTopDamage() != 0) {
    						damage = party.getPlayer(b).getTotalDamage(topAbilityCardsP[b].getTopDamage());
    						//----NOTES FOR AARON----
    						//check if enemy is in range
    						//choose an enemy or attack first one detected???
    						//to attack use takeDmg(damage); on the target. Works on both enemies and players.
    						//I added a variable for enemies that shows what that enemy's index is on the list.
    						//after damage is done check if alive and if dead remove from the board.
    						//needs proper text prompts to show what is happening
                                                int range = topAbilityCardsP[b].getRange();
                                                boolean enemiesInRange[] = new boolean[mobs.getSize()];
                                                for(int z = 0; z < mobs.getSize(); z++){
                                                    x1 = party.getPlayer(b).getX();
                                                    y1 = party.getPlayer(b).getY();
                                                    x2 = mobs.getEnemy(z).getX();
                                                    y2 = mobs.getEnemy(z).getY();
                                                    int distance = board.getDistance(x1, y1, x2, y2);
                                                    if(range >= distance && mobs.getEnemy(z).isAlive()){
                                                        enemiesInRange [z] = true;
                                                    }else{
                                                        enemiesInRange [z] = false;
                                                    }
                                                }
    						System.out.print("");
    						System.out.println("Init(" + party.getPlayer(b).getInitiative() + "): " + party.getPlayer(b).getName() + " can attack for " + damage + " damage.");
                                                System.out.print("Enemies within range: ");
                                                boolean anyInRange = false;
                                                for(int z = 0; z < mobs.getSize(); z++){
                                                    if (enemiesInRange[z] == true){
                                                        System.out.print(z + " ");
                                                        anyInRange = true;
                                                    }
                                                }
                                                if(anyInRange = true){
                                                    boolean validTarget;
                                                    do{
                                                        System.out.print("\nChoose an enemy to attack: ");
                                                        int target = scanner.nextInt();
                                                        if(enemiesInRange[target] = true){
                                                            validTarget = true;
                                                            System.out.println(party.getPlayer(b).getName() + " attacked " + mobs.getEnemy(target).getName() + " " + target + " for " + damage + " damage.");
                                                            mobs.getEnemy(target).takeDmg(damage);
                                                            if(mobs.getEnemy(target).isAlive() == false){
                                                                System.out.println(mobs.getEnemy(target).getName() + target + " has died.");
                                                                x1 = mobs.getEnemy(target).getX();
                                                                y1 = mobs.getEnemy(target).getY();
                                                                board.emptyTile(x1, y1);
                                                            }
                                                        }else{
                                                            validTarget = false;
                                                            System.out.println("Invalid target.");
                                                        }
                                                    }while(validTarget = false);
                                                }else{
                                                    System.out.println("\nNo targets in range.");
                                                }
    					}
    				}
    			}
    			for(int c = 0; c < mobs.getSize(); c++) {
    				if(AbilityCardsE[c].getInitiative() == a) {
    					enemyTitle = "Init(" + mobs.getEnemy(c).getInitiative() + "): " + "(" + mobs.getEnemy(c).getID() + ")" + mobs.getEnemy(c).getName();

    					System.out.println(enemyTitle + " makes it's move.");
    					
    					if(AbilityCardsE[c].getHeal() != 0) {
    						System.out.println(enemyTitle + " heals for " + AbilityCardsE[c].getHeal() + ".");
    						mobs.getEnemy(c).healDmg(AbilityCardsE[c].getHeal());
    					}
    					if(AbilityCardsE[c].getShield() != 0) {
    						System.out.println(enemyTitle + " gains " + AbilityCardsE[c].getShield() + " points of shield.");
    						mobs.getEnemy(c).addShield(AbilityCardsE[c].getShield());
    					}
    					
    					movement = AbilityCardsE[c].getMovement() + mobs.getEnemy(c).getMovement();
    					System.out.println(enemyTitle + " moves " + movement + " space(s).");	
    					//----NOTES FOR AARON----
    					//move functionality for enemies
    					//you can use mobs.getEnemy(c).move(x, y);
    					//random movement?
                                        boolean nextToPlayer = false;
                                        boolean moving = true;
                                        while(movement > 0 && nextToPlayer == false && moving == true){
                                            
                                            x1 = mobs.getEnemy(c).getX();
                                            y1 = mobs.getEnemy(c).getY();
                                            for(int z = 0; z < party.getSize(); z++){
                                                if(party.getPlayer(z).isAlive() && nextToPlayer == false){
                                                    x2 = party.getPlayer(z).getX();
                                                    y2 = party.getPlayer(z).getY();
                                                    nextToPlayer = board.isAdjacent(x1, y1, x2, y2);
                                                }
                                            }
                                            
                                            if(nextToPlayer == false){
                                                validMove = true;
                                                x2 = rng.nextInt(3);
                                                y2 = rng.nextInt(3);
                                                if(x2 == 0 && y2 == 0){
                                                    moving = false;
                                                }
                                                if(x2 == 1){
                                                    x2 = x1 + 1;
                                                }
                                                if (y2 == 1){
                                                    y2 = y1 + 1;
                                                }
                                                if(x2 == 2){
                                                    x2 = x1 - 1;
                                                }
                                                if(y2 == 2){
                                                    y2 = y1 - 1;
                                                }
                                                if(x2 > board.getXsize() || x2 < 0 || y2 > board.getYsize() || y2 < 0){
                                                    validMove = false;
                                                }
                                                if(moving == true && validMove == true){
                                                    validMove = board.Move(x1, y1, x2, y2);
                                                    if(validMove == true){
                                                        mobs.getEnemy(c).move(x2, y2);
                                                        movement--;
                                                    }
                                                }
                                            }
                                            
                                        }
                                        print.Print(board);

    					if(AbilityCardsE[c].getAttack() != 0) {
    						damage = mobs.getTotalDamage(AbilityCardsE[c].getAttack() + mobs.getEnemy(c).getAttack());
    						//----NOTES FOR AARON----
    						//check if enemy is in range
    						//attack first one detected???
    						//to attack use takeDmg(damage); on the target. Works on both enemies and players.
    						//I added a variable for enemies that shows what that enemy's index is on the list.
							//after damage is done check if alive and if dead remove from the board.
    						//needs proper text prompts to show what is happening
    						System.out.println(enemyTitle + " can attack for " + damage + " damage.");
                                                x1 = mobs.getEnemy(c).getX();
                                                y1 = mobs.getEnemy(c).getY();
                                                boolean playersInRange[] = new boolean[party.getSize()];
                                                boolean attackPhaseDone = false;
                                                for(int z = 0; z < party.getSize(); z++){
                                                    x2 = party.getPlayer(z).getX();
                                                    y2 = party.getPlayer(z).getY();
                                                    if(board.isAdjacent(x1, y1, x2, y2) && party.getPlayer(z).isAlive()){
                                                        playersInRange[z] = true;
                                                    }else{
                                                        playersInRange[z] = false;
                                                    }
                                                }
                                                int z = party.getSize();
                                                do{
                                                    
                                                    if(playersInRange[z]){
                                                        System.out.println(enemyTitle + " has attacked " + party.getPlayer(z).getName() + " for " + damage + " damage!");
                                                        party.getPlayer(z).takeDmg(damage);
                                                        if(party.getPlayer(z).isAlive() == false){
                                                            System.out.println(party.getPlayer(z).getName() + " has died.");
                                                            x1 = party.getPlayer(z).getX();
                                                            y1 = party.getPlayer(z).getY();
                                                            board.emptyTile(x1, y1);
                                                        }
                                                    }
                                                    z--;
                                                    
                                                }while(attackPhaseDone == false && z > 0);
    					}
    				}
    			}
    		}
			for(int i = 0; i < topAbilityCardsP.length; i++) {
				if(topAbilityCardsP[i].getInitiative() == 0) {
					System.out.println("Init(99): " + party.getPlayer(i).getName() + " takes a lont rest.");
				}
			}
			
    		party.clearInitiative();
    		mobs.clearInitiative();
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
