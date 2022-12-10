package gloomhaven.clone.cs401;

//to begin with, 2 types of items, one that adds damage, one that adds health
public class Item {
    int goldCost;   //gold cost of the item
    String name;    //name of the item
    String equipSlot;   //equip slot of the item (head/body/legs/onehand/twohands/small item) (small item slot: can equip up to number equal to half their level)
    int useSlots;       //number of times the item can be used before consumed/spent
    boolean isConsumable;   //is consumed after use
    boolean isSpendable;    //is spent after use and can be refreshed when a character performs a long rest
    boolean isConsumed;     //is item consumed
    boolean isSpent;         //is item spent

    String description;     //the effect of the item, will either have keyword 'attack' or 'health'+
    int damageModifier;     //changes damage of player
    int healthModifier;     //changes health of player

    
    // default contructor
    public Item() {

    }

    //constructor to create a specific item
    public Item(String name, int goldCost, String equipSlot, int useSlots, boolean isConsumable,
        boolean isSpendable, boolean isSpent, String description, int damageModifier, int healthModifier) {
            this.name = name;
            this.goldCost = goldCost;
            this.equipSlot = equipSlot;
            this.useSlots = useSlots;
            this.isConsumable = isConsumable;
            this.isSpendable = isSpendable;
            this.isSpent = isSpent;
            this.description = description;
            this.damageModifier = damageModifier;
            this.healthModifier = healthModifier;
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
    public int getUseSlots() {
        return useSlots;
    }
    public void setUseSlots(int useSlots) {
        this.useSlots = useSlots;
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
    public int getDamageModifier() {
        return damageModifier;
    }
    public void setDamageModifier(int damageModifier) {
        this.damageModifier = damageModifier;
    }
    public int getHealthModifier() {
        return healthModifier;
    }
    public void setHealthModifier(int healthModifier) {
        this.healthModifier = healthModifier;
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

    //uses item, and based on description adds health or damage
    public int useItem() {
        //checks if item is already consumed/spent
        if (isConsumed || isSpent) {
            System.out.println("Item has been used already");
            return 0;
        }
        String desc = getDescription().toLowerCase();
        if (isConsumable) { //consumes item
            if (desc.contains("health")) {
                useSlots--;
                if (useSlots == 0) {
                    consumeItem();
                }
                return getHealthModifier();
            } else if (desc.contains("attack")) {
                useSlots--;
                if (useSlots == 0) {
                    consumeItem();
                }
                return getDamageModifier();
            }
        } else if (isSpendable) {   //spends item
            if (desc.contains("health")) {
                useSlots--;
                if (useSlots == 0) {
                    spendItem();
                }
                return getHealthModifier();
            } else if (desc.contains("attack")) {
                useSlots--;
                if (useSlots == 0) {
                    spendItem();
                }
                return getDamageModifier();
            }
        }

        return 0;
    }

    //checks if two items are equal
    public boolean isEqual(Item item) {
        return this.name.toLowerCase() == item.getName().toLowerCase();
    }
}
