//In this class, we will be storing cards into a deck
package Deck;
import java.util.List;
import java.util.ArrayList;
public class Deck {
	/*Pseduocode
	 1. Declare a list of AttackModifiersCard 
	 2. Declare a list of AbilityCards
	 3. Declare a list of BattleGoalCards
	 4. Declare a 
	 */
	public Deck(int n) {
		numOfAMCards = n;
		deckIndex = 0;
	}
	//Stores a list of AttackModifiersCards objects
	List<AttackModifierCard> AttackModifierCardDeck = new ArrayList<AttackModifierCard>();
	List<AbilityCard> AbilityCardDeck = new ArrayList<AbilityCard>();
	List<BattleGoalCard> BattleGoalCardDeck = new ArrayList<BattleGoalCard>();
	
	 //After card objects have been declared, the deck needs
	 //A card needs to be drawn. 
	 //Constructor class for Deck.
	 private int numOfAMCards;
	 private int deckIndex;//Used to draw from the top of the deck.
	 
	 //Draw class
	 public void DrawAttackMod() {
		 AttackModifierCardDeck.get(0);
		 
	 }
	 public void DrawAbility() {
		 AbilityCardDeck.get(0);
	 }
	 public void DrawBattleGoal() {
		 BattleGoalCardDeck.get(0);
	 }
	 
	 //Shuffle function.
	 //Pseudocode
	 	//Function type public class void.
	 	//Create an array/list that will contain all cards. 
	 	//move the cards around by reinitializing objects in the list.
	 public void ShuffleDecks() {
		 System.out.println("Shuffling the decks.");
		 //Shuffling the Attack Modifier Card deck.
		 for(int i = 0; i < AttackModifierCardDeck.size(); i++) {
			 
		 }
		 //Shuffling the Ability card deck.
         for(int i = 0; i < AbilityCardDeck.size(); i++) {
			 
		 }
         System.out.println("Shuffling is done.");
	 }
	 
	 public void Hand() {
		 List<AttackModifierCard>Hand = new ArrayList<AttackModifierCard>();
		 List<AbilityCard>hand = new ArrayList<AbilityCard>();
	 }
	 
	//List of Discarded cards.
	List<AttackModifierCard> DiscardedAMCards = new ArrayList<AttackModifierCard>();
	List<AbilityCard> DiscardedAbilityCards = new ArrayList<AbilityCard>();
	List<BattleGoalCard> DiscardBGCards = new ArrayList<BattleGoalCard>();
    //Discarding function. 
	public void Discard() {
		DiscardedAMCards.add(new AttackModifer(String, int, int));
		DiscardedAbilityCards.add();
	    DiscardBGCards.add();
	 }
	 
	//Lost pile
	public void lostPile() {
		List<AttackModifierCard> lostAMCard = new ArrayList<AttackModifierCard>();
		List<AbilityCard> lostAbilityCardDeck = new ArrayList<AbilityCard>();
		List<BattleGoalCard> lostBGCardDeck = new ArrayList<BattleGoalCard>();
		lostAMCard.add();
		lostAbilityCardDeck.add();
		lostBGCardDeck.add();
	}

}
