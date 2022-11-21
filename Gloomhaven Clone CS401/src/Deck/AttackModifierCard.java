//In this class, we will be making a class that contains the title of the card
package Deck;
public class AttackModifierCard {
	//Attack modifier cards have a symbol that denote the attack boost
	//Print out a messsage telling the player/user how much attack boost they
	
	
	private String Title;//The title of the attack modifier card.
	private int AttackBoost;//The attack boost symbol that is used to determine how much the attack is boosted.
	private int Type;//The 
	
	//Constructor for AttackModifierCard class used to initialize variables.
	public AttackModifierCard(String t, int a, int ty) {
		Title = t;
		AttackBoost = a;
		Type = ty;
	}
	
	//Displays the information on the card.
	public void showAttackModifierCar() {
		System.out.println("Card Title:" + Title);
		System.out.println("Attack Boost number:" + AttackBoost);
		System.out.println("Card type symbol:" + Type);
	}
}
