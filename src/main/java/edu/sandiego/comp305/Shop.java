package edu.sandiego.comp305;

public class Shop {

    private static final int STARTING_WEAPON_PRICE = 10;

    private static final int STARTING_ARMOR_PRICE = 10;

    private static final int STARTING_POTION_PRICE = 10;

    private static final int WEAPON_BOOST_AMOUNT = 5;

    private static final int ARMOR_BOOST_AMOUNT = 3;

    private static final int PRICE_INCREASE = 5;

    private int weaponPrice;

    private int armorPrice;

    private int potionPrice;


    public Shop() {
        weaponPrice = STARTING_WEAPON_PRICE;
        armorPrice = STARTING_ARMOR_PRICE;
        potionPrice = STARTING_POTION_PRICE;
    }

    public boolean buyWeaponBoost(final Player player) {
        if (!canPlayerAfford(player, weaponPrice)) {
            return false;
        }

        if (player.weapon == null) {
            player.equipWeapon(new Weapon());
        }

        player.weapon.setAttackBoost(
                player.weapon.getAttackBoost() + WEAPON_BOOST_AMOUNT);

        player.decreaseGold(weaponPrice);
        weaponPrice += PRICE_INCREASE;
        return true;
    }

    public boolean buyArmorUpgrade(final Player player) {
        if (!canPlayerAfford(player, armorPrice)) {
            return false;
        }

        player.increaseDefense(ARMOR_BOOST_AMOUNT);
        player.decreaseGold(armorPrice);
        armorPrice += PRICE_INCREASE;

        return true;
    }

    public boolean buyPotion(final Player player, final Potion potion) {
        if (!canPlayerAfford(player, potionPrice)) {
            return false;
        }

        player.decreaseGold(potionPrice);
        player.addToInventory(potion);
        return true;
    }

    private boolean canPlayerAfford(final Player player, final int price) {
        return player.getGold() >= price;
    }

    public int getWeaponPrice() {
        return weaponPrice;
    }

    public int getArmorPrice() {
        return armorPrice;
    }

    public int getPotionPrice() {
        return potionPrice;
    }
}
