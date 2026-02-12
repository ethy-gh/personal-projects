
import java.util.Objects;

// Used AI to help produce under Factory Pattern

public class item {
    //Variables for item name, a description and the price for the shop
    private final String itemName;
    private final String description;
    private final String itemPrice;

    public item(String itemName, String description, String itemPrice){
        this.itemName = itemName;
        this.description = description;
        this.itemPrice = itemPrice;
    }
    //function to display the name and description as well as getters to get item name and price
    public void inspect() {
        System.out.println(itemName + " - " + description);
    }

    public String getName(){
       return itemName;
    }

    public String getPrice(){
        return itemPrice;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof item)) return false;
        item item = (item) o;
        return itemName.equalsIgnoreCase(item.itemName);
    }

    @Override
    public int hashCode(){
        return Objects.hash(itemName.toLowerCase());
    }
}
