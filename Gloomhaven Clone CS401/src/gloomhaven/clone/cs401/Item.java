package gloomhaven.clone.cs401;

public class Item {
    int goldCost;   //gold cost of the item
    String name;    //name of the item
    String equipSlot;   //equip slot of the item (head/body/legs/onehand/twohands/small item)
    boolean isConsumable;   //is consumed after use
    boolean isSpendable;    //is spent after use and can be refreshed when a character performs a long rest
    boolean isConsumed;     //is item consumed
    boolean isSpent;         //is item spent

    String description;     //the effect of the item
    
    // default contructor
    public Item() {

    }


    //start of getters and setters
    public int getGoldCost() {
        return goldCost;
    }
    public void setGoldCost(int goldCost) {
        this.goldCost = goldCost;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEquipSlot() {
        return equipSlot;
    }
    public void setEquipSlot(String equipSlot) {
        this.equipSlot = equipSlot;
    }
    public boolean isConsumable() {
        return isConsumable;
    }
    public void setConsumable(boolean isConsumable) {
        this.isConsumable = isConsumable;
    }
    public boolean isSpendable() {
        return isSpendable;
    }
    public void setSpendable(boolean isSpendable) {
        this.isSpendable = isSpendable;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isConsumed() {
        return isConsumed;
    }

    public void setConsumed(boolean isConsumed) {
        this.isConsumed = isConsumed;
    }

    public boolean isSpent() {
        return isSpent;
    }

    public void setSpent(boolean isSpent) {
        this.isSpent = isSpent;
    }
    //end getter and setters


    //consumes the item, can only be refreshed by special abilities
    public void consumeItem() {
        this.isConsumed = true;
    }

    //spends the item, can be refreshed during long rest
    public void spendItem() {
        this.isSpent = true;
    }

    //checks if two items are equal
    public boolean isEqual(Item item) {
        return this.name == item.getName();
    }
}
