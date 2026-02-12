// Used AI to help produce under Factory Pattern

import java.util.HashMap;
import java.util.Map;

public class NPC {
    //Variables for name, two sets of dialogue and a hashmap for the shop contents
    private final String name;
    private final String dialogue;
    private final String dialogue2;
    private final Map<item, Integer> shop = new HashMap<>();
    

    public NPC(String name, String dialogue, String dialogue2){
        this.name = name;
        this.dialogue = dialogue;
        this.dialogue2 = dialogue2;
    }

    //Functions to talk both dialogue options as well as add and remove items to the shop
    public void talk() {
        System.out.println(name + " says: \"" + dialogue + "\"");
    }
    public void talk2() {
        System.out.println(name + " says: \"" + dialogue2 + "\"");
    }

    public void addShopItem(item item, int price){
        shop.put(item, shop.getOrDefault(item, 0) + 1);
    }

    private void removeShopItem(item item){
        int count = shop.get(item);
        if (count > 1){
            shop.put(item, count - 1);
        }
        else{
            shop.remove(item);
        }
    }
    
    //Function for the skelton merchant to be able to open his shop, sets items and prices and displays shop - allows player to buy items and reduces their gold
    public void skeletonMerchantopenShop(Player player){
        String choice;
        if (worldtest.firstVisitSM == true){
            addShopItem(worldtest.skullKey, 250);
            addShopItem(worldtest.healthPotion, 50);
            addShopItem(worldtest.healthPotion, 50);
        }
        if (shop.isEmpty()){
            System.out.println("Skeleton Merchant is sold out.");
        }
        else{
            worldtest.buying = true;
            worldtest.playerInput.nextLine();
            while(worldtest.buying == true){
                System.out.println("Current Player Gold: " + player.getGoldCount());
                worldtest.wait(2);
                System.out.println("Skeleton Merchant Inventory: ");
                for (Map.Entry<item, Integer> entry : shop.entrySet()){
                    System.out.println("- " + entry.getKey().getName() + " (x" + entry.getValue() + ") Price: " + entry.getKey().getPrice() + " gold");
                }
                System.out.println("\n");
                worldtest.wait(1);
                System.out.println("Would you like to buy anything? Y/N");
                choice = worldtest.playerInput.nextLine();
                if (choice.equalsIgnoreCase("Y")){
                    worldtest.buying = true;
                    worldtest.wait(1);
                    System.out.println("What would you like to buy? ");
                    choice = worldtest.playerInput.nextLine();
                    if (choice.equalsIgnoreCase("Skull Key")){
                        int gold = player.getGoldCount();
                        player.spendGold(250);
                        int goldMinusPrice = gold - 250;
                        if (goldMinusPrice >= 0){
                            player.addItem(worldtest.skullKey);
                            worldtest.state.getEventManager().notifyAllObservers(player.getName() + " has bought a " + worldtest.skullKey.getName() + " for 250 Gold.");
                            removeShopItem(worldtest.skullKey);
                        }
                    }
                    else if (choice.equalsIgnoreCase("Health Potion")){
                        int gold = player.getGoldCount();
                        player.spendGold(50);
                        int goldMinusPrice = gold - 50;
                        if (goldMinusPrice >= 0){
                            player.addItem(worldtest.healthPotion);
                            worldtest.state.getEventManager().notifyAllObservers(player.getName() + " has bought a " + worldtest.healthPotion.getName() + " for 50 Gold.");
                            removeShopItem(worldtest.healthPotion);
                        }
                    }
                }
                else if (choice.equalsIgnoreCase("N")){
                    System.out.println("Exiting Shop");
                    worldtest.buying = false;
                }
                else{
                    System.out.println("Invalid Option");
                    worldtest.buying = true;
                }
            }
        }  
    }
        
}

