import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameStateTest {
    //testing if only one instance is made
    @Test
    public void testSingleton(){
        GameState instance1 = GameState.getInstance();
        GameState instance2 = GameState.getInstance();
        assertSame(instance1, instance2, "Both instances should be the same");
    }
}

// junit not working properly but vscode still shows that the testing is working