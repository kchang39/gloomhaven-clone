//In this class, we will be making a class that contains the title of the card
package Deck;
public class AttackModifierCard {
	//Attack modifier cards have a symbol that denote the attack boost
	//Print out a messsage telling the player/user how much attack boost they
	
	
	//private String Title;//The title of the attack modifier card.
	private int AttackBoost;//The attack boost symbol that is used to determine how much the attack is boosted.
	private boolean timesTwo;//The attack damage is doubled.
	//needs boolean for null mod.
	private int Type;//The 
	
	private boolean discarded;
	private boolean lost;
	
	//Constructor for AttackModifierCard class used to initialize variables.
	public AttackModifierCard(int a, boolean timesTwo, int ty, boolean discarded, boolean lost) {
		//Title = t;
		AttackBoost = a;
		this.timesTwo = timesTwo;
		Type = ty;
		this.discarded = discarded;
		this.lost = lost;
	}
	
	//Displays the information on the card.
	public void showAttackModifierCard() {
		if(timesTwo) {
			System.out.println("Attack Modifier: x2 - Card type symbol:" + Type);
		}
		else {
			if(AttackBoost >= 0) {
				System.out.println("Attack Modifier: +" + AttackBoost + " - Card type symbol:" + Type);
			}
			else {
				System.out.println("Attack Modifier: " + AttackBoost + " - Card type symbol:" + Type);
			}
		}
	}
	
	public int getAtkMod() {
		return AttackBoost;
	}

	public boolean isTimesTwo() {
		return timesTwo;
	}

	public boolean isDiscarded() {
		return discarded;
	}
	
	public void setDiscarded(boolean x) {
		this.discarded = x;
	}

	public boolean isLost() {
		return lost;
	}
	
	public void setLost(boolean x) {
		this.lost = x;
	}
}
