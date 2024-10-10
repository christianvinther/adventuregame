// RangedWeapon.java
public class RangedWeapon extends Weapon {

    private int ammo;
    private int damage;

    public RangedWeapon(String itemShortDescription, String itemLongDescription, int ammo, int damage) {
        super(itemShortDescription, itemLongDescription);
        this.ammo = ammo;
        this.damage = damage;
    }

    @Override
    public boolean canUse() {
        return ammo > 0;
    }

    @Override
    public void use() {
        if (ammo > 0) {
            ammo--;
        }
    }

    @Override
    public String attack() {
        if (ammo > 0) {
            return "You fire the " + getItemShortDescription() + ". Ammo remaining: " + (ammo - 1);
        } else {
            return "Your " + getItemShortDescription() + " is out of ammo!";
        }
    }
    @Override
    public int getDamage() {
        return damage;
    }


}
