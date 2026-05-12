package edu.sandiego.comp305;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Item> avaliableItems;

    public Shop() {
        this.avaliableItems = new ArrayList<>();
    }

    public Shop(final Shop other){
        this.avaliableItems = new ArrayList<>(other.avaliableItems);
    }


    public ArrayList<Item> displayItems(){
        return new ArrayList<>(avaliableItems);
    }

    public void addItem(final Item item){
        avaliableItems.add(item);
    }

    public void removeItem(final Item item){
        avaliableItems.remove(item);
    }

    public void addMultipleItems(final ArrayList<Item> items){
        avaliableItems.addAll(items);
    }

    public boolean buyWeaponBoost(
            final int boostAmount,
            final int price,
            final Player player){
        if (player.getWeapon() == null ||
                !canPlayerAfford(player,price)){
            return false;
        }
        player.boostWeapon(boostAmount);
        player.decreaseGold(price);
        return true;
    }

    public void buyNewWeapon(final Player player, final Weapon weapon){
        final int weaponPrice = weapon.getCost();
        if(!(player.hasInInventory(weapon))
                && canPlayerAfford(player, weaponPrice)
                && this.avaliableItems.contains(weapon)){
            player.addToInventory(weapon);
            player.decreaseGold(weaponPrice);
            this.removeItem(weapon);

        }
    }


    private boolean canPlayerAfford(final Player player, final int price){
        if (player.getGold() >= price) {
            return true;
        }
        return false;
    }

    public void buyArmorUpgrade(
            final Player player,
            final int price,
            final Armor armor){
        if (canPlayerAfford(player,price) && !isArmorMaxed(armor)){
            player.decreaseGold(price);
            armor.increaseDefense(10);
        }

    }

    private boolean isArmorMaxed(final Armor armor){
        if (armor.getDefenseBoost() >= armor.getMaxDefenseBoost()){
            return true;
        }
        return false;
    }


    public void buyPotion(final Player player,
                          final int price,
                          final Potion potion){
        if(avaliableItems.contains(potion) &&
                canPlayerAfford(player,price)){
            this.removeItem(potion);
            player.decreaseGold(price);
            player.addToInventory(potion);
        }
    }

}
