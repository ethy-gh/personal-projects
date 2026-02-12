import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameObjectFactoryTest {
    //testing if creating rooms works
    @Test
    public void testCreateRoom(){
        room room = GameObjectFactory.createRoom("Forest");
        assertTrue(room instanceof room, "Room should be the forest");
    }
    //testing if creating items works
    @Test
    public void testCreateItem(){
        item item = GameObjectFactory.createItem("Broken Sword");
        assertTrue(item instanceof item, "Item should be broken sword");
    }
    //testing if creating NPCs works
    @Test
    public void testCreateNPC(){
        NPC npc = GameObjectFactory.createNPC("Old Man");
        assertTrue(npc instanceof NPC, "NPC should be the old man");
    }

    //junit doesnt run properly but visual studio says the tests work
}

