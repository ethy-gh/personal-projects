import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class GameObserverTest {
    //testing if observer is able to be notified and display a message upon player recieving an item
    @Test
    public void testObserversNotified(){
        GameEventManager gameEventManager = new GameEventManager();

        GameObserver notification = mock(GameObserver.class);

        item item = new item("Sword", "Sword", null);
        gameEventManager.notifyAllObservers("recieved " + item.getName());
        verify(notification).update("recieved Sword");

    }
}

//junit not working properly so test should work but doenst as imports dont work