package gloomhaven.clone.cs401;

import java.util.List;

//Shop should be initialized with copies of items to begin with
//when a character retires, all item cards go back to shop
public class Shop {
    List<Item> allItemList;
    
    public Shop() {

    }

    //constructor to populate the Shop with items
    public Shop(Item item) {
        allItemList.add(item);
    }

    //lets player buy an item from the shop, adds it to their deck, then removes the item from the shop
    //no player can own duplicate item
    public void buyItem(Item item) {    //need to pass in player object?
        //check if player deck has item already
        for (int i = 0; i < allItemList.size(); i ++) {
            if (allItemList.get(i) == item) {
                //give player item
                //check if they have enough gold
                //takes the gold from their inventory
                //remove item from shop
                System.out.println("Bought item " + allItemList.get(i).getName() + " for: ");  //notifies user what item was bought and for how much gold
                allItemList.remove(i);
                
                return;
            }
        }
    }

    public void sellItem(Item item) {
        allItemList.add(item);
        //gives player half the price listed on the item(rounded down) 
        //item.getGoldCost()/2
        //probably return that number^^ 
        //System.out.println("Sold item for: " + *price*);
    }

    //when a character retires, all their item cards go back to the shop
    public void retireCharacter(Deck deck) {
        //iterates through list of item cards the player owns
        //adds each card to the shop
    }

}