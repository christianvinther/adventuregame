public class Adventure {
    private Player player;
    private Map map;

    // Constructor - initializes the map + player objects
    public Adventure() {
        map = new Map();
        player = new Player(map.getCurrentRoom());
    }

    public String look() {
        return player.look();
    }

    public String take(String itemName) {
        return player.take(itemName);
    }

    public String drop(String itemName) {
        return player.drop(itemName);
    }

    public String showItems() {
        return player.showPlayerItems();
    }

    public String move(String direction) {
        return player.move(direction);
    }
    public String eat(String itemName) {
        Player.EatStatus status = player.eat(itemName);
        switch (status) {
            case NO_SUCH_ITEM:
                return "There is no " + itemName + " here to eat.";
            case NOT_EDIBLE:
                return "You cannot eat the " + itemName + ".";
            case ATE_FOOD:
                return "You have eaten the " + itemName + ".";
            default:
                return "";
        }
    }

    public String showHealth() {
        return player.getHealthStatus();
    }

    public String equip(String itemName) {
        return player.equip(itemName);
    }

    // method to attack
    public String attack(String enemyName) {
        return player.attack(enemyName);
    }
}
