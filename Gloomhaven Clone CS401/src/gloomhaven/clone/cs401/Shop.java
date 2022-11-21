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
}