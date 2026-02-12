// Used AI to help produce under Factory Pattern
import java.util.Map;

public class GameObjectFactory {
    //Function to create new rooms using templates from templates.java
    public static room createRoom(String templateName) {
        Map<String, String> data = templates.ROOMS.get(templateName);
        if (data != null) {
            return new room(data.get("name"), data.get("description"));
        }
        throw new IllegalArgumentException("No room template: " + templateName);
    }
    //Function to create new items using templates from templates.java
    public static item createItem(String templateName) {
        Map<String, String> data = templates.ITEMS.get(templateName);
        if (data != null) {
            return new item(data.get("name"), data.get("description"), data.get("price"));
        }
        throw new IllegalArgumentException("No item template: " + templateName);
    }
    //Function to create new NPCs using templates from templates.java
    public static NPC createNPC(String templateName) {
        Map<String, String> data = templates.NPCS.get(templateName);
        if (data != null) {
            return new NPC(data.get("name"), data.get("dialogue"), data.get("dialogue2"));
        }
        throw new IllegalArgumentException("No NPC template: " + templateName);
    }
}
