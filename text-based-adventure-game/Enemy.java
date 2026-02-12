// used AI to help implement under Singleton Pattern
public class Enemy {
    //Variables for name, health, attack power and whether the player is guarding or not
    private final String name;
    private int health;
    private double attackPower;
    private final double attackPowerOriginal;
    private boolean playerGuarding;

    public Enemy(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.attackPowerOriginal = attackPower;
    }
    //Getters and Setters for name, health, attackpower, taking damage, player guarding
    public String getName(){
        return name;
    }

    public int getHealth() {
        return health;
    }

    public double getAttackPower(){
        return attackPower;
    }

    public void setPlayerGuarding(boolean playerGuarding){
        this.playerGuarding = playerGuarding;
    }

    public void takeDamage(int amount){
        health = Math.max(0, health - amount);
    }
    //Function to reduce attack power when player guarding, revert to original when not guarding
    public void playerGuarding(){
       if (playerGuarding == true){
        attackPower = attackPower * 0.85;
       }
       else{
        attackPower = attackPowerOriginal;
       }
    }
    //checks if enemy is defeated
    public boolean isDefeated() {
        return health <= 0;
    }
    
}
