// Enemy.java
public class Enemy {

    private String name;
    private String description;
    private int health;
    private Weapon weapon;
    private Room currentRoom;

    public Enemy(String name, String description, int health, Weapon weapon) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.weapon = weapon;
    }

    // Enemy attacksplayer
    public String attack(Player player) {
        if (weapon.canUse()) {
            weapon.use();
            int damage = weapon.getDamage();
            player.reduceHealth(damage);
            String message = name + " attacks you with " + weapon.getItemShortDescription() +
                    ", dealing " + damage + " damage.";
            if (!weapon.canUse()) {
                message += " " + name + " " + weapon.getItemShortDescription() + "is out of ammo!";
            }
            return message;
        } else {
            return name + " tries to attack with " + weapon.getItemShortDescription() + ", but is out of ammo";
        }
    }

    // Enemy takes damage from player attack
    public String hit(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            return name + " has been died!";
        } else {
            return name + " takes " + damage + " damage. Health remaining: " + health;
        }
    }

    // Check if your enemy is dead
    public boolean isDead() {
        return health <= 0;
    }

    // Enemy drops its weapon into the room and removes itself from the room
    public void die(Room room) {
        room.removeEnemy(this);
        room.addItem(weapon);

    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
