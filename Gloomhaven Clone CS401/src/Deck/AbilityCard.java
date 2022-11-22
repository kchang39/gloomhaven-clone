package Deck;

public class AbilityCard {
	
	private String Name;//Name of the attack
	private int initNum;//Initializer number.
	private int levelNum;//The level of the attack card.
	private String topAction;//The top action of the card.
	private String bottomAction;//The bottom action of the card.
	private String sepAbilities;//Separe abilities of the card. Located at the bottom.
	
	private boolean discarded;
	private boolean lost;
	
  //Constructor used to initialize the variables.
	public AbilityCard(String N, int IN, int ln, String tA, String bA, String sA) {
	    Name = N;
	    initNum = IN;
	    levelNum = ln;
            topAction = tA;
	    bottomAction = bA;
	    sepAbilities = sA;
		
	}
  //Displays all the information on the card.
	public void ShowAttackCard() {
	    System.out.println("Name: " + Name);
	    System.out.println("Initializer Number: " + initNum);
	    	
	    System.out.println("Level Number: " + levelNum);
	    System.out.println("Top Action: " + topAction);
	    
	    System.out.println("Bottom Action: " + bottomAction);
	    System.out.println("Separate abilities: " + sepAbilities);
		
	    
	}

	public boolean isDiscarded() {
		return discarded;
	}

	public boolean isLost() {
		return lost;
	}
}
