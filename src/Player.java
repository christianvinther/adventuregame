import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private int health;
    private Weapon equippedWeapon;

    // Enum for eat status
    public enum EatStatus {
        NO_SUCH_ITEM,
        NOT_EDIBLE,
        ATE_FOOD
    }



    // Constructor to initialize playa
    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        this.inventory = new ArrayList<Item>();
        this.health = 80;



    }

    // Method to get playa health
    public String getHealthStatus() {
        String healthDescription;
        if (health >= 80) {
            healthDescription = "You are in excellent health.";
        } else if (health >= 50) {
            healthDescription = "You are in good health, but avoid fighting right now.";
        } else if (health >= 20) {
            healthDescription = "You are injured and should find food.";
        } else {
            healthDescription = "You are in critical condition(u will probably die and become alien food :) !";
        }
        return "Health: " + health + " - " + healthDescription;
    }

    // Method for eating food
    public EatStatus eat(String itemName) {
        Item itemToEat = null;

        // Check in inventory
        for (Item item : inventory) {
            if (item.getItemShortDescription().equalsIgnoreCase(itemName)) {
                itemToEat = item;
                break;
            }
        }

        // If not in inventory, check in current room
        if (itemToEat == null) {
            for (Item item : currentRoom.getItems()) {
                if (item.getItemShortDescription().equalsIgnoreCase(itemName)) {
                    itemToEat = item;
                    break;
                }
            }
        }

        if (itemToEat == null) {
            return EatStatus.NO_SUCH_ITEM;
        }

        if (!(itemToEat instanceof Food)) {
            return EatStatus.NOT_EDIBLE;
        }

        Food food = (Food) itemToEat;
        health += food.getHealthPoints();

        // Ensure health does not go below 0 or over 100
        if (health > 100) health = 100;
        if (health < 0) health = 0;

        // Remove food from inv or room
        inventory.remove(itemToEat);
        currentRoom.removeItem(itemToEat);

        return EatStatus.ATE_FOOD;
    }

    // Method for taking an item from the current room
    public String take(String itemName) {
        for (Item item : currentRoom.getItems()) {
            if (item.getItemShortDescription().equalsIgnoreCase(itemName)) {
                currentRoom.removeItem(item); // taking away item
                inventory.add(item); // ading to array
                return "You have taken the " + itemName + ".";
            }
        }
        return "There is no " + itemName + " in this room.";
    }



    // Method for dropping an item in current room(from inventory)
    public String drop(String itemName) {
        for (Item item : inventory) {
            if (item.getItemShortDescription().equalsIgnoreCase(itemName)) {
                inventory.remove(item);
                currentRoom.addItem(item);
                return "You have dropped the " + itemName + ".";
            }
        }
        return "You do not have a " + itemName + " in your inventory.";
    }


    // Method for looking around in the room you are currently in
    public String look() {
        String roomDetails = "Currently in " + currentRoom.getName() + ".\n" + currentRoom.getDescription() + "\n";
        roomDetails += currentRoom.printItems() + "\n";
        roomDetails += currentRoom.printEnemies();
        return roomDetails;
    }

    // method to equip a weapon
    public String equip(String itemName) {
        // checking if the item is in inventory
        for (Item item : inventory) {
            if (item.getItemShortDescription().equalsIgnoreCase(itemName)) {
                if (item instanceof Weapon) {
                    equippedWeapon = (Weapon) item;
                    return "You have equipped the " + itemName + ".";
                } else {
                    return "The " + itemName + " is not a weapon.";
                }
            }
        }
        return "You do not have a " + itemName + " in your inventory.";
    }

    // New method to attack
    public String attack(String enemyName) {
        if (equippedWeapon == null) {
            return "You have no weapon equipped. You cannot attack.";
        }
        if (!equippedWeapon.canUse()) {
            return "You cannot use the " + equippedWeapon.getItemShortDescription() + ".";
        }

        Enemy targetEnemy = null;

        if (enemyName != null && !enemyName.isEmpty()) {
            // seach for the enemy with the given name
            for (Enemy enemy : currentRoom.getEnemies()) {
                if (enemy.getName().equalsIgnoreCase(enemyName)) {
                    targetEnemy = enemy;
                    break;
                }
            }
            if (targetEnemy == null) {
                return "There is no " + enemyName + " here to attack.";
            }
        } else {
            // attacking the first enemy in the list
            if (!currentRoom.getEnemies().isEmpty()) {
                targetEnemy = currentRoom.getEnemies().get(0);
            } else {
                // no enemies to attack
                String attackMessage = equippedWeapon.attack();
                equippedWeapon.use();
                return attackMessage + " There are no enemies here.";
            }
        }

        // Player attacks the enemy
        int playerDamage = equippedWeapon.getDamage();
        equippedWeapon.use();
        String attackMessage = "You attack " + targetEnemy.getName() + " with " + equippedWeapon.getItemShortDescription() +
                ", dealing " + playerDamage + " damage.\n";
        attackMessage += targetEnemy.hit(playerDamage) + "\n";

        if (targetEnemy.isDead()) {
            // enemy freaking dies
            targetEnemy.die(currentRoom);
            attackMessage += targetEnemy.getName() + " has been defeated!";
        } else {
            // Enemy attacks back :(
            attackMessage += targetEnemy.attack(this);
        }

        if (isDead()) {
            attackMessage += "\nYou have been defeated!";
        }

        return attackMessage;
    }

    // Method to reduce health
    public void reduceHealth(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    // Method to check if player is dead
    public boolean isDead() {
        return health <= 0;
    }

    // Method for showing inventory, updated to show equipped weapon
    public String showPlayerItems() {
        if (inventory.isEmpty()) {
            return "No inventory.";
        }

        String itemList = "Items in your inventory: ";
        for (Item item : inventory) {
            itemList += item.getItemShortDescription();
            if (item == equippedWeapon) {
                itemList += " (equipped)";
            }
            itemList += ", ";
        }

        return itemList;
    }


    // Method for moving player into different room
    public String move(String direction) {
        Room nextRoom = null;
        switch (direction.toLowerCase()) {
            case "go north":
                nextRoom = currentRoom.getNorth();
                break;
            case "go south":
                nextRoom = currentRoom.getSouth();
                break;
            case "go east":
                nextRoom = currentRoom.getEast();
                break;
            case "go west":
                nextRoom = currentRoom.getWest();
                break;
        }

        if (nextRoom != null) {
            currentRoom = nextRoom;
            return "You are now in " + currentRoom.getName();
        } else {
            return "You cannot go that way.";
        }
    }
}
