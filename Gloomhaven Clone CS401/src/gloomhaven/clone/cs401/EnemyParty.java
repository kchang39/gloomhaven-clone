package gloomhaven.clone.cs401;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnemyParty {
	private List<EnemyAbilityCard> abilityCards = new ArrayList<EnemyAbilityCard>();
	private List<Enemy> enemyList = new ArrayList<Enemy>();
	
	private int size;
	
	EnemyParty(int size, String filename){
		this.size = size;
		
		try {
			addEnemies(filename);
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
	
	
	
	public Enemy getEnemy(int i) {
		return enemyList.get(i);
	}
}
