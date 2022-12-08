package gloomhaven.clone.cs401;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnemyParty {
	private List<EnemyAbilityCard> abilityCards = new ArrayList<EnemyAbilityCard>();
	private List<AttackModifierCard> atkModCards = new ArrayList<AttackModifierCard>();
	private List<Enemy> enemyList = new ArrayList<Enemy>();
	
	private int size;
	
	EnemyParty(int size, String filename){
		this.size = size;
		
		try {
			addEnemies(filename);
			getAtkModCards();
			getAbilityCards();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void addEnemies(String filename) throws FileNotFoundException {
		String name = null;
		int level = 0, rarity = 0, health = 0, movement = 0, atk = 0, range = 0;
		
		Scanner scanner = new Scanner(new File(filename + "Stats.csv"));
		scanner.useDelimiter(",");
		
		while(scanner.hasNext()) {
			name = scanner.next();
			level = scanner.nextInt();
			rarity = scanner.nextInt();
			health = scanner.nextInt();
			movement = scanner.nextInt();
			atk = scanner.nextInt();
			range = scanner.nextInt();
		}
		for(int i = 0; i < size; i++) {
			enemyList.add(new Enemy(name, level, rarity, health, movement, atk, range));
		}
		
	}
	
	public void getAtkModCards() throws FileNotFoundException {
		int quantity, mod, type;
		boolean timesTwo;
		
		Scanner scanner = new Scanner(new File("AttackModCards.csv"));
		scanner.useDelimiter(",");
		
		while(scanner.hasNext()) {
			quantity = scanner.nextInt();
			mod = scanner.nextInt();
			timesTwo = scanner.nextBoolean();
			type = scanner.nextInt();
			atkModCards.add(new AttackModifierCard(quantity, mod, timesTwo, type));
		}
	}
	
	public void getAbilityCards() throws FileNotFoundException{
		int atk, range, movement, shield, heal, initiative;
		boolean reshuffle;
		
		Scanner scanner = new Scanner(new File("EnemyAbilityCards.csv"));
		scanner.useDelimiter(","); 
		
		while(scanner.hasNext()) {
			atk = scanner.nextInt();
			range = scanner.nextInt();
			movement = scanner.nextInt();
			shield = scanner.nextInt();
			heal = scanner.nextInt();
			initiative = scanner.nextInt();
			reshuffle = scanner.nextBoolean();
			abilityCards.add(new EnemyAbilityCard(atk, range, movement, shield, heal, initiative, reshuffle));
		}
	}

	public int drawAttackMod(int dmg) {//returns number to add to attack damage based on modifier drawn.
		int index, count = 0;
		for(int i = 0; i < atkModCards.size(); i++) {
			if(!atkModCards.get(i).isDiscarded() && !atkModCards.get(i).isLost()) {
				count++;
			}
		}
		if(count == 0) {
			shuffleModifiers();
		}
		
		do {
			index = (int)(Math.random() * (atkModCards.size()));
		}while(atkModCards.get(index).isDiscarded() || atkModCards.get(index).isLost());
			
		atkModCards.get(index).setDiscarded(true); 
		
		//Check for x2 modifier.
		if(atkModCards.get(index).isTimesTwo()) {
			return dmg;
		}
		
		return atkModCards.get(index).getAtkMod();//should range from +2 through -2.
	}
	
	public EnemyAbilityCard drawAbilityCard() {//returns an ability card to use for that turn.
		int index, count = 0;
		for(int i = 0; i < abilityCards.size(); i++) {
			if(!abilityCards.get(i).isDiscarded()) {
				count++;
			}
		}
		if(count == 0) {
			shuffleAbilities();
		}
		
		do {
			index = (int)(Math.random() * (abilityCards.size()));
		}while(abilityCards.get(index).isDiscarded());
			
		abilityCards.get(index).setDiscarded(true); 
		
		return abilityCards.get(index);
	}
	
	public void shuffleModifiers() {//turn all discarded boolean variables to false.
		for(int i = 0; i < atkModCards.size(); i++) {
			atkModCards.get(i).setDiscarded(false);
		}
	}
	
	public void shuffleAbilities() {//turn all discarded boolean variables to false.
		for(int i = 0; i < abilityCards.size(); i++) {
			abilityCards.get(i).setDiscarded(false);
		}
	}

	public Enemy getEnemy(int i) {
		return enemyList.get(i);
	}
	
	public boolean isAlive() {
		for(int i = 0; i < enemyList.size(); i++) {
			if(enemyList.get(i).isAlive()) {
				return true;
			}
		}
		return false;
	}
}
