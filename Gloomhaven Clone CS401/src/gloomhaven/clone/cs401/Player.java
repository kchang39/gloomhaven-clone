package gloomhaven.clone.cs401;

import java.util.Scanner;

public class Player {
	private String name;
	private String job;
	private Deck deck;
	
	private int x;
	private int y;
	
	private int level;
	private int exp;
	private int levelUpPoint;

	private int shield;
	private int maxHP;
	private int currentHP;
	private boolean alive;
	
	private int gold;
	
	Player(String newName, int newJob){
		name = newName;
		alive = true;
		level = 1;
		exp = 0;
		levelUpPoint = 45;
		gold = 0;
		shield = 0;
		x = 0;
		y = 0;
		int handSize = 0;
		
		//Hard coded jobs.
		if(newJob == 1) {//Scoundrel, hand = 9
			job = "Scoundrel";
			maxHP = 8;
			currentHP = maxHP;
			handSize = 9;
		}
		else if(newJob == 2) {//Brute, hand = 10
			job = "Brute";
			maxHP = 10;
			currentHP = maxHP;
			handSize = 10;
		}
		else if(newJob == 3) {//Spellweaver, hand = 8 + reviving ether
			job = "Spellweaver";
			maxHP = 6;
			currentHP = maxHP;
			handSize = 8;
		}
		else if(newJob == 4) {//Tinkerer, hand = 12
			job = "Tinkerer";
			maxHP = 8;
			currentHP = maxHP;
			handSize = 12;
		}
		deck = new Deck(handSize, job);
	}

	public int playerTurn() {
		Scanner scanner = new Scanner(System.in);
		int input;
		
		do {
			System.out.print("Enter 0 to Long Rest or 1 to Attack: ");
			input = scanner.nextInt();
			if(input != 0 && input != 1) {
				System.out.println("Error: Invalid Input.");
			}
		}while(input != 0 && input != 1);
		
		if(input == 0) {
			longRest();
		}
		else {
			deck.showHand();
			System.out.print("Choose two cards to play: ");
			
		}
		
		return 0;
	}
	
	void AddExp(int x){//MUST be in town to level-up.
		if(alive) {
			exp += x;
			while(exp >= levelUpPoint) {//Add new perks.
				levelUpPoint += 45 + (5 * level);
				level++;
			
				//Hard coded jobs.
				if(job == "Scoundrel") {
					maxHP = (int) Math.floor(6.5+(1.5*level));
					currentHP = maxHP;//Restore health on level-up?
				}
				else if(job == "Brute") {
					maxHP = 8+(2*level);
					currentHP = maxHP;
				}
				else if(job == "Spellweaver") {
					maxHP = 5+(1*level);
					currentHP = maxHP;
				}
				else if(job == "Tinkerer") {
					maxHP = (int) Math.floor(6.5+(1.5*level));
					currentHP = maxHP;
				}
			}
		}
	}
	
	void takeDmg(int x) {
		if(alive) {	
			if(x > shield) {
				currentHP -= (x - shield);
				if(currentHP <= 0) {
					alive = false;
				}
			}
		}
	}
	
	void healDmg(int x) {
		if(alive) {
			currentHP += x;
			if(currentHP > maxHP)
				currentHP = maxHP;
		}
	}
	
	void fullHeal() {
		if(alive) {
			currentHP = maxHP;
		}
	}
	
	void addShield(int x) {
		if(alive) {
		shield += x;
		}
	}
	
	void shortRest() {//lose 1 random discarded card, shuffle discard piles into main deck
		if(alive) {
			deck.loseRandom();
			deck.shuffleHand();
			deck.shuffleModifiers();
		}
	}
	
	void longRest() {//lose 1 chosen discarded card, shuffle discard piles into main deck
		if(alive) {
			deck.loseChoice();
			deck.shuffleHand();
			deck.shuffleModifiers();
			//deck.refreshItems();
			healDmg(2);
		}
	}
	
	void move(int newX, int newY) {
		if(alive) {
			x = newX;
			y = newY;
		}
	}
	
	public String toString() {
		return (this.name + "(Lvl:" + level + " - " + job + "): " + "HP(" + currentHP + "/" + maxHP + ")");
	}

	
	public String getName() {
		return name;
	}
	public String getJob() {
		return job;
	}
	public int getLevel() {
		return level;
	}
	public int getExp() {
		return exp;
	}
	public int getmaxHP() {
		return maxHP;
	}
	public int getcurrentHP() {
		return currentHP;
	}
	public boolean isAlive() {//At the beginning of every round check if alive.
		return alive;
	}
	public int getGold() {
		return gold;
	}
	public int getShield() {
		return shield;
	}
	public Deck getDeck() {
		return deck;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
