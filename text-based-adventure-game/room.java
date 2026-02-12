// Used AI to help produce under Factory Pattern

public class room {
    //Variables for room name and a description
    private final String roomName;
    private final String description;
    
    public room(String roomName, String description) {
        this.roomName = roomName;
        this.description = description;
    }

    //functions to describe the room and display the current room
    public void describe(){
        System.out.println(description);
    }

    public String CurrentRoom() {
        return roomName;
    }
}
