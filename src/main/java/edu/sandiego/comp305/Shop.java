package edu.sandiego.comp305;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Item> avaliableItems = new ArrayList<>();

    public ArrayList<Item> displayItems(){
        return new ArrayList<>(avaliableItems);
    }

    public void addItem(final Item item){
        avaliableItems.add(item);
    }

    public boolean buyWeaponUpgrade(
            final int boostAmount,
            final int price,
            final Player player){
        if (canPlayerAfford(player,price)){
            if (player.weapon != null){
                player.weapon.attackBoost += boostAmount;
                player.decreaseGold(price);
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    private boolean canPlayerAfford(final Player player, final int price){
        if (player.gold >= price) {
            return true;
        }
        return false;
    }

    public void buyArmorUpgrade(final int price, final Armor armor){

    }

    public void buyPotion(final int price, final Potion potion){

    }

}
