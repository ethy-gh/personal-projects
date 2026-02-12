import java.util.Random;
import java.util.Scanner;

public class worldtest {
    //create singleton instance and bring in combat
    static GameState state = GameState.getInstance();
    static Combat combat = new Combat();
    
        
        // Create Rooms and variables for the rooms so theyre always false when the game loads up
        static boolean changeRoom = false;
        static room forest = GameObjectFactory.createRoom("Forest");
        static room cabin = GameObjectFactory.createRoom("Cabin");
        static room gate = GameObjectFactory.createRoom("Gate");
        static room mainEntrance = GameObjectFactory.createRoom("Main Entrance");
        static room diamondHallway = GameObjectFactory.createRoom("Diamond Hallway");
        static boolean diamondHallwayVisited = false;
        static boolean diamondCabinetsSearched = false;
        static boolean mainEntranceVisited = false;
        static boolean diamondDoorUnlocked = false;
        static room riddleRoom = GameObjectFactory.createRoom("Riddle Room");
        static boolean riddleRoomVisited = false;
        static boolean riddleCorrect = false;
        static String playerRiddleAnswer = " ";
        static boolean noSphinx = false;
        static room treasureRoom = GameObjectFactory.createRoom("Treasure Room");
        static boolean treasureRoomVisited = false;
        static boolean chestOpen = false;
        static room mimicRoom = GameObjectFactory.createRoom("Mimic Room");
        static boolean mimicRoomVisited = false;
        static boolean chestOpened = false;
        static room hallway = GameObjectFactory.createRoom("Hallway");
        static boolean hallwayVisited = false;
        static boolean cabinetsSearched = false;
        static room dungeon = GameObjectFactory.createRoom("Dungeon");
        static boolean dungeonVisited = false;
        static boolean dungeonInvestigated = false;
        static room upstairs = GameObjectFactory.createRoom("Upstairs");
        static boolean upstairsVisited = false;
        static boolean upstairsSearched = false;
        static room skullRoom = GameObjectFactory.createRoom("Skull Room");

        //Create Items and item variables
        static item brokenSword = (item) GameObjectFactory.createItem("Broken Sword");
        static int brokenSwordATK = 10;
        static item diamondKey = (item) GameObjectFactory.createItem("Diamond Key");
        static item healthPotion = (item) GameObjectFactory.createItem("Health Potion");
        static item oldKnightBlade = (item) GameObjectFactory.createItem("Old Knights Blade");
        static int oldKnightBladeATK = 20;
        static item skullKey = (item) GameObjectFactory.createItem("Skull Key");

        //Create NPCs and variables
        static NPC oldMan = (NPC) GameObjectFactory.createNPC("Old Man");
        static boolean oldManSpokenWith = false;
        static NPC sphinxStatue = (NPC) GameObjectFactory.createNPC("Sphinx Statue");
        static NPC skeletonMerchant = (NPC) GameObjectFactory.createNPC("Skeleton Merchant");
        static boolean firstVisitSM = true;
        static boolean buying = true;
        static NPC warlock = (NPC) GameObjectFactory.createNPC("Warlock");
    
        

        //Create Enemies
        static Enemy sphinxStatueEnemy = new Enemy("Sphinx Statue", 100, 8);
        static Enemy mimic = new Enemy("Mimic", 80, 10);
        static Enemy beastialWarlock = new Enemy("Beastial Warlock", 150, 10);
       
        // Game World Variables - player input scanner
        static Scanner playerInput = new Scanner(System.in);
       
    //function to delay code execution to aid with reading descriptions
    public static void wait(int seconds){
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
    }
    //function for the introduction section
    public static void introduction(Player player){
        // Introduction
        System.out.printf("A chill runs down your spine as you develop a cold flush of sweat across your whole body.%n You hear a haunting whisper in your ear, tempting you towards an environment devoid of life.%n You envision a castle barred from the grasps of man, your body moves you unwillingly towards it.%n The closer you get the colder the chill. Until suddenly... you awake.%n-%n"); 
        wait(3);
        forest.describe();
        wait(3);
        System.out.printf("You wander until you encounter an old cabin.%n It doesn't look like its been used in years.%n You walk closer to the door and read a sign on the door saying 'Traveller's Rest Inn'.%n You hear someone shuffling around inside.%n-%n");
        wait(3);
        System.out.printf("What do you do?%n 1. Enter the cabin%n 2. Ignore the cabin and walk on%n");
        int choice = playerInput.nextInt();

        //Enter Cabin
        if (choice == 1){
            cabin(player);
        }
        //Ignore cabin
        else if (choice == 2){
            System.out.printf("You ignore the cabin and keep walking forward.%n-%n");
        }
        else if (choice != 1 && choice != 2){
            System.out.println("Invalid Option");
            introduction(player);
        }

    }
    //function for the cabin section
    public static void cabin(Player player){
        wait(1);
        state.getEventManager().notifyAllObservers(player.getName() + " has entered the Cabin.");
        wait(3);
        cabin.describe();
        wait(3);
        int choice = 0;
        String choiceS;
        while(choice != 3){
            System.out.printf("What do you do?%n 1. Talk to the old man%n 2. Have a look around%n 3. Exit the Cabin%n");
            choice = playerInput.nextInt();
            //Talk to old man
            if (choice == 1 && oldManSpokenWith == false){
                oldMan.talk();
                wait(3);
                System.out.println("You share your story with the Old Man.");
                wait(3);
                oldMan.talk2();
                wait(3);
                System.out.println("The Old Man hands you a broken sword.");
                oldManSpokenWith = true;
                player.addItem(brokenSword);
                state.getEventManager().notifyAllObservers(player.getName() + " has acquired a " + brokenSword.getName());
                wait(1);
                brokenSword.inspect();
                wait(3);
                playerInput.nextLine();
                System.out.println("Would you like to equip the " + brokenSword.getName() + " ? Y/N");
                choiceS = playerInput.nextLine();
                if (choiceS.equalsIgnoreCase("Y")){
                    player.equipWeapon(brokenSword);
                }
            }
            else if (choice == 1 && oldManSpokenWith == true){
                System.out.println("The old man has nothing more to say.");
            }
            else if (choice == 2){
                System.out.println("You wander around the cabin but all you find are signs of neglect and loneliness");
            }
            else if (choice != 1 && choice != 2 && choice != 3){
                System.out.println("Invalid Choice");
            }
        }
        System.out.printf("You thank the old man for his time and leave the cabin.\n-\n");
    }

    //function for the gate section
    public static void gate(Player player){
        gate.describe();
        wait(3);
        int choice = 0;
        while (choice != 1){
            System.out.printf("What do you do?%n 1. Enter the gate%n 2. Turn around and walk away%n");
            choice = playerInput.nextInt();
            if (choice == 2){
                System.out.printf("You turn around and walk away from the gate.%n You walk and walk until suddenly you see something in the distance... it's the same gate.%n You try to walk away again only to find yourself infront of the gate again.%n It's almost like somethings stopping you from leaving.%n-%n");
            }
        }
        if (choice != 1 && choice != 2){
            System.out.println("Invalid Option");
            gate(player);
        }
        System.out.printf("You walk through the gate and once your feet passed the underside, the gate slams shut behind you rendering any chance of turning back you had useless.%n You press onwards as there's nowhere else you can go but on.%n You seem to walk for miles until you come to a clearing in the forest, and standing tall and alone in the clearing is a castle in a shallow state of what it once was.%n-%n");
    }

    //function for the main entrance section - calls functions for the connecting areas
    public static void mainEntrance(Player player){
        if (mainEntranceVisited == false){
            wait(2);
            state.getEventManager().notifyAllObservers(player.getName() + " has entered the Castle.");
            wait(3);
            mainEntrance.describe();
            mainEntranceVisited = true;
            wait(3);
        }
        else if (mainEntranceVisited == true){
            wait(3);
            System.out.printf("You return to the main entrance.%n-%n");
            wait(3);
        }
        int choice;
        // connecting room choices
        changeRoom = false;
        while (changeRoom == false){
            System.out.printf("What do you do?%n 1. Enter the left room%n 2. Enter the right room%n 3. Go up the stairs%n");
            choice = playerInput.nextInt();
            if (choice == 1){
                System.out.printf("You make your way over to the left door and push your weight against it.%n With a bit of effort, the door opens with a creak.%n-%n");
                hallway(player);
                changeRoom = true;
            }
            else if (choice == 2 && player.checkItem(diamondKey) == true && diamondDoorUnlocked == false){
                player.useItem("Diamond Key");
                wait(1);
                diamondDoorUnlocked = true;
                System.out.printf("You pull the diamond key out of your bag and insert it into the lock and turn.%n You can hear the lock inside the door disengage and you open the door.%n-%n");
                wait(2);
                state.getEventManager().notifyAllObservers(player.getName() + " has unlocked the Diamond Door.");
                diamondHallway(player);
                changeRoom = true;
            }
            else if (choice == 2 && diamondDoorUnlocked == true){
                System.out.println("You have already unlocked the door so you freely enter.");
                diamondHallway(player);
                changeRoom = true;
            }
            else if (choice == 2 && player.checkItem(diamondKey) == false){
                System.out.printf("You push the door and realise it's locked.%n You pan your eyes down to the lock and notice it's in the shape of a diamond.%n-%n");
                changeRoom = false;
            }
            else if (choice == 3){
                System.out.printf("You make your way up the stairs and arrive at an upper floor.%n-%n");
                upstairs(player);
                changeRoom = true;
            }
            else if (choice != 1 && choice != 2 && choice != 3){
                System.out.println("Invalid Option");
                changeRoom = false;
            }
        }
    }

    //function for the hallway section - calls connecting room functions for backtracking and going forward
    public static void hallway(Player player){
        changeRoom = false;
        //checks if hallway already visited
        if (hallwayVisited == false){
            wait(3);
            hallway.describe();
            hallwayVisited = true;
            wait(3);
        }
        else if (hallwayVisited == true){
            wait(3);
            System.out.printf("You return to the hallway.%n-%n");
            wait(3);
        }
        int choice;
            while (changeRoom == false){
                System.out.printf("What do you do?%n 1. Continue Onwards%n 2. Search some cabinets%n 3. Return to the previous room%n");
                choice = playerInput.nextInt();
                if (choice == 1){
                    System.out.printf("You decide to press onwards and you leave the hallway.\n-\n");
                    riddleRoom(player);
                    changeRoom = true;
                }
                else if (choice == 2 && cabinetsSearched == false){
                    System.out.printf("You quickly decide to rummage through the cabinets in hopes of finding something good.%n-%n");
                    Random r = new Random();
                    int r1 = r.nextInt(2);
                    if (r1 == 0){
                        wait(3);
                        System.out.println("You find nothing.");
                        cabinetsSearched = false;
                    }
                    else{
                        wait(3);
                        System.out.printf("You find a decent sum of gold between the cabinets, alongside a health potion.%n-%n");
                        player.gainGold(50);
                        state.getEventManager().notifyAllObservers(player.getName() + " has acquired 50 gold.");
                        wait(1);
                        player.addItem(healthPotion);
                        state.getEventManager().notifyAllObservers(player.getName() + " has acquired a health potion.");
                        cabinetsSearched = true;
                    }
                    changeRoom = false;
                }
                else if (choice == 2 && cabinetsSearched == true){
                    System.out.println("The cabinets have nothing left inside them.");
                    changeRoom = false;
                }
                else if (choice == 3){
                    System.out.println("You turn around and head to the previous room.\n-\n");
                    mainEntrance(player);
                    changeRoom = true;
                }
                else{
                    System.out.println("Invalid Option");
                    hallway(player);
                }
            }  
    }
    //function for the riddle room section - calls connecting room functions for backtracking and going forward
    public static void riddleRoom(Player player){
        //checks if riddle room already visited
        changeRoom = false;
        if (riddleRoomVisited == false){
            wait(3);
            riddleRoom.describe();
            riddleRoomVisited = true;
            wait(3);
        }
        else if (riddleRoomVisited == true){
            wait(3);
            System.out.printf("You return to the riddle room.%n-%n");
            wait(3);
        }
        int choice;
        while(noSphinx == false){
            System.out.printf("What do you do?%n 1. Approach the statue%n 2. Return to the previous room%n");
            choice = playerInput.nextInt();
            if (choice == 1){
                System.out.printf("You cautiously approach the statue of the sphinx.%n As soon as you get close enough the eyes of the statue light up and you hear a voice bellow throughout the room.%n-%n");
                wait(3);
                System.out.printf("Sphinx Statue says: \"Ahhh, a human... it's been a while since a human was challenged...\n You wish to gain access past me? Then answer this one riddle and satisfy my thirst for challenge...\"\n-\n");
                // need to reference riddle as from the hobbit said by gollum
                wait(3);
                int attempt = 0;
                String riddleAnswer = "time";
                playerInput.nextLine();
                while (riddleCorrect != true){
                    System.out.println("This thing all things devours: birds, beasts, trees, flowers; gnaws iron, bites steel, grinds hard stones to meal; slays king, ruins town, and beats high mountain down... what am I? ");
                    playerRiddleAnswer = playerInput.nextLine();
                    if (playerRiddleAnswer.equalsIgnoreCase(riddleAnswer)){
                        sphinxStatue.talk();
                        noSphinx = true;
                        riddleCorrect = true;
                        treasureRoom(player); 
                    }
                    else{
                        riddleCorrect = false;
                        sphinxStatue.talk2();
                        attempt = attempt + 1;
                        System.out.println("You have " + (3 - attempt) + " attempts left.");
                        if (attempt == 3){
                            break;
                        }
                    } 
                }
                if (attempt == 3){
                    System.out.printf("Sphinx Statue says: \"You're foolish guesses have gone on long enough...%n You're continued failure makes me grow restless...%n YOU DO NOT DESERVE TO PASS!\"%n-%n");
                    wait(3);
                    combat.startCombat(player, sphinxStatueEnemy, false);
                    if (sphinxStatueEnemy.isDefeated() == true){
                        System.out.println("With the sphinx defeated, you freely move to the next room.");
                        noSphinx = true;
                        treasureRoom(player);
                    }
                }
            }
            else if (choice == 2){
                hallway(player);
            }
            else{
                System.out.println("Invalid Option");
                noSphinx = false;
            }
        }
        System.out.printf("What do you do?%n 1. Enter the next room%n 2. Return to the previous room%n");
        choice = playerInput.nextInt();
        if (choice == 1){
            System.out.println("With the sphinx dealt with you move freely to the next room.");
            treasureRoom(player);
        }
        else if (choice == 2){
            hallway(player);
        }
        else{
            System.out.println("Invalid Option");
            riddleRoom(player);
        }
    }

    //function for the treasure room section - calls connecting room functions for backtracking and going forward
    public static void treasureRoom(Player player){
        //checks if treasure room already visited
        if (treasureRoomVisited == false){
            wait(3);
            treasureRoom.describe();
            treasureRoomVisited = true;
            wait(3);
        }
        else if (treasureRoomVisited == true){
            wait(3);
            System.out.printf("You re-enter the treasure room.%n-%n");
            wait(3);
        }
        int choice = 0;
        while (choice != 2){
          System.out.printf("What do you do?%n 1. Open the chest%n 2. Leave the room%n");
            choice = playerInput.nextInt();
            if (choice == 1 && chestOpen == false){
                System.out.printf("You approach the chest with caution, as the room looks a little too inviting.%n You find the chest is unlocked so you slowly lift the top open.%n Inside you find a pile of gold and a key with a diamond hilt.%n-%n");
                player.gainGold(150);
                wait(1);
                state.getEventManager().notifyAllObservers(player.getName() + " has acquired 150 gold.");
                player.addItem(diamondKey);
                wait(1);
                state.getEventManager().notifyAllObservers(player.getName() + " has acquired the diamond key.");
                chestOpen = true;
            }
            else if(choice == 1 && chestOpen == true){
                wait(1);
                System.out.println("The chest has already been opened.");
            }
        }
        if (choice == 2){
            System.out.println("You turn and leave the treasure room.");
            riddleRoom(player);
        }
        else if (choice != 1 && choice != 2){
            System.out.println("Invalid Option");
            treasureRoom(player);
        }
        
    }

    //function for the diamond hallway section - calls connecting room functions for backtracking and going forward
    public static void diamondHallway(Player player){
        changeRoom = false;
        //checks if diamond hallway already visited
        if(diamondHallwayVisited == false){
            wait(3);
            diamondHallway.describe();
            diamondHallwayVisited = true;
            wait(3);
        }
        else if(diamondHallwayVisited == true){
            wait(3);
            System.out.printf("You re-enter the diamond hallway.%n-%n");
            wait(3);
        }
        int choice;
        while (changeRoom == false){
            System.out.printf("What do you do?%n 1. Continue onwards%n 2. Search the cabinets%n 3. Return to the previous room%n");
            choice = playerInput.nextInt();
            if(choice == 1){
                System.out.println("You decide to leave the hallway and continue to the next room.");
                mimicRoom(player);
                changeRoom = true;
            }
            else if (choice == 2 && diamondCabinetsSearched == false){
                System.out.printf("You can't resist the temptation of looting again so you scavange in the cabinets.%n-%n");
                Random r = new Random();
                int r1 = r.nextInt(2);
                if (r1 == 0){
                    wait(3);
                    System.out.println("You find nothing.");
                    cabinetsSearched = false;
                }
                else{
                    wait(3);
                    System.out.printf("You find a handful of gold.%n-%n");
                    player.gainGold(50);
                    state.getEventManager().notifyAllObservers(player.getName() + " has acquired 25 gold.");
                    wait(1);
                    diamondCabinetsSearched = true;
                }
                changeRoom = false;
            }
            else if (choice == 2 && diamondCabinetsSearched == true){
                System.out.println("The cabinets have nothing left inside them.");
                changeRoom = false;
            }
            else if (choice == 3){
                System.out.println("You decide to head back to the previous room.\n-\n");
                mainEntrance(player);
                changeRoom = true;
            }
            else{
                System.out.println("Invalid Option");
                diamondHallway(player);
            }
        }
    }

    //function for the mimic room section - calls connecting room functions for backtracking and going forward
    public static void mimicRoom(Player player){
        changeRoom = false;
        //checks if mimic room already visited
        if(mimicRoomVisited == false){
            wait(3);
            mimicRoom.describe();
            mimicRoomVisited = true;
            wait(3);
        }
        else if(mimicRoomVisited == true && mimic.isDefeated() == false){
            wait(3);
            System.out.printf("You re-enter the treasure room.%n-%n");
            wait(3);
        }
        else if(mimicRoomVisited == true && mimic.isDefeated() == true){
            wait(3);
            System.out.printf("You re-enter the mimic room.%n-%n");
            wait(3);
        }
        int choice;
        String choiceS;
        while(changeRoom == false){
            System.out.printf("What do you do?%n 1. Open the chest%n 2. Continue onwards%n 3. Return to the previous room%n");
            choice = playerInput.nextInt();
            if(choice == 1 && chestOpened == false){
                System.out.printf("You walk towards the chest and put your hand under the lid ready to open it when you feel something sharp...%n You jump back as suddenly a gaping mouth lurches towards you with a tongue swinging side to side.%n The once harmless chest turns out to have been a mimic lying in wait.%n-%n");
                combat.startCombat(player, mimic, false);
                if (mimic.isDefeated() == true){
                    wait(1);
                    System.out.printf("In the mimic's last breath it coughs out its treasure.%n-%n");
                    player.gainGold(200);
                    state.getEventManager().notifyAllObservers(player.getName() + " has acquired 200 gold.");
                    player.addItem(oldKnightBlade);
                    state.getEventManager().notifyAllObservers(player.getName() + " has acquired a " + oldKnightBlade.getName());
                    wait(1);
                    oldKnightBlade.inspect();
                    wait(3);
                    playerInput.nextLine();
                    System.out.println("Would you like to equip the " + oldKnightBlade.getName() + " ? Y/N");
                    choiceS = playerInput.nextLine();
                    if (choiceS.equalsIgnoreCase("Y")){
                        player.equipWeapon(oldKnightBlade);
                    }
                    chestOpened = true;
                    changeRoom = false;
                }
            }
            else if (choice == 1 && chestOpened == true){
                System.out.println("The mimic has already been defeated.");
                changeRoom = false;
            }
            else if (choice == 2 && chestOpened == false){
                System.out.printf("You ignore the chest and move onto the next room.%n-%n");
                dungeon(player);
                changeRoom = true;
            }
            else if (choice == 2 && chestOpened == true){
                System.out.printf("You decide to head into the next room.%n-%n");
                dungeon(player);
                changeRoom = true;
            }
            else if (choice == 3){
                System.out.printf("You turn around and head into the previous room.%n-%n");
                diamondHallway(player);
                changeRoom = true;
            }
            else if (choice != 1 && choice != 2 && choice != 3){
                System.out.println("Invalid Option");
                changeRoom = false;
            }
        }    
    }

    //function for the dungeon section - calls connecting room functions for backtracking and going forward
    public static void dungeon(Player player){
        //checks if dungeon already visited
        if(dungeonVisited == false){
            wait(3);
            dungeon.describe();
            dungeonVisited = true;
            wait(3);
        }
        else if(dungeonVisited == true){
            wait(3);
            System.out.printf("You re-enter the dungeon.%n-%n");
            wait(3);
        }
        int choice;
        changeRoom = false;
        while (changeRoom == false){
            if (dungeonInvestigated == false){
                System.out.printf("What do you do?%n 1. Investigate the rattling%n 2. Leave the dungeon%n");
                choice = playerInput.nextInt();
                if (choice == 1){
                    System.out.printf("You cautiously approach the cell where the rattling is coming from.%n You peer around the corner of the cell only to find a skeleton chained up against the wall.%n-%n");
                    wait(3);
                    skeletonMerchant.talk();
                    wait(3);
                    skeletonMerchant.talk2();
                    wait(2);
                    skeletonMerchant.skeletonMerchantopenShop(player);
                    firstVisitSM = false;
                    changeRoom = false;
                    dungeonInvestigated = true;
                }
                else if (choice == 2){
                    System.out.printf("You exit the dungeon.%n-%n");
                    mimicRoom(player);
                    changeRoom = true;
                }
                else if (choice != 1 && choice != 2){
                    System.out.println("Invalid Choice");
                    changeRoom = false;
                }
            }
            else if(dungeonInvestigated == true){
                System.out.printf("what do you do?%n 1. Visit the merchant%n 2. Leave the dungeon%n");
                choice = playerInput.nextInt();
                if (choice == 1){
                    System.out.printf("You approach the merchant.%n-%n");
                    skeletonMerchant.talk2();
                    wait(2);
                    skeletonMerchant.skeletonMerchantopenShop(player);
                    changeRoom = false;
                }
                else if (choice == 2){
                    System.out.printf("You exit the dungeon.%n-%n");
                    mimicRoom(player);
                    changeRoom = true;
                }
                else if (choice != 1 && choice != 2){
                    System.out.println("Invalid Option");
                    changeRoom = false;
                }
            }
        }
    }

    //function for the upstairs section - calls connecting room functions for backtracking and going forward
    public static void upstairs(Player player){
        changeRoom = false;
        //checks if upstairs already visited
        if (upstairsVisited == false){
            wait(3);
            upstairs.describe();
            upstairsVisited = true;
            wait(3);
        }
        else if (upstairsVisited == true){
            wait(3);
            System.out.printf("You re-enter the upstairs mezzanine.%n-%n");
            wait(3);
        }
        int choice;
        String choiceS;
        while (changeRoom == false){
            System.out.printf("What do you do?%n 1. Enter the Skull Room%n 2. Explore the mezzanine%n 3. Go back downstairs%n");
            choice = playerInput.nextInt();
            if (choice == 1 && player.checkItem(skullKey) == false){
                System.out.printf("You prepare a stance to push all of your weight against the gargantuan door infront of you.%n You begin to push and it doesn't budge.%n The door is locked tight as if it's trying to keep you out... or something in...%n-%n");
                changeRoom = false;
            }
            else if (choice == 1 && player.checkItem(skullKey) == true){
                playerInput.nextLine();
                System.out.printf("There is no turning back after this... do you still wish to escape hell? Y/N%n");
                choiceS = playerInput.nextLine();
                if (choiceS.equalsIgnoreCase("Y")){
                    player.useItem("Skull Key");
                    wait(1);
                    System.out.printf("You insert the skull key into the lock and turn.%n You hear multiple locks disengage and you begin to push.%n-%n");
                    wait(2);
                    state.getEventManager().notifyAllObservers(player.getName() + " has unlocked the Skull Door.");
                    skullRoom(player);
                    changeRoom = true;
                }
                else{
                    System.out.printf("You suddenly feel unprepared and back away from the door.%n-%n");
                    changeRoom = false;
                }
            }
            else if (choice == 2 && upstairsSearched == false){
                System.out.printf("You decide to explore walk around the mezzanine.%n You discover there are no more doors around the mezzanine and you end up standing opposed by the skull door once again.%n You did however manage to find a health potion atop a chest of drawers.%n-%n");
                player.addItem(healthPotion);
                state.getEventManager().notifyAllObservers(player.getName() + " has acquired a health potion.");
                changeRoom = false;
                upstairsSearched = true;
            }
            else if (choice == 2 && upstairsSearched == true){
                System.out.printf("You walk around the mezzanine again in hopes of finding other items.%n Your search bares no fruit.%n-%n");
                changeRoom = false;
            }
            else if (choice == 3){
                System.out.printf("You decide to head back downstairs.%n-%n");
                mainEntrance(player);
                changeRoom = true;
            }
            else if (choice != 1 && choice != 2 && choice != 3){
                System.out.println("Invalid Option");
                changeRoom = false;
            }
            
        }
    }

    //function for the skull room section - calls connecting room functions for backtracking and going forward
    public static void skullRoom(Player player){
        wait(3);
        skullRoom.describe();
        wait(3);
        System.out.printf("In the light of the final brazier stands a warlock clad in black holding a large scepter.%n-%n");
        wait(3);
        warlock.talk();
        wait(3);
        System.out.printf("Before your very eyes, the once man sized warlock has transformed into a ferocious beastial presence.%n You grip your blade tight and prepare for one final battle.%n-%n");
        wait(1);
        combat.startCombat(player, beastialWarlock, true);
        if (beastialWarlock.isDefeated() == true){
            wait(1);
            warlock.talk2();
            wait(3);
            System.out.printf("As the warlock fades into the heavens, a blinding light appears from the scepter and you fall unconsious...%n-%n");
            wait(2);
            System.out.printf("You awaken in the forest, where you first opened your eyes...%n Only this time the fog has cleared and the trees have shrunk to a more natural size.%n You hear a voice calling out to you telling you it's time to go.%n You pick yourself up and walk back towards your car, blade still in hand...%n-%n");
            wait(3);
            System.out.println("THANK YOU FOR PLAYING MY GAME");
            wait(1);
            System.out.println("Total gold: " + player.getGoldCount());
            wait(1);
            state.endGame();
        }
    }
       

    //Main function
    public static void main(String[] args) throws InterruptedException {
        //Starting Game
        System.out.println("Please enter your player name: ");
        String playerName = playerInput.nextLine();
        Player player = new Player(playerName);

        state.addPlayer(playerName, player);
        state.getEventManager().addObserver(player);
       
        // game structure: introduction -> cabin -> gate -> mainEntrance -> left room -> hallway -> riddle room -> treasure room
        //                                                               -> diamond key room -> diamondHallway -> mimic room -> dungeon
        //                                                               -> upstairs -> Skull Room -> END
        introduction(player);
        wait(3);
        System.out.printf("As you walk deeper into the forest, the cabin behind you slowly fades into the fog.%n Soon enough you find yourself surrounded by trees yet again.%n You wander and wander for what seems like an eternity until out of the fog appears a looming gate.%n-%n");
        wait(3);
        gate(player);
        wait(3);
        System.out.printf("As you approach the weathered old wooden castle doors, a sudden and chilling gust of wind thrusts them wide open.%n Something from inside is beckoning you inside and you can't ignore its call.%n Your legs move on their own as you walk through the doors and just like the gate, they slam shut behind you.%n-%n");
        wait(3);
        // Main Entrance
        mainEntrance(player);
        
    }
}
