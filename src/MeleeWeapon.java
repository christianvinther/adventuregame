// MeleeWeapon.java
public class MeleeWeapon extends Weapon {

    private int damage;

    public MeleeWeapon(String itemShortDescription, String itemLongDescription, int damage) {
        super(itemShortDescription, itemLongDescription);
        this.damage = damage;

    }

    @Override
    public boolean canUse() {
        return true; // beacuse meele weapons can always be used :)
    }

    @Override
    public void use() {

    }

    @Override
    public String attack() {
        return "You swing the " + getItemShortDescription();
    }
    @Override
    public int getDamage() {
        return damage;
    }
}
