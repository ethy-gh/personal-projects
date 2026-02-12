// Used AI to help produce under Factory Pattern

import java.util.HashMap;
import java.util.Map;

public class templates {
    //hashmaps for the three game objects
    public static final Map<String, Map<String, String>> ROOMS = new HashMap<>();
    public static final Map<String, Map<String, String>> ITEMS = new HashMap<>();
    public static final Map<String, Map<String, String>> NPCS = new HashMap<>();

    // Produce templates for game objects - used to make the objects in GameObjectFactory.java
    static {
        // Rooms
        ROOMS.put("Forest", Map.of(
            "name", "Forest",
            "description", "Tall trees surround you on every side, towering over you like a human to an ant.\n You can't tell the time of day as they block most of the sunlight.\n All you hear is silence broken by occassional squawks from a nearby crow.\n-"
        ));
        ROOMS.put("Cabin", Map.of(
            "name", "Cabin",
            "description", "You slowly open the door, you can feel the air around you grow dense with dust.\n The cabin is dimly lit by a few candles which are almost burnt to their base.\n You hear a gentle rocking as an old man holds up a candlestick to reveal himself on a wooden rocking chair in the corner.\n-"
        ));
        ROOMS.put("Gate", Map.of(
            "name", "Gate",
            "description", "You approach the gate, the closer you get the more dominating its presence seems.\n Looking both left and right you notice a thick brick wall stretching into the fog.\n The closer you get, the greater the urge you have to keep moving forward... until suddenly...\n A loud rattle fills your brain as the once sealed gate opens itself to you, a gust of wind blows behind you almost like its trying to tempt you inside.\n-"
        ));
        ROOMS.put("Main Entrance", Map.of(
            "name", "Main Entrance",
            "description", "You enter a pitch black room, all you can recognise is the scent of ash and the sound of rats.\n In the blink of an eye, braziers surrounding the walls of the room light up revealing a main foyer.\n You see two doors, one to the left, to the right, and a staircase leading upwards adorned with a carpet.\n-\n"
        ));
        ROOMS.put("Treasure Room", Map.of(
            "name", "Treasure Room",
            "description", "You enter a room adorned with golden livery across the walls, lavish furniture spruces up the area.\n In the centre of the room beneath a large chandelier lies an old wooden chest waiting to be opened.\n-\n"
        ));
        ROOMS.put("Mimic Room", Map.of(
            "name", "Mimic Room",
            "description", "You enter a room adorned with golden livery across the walls, lavish furniture spruces up the area.\n In the centre of the room beneath a large  chandelier lies an old wooden chest begging to be opened.\n-\n"
        ));
        ROOMS.put("Riddle Room", Map.of(
            "name", "Riddle Room",
            "description", "You enter a room with a single exit directly ahead of you.\nThe door seems to be blocked by a large statue of the legendary sphinx.\n-\n"
        ));
        ROOMS.put("Hallway", Map.of(
            "name", "Hallway",
            "description", "Infront of you lies a hallway.\n It's just a regular hallway adorned with paintings and cabinets.\n-\n"
        ));
        ROOMS.put("Diamond Hallway", Map.of(
            "name", "Diamond Hallway",
            "description", "You enter a hallway similar to the last.\n The only difference is the paintings are now in diamond frames to match the keyhole.\n-\n"
        ));
        ROOMS.put("Dungeon", Map.of(
            "name", "Dungeon",
            "description", "You decend a staircase down a dimly lit corridor, the further down you go the damper it feels.\n As you reach the bottom of the stairs you hear the rattle of chains and you pass through an open iron gate.\n You enter a room lit by few torches made of dank brick and cobwebs with rats scrawling across the ground through puddles caused by dampness.\n Lines of jail cells occupy the walls and you hear the same rattle come from a cell further down.\n-\n"
        ));
        ROOMS.put("Upstairs", Map.of(
            "name", "Upstairs",
            "description", "Directly ahead of you on the upper is a large daunting door, embezzled with skull designs.\n Two large pillars stand on either side with lanterns hanging off of them.\n You look around and notice this upper floor is a ringed shaped mezzanine.\n-\n"
        ));
        ROOMS.put("Skull Room", Map.of(
            "name", "Skull Room",
            "description", "Upon the large door swinging open, a powerful gust of wind bellows from inside the room, reminiscent of the gust that forced you inside.\n You grip your weapon tight as you brace yourself for whats on the otherside, but whatever it is you know it's what brought you here.\n The room is large, larger than any room before it.\n Braziers light one by one until the whole circular room is in clear view, all but the large brazier in the back...\n You walk further into the room and hear a low growl as the last brazier ignites!\n-\n"
        ));
        // Items
        ITEMS.put("Broken Sword", Map.of(
            "name", "Broken Sword",
            "description", "A battle-worn blade, with half it's blade shattered. The broken blade provides a effective slash."
        ));
        ITEMS.put("Diamond Key", Map.of(
            "name", "Diamond Key",
            "description", "A key with a diamond hilt. You wonder which door corresponds to it."
        ));
        ITEMS.put("Health Potion", Map.of(
            "name", "Health Potion",
            "description", "A bubbling red liquid that miraculously heals wounds.",
            "price", "50"
        ));
        ITEMS.put("Old Knights Blade", Map.of(
            "name", "Old Knights Blade",
            "description", "The blade of one of the knights of the realm, it's long enough to be wielded with two hands to provide a strong blow."
        ));
        ITEMS.put("Skull Key", Map.of(
            "name", "Skull Key",
            "description", "A key with a skull hilt. You wonder which door corresponds to it.",
            "price", "250"
        ));
        // NPCs
        NPCS.put("Old Man", Map.of(
            "name", "Old Man",
            "dialogue", "Ahh, what 'ave we 'ere? Another traveller eh...\n We ne'er get travellers 'ere no more...\n Not since... What brings you to these parts young traveller?\n-",
            "dialogue2", "The Castle eh... No ones en'ered the castle in years...\n Yer gonna wan' this, It may be broken now but it saved me more than once back 'n my day.\n-"
        ));
        NPCS.put("Sphinx Statue", Map.of(
            "name", "Sphinx Statue",
            "dialogue", "Congratulations human... for you have answered most satisfactory...\n Your wisdom satiates my thrist for challenge... you may continue...",
            "dialogue2", "Foolish human... that is false."
        ));
        NPCS.put("Skeleton Merchant", Map.of(
            "name", "Skeleton Merchant",
            "dialogue", "A human ehh? kekekeke!!\n You've done well to make it this far... and I know just what you need to get further and get out of this place kekekeke!!\n I swiped a key shaped skull off one of the guards a few hundred years ago... they all died before they caught me kekekeke!!\n How about this, as I am a merchant, I will sell it to you and since you're the first person i've spoken to in a millenia I will even give you a discounted price kekekeke!!\n How does that sound?\n-\n",
            "dialogue2", "Take a look at my wares kekekeke!!\n-\n"
        ));
        NPCS.put("Warlock", Map.of(
            "name", "Warlock",
            "dialogue", "Well done on making it this far... I didn't expect you to get through my castle so easily.\n Do you really think because you made it all this way I would roll over and send you home?\n WELL THINK AGAIN!\n I'm about to make you regret ever leaving that old man's cabin behind...\n FULL MOON MAGIC: BEASTIUS TRANSFORMICUS !!!\n-\n",
            "dialogue2", "H...h...how did you manage to...*coughs up blood*... manage to defeat me in such a form...\n Curse you... *coughs* no one has managed to kill me for a millenia after I took over this poor excuse for a castle...\n *coughs some more* but you... YOU... WHAT MAKES YOU SO SPECIAL... *coughs up blood violently*\n It seems like this is the end of me... you got lucky *coughs* the spell will be lifted now... you... win... *collapses to the floor and dies*\n-\n"
        ));

    }
}
