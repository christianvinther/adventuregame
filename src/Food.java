public class Food extends Item {
    private int healthPoints;

    // Constructor initialize food with health points
    public Food(String itemShortDescription, String itemLongDescription, int healthPoints) {
        super(itemShortDescription, itemLongDescription);
        this.healthPoints = healthPoints;
    }

    // Getter for health points
    public int getHealthPoints() {
        return healthPoints;
    }
}
