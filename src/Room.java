import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room north, east, west, south;
    private ArrayList<Item> items;
    private ArrayList<Enemy> enemies;

    // Constructor to initialize room with name + description
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        items = new ArrayList<Item>();
        enemies = new ArrayList<Enemy>();

    }

    // Add an enemy to the room
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

    // Get the list of enemies
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    // Method to add item to the room
    public void addItem(Item item) {
        items.add(item);
    }

    // Method to remove item from the room
    public void removeItem(Item item) {
        items.remove(item);
    }


    // Method to print descriptions of items in room
    public String printItems() {
        if (items.isEmpty()) {
            return "No items in this room";

        } else {

            String itemsDescription = "Items in this room:" + "\n";
            for (Item item : items) {
                itemsDescription += item.getItemLongDescription() + "\n";
            }

            return itemsDescription;
        }
    }
    public String printEnemies() {
        if (enemies.isEmpty()) {
            return "No enemies in this room";
        } else {
            String enemiesDescription = "Enemies in this room:\n";
            for (Enemy enemy : enemies) {
                enemiesDescription += "- " + enemy.getName() + ": " + enemy.getDescription() + "\n";
            }
            return enemiesDescription;
        }
    }

    // GETTERS for room properties

    public ArrayList<Item> getItems() {
        return items;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Room getNorth() {
        return north;
    }

    public Room getEast() {
        return east;
    }

    public Room getSouth() {
        return south;
    }

    public Room getWest() {
        return west;
    }

    // SETTERS for room connection

    public void setEast(Room east) {
        this.east = east;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setWest(Room west) {
        this.west = west;
    }
}
