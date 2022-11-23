//In this class, we will be storing cards into a deck
package Deck;

import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Deck {
	private List<AttackModifierCard> atkModCards = new ArrayList<AttackModifierCard>();
	private List<AbilityCard> abilityCards = new ArrayList<AbilityCard>();
	private List<BattleGoalCard> battleGoalCards = new ArrayList<BattleGoalCard>();
	
	private List<AbilityCard> hand = new ArrayList<AbilityCard>();//holds your available cards for the scenario.
	private int handSize;
	
	public Deck(int handSize, String filename) {
		this.handSize = handSize;
		//fill card lists from files. Unique files for each card type.
		try {
			getAbilityCards(filename);
			getAtkModCards();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getAbilityCards(String filename) throws FileNotFoundException{
		String name;
		int cardID, init, level, dmg, range, move, heal, shield;
		
		Scanner scanner = new Scanner(new File(filename + "AbilityCards.csv"));
		scanner.useDelimiter(","); 
		
		while(scanner.hasNext()) {
			cardID = scanner.nextInt();
			name = scanner.next();
			init = scanner.nextInt();
			level = scanner.nextInt();
			dmg = scanner.nextInt();
			range = scanner.nextInt();
			move = scanner.nextInt();
			heal = scanner.nextInt();
			shield = scanner.nextInt();
			abilityCards.add(new AbilityCard(cardID, name, init, level, dmg, range, move, heal, shield));
		}
	}
	
	public void getAtkModCards() throws FileNotFoundException {
		int cardID, mod, type;
		boolean timesTwo;
		
		Scanner scanner = new Scanner(new File("AttackModCards.csv"));
		scanner.useDelimiter(",");
		
		while(scanner.hasNext()) {
			cardID = scanner.nextInt();
			mod = scanner.nextInt();
			timesTwo = scanner.nextBoolean();
			type = scanner.nextInt();
			atkModCards.add(new AttackModifierCard(cardID, mod, timesTwo, type));
		}
	}
	
	public void pickHand() {
		//prints all types of cards and prompts the user to pick however many is determined by their class.
		
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
	 
	public void shuffleAbilities() {//turn all discarded boolean variables to false.
		for(int i = 0; i < abilityCards.size(); i++) {
			abilityCards.get(i).setDiscarded(false);//need to add lost functionality.
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
		List<Integer> counter = new ArrayList<Integer>();
		int temp = 0, index = 0;
		
		for(int i = 0; i < atkModCards.size(); i++) {
			if(temp < atkModCards.get(i).getCardID()) {
				temp = atkModCards.get(i).getCardID();
			}
			else {
				counter.add(temp);
				temp = 0;
			}
		}
		counter.add(atkModCards.get(atkModCards.size() - 1).getCardID());
		System.out.println("\nAttack Modifier Deck:");
		for(int i = 0; i < atkModCards.size(); i++) {
			if(atkModCards.get(i).getCardID() == 1 && !atkModCards.get(i).isDiscarded() && !atkModCards.get(i).isLost()) {
				System.out.print("x" + counter.get(index) + " - ");
				atkModCards.get(i).showAttackModifierCard();
				index++;
			}
		}
	}
	
	public void showModDiscards() {
		List<Integer> counter = new ArrayList<Integer>();
		int temp = 0, index = 0;
		
		for(int i = 0; i < atkModCards.size(); i++) {
			if(temp < atkModCards.get(i).getCardID()) {
				temp = atkModCards.get(i).getCardID();
			}
			else {
				counter.add(temp);
				temp = 0;
			}
		}
		counter.add(atkModCards.get(atkModCards.size() - 1).getCardID());
		System.out.println("\nAttack Modifier Discard Pile:");
		for(int i = 0; i < atkModCards.size(); i++) {
			if(atkModCards.get(i).getCardID() == 1 && !atkModCards.get(i).isDiscarded() && !atkModCards.get(i).isLost()) {
				System.out.print("x" + counter.get(index) + " - ");
				atkModCards.get(i).showAttackModifierCard();
				index++;
			}
		}
	}
	
	public void showAbilityDeck() {
		List<Integer> counter = new ArrayList<Integer>();
		int temp = 0, index = 0;
		
		for(int i = 0; i < abilityCards.size(); i++) {
			if(temp < abilityCards.get(i).getCardID()) {
				temp = abilityCards.get(i).getCardID();
			}
			else {
				counter.add(temp);
				temp = 0;
			}
		}
		counter.add(abilityCards.get(abilityCards.size() - 1).getCardID());
		System.out.println("\nAbility Card Deck:");
		for(int i = 0; i < abilityCards.size(); i++) {
			if(abilityCards.get(i).getCardID() == 1 && !abilityCards.get(i).isDiscarded() && !abilityCards.get(i).isLost()) {
				System.out.print("x" + counter.get(index) + " - ");
				abilityCards.get(i).showAbilityCard();
				index++;
			}
		}
	}
	
	public void showAbilityDiscards() {
		List<Integer> counter = new ArrayList<Integer>();
		int temp = 0, index = 0;
		
		for(int i = 0; i < abilityCards.size(); i++) {
			if(temp < abilityCards.get(i).getCardID()) {
				temp = abilityCards.get(i).getCardID();
			}
			else {
				counter.add(temp);
				temp = 0;
			}
		}
		counter.add(abilityCards.get(abilityCards.size() - 1).getCardID());
		System.out.println("\nAbility Card Deck:");
		for(int i = 0; i < abilityCards.size(); i++) {
			if(abilityCards.get(i).getCardID() == 1 && abilityCards.get(i).isDiscarded() && !abilityCards.get(i).isLost()) {
				System.out.print("x" + counter.get(index) + " - ");
				abilityCards.get(i).showAbilityCard();
				index++;
			}
		}
	}

	public int getHandSize() {
		return handSize;
	}
}
