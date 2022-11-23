package Deck;

public class AbilityCard {
	
	private int cardID;
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
	public AbilityCard(int ID, String N, int IN, int ln, int tD, int r, int bM, int bH, int bS) {
		cardID = ID;
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
	//Copy Constructor
	public AbilityCard(AbilityCard x) {
		this.Name = x.Name;
		this.initNum = x.initNum;
		this.levelNum = x.levelNum;
		this.topDamage = x.topDamage;
		this.range = x.range;
		this.botMovement = x.botMovement;
		this.botHeal = x.botHeal;
		this.botShield = x.botShield;
		this.discarded = x.discarded;
		this.lost = x.lost;
	}
	
	public boolean equals(AbilityCard x) {
		return (this.Name == x.Name && this.initNum == x.initNum && this.levelNum == x.levelNum && 
			this.topDamage == x.topDamage && this.range == x.range && this.botMovement == x.botMovement && 
			this.botHeal == x.botHeal && this.botShield == x.botShield && this.discarded == x.discarded && 
			this.lost == x.lost);
	}
	
  //Displays all the information on the card.
	public void showAbilityCard() {
		System.out.print(Name + " - Initiative: " + initNum + " - Level: " + levelNum);
		System.out.print(" Top Actions:");
		if(topDamage != 0) {
			System.out.print(" -Attack: " + topDamage);
	    }
		else {
			System.out.print(" -None");
		}
		System.out.print(" Bottom Actions:");
		if(botMovement != 0 || botHeal != 0 || botShield != 0) {
			if(botMovement != 0) {
				System.out.print(" -Movement: " + botMovement);
			}
			if(botHeal != 0) {
				System.out.print(" -Heal: " + botHeal);
			}
			if(botShield != 0) {
				System.out.print(" -Shield: " + botShield);
			}
		}
		else {
			System.out.print(" -None");
		}
		System.out.println("");
	}

	public int getCardID() {
		return cardID;
	}
	public String getName() {
		return Name;
	}
	public int getInitiative() {
		return initNum;
	}
	public int getLevel() {
		return levelNum;
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
