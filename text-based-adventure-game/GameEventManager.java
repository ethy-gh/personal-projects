// Used AI to help implement observer pattern

import java.util.ArrayList;
import java.util.List;

public class GameEventManager {
    //Creates a list of observers
    private final List<GameObserver> observers = new ArrayList<>();

    //Adding and removing observers
    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }

    //Function to notify all observers of an event through message parameter
    public void notifyAllObservers(String message){
        for (GameObserver observer : observers){
            observer.onGameEvent(message);
        }
    }
}
