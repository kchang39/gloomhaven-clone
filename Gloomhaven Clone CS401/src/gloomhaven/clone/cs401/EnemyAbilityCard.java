package gloomhaven.clone.cs401;

public class EnemyAbilityCard {
	private int attack;
	private int movement;
	private int shield;
	private int heal;
	private int initiative;
	private boolean reshuffle;
	
	EnemyAbilityCard(int attack, int movement, int shield, int heal, int initiative, boolean reshuffle){
		this.attack = attack;
		this.movement = movement;
		this.shield = shield;
		this.heal = heal;
		this.initiative = initiative;
		this.reshuffle = reshuffle;
	}

	public int getAttack() {
		return attack;
	}

	public int getMovement() {
		return movement;
	}

	public int getInitiative() {
		return initiative;
	}

	public boolean isReshuffle() {
		return reshuffle;
	}

	public int getShield() {
		return shield;
	}

	public int getHeal() {
		return heal;
	}
}
