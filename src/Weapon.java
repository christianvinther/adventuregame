public abstract class Weapon extends Item {

    public Weapon(String itemShortDescription, String itemLongDescription) {
        super(itemShortDescription, itemLongDescription);
    }

    public abstract boolean canUse();

    public abstract void use();

    public abstract String attack();

    public abstract int getDamage();

}

