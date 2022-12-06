package gloomhaven.clone.cs401;

import java.util.List;
import java.util.ArrayList;

public class Enemy {
	private String name;
	private int level;
	private int rarity;//1 = normal, 2 = elite, 3 = boss.
	
	private int maxHP;
	private int currentHP;
	private boolean alive;
	private int shield;
	
	private int movement;
	private int attack;
	private int range;
	
	private List<EnemyAbilityCard> hand = new ArrayList<EnemyAbilityCard>();//might get moved to scenario class.
	
	Enemy(String name, int level, int rarity, int maxHP, int movement, int attack, int range){
		this.name = name;
		this.level = level;
		this.rarity = rarity;
		this.maxHP = maxHP;
		currentHP = this.maxHP;
		this.movement = movement;
		this.attack = attack;
		this.range = range;
	}
	
	void takeDmg(int x) {
		if(x > shield) {
			currentHP -= (x - shield);
			if(currentHP <= 0) {
				alive = false;
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
		shield += x;
	}

	public String toString() {
		return (this.name + "(Lvl:" + level + " - " + getRarity() + "): " + "HP(" + currentHP + "/" + maxHP + ")");
	}

	public String getName() {
		return name;
	}
	public int getLevel() {
		return level;
	}
	public String getRarity() {
		if(rarity == 1)
			return "Normal";
		else if(rarity == 2)
			return "Elite";
		else if(rarity == 3)
			return "Boss";
		return "";//placeholder return.
	}
	public int getMaxHP() {
		return maxHP;
	}
	public int getCurrentHP() {
		return currentHP;
	}
	public int getShield() {
		return shield;
	}
	public int getMovement() {
		return movement;
	}
	public int getAttack() {
		return attack;
	}
	public int getRange() {
		return range;
	}
	public boolean isAlive() {
		return alive;
	}
}
