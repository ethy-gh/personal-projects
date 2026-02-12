// used AI to help implement singleton pattern
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GameState {
    //Variables for the singleton instance 
    private static GameState instance;
    private final GameEventManager eventManager = new GameEventManager();

    public GameEventManager getEventManager() {
        return eventManager;
    }
    //Variables for hashmap of players and enemies, alongside a boolean to determine if game is over
    private static Map<String, Player> players;
    private final Map<String, Enemy> enemies;
    private boolean isGameOver;

    private GameState() {
        players = new HashMap<>();
        enemies = new HashMap<>();
        isGameOver = false;
    }
    //Create new instance if no instance exists
    public static synchronized GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    
// Managing Player - functions to add player, return the name of a player and return the list of all players

    public void addPlayer(String name, Player player) {
        players.put(name, player);
    }

    public Player getPlayer(String name) {
        return players.get(name);
    }

    public synchronized Collection<Player> getAllPlayers(){
        return players.values();
    }


// Managing Enemies - functions to add enemies, remove enemies, return enemy names and return list of all enemies

    public void addEnemy(String name, Enemy enemy){
        enemies.put(name, enemy);
    }

    public Enemy getEnemy(String name) {
        return enemies.get(name);
    }

    public Map<String, Enemy> getAllEnemies(){
        return enemies;
    }

    public void removeEnemy(String name){
        enemies.remove(name);
    }

// Game control flags - able to determine if game is over and end the game

    public boolean isGameOver() {
        return isGameOver;
    }

    public void endGame(){
        isGameOver = true;
        System.exit(0);
    }
}


