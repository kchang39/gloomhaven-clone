package gloomhaven.clone.cs401;

public class AbilityCard {
	
	private int quantity;
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
	public AbilityCard(int quant, String N, int IN, int ln, int tD, int bM, int bH, int bS) {
		quantity = quant;
		Name = N;
		initNum = IN;
		levelNum = ln;
		topDamage = tD;
		range = 1;//For now default range is 1
		botMovement = bM;
		botHeal = bH;
		botShield = bS;
		discarded = false;
		lost = false;
	}
	//Copy Constructor
	public AbilityCard(AbilityCard x) {
		this.quantity = x.quantity;
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
	
	//Equals comparison
	public boolean equals(AbilityCard x) {
		boolean result;
		result = (Name == x.Name && 
				initNum == x.initNum && 
				levelNum == x.levelNum && 
				topDamage == x.topDamage && 
				range == x.range && 
				botMovement == x.botMovement && 
				botHeal == x.botHeal && 
				botShield == x.botShield && 
				discarded == x.discarded && 
				lost == x.lost);
		return result;
	}
	
  //Displays all the information on the card.
	public String toString() {
		String temp;
		temp = (Name + " - Initiative: " + initNum + " - Level: " + levelNum + "| Top Actions:");
		if(topDamage != 0) {
			temp += " -Attack: " + topDamage;
	    }
		else {
			temp += " -None";
		}
		temp += "| Bottom Actions:";
		if(botMovement != 0 || botHeal != 0 || botShield != 0) {
			if(botMovement != 0) {
				temp += " -Movement: " + botMovement;
			}
			if(botHeal != 0) {
				temp += " -Heal: " + botHeal;
			}
			if(botShield != 0) {
				temp += " -Shield: " + botShield;
			}
		}
		else {
			temp += " -None";
		}
		return temp;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int x) {
		this.quantity = x;
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
