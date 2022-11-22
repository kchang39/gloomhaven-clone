package Deck;

public class BattleGoalCard {
	private int numOfCheckMarks;
	private String Prompt;
	
	private boolean discarded;
	
	public BattleGoalCard(int c, String p) {
		numOfCheckMarks = c;
		Prompt = p;
	}

	void DisplayBattleGoal() {
		System.out.println("Battle Goal: " + Prompt);
		System.out.println("Checkmarks: " + numOfCheckMarks);
	}
	
	public boolean isDiscarded() {
		return discarded;
	}
}

