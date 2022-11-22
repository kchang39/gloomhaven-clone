//In this class, we will be storing cards into a deck
package Deck;
import java.util.List;
import java.util.ArrayList;
public class Deck {
	 
	
	private List<AttackModifierCard> atkModCards = new ArrayList<AttackModifierCard>();
	private List<AbilityCard> abilityCards = new ArrayList<AbilityCard>();
	private List<BattleGoalCard> battleGoalCards = new ArrayList<BattleGoalCard>();
	
	private List<AbilityCard> hand = new ArrayList<AbilityCard>();//holds your available cards for the scenario.
	private int handSize;
	
	public Deck(int handSize) {
		this.handSize = handSize;
		//fill card lists from files. Unique files for each card type.
		
		//Test cards.
		atkModCards.add(new AttackModifierCard(1, false, 1, false, false));
		atkModCards.add(new AttackModifierCard(0, true, 1, false, false));
		atkModCards.add(new AttackModifierCard(-1, false, 1, false, false));
		atkModCards.add(new AttackModifierCard(1, false, 1, true, false));
		atkModCards.add(new AttackModifierCard(1, false, 1, false, true));
	}
	
	public void pickHand() {
		//prints all types of cards and prompts the user to pick however many is determined by their class.
	}
	
	public int DrawAttackMod(int dmg) {
		int index = (int)(Math.random() * (atkModCards.size()));
		 
		if(atkModCards.get(index).isDiscarded() || atkModCards.get(index).isLost()) {
			index = (int)(Math.random() * (atkModCards.size()));
		}
		 
		//Needs check for x2 modifier.
		if(atkModCards.get(index).isTimesTwo()) {
			return dmg;
		}
		
		return atkModCards.get(index).getAtkMod();//should range from +2 through -2.
	}
	 
	public void DrawBattleGoal() {
		 
		battleGoalCards.get(0);
	}
	 
	public void shuffleAbilities() {

	}

	public void shuffleModifiers() {//turn all discarded booleans to false.
		for(int i = 0; i < atkModCards.size(); i++) {
			 atkModCards.get(i).setDiscarded(false);//need to add lost functionality.
		}
	}
	
	public void lostModChoice() {//when long rest, choose a discarded card to lose.

	}
	
	public void showModDeck() {
		System.out.println("Attack Modifier Deck:");
		for(int i = 0; i < atkModCards.size(); i++) {
			if(!atkModCards.get(i).isDiscarded() && !atkModCards.get(i).isLost()) {
				atkModCards.get(i).showAttackModifierCard();
			}
		}
	}
	
	public void showModDiscards() {
		System.out.println("Attack Modifier Discard Pile:");
		for(int i = 0; i < atkModCards.size(); i++) {
			if(atkModCards.get(i).isDiscarded() && !atkModCards.get(i).isLost()) {
				atkModCards.get(i).showAttackModifierCard();
			}
		}
	}

	public int getHandSize() {
		return handSize;
	}
}
