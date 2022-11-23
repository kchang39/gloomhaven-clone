/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gloomhaven.clone.cs401;

/**
 *
 * @author PishSama
 */
public class GloomhavenCloneCS401 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    	Player testPlayer = new Player("Jimmy Jam", 2);
    	
    	testPlayer.printPlayer();
    	testPlayer.getDeck().showAbilityDeck();
    	testPlayer.getDeck().showModDeck();
    	
    }
    
}
