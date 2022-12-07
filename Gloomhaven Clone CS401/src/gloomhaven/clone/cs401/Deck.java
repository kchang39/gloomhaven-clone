//In this class, we will be storing cards into a deck
package gloomhaven.clone.cs401;

import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Deck {
	private List<AttackModifierCard> atkModCards = new ArrayList<AttackModifierCard>();
	private List<AbilityCard> abilityCards = new ArrayList<AbilityCard>();
	private List<BattleGoalCard> battleGoalCards = new ArrayList<BattleGoalCard>();
	
	//Item cards
	private List<Item> ItemCards = new ArrayList<Item>();
	
	private List<AbilityCard> hand = new ArrayList<AbilityCard>();//holds your available cards for the scenario.
	private int maxHandSize;
	
	public Deck(int handSize, String filename) {
		this.maxHandSize = handSize;
		//fill card lists from files. Unique files for each card type.
		try {
			getAbilityCards(filename);
			getAtkModCards();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getAbilityCards(String filename) throws FileNotFoundException{
		String name;
		int quantity, init, level, dmg, move, heal, shield;
		
		Scanner scanner = new Scanner(new File(filename + "AbilityCards.csv"));
		scanner.useDelimiter(","); 
		
		while(scanner.hasNext()) {
			quantity = scanner.nextInt();
			name = scanner.next();
			init = scanner.nextInt();
			level = scanner.nextInt();
			dmg = scanner.nextInt();
			move = scanner.nextInt();
			heal = scanner.nextInt();
			shield = scanner.nextInt();
			abilityCards.add(new AbilityCard(quantity, name, init, level, dmg, move, heal, shield));
		}
	}
	
	public void getAtkModCards() throws FileNotFoundException {
		int quantity, mod, type;
		boolean timesTwo;
		
		Scanner scanner = new Scanner(new File("AttackModCards.csv"));
		scanner.useDelimiter(",");
		
		while(scanner.hasNext()) {
			quantity = scanner.nextInt();
			mod = scanner.nextInt();
			timesTwo = scanner.nextBoolean();
			type = scanner.nextInt();
			atkModCards.add(new AttackModifierCard(quantity, mod, timesTwo, type));
		}
	}
	
	public void pickHand() {
		Scanner input = new Scanner(System.in);
		int totalHand = 0, temp;
		System.out.print("\nSelect " + maxHandSize + " cards to fill your hand:");
		showAbilityDeck();
		do {
			for(int i = 0; i < abilityCards.size(); i++) {
				do {
					System.out.println("\n[x" + abilityCards.get(i).getQuantity() + " - " + abilityCards.get(i).toString() + "]");
					System.out.print("How many of the above cards do you want in your hand: ");
					temp = input.nextInt();
					if(temp > abilityCards.get(i).getQuantity() || totalHand + temp > maxHandSize || temp < 0) {
						System.out.println("Error: Not enough of that card or your hand would be full. Please try again.\n");
					}
				}while(temp > abilityCards.get(i).getQuantity() || totalHand + temp > maxHandSize || temp < 0);
				//adding the cards to hand list.
				for(int a = 0; a < temp; a++) {
					hand.add(new AbilityCard(abilityCards.get(i)));
					hand.get(hand.size() - 1).setQuantity(temp);
				}
				totalHand += temp;
				System.out.println(maxHandSize - totalHand + " cards left.");
			}
			if(totalHand < maxHandSize) {
				System.out.print("\nNot enough cards were chosen. Pick again.\n");
				hand.clear();
				totalHand = 0;
			}
		}while(totalHand < maxHandSize);
		showHand();
	}
	
	public int drawAttackMod(int dmg) {
		int index, count = 0;
		for(int i = 0; i < atkModCards.size(); i++) {
			if(!atkModCards.get(i).isDiscarded() && !atkModCards.get(i).isLost()) {
				count++;
			}
		}
		if(count == 0) {
			shuffleModifiers();
		}
		
		do {
			index = (int)(Math.random() * (atkModCards.size()));
		}while(atkModCards.get(index).isDiscarded() || atkModCards.get(index).isLost());
			
		atkModCards.get(index).setDiscarded(true); 
		
		//Check for x2 modifier.
		if(atkModCards.get(index).isTimesTwo()) {
			return dmg;
		}
		
		return atkModCards.get(index).getAtkMod();//should range from +2 through -2.
	}
	 
	public void drawBattleGoal() {//WIP
		 
		battleGoalCards.get(0);
	}
	 
	public AbilityCard getHandCard(int x) {//should this be here or in player class?
		//needs check for if card is discarded or lost
		Scanner input = new Scanner(System.in);
		while(hand.get(x).isDiscarded() || hand.get(x).isLost()) {
			System.out.print("Error: That card is either discarded or lost. Choose another card: ");
			x = input.nextInt();
		}
		hand.get(x).setDiscarded(true);
		return hand.get(x);
		
	}
	
	public void shuffleHand() {//turn all discarded boolean variables to false.
		for(int i = 0; i < hand.size(); i++) {
			hand.get(i).setDiscarded(false);
		}
	}

	public void shuffleModifiers() {//turn all discarded boolean variables to false.
		for(int i = 0; i < atkModCards.size(); i++) {
			atkModCards.get(i).setDiscarded(false);
		}
	}
	
	public void loseRandom() {
		int index;
		do {
			index = (int)(Math.random() * (hand.size()));
		}while(!hand.get(index).isDiscarded() || hand.get(index).isLost());//while hand(index) is not discarded and is not lost
		hand.get(index).setDiscarded(false);
		hand.get(index).setLost(true);
	}
	
	public void loseChoice() {//when long rest, choose a discarded card to lose.
		Scanner scanner = new Scanner(System.in);
		int index;
		do {
			System.out.print("\nChoose 1 discarded card to lose:");
			index = scanner.nextInt();
			if(!hand.get(index).isDiscarded() || hand.get(index).isLost()) {
				System.out.println("Error: Chosen card is not in discard pile or is already lost.Please choose another.");
			}
		}while(!hand.get(index).isDiscarded() || hand.get(index).isLost());//while hand(index) is not discarded and is not lost
		
		hand.get(index).setDiscarded(false);
		hand.get(index).setLost(true);
	}
	
	public void showModDeck() {
		int counter = 0;
		System.out.println("\nAttack Modifier Deck:");
		for(int i = 0; i < atkModCards.size(); i++) {
			if(!atkModCards.get(i).isDiscarded() && !atkModCards.get(i).isLost()) {
				System.out.println("(" + i + ")" + atkModCards.get(i).toString());
				counter++;
			}
		}
		if(counter == 0) {
			System.out.println("Empty.");
		}
	}
	
	public void showModDiscards() {
		int counter = 0;
		System.out.println("\nAttack Modifier Discard Pile:");
		for(int i = 0; i < atkModCards.size(); i++) {
			if(atkModCards.get(i).isDiscarded() && !atkModCards.get(i).isLost()) {
				System.out.println("(" + i + ")" + atkModCards.get(i).toString());
				counter++;
			}
		}
		if(counter == 0) {
			System.out.println("Empty.");
		}
	}
	
	public void showAbilityDeck() {
		System.out.println("\nAbility Card Deck:");
		for(int i = 0; i < abilityCards.size(); i++) {
			System.out.println("x" + abilityCards.get(i).getQuantity() + " - " + abilityCards.get(i).toString());
		}
	}
	
	public void showHand() {
		int counter = 0;
		System.out.println("\nHand:");
		for(int i = 0; i < hand.size(); i++) {
			if(!hand.get(i).isDiscarded() && !hand.get(i).isLost()) {
				System.out.println("(" + i + ")" + hand.get(i).toString());
				counter++;
			}
		}
		if(counter == 0) {
			System.out.println("Empty.");
		}
	}
	
	public void showHandDiscards() {
		int counter = 0;
		System.out.println("\nDiscard Pile:");
		for(int i = 0; i < hand.size(); i++) {
			if(hand.get(i).isDiscarded() && !hand.get(i).isLost()) {
				System.out.println("(" + i + ")" + hand.get(i).toString());
				counter++;
			}
		}
		if(counter == 0) {
			System.out.println("Empty.");
		}
	}

	public void showHandLost() {
		int counter = 0;
		System.out.println("\nLost Pile:");
		for(int i = 0; i < hand.size(); i++) {
			if(!hand.get(i).isDiscarded() && hand.get(i).isLost()) {
				System.out.println("(" + i + ")" + hand.get(i).toString());
				counter++;
			}
		}
		if(counter == 0) {
			System.out.println("Empty.");
		}
	}
	
	public void resetDeck() {//for end of senario.
		hand.clear();
		shuffleModifiers();
		
	}
	
	public int getMaxHandSize() {
		return maxHandSize;
	}

	public int getHandSize() {
		int counter = 0;
		for(int i = 0; i < hand.size(); i++) {
			if(!hand.get(i).isDiscarded() && !hand.get(i).isLost()) {
				counter++;
			}
		}
		return counter;
	}
}
