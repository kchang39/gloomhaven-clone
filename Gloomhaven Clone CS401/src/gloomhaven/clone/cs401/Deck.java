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
	
	//private List<>//Item cards
	
	private List<AbilityCard> hand = new ArrayList<AbilityCard>();//holds your available cards for the scenario.
	private int handSize;
	
	public Deck(int handSize, String filename) {
		this.handSize = handSize;
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
		System.out.print("\nSelect " + handSize + " cards to fill your hand:");
		showAbilityDeck();
		do {
			for(int i = 0; i < abilityCards.size(); i++) {
				do {
					System.out.println("\n[x" + abilityCards.get(i).getQuantity() + " - " + abilityCards.get(i).toString() + "]");
					System.out.print("How many of the above cards do you want in your hand: ");
					temp = input.nextInt();
					if(temp > abilityCards.get(i).getQuantity() || totalHand + temp > handSize || temp < 0) {
						System.out.println("Error: Not enough of that card or your hand would be full. Please try again.\n");
					}
				}while(temp > abilityCards.get(i).getQuantity() || totalHand + temp > handSize || temp < 0);
				//adding the cards to hand list.
				for(int a = 0; a < temp; a++) {
					hand.add(new AbilityCard(abilityCards.get(i)));
					hand.get(hand.size() - 1).setQuantity(temp);
				}
				totalHand += temp;
				System.out.println(handSize - totalHand + " cards left.");
			}
			if(totalHand < handSize) {
				System.out.print("\nNot enough cards were chosen. Pick again.\n");
				hand.clear();
				totalHand = 0;
			}
		}while(totalHand < handSize);
		showHand();
	}
	
	public int DrawAttackMod(int dmg) {
		int index = (int)(Math.random() * (atkModCards.size()));
		 
		if(atkModCards.get(index).isDiscarded() || atkModCards.get(index).isLost()) {
			index = (int)(Math.random() * (atkModCards.size()));
		}
		 
		//Check for x2 modifier.
		if(atkModCards.get(index).isTimesTwo()) {
			return dmg;
		}
		
		return atkModCards.get(index).getAtkMod();//should range from +2 through -2.
	}
	 
	public void DrawBattleGoal() {//WIP
		 
		battleGoalCards.get(0);
	}
	 
	public AbilityCard getHand(int x) {//should this be here or in player class?
		//needs check for if card is discarded or lost
		hand.get(x).setDiscarded(true);
		return hand.get(x);
		
	}
	
	public void shuffleHand() {//turn all discarded boolean variables to false.
		for(int i = 0; i < hand.size(); i++) {
			
		}
		for(int i = 0; i < hand.size(); i++) {
			hand.get(i).setDiscarded(false);//need to add lost functionality.
		}
	}

	public void shuffleModifiers() {//turn all discarded boolean variables to false.
		for(int i = 0; i < atkModCards.size(); i++) {
			atkModCards.get(i).setDiscarded(false);//need to add lost functionality.
		}
	}
	
	public void lostModChoice() {//when long rest, choose a discarded card to lose.

	}
	
	public void showModDeck() {

	}
	
	public void showModDiscards() {
	
	}
	
	public void showAbilityDeck() {
		System.out.println("\nAbility Card Deck:");
		for(int i = 0; i < abilityCards.size(); i++) {
			System.out.println("x" + abilityCards.get(i).getQuantity() + " - " + abilityCards.get(i).toString());
		}
	}
	
	public void showHand() {
		System.out.println("\nHand:");
		for(int i = 0; i < hand.size(); i++) {
			if(!hand.get(i).isDiscarded() && !hand.get(i).isLost()) {
				System.out.print("(" + i + ")");
				System.out.println(hand.get(i).toString());
			}
		}
	}
	
	public void showDiscards() {
		System.out.println("\nDiscard Pile:");
		for(int i = 0; i < hand.size(); i++) {
			if(hand.get(i).isDiscarded() && !hand.get(i).isLost()) {
				System.out.print("(" + i + ")");
				System.out.println(hand.get(i).toString());
			}
		}
	}

	public int getHandSize() {
		return handSize;
	}
}
