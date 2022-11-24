//In this class, we will be making a class that contains the title of the card
package gloomhaven.clone.cs401;
public class AttackModifierCard {
	//Attack modifier cards have a symbol that denote the attack boost
	//Print out a messsage telling the player/user how much attack boost they
	
	private int quantity;
	//private String Title;//The title of the attack modifier card.
	private int AttackBoost;//The attack boost symbol that is used to determine how much the attack is boosted.
	private boolean timesTwo;//The attack damage is doubled.
	//needs boolean for null mod.
	private int Type;//not yet implimented.
	
	private boolean discarded;
	private boolean lost;
	
	//Constructor for AttackModifierCard class used to initialize variables.
	public AttackModifierCard(int quant, int a, boolean timesTwo, int ty) {
		quantity = quant;
		//Title = t;
		AttackBoost = a;
		this.timesTwo = timesTwo;
		Type = ty;
		this.discarded = false;
		this.lost = false;
	}
	
	//copy constructor
	public AttackModifierCard(AttackModifierCard x) {
		this.AttackBoost = x.AttackBoost;
		this.timesTwo = x.timesTwo;
		this.Type = x.Type;
		this.discarded = x.discarded;
		this.lost = x.lost;
	}
	
	//Displays the information on the card.
	public String toString() {
		String temp = "";
		if(timesTwo) {
			temp = "Attack Modifier: x2 - Card type symbol:" + Type;
		}
		else {
			if(AttackBoost >= 0) {
				temp += "Attack Modifier: +" + AttackBoost + " - Card type symbol:" + Type;
			}
			else {
				temp += "Attack Modifier: " + AttackBoost + " - Card type symbol:" + Type;
			}
		}
		return temp;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int x) {
		this.quantity = x;
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
