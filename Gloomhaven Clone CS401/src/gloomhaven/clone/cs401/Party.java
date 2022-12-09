package gloomhaven.clone.cs401;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Party {
	
	private String name;
	private List<Player> players = new ArrayList<Player>();
	
	private int reputation;
	
	Party(String name, int numPlayers){
		this.name = name;
		
		for(int i = 0; i < numPlayers; i++) {
			addPlayer();
		}
	}
	
	public void addPlayer() {
		Scanner scanner = new Scanner(System.in);
		String playerName;
		int jobNum;
		
		System.out.print("Enter player's name: ");
		playerName = scanner.nextLine();
		do{
			System.out.print("Choose " + playerName + "'s Job(1 = Scoundrel, 2 = Brute, 3 = Spellweaver, 4 = Tinkerer): ");
			jobNum = scanner.nextInt();
			if(jobNum < 1 || jobNum > 4) {
				System.out.println("Error: Not a valid input.");
			}
		}while(jobNum < 1 || jobNum > 4);
		
		players.add(new Player(playerName, jobNum));
	}
	
	public void pickHands() {
		for(int i = 0; i < players.size(); i++) {
			System.out.println("\nPlayer: " + players.get(i).getName());
			players.get(i).getDeck().pickHand();
		}
	}
	
	public void printParty() {
		System.out.println("\nParty Name: " + name);
		for(int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).toString());
		}
	}

	public String getName() {
		return name;
	}

	public int getReputation() {
		return reputation;
	}
	
	public boolean isAlive() {
		for(int i = 0; i < players.size(); i++) {
			if(players.get(i).isAlive()) {
				return true;
			}
		}
		return false;
	}
	
	public int getSize() {
		return players.size();
	}
	
	public Player getPlayer(int i) {
		return players.get(i);
	}
	
	public void clearInitiative() {
		for(int i = 0; i < players.size(); i++) {
			players.get(i).setInitiative(0);
		}
	}
}
