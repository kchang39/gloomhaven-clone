package Deck;

public class AbilityCard {
	
	private String Name;//Name of the attack
	private int initNum;//Initializer number.
	private int levelNum;//The level of the attack card.
	
	private int topDamage;//The top damage of the card.
	private int range;
	
	private int botMovement;//The bottom movement of the card.
	private int botHeal;//Bottom heal ability.
	private int botShield;
	
	private boolean discarded;
	private boolean lost;
	
  //Constructor used to initialize the variables.
	public AbilityCard(String N, int IN, int ln, int tD, int r, int bM, int bH, int bS) {
		Name = N;
		initNum = IN;
		levelNum = ln;
		topDamage = tD;
		range = r;
		botMovement = bM;
		botHeal = bH;
		botShield = bS;
		discarded = false;
		lost = false;
		
	}
  //Displays all the information on the card.
	public void showAbilityCard() {
		System.out.println(Name + " - Initiative: " + initNum + " - Level: " + levelNum);
		System.out.println("Top Actions: ");
		if(topDamage != 0) {
			System.out.println("Attack - " + topDamage);
	    }
		System.out.println("Bottom Actions: ");
		if(botMovement != 0) {
			System.out.println("Movement - " + botMovement);
	    }
		if(botHeal != 0) {
			System.out.println("Heal - " + botHeal);
	    }
	}

	public boolean isDiscarded() {
		return discarded;
	}
	public void setDiscarded(boolean x) {
		discarded = x;
	}
	public boolean isLost() {
		return lost;
	}
	public void setLost(boolean x) {
		lost = x;
	}
	public int getTopDamage() {
		return topDamage;
	}
	public int getBotMovement() {
		return botMovement;
	}
	public int getBotHeal() {
		return botHeal;
	}
	public int getBotShield() {
		return botShield;
	}
	public int getRange() {
		return range;
	}
}
