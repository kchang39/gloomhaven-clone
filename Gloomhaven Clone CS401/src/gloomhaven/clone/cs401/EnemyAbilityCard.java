package gloomhaven.clone.cs401;

public class EnemyAbilityCard {
	private int attack;
	private int range;
	private int movement;
	private int shield;
	private int heal;
	private int initiative;
	private boolean reshuffle;
	private boolean discarded;
	
	EnemyAbilityCard(int attack, int range, int movement, int shield, int heal, int initiative, boolean reshuffle){
		this.attack = attack;
		this.range = range;
		this.movement = movement;
		this.shield = shield;
		this.heal = heal;
		this.initiative = initiative;
		this.reshuffle = reshuffle;
		discarded = false;
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

	public int getRange() {
		return range;
	}

	public boolean isDiscarded() {
		return discarded;
	}

	public void setDiscarded(boolean discarded) {
		this.discarded = discarded;
	}
}
