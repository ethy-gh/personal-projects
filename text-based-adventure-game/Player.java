
import java.util.HashMap;
import java.util.Map;


// Used AI to help implement under singleton pattern and observer pattern
public class Player implements GameObserver{
    //Variables for name, health, attackpower, goldcount and a hashmap for the inventory and a boolean to determine if the inventory is empty
    private final String name;
    private int health;
    private int attackPower;
    private final Map<item, Integer> inventory = new HashMap<>();
    private int goldCount;
    public boolean invEmpty;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.attackPower = 5;
        this.goldCount = 0;
    }
    //Function to add name to the front of the observer message
    @Override
    public void onGameEvent(String message) {
        System.out.println("[" + name + "] " + message);
    }
    //Getters for getting name, health, attackpower and gold count
    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public int getAttackPower(){
        return attackPower;
    }

    public int getGoldCount(){
        return goldCount;
    }
    //Functions for the player to take damage, heal, gain gold and spend gold
    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
    }

    public void heal(int amount){
        health = Math.min(100, health + amount);
    }

    public void gainGold(int amount){
        goldCount = goldCount + amount;
    }

    public void spendGold(int price){
        int temp = goldCount;
        goldCount = goldCount - price;
        if (goldCount<0){
            System.out.println("Not enough Gold");
            goldCount = temp;
        }
        else{
            System.out.println(price + " gold spent.");
        }
    }
    //ends the game when the player dies
    public void died(){
        GameState.getInstance().endGame();
    }


//inventory - functions to add and remove items, use items, equip weapons, check whether an item is in the inventory and display the inventory
    public void addItem(item item){
        inventory.put(item, inventory.getOrDefault(item, 0) + 1);
        System.out.println(item.getName() + " added to inventory");
    }

    public void useItem(String itemName){
        for (item item : inventory.keySet()){
            if (item.getName().equalsIgnoreCase(itemName)){
                if (itemName.equalsIgnoreCase("Broken Sword") == false){ //update for any new weapons
                     System.out.println("You use the " + item.getName());
                    removeItem(item);
                    return;
                }
            }
        }
        System.out.println("You don't have that item.");
    }

    private void removeItem(item item){
        int count = inventory.get(item);
        if (count > 1){
            inventory.put(item, count - 1);
        }
        else{
            inventory.remove(item);
        }
    }

    public void equipWeapon(item item){
        if (item.getName().equalsIgnoreCase("Broken Sword")){
            System.out.println(item.getName() + " has been equipped.");
            attackPower = worldtest.brokenSwordATK;
            System.out.println(name + " attack power: " + attackPower);
        }
        else if (item.getName().equalsIgnoreCase("Old Knights Blade")){
            System.out.println(item.getName() + " has been equipped.");
            attackPower = worldtest.oldKnightBladeATK;
            System.out.println(name + " attack power: " + attackPower);
        }
    }

    public boolean checkItem(item item){
        return inventory.containsKey(item);
    }
    
    public void showInventory(){
        invEmpty = false;
        if (inventory.isEmpty()){
            System.out.println("Inventory is empty.");
            invEmpty = true;
        }
        else{
            System.out.println("Inventory:");
            for (Map.Entry<item, Integer> entry : inventory.entrySet()){
                System.out.println("- " + entry.getKey().getName() + " (x" + entry.getValue() + ")");
            }
        }
    }
}
