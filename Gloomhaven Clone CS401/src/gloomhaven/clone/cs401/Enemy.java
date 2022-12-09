package gloomhaven.clone.cs401;

import java.util.List;
import java.util.ArrayList;

public class Enemy {
	int id;
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
	private int initiative;
	
	private int x;
	private int y;
	
	Enemy(int id, String name, int level, int rarity, int maxHP, int movement, int attack, int range){
		alive = true;
		this.id = id;
		this.name = name;
		this.level = level;
		this.rarity = rarity;
		this.maxHP = maxHP;
		currentHP = this.maxHP;
		this.movement = movement;
		this.attack = attack;
		this.range = range;
		x = 0;
		y = 0;
		initiative = 0;
	}
	
	int takeDmg(int x) {
		if(alive) {	
			if(x > shield) {
				currentHP -= (x - shield);
				if(currentHP <= 0) {
					alive = false;
				}
				return x - shield;
			}
		}
		return 0;
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

	void move(int newX, int newY) {
		if(alive) {
			x = newX;
			y = newY;
		}
	}
	
	public String toString() {
		return (this.name + "(Lvl:" + level + " - " + getRarity() + "): " + "HP(" + currentHP + "/" + maxHP + "), Position(" + x + "," + y + ")");
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
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getInitiative() {
		return initiative;
	}
	public void setInitiative(int i) {
		initiative = i;
	}
	public int getID() {
		return id;
	}
}
