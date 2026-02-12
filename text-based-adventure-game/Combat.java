
import java.util.Random;
import java.util.Scanner;

public class Combat {
    //Variables for inputs, randomising and checking if running is successful
    Scanner combatInput = new Scanner(System.in);
    String choiceS = " ";
    private final Random r = new Random();
    private boolean runSuccessful;

    //Main combat function that takes in the player in combat, the enemy to fight and whether it is a boss or not as parameters
    public void startCombat(Player player, Enemy enemy, Boolean boss){
        runSuccessful = false;
        System.out.println("You have engaged in combat with: " + enemy.getName());
        while (enemy.isDefeated() == false || runSuccessful != true){
            runSuccessful = false;
            enemy.setPlayerGuarding(false);
            enemy.playerGuarding();
            System.out.println("What do you do?: \n1. Attack\n2. Guard\n3. Inventory\n4. Run");
            int choice = combatInput.nextInt();
            //player attack choice
            if (choice == 1){
                enemy.takeDamage(player.getAttackPower());
                System.out.println("You attacked " + enemy.getName() + "! HP left: " + enemy.getHealth());
                if (enemy.getHealth() <= 0){
                    enemy.isDefeated();
                    worldtest.wait(1);
                    System.out.println(player.getName() + " has defeated the " + enemy.getName());
                    runSuccessful = false;
                    break;
                }
            }
            //player guarding choice
            else if (choice == 2){
                System.out.println("You take up a guarding stance with hopes of minimising the damage.");
                worldtest.wait(1);
                enemy.setPlayerGuarding(true);
                enemy.playerGuarding();
            }
            //player opens inventory choice, able to heal in combat
            else if (choice == 3){
                player.showInventory();
                if (player.invEmpty == false){
                    worldtest.wait(1);
                    combatInput.nextLine();
                    System.out.println("Would you like to heal? Y/N");
                    choiceS = combatInput.nextLine();
                    if(choiceS.equalsIgnoreCase("Y")){
                        worldtest.wait(1);
                        System.out.println("Which potion would you like to use?");
                        choiceS = combatInput.nextLine();
                        player.useItem(choiceS);
                        if (choiceS.equalsIgnoreCase("Health Potion")){
                            player.heal(50);
                        }
                    }
                    else if (choiceS.equalsIgnoreCase("N")){
                        System.out.println("Closing Inventory");
                    }
                    else{
                        System.out.println("Invalid Option");
                    }
                }
            }
            //player trying to run choice, 25% chance of success
            else if(choice == 4 && boss == false){
                int chance = r.nextInt(4)+1;
                if(chance == 4){
                    runSuccessful = true;
                    System.out.println("You successfully escaped the enemy!");
                    break;
                }
                else{
                    System.out.println("The enemy does not let you escape.");
                    worldtest.wait(1);
                    runSuccessful = false;
                }
                
            }
            //cannot run from boss
            else if (choice == 4 && boss == true){
                System.out.println("You cannot run from this enemy... stand brave and face it.");
            }
            //enemy attack
            worldtest.wait(1);
            if (boss == false){
                System.out.println("The enemy attacks!\nYou get hit for " + enemy.getAttackPower());
                player.takeDamage((int) enemy.getAttackPower());
                worldtest.wait(1);
                System.out.println("Player Current Health: " + player.getHealth());
                if (player.getHealth() <= 0){
                    GameState.getInstance().getEventManager().notifyAllObservers(player.getName() + " has died.");
                    worldtest.wait(3);
                    System.out.println("GAME OVER");
                    worldtest.wait(3);
                    player.died();
                } 
            }
            //if enemy is a boss theyre able to do a charged attack, 1/3 chance
            else if (boss == true){
                int chance = r.nextInt(2)+1;
                if (chance == 3){
                    combatInput.nextLine();
                    System.out.println("The enemy is charging up a strong attack!");
                    worldtest.wait(2);
                    System.out.printf("Do you wish to guard? Y/N%n-%n");
                    choiceS = combatInput.nextLine();
                    if (choiceS.equalsIgnoreCase("Y")){
                        System.out.println("You take up a guarding stance with hopes of minimising the damage.");
                        worldtest.wait(1);
                        enemy.setPlayerGuarding(true);
                        enemy.playerGuarding();
                    }
                    else{
                        System.out.println("You do not put up a guarding stance.");
                        enemy.setPlayerGuarding(false);
                        enemy.playerGuarding();
                    }
                    System.out.println("The enemy strikes with a poweful blow!\nYou get hit for " + (enemy.getAttackPower()+5));
                    player.takeDamage((int) enemy.getAttackPower()+5);
                    worldtest.wait(1);
                    System.out.println("Player Current Health: " + player.getHealth());
                    if (player.getHealth() <= 0){
                        GameState.getInstance().getEventManager().notifyAllObservers(player.getName() + " has died.");
                        worldtest.wait(3);
                        System.out.println("GAME OVER");
                        worldtest.wait(3);
                        player.died();
                    }
                }
                else{
                    System.out.println("The enemy attacks!\nYou get hit for " + enemy.getAttackPower());
                    player.takeDamage((int) enemy.getAttackPower());
                    worldtest.wait(1);
                    System.out.println("Player Current Health: " + player.getHealth());
                    if (player.getHealth() <= 0){
                        GameState.getInstance().getEventManager().notifyAllObservers(player.getName() + " has died.");
                        worldtest.wait(3);
                        System.out.println("GAME OVER");
                        worldtest.wait(3);
                        player.died();
                    } 
                }
            }
        }
    }
}
